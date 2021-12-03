import akka.actor.AbstractActor;
import akka.actor.ActorRef;

public class TestActor extends AbstractActor {

    private ActorRef storeActor;

    TestActor(ActorRef storeActor) {
        this.storeActor = storeActor;
    }

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match()
    }
}
