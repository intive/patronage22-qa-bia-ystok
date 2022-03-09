package test;

import common.Config;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import java.io.FileNotFoundException;

public class TestBase {
    Config configFile = new Config ();

    @BeforeSuite
    public void setUpLog() {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails ();
    }

    @BeforeClass
    public void loadConfig() throws FileNotFoundException {
        configFile.loadConfig ();
    }
}
