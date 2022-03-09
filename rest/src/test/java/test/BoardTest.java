package test;

import io.restassured.RestAssured;
import org.json.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class BoardTest extends TestBase {

    @BeforeClass
    public void setUpBoardTest() {
        RestAssured.baseURI = configFile.getURL () + "/board";
    }

    @Test
    public void createBoard() {
        String createBody = new JSONObject ()
                .put ("alias", "createAlias")
                .put ("name", "createName")
                .put ("description", "createDesc")
                .put ("boardId", 0)
                .put ("statusId", 0)
                .put ("isActive", true)
                .put ("createdOn", "2022-02-25T23:44:11.911Z")
                .put ("modifiedOn", "2022-02-25T23:44:11.911Z")
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
    public void getList() {
        given ().
                when ().
                get ("/list?PageNumber=1&PageSize=2").
                then ().
                assertThat ().
                statusCode (200);
    }

    @Test
    public void getBoardById() {
        given ().
                when ().
                get ("/1").
                then ().
                assertThat ().
                statusCode (200);
    }

    @Test
    public void deleteBoardById() {
        given ().
                when ().
                delete ("/delete/1").
                then ().
                assertThat ().
                statusCode (200);
    }

    @Test
    public void updateBoardById() {
        String updateBody = new JSONObject ()
                .put ("alias", "updateAlias")
                .put ("name", "updateName")
                .put ("description", "updateDesc")
                .put ("boardId", 0)
                .put ("statusId", 0)
                .put ("isActive", true)
                .put ("createdOn", "2022-02-25T23:44:11.911Z")
                .put ("modifiedOn", "2022-02-25T23:44:11.911Z")
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
    public void lightUpdateBoardById() {
        String lightUpdateBody = new JSONObject ()
                .put ("alias", "lightUpdateAlias")
                .put ("name", "lightUpdateName")
                .put ("description", "lightUpdateDesc")
                .put ("boardId", 0)
                .put ("statusId", 0)
                .put ("isActive", true)
                .put ("createdOn", "2022-02-25T23:44:11.911Z")
                .put ("modifiedOn", "2022-02-25T23:44:11.911Z")
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
