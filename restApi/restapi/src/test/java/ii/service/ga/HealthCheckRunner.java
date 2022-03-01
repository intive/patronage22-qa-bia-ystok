package ii.service.ga;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class HealthCheckRunner {

    @Test
    public void getServiceStatus() {

        given().
                when().
                get("https://jsonplaceholder.typicode.com/posts").
                then().
                assertThat().
                statusCode(200).
                body("[0].userId", equalTo(1));
     }

}

