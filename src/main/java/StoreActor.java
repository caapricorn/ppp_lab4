import akka.actor.AbstractActor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class StoreActor extends AbstractActor {

    private Map<String, ArrayList<Test>> storage = new HashMap<>();

    private void addTest(Test test) {
        String packageId = test.getTestPackage().getPackageId();
        if (this.storage.containsKey(packageId)) {
            this.storage.get(packageId).add(test);
        }
        else {
            ArrayList<Test> tests = new ArrayList<>();
            tests.add(test);
            this.storage.put(packageId, tests);
        }
    }
}
