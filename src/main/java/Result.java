import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class Result implements Serializable {
    private final String result;
    private final String expectedResult;
    private final Boolean success;

    @JsonCreator
    public Result(
            @JsonProperty("result") String result,
            @JsonProperty("expectedResult") String expectedResult,
            @JsonProperty("") ,
    )
}
