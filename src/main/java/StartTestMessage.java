import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class StartTestMessage implements Serializable {

    private final String packageId;
    private final String jsScript;
    private final String functionName;
    private final Test test;

    @JsonCreator
    public StartTestMessage(
            @JsonProperty("packageId") String packageId,
            @JsonProperty("jsScript") String jsScript,
            @JsonProperty("functionName") String functionName,
            @JsonProperty("test") Test test
    ) {
        this.packageId = packageId;
        this.jsScript = jsScript;
        this.functionName = functionName;
        this.test = test;
    }

    public String getPackageId() {
        return packageId;
    }

    public String getJsScript() {
        return jsScript;
    }

    public String getFunctionName() {
        return functionName;
    }

    public Test getTest() {
        return test;
    }
}
