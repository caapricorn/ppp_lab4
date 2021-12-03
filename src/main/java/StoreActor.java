import akka.actor.AbstractActor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class StoreActor extends AbstractActor {

    private Map<String, ArrayList<Test>> storage = new HashMap<>();

    private void addTest(Test test) {
        
    }
}
