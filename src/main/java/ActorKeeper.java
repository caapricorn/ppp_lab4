import akka.actor.AbstractActor;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.*;

public class ActorKeeper extends AbstractActor {
    private final Map<String, List<Result>> results = new HashMap<>();

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(
                        ActorTester.MessageStoreTestResult.class,
                        this::storeResult
                )
                .match(
                        TestApp.MessageGetTestPackageResult.class,
                        req -> sender().tell(
                                new MessageReturnResults(
                                        req.getPackageID(),
                                        results.get(req.getPackageID())
                                ),
                                self()
                        )
                )
                .build();
    }

    private void storeResult(ActorTester.MessageStoreTestResult m) {
        String packageId = m.getPackageId();
        if (results.containsKey(packageId)) {
            results.get(packageId).add(m.getTestResult());
        } else {
            results.put(
                    m.getPackageId(),
                    new ArrayList<>(
                            Collections.singleton(m.getTestResult())
                    )
            );
        }
        System.out.println("Received message: " + m);
    }

    static class MessageReturnResults {
        private final String packageID;
        private final List<Result> results;

        @JsonCreator
        public MessageReturnResults(
                @JsonProperty("packageId") String packageID,
                @JsonProperty("results") List<Result> results) {
            this.packageID = packageID;
            this.results = results;
        }

        public String getPackageID() {
            return packageID;
        }

        public List<Result> getResults() {
            return results;
        }

    }
}