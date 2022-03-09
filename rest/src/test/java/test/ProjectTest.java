package test;

import io.restassured.RestAssured;
import org.json.JSONObject;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ProjectTest extends TestBase {

    @BeforeTest
    public void setUpProjectTest() {
        RestAssured.baseURI = configFile.getURL () + "/project";
    }

    @Test
    public void createProject() {
        String createBody = new JSONObject ()
                .put ("alias", "createAlias")
                .put ("name", "createNAme")
                .put ("description", "createDesc")
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
        String updateBody = new JSONObject ()
                .put ("alias", "updatedAlias")
                .put ("name", "updatedName")
                .put ("description", "updatedDesc")
                .toString ();
        given ()
                .header ("Content-type", "application/json")
                .and ()
                .body (updateBody)
                .when ()
                .put ("api/update/1")
                .then ()
                .assertThat ()
                .statusCode (200);
    }

    @Test
    public void lightUpdateProjectById() {
        String lightUpdateBody = new JSONObject ()
                .put ("alias", "lightUpdatedAlias")
                .put ("name", "lightUpdatedName")
                .put ("description", "lightUpdatedDescription")
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
