import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.SupervisorStrategy;

public class RouterActor extends AbstractActor {

    private ActorRef storeActor;
    private ActorRef testActor;
    private SupervisorStrategy strategy;

    public RouterActor(ActorSystem sys) {
        
    }
}
