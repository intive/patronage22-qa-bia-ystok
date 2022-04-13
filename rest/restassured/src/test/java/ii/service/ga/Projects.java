package ii.service.ga;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class Projects extends base{


    @BeforeTest
    public void setUp() {

        RestAssured.baseURI = getUrl() + "/project";
        // RestAssured.baseURI = "https://patronageapi.herokuapp.com";
//
//        postProjectBody = new JSONObject()
//                .put ("data", postProjectBody
//                        .put ("boardId", 0)
//                        .put ("statusId", 0)
//                        .put ("isActive", true)
//                        .put ("createdOn", "2022-02-25T23:44:11.911Z")
//                        .put ("modifiedOn", "2022-02-25T23:44:11.911Z"));
//
//        putProjectBody = new JSONObject ()
//                .put ("data", putProjectBody
//                        .put ("boardId", 0)
//                        .put ("statusId", 0)
//                        .put ("isActive", true)
//                        .put ("createdOn", "2022-02-25T23:44:11.911Z")
//                        .put ("modifiedOn", "2022-02-25T23:44:11.911Z"));
//
//        patchProjectBody = new JSONObject ()
//                .put ("data", patchProjectBody
//                        .put ("boardId", 0)
//                        .put ("statusId", 0)
//                        .put ("isActive", true)
//                        .put ("createdOn", "2022-02-25T23:44:11.911Z")
//                        .put ("modifiedOn", "2022-02-25T23:44:11.911Z"));

    }

    @Test
    public void getProjectById() {


        given()
                .get("/1")
                .then()
                .log()
                .all()
                .assertThat ()
                .statusCode(200);

    }

    @Test
    public void getProjectsList() {


        given()
                .get("")
                .then()
                .log()
                .all()
                .assertThat ()
                .statusCode(200);

    }


    @Test
    public void deleteProjectById() {

        when()
                .delete("/1")
                .then()
                .log()
                .all()
                .assertThat ()
                .statusCode(200);
    }

}
