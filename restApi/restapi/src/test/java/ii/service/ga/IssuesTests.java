package ii.service.ga;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class IssuesTests {

    @BeforeTest
    public static void setUp() {
        RestAssured.baseURI = Consts.Url + "/issue";
    }

    @Test
    public void getList() {
        given().
                when().
                get("/list?PageNumber=1&PageSize=5").
                then().
                assertThat().
                statusCode(200);
     }

    @Test
    public void get() {
        given().
                when().
                get("/" + Consts.IssueId).
                then().
                assertThat().
                statusCode(404); //200
    }

    @Test
    public void deleteIssue() {
        given().
                when().
                delete("/delete/" + Consts.IssueId).
                then().
                assertThat().
                statusCode(404); //200
    }

    @Test
    public void create() {
        String requestBody = "{\n" +
                "  \"alias\": \"{ \"data\": \"string\"}\",\n" +
                "  \"name\": \"{ \"data\": \"string\"}\",\n" +
                "  \"description\": \"{ \"data\": \"string\"}\",\n" +
                "  \"boardId\": \"{ \"data\": 0}\",\n" +
                "  \"statusId\": \"{ \"data\": 0}\",\n" +
                "  \"projectId\": 0 \n}";

        given()
                .header("Content-type", "application/json")
                .and()
                .body(requestBody)
                .when()
                .post("/create")
                .then()
                .assertThat()
                .statusCode(200);
    }

    @Test
    public void update() {
        String requestBody = "{\n" +
                "  \"alias\": \"{ \"data\": \"string\"}\",\n" +
                "  \"name\": \"{ \"data\": \"string\"}\",\n" +
                "  \"description\": \"{ \"data\": \"string\"}\",\n" +
                "  \"boardId\": \"{ \"data\": 0}\",\n" +
                "  \"statusId\": \"{ \"data\": 0}\",\n" +
                "  \"projectId\": 0 \n}";

        given()
                .header("Content-type", "application/json")
                .and()
                .body(requestBody)
                .when()
                .put("/update/" + Consts.IssueId)
                .then()
                .assertThat()
                .statusCode(200);
    }

    @Test
    public void lightUpdate() {
        String requestBody = "{\n" +
                "  \"alias\": \"{ \"data\": \"string\"}\",\n" +
                "  \"name\": \"{ \"data\": \"string\"}\",\n" +
                "  \"description\": \"{ \"data\": \"string\"}\",\n" +
                "  \"boardId\": \"{ \"data\": 0}\",\n" +
                "  \"statusId\": \"{ \"data\": 0}\",\n" +
                "  \"projectId\": 0 \n}";

        given()
                .header("Content-type", "application/json")
                .and()
                .body(requestBody)
                .when()
                .patch("/updateLight/" + Consts.IssueId)
                .then()
                .assertThat()
                .statusCode(200);
    }
}

