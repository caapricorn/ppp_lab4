import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;


public class TestPackage {
    private final String testName;
    private final Object[] params;
    private final String expectedResult;

    @JsonCreator
    public TestPackage(@JsonProperty("testName") String testName,
                        @JsonProperty("params") Object[] params,
                        @JsonProperty("expectedResult") String expectedResult) {
        this.expectedResult =  expectedResult;
        this.params = params;
        this.testName = testName;
    }

    protected String getTestName() {
        return testName;
    }

    protected Object[] getParams() {
        return params;
    }

    protected String getExpectedResult() {
        return expectedResult;
    }
}