import akka.actor.AbstractActor;

import java.util.ArrayList;
import java.util.HashMap;

public class StoreActor extends AbstractActor {

    private Map<String, ArrayList<Test>> storage = new HashMap<>();
}
