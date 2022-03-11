package ii.service.ga;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.*;


public class base {


    @BeforeTest
    public static void setUp() {
        RestAssured.baseURI = "https://patronageapi.herokuapp.com";
    }

    //BOARDS


    @Test
    public void postBoard() {



    }




    @Test
    public void patchBoard() {

         String requestBody = "{\n" +
                "  \"alias\": \"updatePlease\" \n}";

        Response response = given()
                .header("Content-type", "application/json")
                .and()
                .body(requestBody)
                .when()
                .patch("/api/board/updateLight/3")
                .then()
                .extract().response();


    }


    @Test
    public void getBoardById() {


        given()
                .get("/api/board/3")
                .then()
                .log().all()
                .statusCode(200);

    }

    @Test
    public void getBoardList() {


        given()
                .get("/api/board/list")
                .then()
                .log().all()
                .statusCode(200);

    }


    @Test
    public void deleteBoardById() {

        when()
                .delete("/api/board/delete/" +3)
                .then()
                .log()
                .all()
                .statusCode(200);
    }

    //BOARDSTATUS

    @Test
    public void getBoardStatusById() {


        given()
                .get("/api/boardStatus/0")
                .then()
                .log()
                .all()
                .statusCode(200);


    }

    @Test
    public void getBoardStatusList() {


        given()
                .get("/api/boardStatus")
                .then()
                .log()
                .all()
                .statusCode(200);

    }


    @Test
    public void deleteBoardStatus() {

        when()
                .delete("/api/boardStatus/" + 0)
                .then()
                .log()
                .all()
                .statusCode(200);
    }


    //ISSUE

    @Test
    public void getIssueById() {


        given()
                .get("/api/issue/0")
                .then()
                .log()
                .all()
                .statusCode(200);

    }

    @Test
    public void getIssuesList() {


        given()
                .get("/api/issue/list")
                .then()
                .log()
                .all()
                .statusCode(200);

    }


    @Test
    public void deleteIssueById() {

        when()
                .delete("/api/issue/delete/" + 0)
                .then()
                .log()
                .all()
                .statusCode(200);
    }


    //PROJECT

    @Test
    public void getProjectById() {


        given()
                .get("/api/project/9")
                .then()
                .log()
                .all()
                .statusCode(200);

    }

    @Test
    public void getProjectsList() {


        given()
                .get("/api/project")
                .then()
                .log()
                .all()
                .statusCode(200);

    }


    @Test
    public void deleteProjectById() {

        when()
                .delete("/api/project/" + 9)
                .then()
                .log()
                .all()
                .statusCode(200);
    }

}
