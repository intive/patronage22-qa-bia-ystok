package test;

import io.restassured.RestAssured;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Date;

import static io.restassured.RestAssured.given;

public class ProjectTest extends TestBase {

    @BeforeClass
    public void setUpProjectTest() {
        RestAssured.baseURI = configFile.getURL () + "/project";
        logger = Logger.getLogger (ProjectTest.class);
    }

    @Test
    public void createProject() {
        logger.log (Level.toLevel (1), "\n--------------\ncreateProject " + new Date () + " \n--------------\n");
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
    public void getProjectsList() {
        logger.log (Level.toLevel (1), "\n--------------\ngetProjectsList " + new Date () + "\n--------------\n");
        response = given ()
                .when ()
                .get ()
                .then ()
                .extract ()
                .response ();
        logDataToFile (response);
        response
                .then ()
                .statusCode (200);
    }

    @Test
    public void getProjectById() {
        logger.log (Level.toLevel (1), "\n--------------\ngetProjectById " + new Date () + "\n--------------\n");
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
    public void deleteProjectById() {
        logger.log (Level.toLevel (1), "\n--------------\ndeleteProjectById "  + new Date () + "\n--------------\n");
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
    public void updateProjectById() {
        logger.log (Level.toLevel (1), "\n--------------\nupdateProjectById " + new Date () + "\n--------------\n");
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
    public void lightUpdateProjectById() {
        logger.log (Level.toLevel (1), "\n--------------\nlightUpdateProjectById "  + new Date () + "\n--------------\n");
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
