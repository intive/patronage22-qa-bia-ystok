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
        createBody = new JSONObject ()
                .put ("data", createBody
                        .put ("boardId", 0)
                        .put ("statusId", 0)
                        .put ("isActive", true)
                        .put ("createdOn", "2022-02-25T23:44:11.911Z")
                        .put ("modifiedOn", "2022-02-25T23:44:11.911Z"));

        updateBody = new JSONObject ()
                .put ("data", updateBody
                        .put ("boardId", 0)
                        .put ("statusId", 0)
                        .put ("isActive", true)
                        .put ("createdOn", "2022-02-25T23:44:11.911Z")
                        .put ("modifiedOn", "2022-02-25T23:44:11.911Z"));

        lightUpdateBody = new JSONObject ()
                .put ("data", lightUpdateBody
                        .put ("boardId", 0)
                        .put ("statusId", 0)
                        .put ("isActive", true)
                        .put ("createdOn", "2022-02-25T23:44:11.911Z")
                        .put ("modifiedOn", "2022-02-25T23:44:11.911Z"));

    }

    @Test
    public void createBoard() {
        given ()
                .header ("Content-type", "application/json")
                .and ()
                .body (createBody.toString ())
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
                get ("/list?PageNumber=1&PageSize=5").
                then ().log ().all ().
                assertThat ().
                statusCode (200);
    }

    @Test
    public void getBoardById() {
        given ().
                when ().
                get ("/2").
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
        given ()
                .header ("Content-type", "application/json")
                .and ()
                .body (updateBody.toString ())
                .when ()
                .put ("/update/1")
                .then ()
                .assertThat ()
                .statusCode (200);
    }

    @Test
    public void lightUpdateBoardById() {
        given ()
                .header ("Content-type", "application/json")
                .and ()
                .body (lightUpdateBody.toString ())
                .when ()
                .patch ("/updateLight/1")
                .then ()
                .assertThat ()
                .statusCode (200);
    }
}
