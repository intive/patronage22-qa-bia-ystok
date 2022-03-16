package test;

import io.restassured.RestAssured;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Date;

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
        logger = Logger.getLogger (IssueTest.class);
    }


    @Test
    public void createIssue() {
        logger.log (Level.toLevel (1), "\n--------------\ncreateIssue " + new Date () + " \n--------------\n");
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
    public void getIssuesList() {
        logger.log (Level.toLevel (1), "\n--------------\ngetIssuesList " + new Date () + " \n--------------\n");
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
    public void getIssueById() {
        logger.log (Level.toLevel (1), "\n--------------\ngetIssueById " + new Date () + " \n--------------\n");
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
    public void deleteIssueById() {
        logger.log (Level.toLevel (1), "\n--------------\ndeleteIssueById " + new Date () + " \n--------------\n");
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
    public void updateIssueById() {
        logger.log (Level.toLevel (1), "\n--------------\nupdateIssueById " + new Date () + " \n--------------\n");
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
    public void lightUpdateIssueById() {
        logger.log (Level.toLevel (1), "\n--------------\nlightUpdateIssueById " + new Date () + " \n--------------\n");
        response = given ()
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
                .then ()
                .statusCode (200);
    }
}