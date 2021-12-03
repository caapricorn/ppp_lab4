import akka.actor.AbstractActor;
import akka.actor.ActorRef;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class TestActor extends AbstractActor {

    private ActorRef storeActor;

    TestActor(ActorRef storeActor) {
        this.storeActor = storeActor;
    }

    private static String testRun(TestPackage message) throws ScriptException, NoSuchMethodException {
        try {
            ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
            engine.eval(message.getJsScript());
            Invocable invocable = (Invocable) engine;
            return invocable.invokeFunction(message.getFunctionName(), message.getTests().)
        }
    }

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match()
    }
}
