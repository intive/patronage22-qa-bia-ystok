package test;

import io.restassured.RestAssured;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class IssueTest extends TestBase {

    @BeforeClass
    public void setUpIssueTest() {
        RestAssured.baseURI = configFile.getURL () + "/issue";

        createBody = new JSONObject ()
                .put ("data", createBody
                                .put ("boardId", 1)
                                .put ("statusId", 1)
                                .put ("projectId", 1));

        updateBody = new JSONObject ()
                .put ("data", updateBody
                        .put ("boardId", 1)
                        .put ("statusId", 1)
                        .put ("projectId", 1));

        lightUpdateBody = new JSONObject ()
                .put ("data", lightUpdateBody
                        .put ("boardId", 1)
                        .put ("statusId", 1)
                        .put ("projectId", 1));

    }

    @Test
    public void createIssue() {
        given ()
                .header ("Content-type", "application/json")
                .and ()
                .body (createBody.toString ()).log().all ()
                .when ()
                .post ("/create")
                .then ()
                .assertThat ()
                .statusCode (200);
    }

    @Test
    public void getIssuesList() {
        given ().
                when ().
                get ("/list?PageNumber=1&PageSize=5").
                then ().log ().all ().
                assertThat ().
                statusCode (200);
    }

    @Test
    public void getIssueById() {
        given ().
                when ().
                get ("/10").
                then ().
                assertThat ().
                statusCode (200);
    }

    @Test
    public void deleteIssueById() {
        given ().
                when ().
                delete ("/delete/11").
                then ().
                assertThat ().
                statusCode (200);
    }

    @Test
    public void updateIssueById() {
        given ()
                .header ("Content-type", "application/json")
                .and ()
                .body (updateBody.toString ())
                .when ()
                .put ("/update/10")
                .then ()
                .assertThat ()
                .statusCode (200);
    }

    @Test
    public void lightUpdateIssueById() {
        given ()
                .header ("Content-type", "application/json")
                .and ()
                .body (lightUpdateBody.toString ())
                .when ()
                .patch ("/updateLight/10")
                .then ()
                .assertThat ()
                .statusCode (200);
    }
}