import akka.NotUsed;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.http.javadsl.Http;
import akka.http.javadsl.marshallers.jackson.Jackson;
import akka.http.javadsl.model.HttpRequest;
import akka.http.javadsl.model.HttpResponse;
import akka.http.javadsl.server.AllDirectives;
import akka.http.javadsl.server.Route;
import akka.pattern.Patterns;
import akka.stream.ActorMaterializer;
import akka.stream.javadsl.Flow;

import java.io.IOException;

import static akka.http.javadsl.server.PathMatchers.segment;

public class TestApp extends AllDirectives {

    private static final String HOST = "localhost";
    private static final int PORT = 5000;
    private static final int TIME_OUT_MILLIS = 5000;

    private ActorRef routeActor;

    private TestApp(ActorRef routeActor) {
        this.routeActor = routeActor;
    }

    private Route createRoute(ActorSystem system) {
        return concat(
                get(() -> pathPrefix("getPackage", () ->
                        path(segment(), (String id) -> {
                            scala.concurrent.Future<Object> res = Patterns.ask(
                                    routeActor,
                                    id,
                                    TIME_OUT_MILLIS
                            );
                            return completeOKWithFuture(res, Jackson.marshaller());
                        })
                ))
        ),
        post()
    }

    public static void main(String args[]) throws IOException {
        ActorSystem system = ActorSystem.create("test");
        ActorRef routeActor = system.actorOf(Props.create(RouterActor.class, system));

        final Http http = Http.get(system);
        final ActorMaterializer materializer = ActorMaterializer.create(system);

        TestApp app = new TestApp(routeActor);

        final Flow<HttpRequest, HttpResponse, NotUsed> routeFlow =
    }
}
