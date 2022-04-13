package ii.service.ga;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;


public class Boards extends base {



    @BeforeTest
    public void setUp() {

        RestAssured.baseURI = getUrl() + "/board";
    }

    @Test
    public void postBoard() {

        given()
               // .log()
               // .all()
                .contentType(ContentType.JSON)
                .body(postBoardBody.toString())
                .when()
                .post("")
                .then()
                .log()
                .all()
                .assertThat();

    } //done

    @Test
    public void putBoardById() {

        given()
                .log()
                .all()
                .contentType(ContentType.JSON)
                .body(putBoardBody)
                .when()
                .post("/2")
                .then()
                .log()
                .all()
                .assertThat();
    } //done

    @Test
    public void patchBoardById() {

        given()
                .log()
                .all()
                .contentType(ContentType.JSON)
                .body(patchBoardById)
                .when()
                .patch("/1")
                .then()
                .log()
                .all()
                .assertThat();
    }


    @Test
    public void getBoardById() {


        given()
                .get("/1")
                .then()
                .log()
                .all()
                .assertThat ()
                .statusCode(200);

    } //done

    @Test
    public void getBoardList() {


        given()
                .get("")
                .then()
                .log()
                .all()
                .assertThat ()
                .statusCode(200);

    } //done


    @Test
    public void deleteBoardById() {

        when()
                .delete("/1")
                .then()
                .log()
                .all()
                .assertThat ()
                .statusCode(200);
    } //done


}
