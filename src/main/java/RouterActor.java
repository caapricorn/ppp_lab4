import akka.actor.*;
import scala.concurrent.duration.Duration;

import java.util.Collections;

public class RouterActor extends AbstractActor {

    private final int MAX_RETRIES = 10;

    private ActorRef storeActor;
    private ActorRef testActor;
    private SupervisorStrategy strategy;

    public RouterActor(ActorSystem sys) {
        this.storeActor = sys.actorOf(StoreActor.props(), "Store");
        this.strategy = new OneForOneStrategy(
                MAX_RETRIES,
                Duration.create("1 minute"),
                Collections.singletonList(Exception.class)
        )
    }
}
