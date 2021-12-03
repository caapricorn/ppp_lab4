import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class Test implements Serializable {

    private final String testName;
    private String result;
    private final String expectedResult;
    private final Object[] params;
    private TestPackage testPackage;

    @JsonCreator
    public Test(
            @JsonProperty("testName") ,
            @JsonProperty("") ,
            @JsonProperty("")
    )
}
