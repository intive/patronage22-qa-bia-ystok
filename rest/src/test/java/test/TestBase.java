package test;

import com.github.javafaker.Faker;
import common.Config;
import io.restassured.response.Response;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.testng.annotations.BeforeClass;

import java.io.FileNotFoundException;

public class TestBase {
    public JSONObject createBody = new JSONObject ();
    public JSONObject updateBody = new JSONObject ();
    public JSONObject lightUpdateBody = new JSONObject ();
    public Faker faker = new Faker ();
    Config configFile = new Config ();
    Logger logger;
    Response response;

    @BeforeClass
    public void loadConfig() throws FileNotFoundException {
        configFile.loadConfig ();
        createBody = new JSONObject ()
                .put ("alias", "createAlias" + faker.internet ().ipV6Address ())
                .put ("name", "createNAme" + faker.internet ().ipV6Address ())
                .put ("description", "createDesc" + faker.internet ().ipV6Address ());

        updateBody = new JSONObject ()
                .put ("alias", "updatedAlias" + faker.internet ().ipV6Address ())
                .put ("name", "updatedName" + faker.internet ().ipV6Address ())
                .put ("description", "updatedDesc" + faker.internet ().ipV6Address ());

        lightUpdateBody = new JSONObject ()
                .put ("alias", "lightUpdatedAlias" + faker.internet ().ipV6Address ())
                .put ("name", "lightUpdatedName" + faker.internet ().ipV6Address ())
                .put ("description", "lightUpdatedDescription" + faker.internet ().ipV6Address ());
    }

    public void logDataToFile(Response response) {
        logger.log (Level.toLevel (1), response);
    }
}