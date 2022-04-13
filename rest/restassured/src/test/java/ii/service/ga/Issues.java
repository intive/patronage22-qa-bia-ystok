package ii.service.ga;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class Issues extends base{

    @BeforeTest
    public void setUp() {

        RestAssured.baseURI = getUrl() + "/issue";
        // RestAssured.baseURI = "https://patronageapi.herokuapp.com";
    }

    @Test
    public void postIssue() {

        given()
                .log()
                .all()
                .contentType(ContentType.JSON)
                .body(postIssueBody)
                .when()
                .post("")
                .then()
                .log()
                .all()
                .assertThat()
                .statusCode(200);

    }

    @Test
    public void getIssueById() {


        given()
                .get("/1")
                .then()
                .log()
                .all()
                .assertThat ()
                .statusCode(200);

    }

    @Test
    public void getIssuesList() {


        given()
                .get("")
                .then()
                .log()
                .all()
                .assertThat ()
                .statusCode(200);

    }


    @Test
    public void deleteIssueById() {

        when()
                .delete("/1")
                .then()
                .log()
                .all()
                .assertThat ()
                .statusCode(200);
    }
//        postIssueBody = new JSONObject()
//                .put ("data", postIssueBody
//                        .put ("boardId", 0)
//                        .put ("statusId", 0)
//                        .put ("isActive", true)
//                        .put ("createdOn", "2022-02-25T23:44:11.911Z")
//                        .put ("modifiedOn", "2022-02-25T23:44:11.911Z"));
//
//        putIssueBody = new JSONObject ()
//                .put ("data", putIssueBody
//                        .put ("boardId", 0)
//                        .put ("statusId", 0)
//                        .put ("isActive", true)
//                        .put ("createdOn", "2022-02-25T23:44:11.911Z")
//                        .put ("modifiedOn", "2022-02-25T23:44:11.911Z"));
//
//        patchIssueBody = new JSONObject ()
//                .put ("data", patchIssueBody
//                        .put ("boardId", 0)
//                        .put ("statusId", 0)
//                        .put ("isActive", true)
//                        .put ("createdOn", "2022-02-25T23:44:11.911Z")
//                        .put ("modifiedOn", "2022-02-25T23:44:11.911Z"));



}
