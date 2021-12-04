import akka.actor.AbstractActor;
import akka.actor.Props;
import akka.japi.pf.ReceiveBuilder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StoreActor extends AbstractActor {

    private final Map<String, List<Result>> storage = new HashMap<>();

    private void addTest(Result test) {
//        String packageId = test.getPackageId();
//        if (this.storage.containsKey(packageId)) {
//            this.storage.get(packageId).add(test);
//        }
//        else {
//            ArrayList<> tests = new ArrayList<>();
//            tests.add(test);
//            this.storage.put(packageId, tests);
//        }
        storage.computeIfAbsent(test.getPackageId(), k -> new ArrayList<>()).add(test);
    }

    @Override
    public Receive createReceive() {
        return ReceiveBuilder.create()
                .match(Result.class, this::addTest)
                .match(String.class, p -> sender().tell(
                        this.get(p),
                        self()
                ))
                .build();
    }

    private Message get(String packageId) {
        return new Message(packageId, storage.get(packageId));
    }

    static Props props() {
        return Props.create(StoreActor.class);
    }
}
