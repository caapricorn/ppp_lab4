import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class Result implements Serializable {
    private final String packageId;
    private final String result;
    private final String expectedResult;
    private final Boolean success;

    @JsonCreator
    public Result(
            @JsonProperty("packageId") String packageId,
            @JsonProperty("result") String result,
            @JsonProperty("expectedResult") String expectedResult,
            @JsonProperty("success") Boolean success
    ) {
        this.packageId = packageId;
        this.result = result;
        this.expectedResult = expectedResult;
        this.success = success;
    }

    public String getPackageId() {
        return packageId;
    }

    public String getResult() {
        return result;
    }

    public String getExpectedResult() {
        return expectedResult;
    }

    public Boolean getSuccess() {
        return success;
    }
}
