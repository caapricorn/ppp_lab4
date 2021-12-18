import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Result {
    private final String status;
    private final String testName;
    private final String expectedResult;
    private final String receivedResult;

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
        return "Status: " + status + "\n"
                + "Test name: " + testName + "\n"
                + "Expected: " + expectedResult + "\n"
                + "Received: " + receivedResult + "\n";
    }

}