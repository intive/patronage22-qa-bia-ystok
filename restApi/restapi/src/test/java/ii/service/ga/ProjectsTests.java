package ii.service.ga;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ProjectsTests {

    @BeforeTest
    public static void setUp() {
        RestAssured.baseURI = Consts.Url + "/project";
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
                get("/" + Consts.ProjectId).
                then().
                assertThat().
                statusCode(200);
    }

    @Test
    public void delete() {
        given().
                when().
                delete("/delete/" + Consts.ProjectId).
                then().
                assertThat().
                statusCode(200);
    }

    @Test
    public void create() {
        String requestBody = "{\n" +
                "  \"alias\": \"string\",\n" +
                "  \"name\": \"string\",\n" +
                "  \"description\": \"string\",\n}";

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
                "  \"alias\": \"string\",\n" +
                "  \"name\": \"string\",\n" +
                "  \"description\": \"string\",\n}";

        given()
                .header("Content-type", "application/json")
                .and()
                .body(requestBody)
                .when()
                .put("/update/" + Consts.ProjectId)
                .then()
                .assertThat()
                .statusCode(200);
    }

    @Test
    public void lightUpdate() {
        String requestBody = "{\n" +
                "  \"alias\": \"string\",\n" +
                "  \"name\": \"string\",\n" +
                "  \"description\": \"string\",\n}";

        given()
                .header("Content-type", "application/json")
                .and()
                .body(requestBody)
                .when()
                .patch("/updateLight/" + Consts.ProjectId)
                .then()
                .assertThat()
                .statusCode(200);
    }
}

