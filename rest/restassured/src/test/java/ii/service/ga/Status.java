package ii.service.ga;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class Status extends base{

    @BeforeTest
    public void setUp() {

        RestAssured.baseURI = getUrl() + "/status";
        // RestAssured.baseURI = "https://patronageapi.herokuapp.com";
    }

    @Test
    public void getStatusById() {


        given()
                .get("/1")
                .then()
                .log()
                .all()
                .assertThat ()
                .statusCode(200);

    }

    @Test
    public void getStatusesList() {


        given()
                .get("")
                .then()
                .log()
                .all()
                .assertThat ()
                .statusCode(200);

    }


    @Test
    public void deleteStatusById() {

        when()
                .delete("/1")
                .then()
                .log()
                .all()
                .assertThat ()
                .statusCode(200);
    }

    @Test
    public void postStatus() {

        given()
                .contentType(ContentType.JSON)
                .body(postStatusBody.toString())
                .when()
                .post("")
                .then()
                .log()
                .all()
                .assertThat();

    } //done

    @Test
    public void putStatusById() {

        given()
                .log()
                .all()
                .contentType(ContentType.JSON)
                .body(putStatusBody)
                .when()
                .post("/3")
                .then()
                .log()
                .all()
                .assertThat();
    } //done

}
