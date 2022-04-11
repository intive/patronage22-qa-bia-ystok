package base;

import com.github.javafaker.Faker;
import common.Config;
import common.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.SoftAssert;

import java.io.FileNotFoundException;

public class TestBase {
    protected WebDriver driver;
    protected SoftAssert softAssert;
    public Config config = new Config ();
    protected Faker faker;
    DriverFactory driverFactory;


    @BeforeClass
    public void setup() throws FileNotFoundException {
        driverFactory = new DriverFactory ();
        config.loadConfig ();
        softAssert = new SoftAssert ();
        faker = new Faker ();
        driver = driverFactory.getDriver (config.getBrowser ());
        driver.get (config.getLOG_IN_URL ());
        driver.manage ().window ().maximize ();
    }

    @AfterClass
    public void tearDown() {
//        driver.quit ();
    }

    public void goToPreviousPage() {
        driver.navigate ().back ();
    }
}