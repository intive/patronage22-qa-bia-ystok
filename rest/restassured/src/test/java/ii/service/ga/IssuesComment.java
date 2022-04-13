package ii.service.ga;

import io.restassured.RestAssured;
import org.json.JSONObject;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class IssuesComment extends base {


    @BeforeTest
    public void setUp() {

        RestAssured.baseURI = getUrl() + "/issue/comments";
        // RestAssured.baseURI = "https://patronageapi.herokuapp.com";


        patchIssueCommentContent = new JSONObject()
                .put ("data", patchIssueCommentContent
                        .put ("content", true));
    }

    @Test
    public void getIssueCommentsByIssueId(){

        given()
                .param("issueId","1")
                .get("")
                .then()
                .log()
                .all()
                .assertThat ()
                .statusCode(200);
    }

    @Test
    public void deleteIssueCommentById(){

        when()
                .delete("/1")
                .then()
                .log()
                .all()
                .assertThat ()
                .statusCode(200);
    }

    @Test
    public void postIssueComment(){

    }

    @Test
    public void patchIssueCommentContent(){

        given ()
                .header ("Content-type", "application/json")
                .and ()
                .body (patchIssueCommentContent.toString ())
                .when ()
                .patch ("/1")
                .then ()
                .statusCode (200)
                .assertThat () ;
    }


}
