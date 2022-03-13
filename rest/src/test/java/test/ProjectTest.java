package test;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ProjectTest extends TestBase {

    @BeforeClass
    public void setUpProjectTest() {
        RestAssured.baseURI = configFile.getURL () + "/project";
    }

    @Test
    public void createProject() {
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
    public void getProjectsList() {
        given ().
                when ().
                get ("/list?PageNumber=1&PageSize=2").
                then ().
                assertThat ().
                statusCode (200);
    }

    @Test
    public void getProjectById() {
        given ().
                when ().
                get ("/1").
                then ().
                assertThat ().
                statusCode (200);
    }

    @Test
    public void deleteProjectById() {
        given ().
                when ().
                delete ("/delete/1").
                then ().
                assertThat ().
                statusCode (200);
    }


    @Test
    public void updateProjectById() {
        given ()
                .header ("Content-type", "application/json")
                .and ()
                .body (updateBody.toString ())
                .when ()
                .put ("api/update/1")
                .then ()
                .assertThat ()
                .statusCode (200);
    }

    @Test
    public void lightUpdateProjectById() {
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
