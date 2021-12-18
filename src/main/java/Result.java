import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Result {
    private final String status;
    private final String testName;
    private final String expectedResult;
    private final String receivedResult;

    private static final String NEW_LINE = "\n";

    @JsonCreator
    public Result(@JsonProperty("status") String status,
                      @JsonProperty("testName") String testName,
                      @JsonProperty("expectedResult") String expectedResult,
                      @JsonProperty("receivedResult") String receivedResult) {
        this.status = status;
        this.testName = testName;
        this.expectedResult = expectedResult;
        this.receivedResult = receivedResult;
    }

    public String getStatus() {
        return status;
    }

    public String getTestName() {
        return testName;
    }

    public String getExpectedResult() {
        return expectedResult;
    }

    public String getReceivedResult() {
        return receivedResult;
    }

    @Override
    public String toString() {
        return "Status: " + status + NEW_LINE
                + "Test name: " + testName + NEW_LINE
                + "Expected: " + expectedResult + NEW_LINE
                + "Received: " + receivedResult + NEW_LINE;
    }

}