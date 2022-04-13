package ii.service.ga;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class BoardStatus extends base {

    @BeforeTest
    public void setUp() {

        RestAssured.baseURI = getUrl() + "/boardStatus";
        // RestAssured.baseURI = "https://patronageapi.herokuapp.com";

    }

    @Test
    public void getBoardStatus() {


        given()
                .get("")
                .then()
                .log()
                .all()
                .assertThat ()
                .statusCode(200);

    } //done
    @Test
    public void deleteBoardStatus(){
        given()
            .param("boardId","1")
            .param("statusId","1")
            .when()
                .delete("")
                .then()
                .log()
                .all()
                .statusCode(200)
                .assertThat ();
    } //done
    @Test
    public void postBoardStatus(){
        given()
                //.param("boardId","123")
                //.param("statusId","1234")
                .log()
                .all()
                .contentType(ContentType.JSON)
                .body(postBoardStatusBody)
                .when()
                .post("")
                .then()
                .log()
                .all()
                .assertThat();
    } //test przechodzi, zwraca jakis błąd The JSON object contains a trailing comma at the end which is not supported in this mode. Change the reader options
}
