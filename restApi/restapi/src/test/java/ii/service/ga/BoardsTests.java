package ii.service.ga;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class BoardsTests {

    @BeforeTest
    public static void setUp() {
        RestAssured.baseURI = Consts.Url + "/board";
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
                get("/" + Consts.BoardId).
                then().
                assertThat().
                statusCode(200);
    }

    @Test
    public void delete() {
        given().
                when().
                delete("/delete/" + Consts.BoardId).
                then().
                assertThat().
                statusCode(200);
    }

    @Test
    public void create() {
        String requestBody = "{\n" +
                "  \"alias\": \"string\",\n" +
                "  \"name\": \"string\",\n" +
                "  \"description\": \"string\",\n" +
                "  \"projectId\": 0,\n" +
                "  \"statusId\": 0,\n" +
                "  \"boardId\": 0,\n" +
                "  \"isActive\": true,\n" +
                "  \"createdOn\": \"2022-02-22T11:45:57.911Z\",\n" +
                "  \"modifiedOn\": \"2022-02-22T11:45:57.911Z\",\n}";

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
                "  \"description\": \"string\",\n" +
                "  \"projectId\": 0,\n" +
                "  \"statusId\": 0,\n" +
                "  \"boardId\": 0,\n" +
                "  \"isActive\": true,\n" +
                "  \"createdOn\": \"2022-02-22T11:45:57.911Z\",\n" +
                "  \"modifiedOn\": \"2022-02-22T11:45:57.911Z\",\n}";

        given()
                .header("Content-type", "application/json")
                .and()
                .body(requestBody)
                .when()
                .put("/update/" + Consts.BoardId)
                .then()
                .assertThat()
                .statusCode(200);
    }

    @Test
    public void lightUpdate() {
        String requestBody = "{\n" +
                "  \"alias\": \"string\",\n" +
                "  \"name\": \"string\",\n" +
                "  \"description\": \"string\",\n" +
                "  \"projectId\": 0,\n" +
                "  \"statusId\": 0,\n" +
                "  \"boardId\": 0,\n" +
                "  \"isActive\": true,\n" +
                "  \"createdOn\": \"2022-02-22T11:45:57.911Z\",\n" +
                "  \"modifiedOn\": \"2022-02-22T11:45:57.911Z\",\n}";

        given()
                .header("Content-type", "application/json")
                .and()
                .body(requestBody)
                .when()
                .patch("/updateLight/" + Consts.BoardId)
                .then()
                .assertThat()
                .statusCode(200);
    }
}

