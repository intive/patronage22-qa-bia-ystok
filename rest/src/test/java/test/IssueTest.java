package test;

import io.restassured.RestAssured;
import org.json.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class IssueTest extends TestBase {

    @BeforeClass
    public void setUpIssueTest() {
        RestAssured.baseURI = configFile.getURL () + "/issue";
    }

    @Test
    public void createIssue() {
        String createBody = new JSONObject ()
                .put ("alias", "createAlias")
                .put ("name", "createName")
                .put ("description", "createDesc")
                .put ("boardId", 0)
                .put ("statusId", 0)
                .put ("projectId", 0)
                .toString ();

        given ()
                .header ("Content-type", "application/json")
                .and ()
                .body (createBody)
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
                get ("/list?PageNumber=1&PageSize=2").
                then ().
                assertThat ().
                statusCode (200);
    }

    @Test
    public void getIssueById() {
        given ().
                when ().
                get ("/1").
                then ().
                assertThat ().
                statusCode (200);
    }

    @Test
    public void deleteIssueById() {
        given ().
                when ().
                delete ("/delete/1").
                then ().
                assertThat ().
                statusCode (200);
    }

    @Test
    public void updateIssueById() {
        String updateBody = new JSONObject ()
                .put ("alias", "updateAlias")
                .put ("name", "updateName")
                .put ("description", "updateDesc")
                .put ("boardId", 0)
                .put ("statusId", 0)
                .put ("projectId", 0)
                .toString ();

        given ()
                .header ("Content-type", "application/json")
                .and ()
                .body (updateBody)
                .when ()
                .put ("/update/1")
                .then ()
                .assertThat ()
                .statusCode (200);
    }

    @Test
    public void lightUpdateIssueById() {
        String lightUpdateBody = new JSONObject ()
                .put ("alias", "lightUpdateAlias")
                .put ("name", "lightUpdateName")
                .put ("description", "lightUpdateDesc")
                .put ("boardId", 0)
                .put ("statusId", 0)
                .put ("projectId", 0)
                .toString ();

        given ()
                .header ("Content-type", "application/json")
                .and ()
                .body (lightUpdateBody)
                .when ()
                .patch ("/updateLight/1")
                .then ()
                .assertThat ()
                .statusCode (200);
    }
}