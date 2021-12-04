import akka.actor.ActorRef;
import akka.http.javadsl.server.AllDirectives;

import java.io.IOException;

public class TestApp extends AllDirectives {

    private static final String HOST = "localhost";
    private static final int PORT = 5000;
    private static final int TIME_OUT_MILLIS = 5000;

    private ActorRef routeActor;

    private TestApp(ActorRef routeActor) {
        this.routeActor = routeActor;
    }

    public static void main(String args[]) throws IOException {
        
    }
}
