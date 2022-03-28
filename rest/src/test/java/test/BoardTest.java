package test;

import io.restassured.RestAssured;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Date;

import static io.restassured.RestAssured.given;

public class BoardTest extends TestBase {

    @BeforeClass
    public void setUpBoardTest() {
        RestAssured.baseURI = configFile.getURL () + "/board";
        createBody = new JSONObject ()
                .put ("data", createBody
                        .put ("boardId", 1)
                        .put ("statusId", 0)
                        .put ("isActive", true)
                        .put ("createdOn", "2022-02-25T23:44:11.911Z")
                        .put ("modifiedOn", "2022-02-25T23:44:11.911Z"));

        updateBody = new JSONObject ()
                .put ("data", updateBody
                        .put ("boardId", 1)
                        .put ("statusId", 0)
                        .put ("isActive", true)
                        .put ("createdOn", "2022-02-25T23:44:11.911Z")
                        .put ("modifiedOn", "2022-02-25T23:44:11.911Z"));

        lightUpdateBody = new JSONObject ()
                .put ("data", lightUpdateBody
                        .put ("boardId", 1)
                        .put ("statusId", 0)
                        .put ("isActive", true)
                        .put ("createdOn", "2022-02-25T23:44:11.911Z")
                        .put ("modifiedOn", "2022-02-25T23:44:11.911Z"));
        logger = Logger.getLogger (BoardTest.class);
    }

    @Test
    public void createBoard() {
        logger.log (Level.toLevel (1), "\n--------------\ncreateBoard " + new Date () + "\n--------------\n");
        response = given ()
                .header ("Content-type", "application/json")
                .and ()
                .body (createBody.toString ())
                .when ()
                .post ("/create")
                .then ()
                .extract ()
                .response ();
        logDataToFile (response);
        response.then ().statusCode (200);
    }

    @Test
    public void getBoardsList() {
        logger.log (Level.toLevel (1), "\n--------------\ngetBoardsList " + new Date () + " \n--------------\n");
        response = given ()
                .when ()
                .get ("/list?PageNumber=1&PageSize=5")
                .then ()
                .extract ()
                .response ();
        logDataToFile (response);
        response
                .then ()
                .statusCode (200);
    }

    @Test
    public void getBoardById() {
        logger.log (Level.toLevel (1), "\n--------------\ngetBoardById " + new Date () + " \n--------------\n");
        response = given ().
                when ().
                get ("/10").
                then ().
                extract ().
                response ();
        logDataToFile (response);
        response
                .then ()
                .statusCode (200);
    }

    @Test
    public void deleteBoardById() {
        logger.log (Level.toLevel (1), "\n--------------\ndeleteBoardById " + new Date () + " \n--------------\n");
        response = given ().
                when ().
                delete ("/delete/11").
                then ().
                extract ().
                response ();
        logDataToFile (response);
        response
                .then ()
                .statusCode (200);
    }

    @Test
    public void updateBoardById() {
        logger.log (Level.toLevel (1), "\n--------------\nupdateBoardById " + new Date () + " \n--------------\n");
        response = given ()
                .header ("Content-type", "application/json")
                .and ()
                .body (updateBody.toString ())
                .when ()
                .put ("/update/10")
                .then ()
                .extract ()
                .response ();
        logDataToFile (response);
        response
                .then ()
                .statusCode (200);
    }

    @Test
    public void lightUpdateBoardById() {
        logger.log (Level.toLevel (1), "\n--------------\nlightUpdateBoardById " + new Date () + " \n--------------\n");
        response = given ().log ().all ()
                .header ("Content-type", "application/json")
                .and ()
                .body (lightUpdateBody.toString ())
                .when ()
                .patch ("/updateLight/10")
                .then ()
                .extract ()
                .response ();
        logDataToFile (response);
        response
                .then ().log ().all ()
                .statusCode (200).log ().all ();
    }
}
