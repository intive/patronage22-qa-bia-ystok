package loginTest;

import base.Pages;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ValidCredentials extends Pages {

    @BeforeMethod
    public void setUp() {
        driver.get (config.getLOG_IN_URL ());
    }

    @Test
    public void ValidCredentialsLogIn() {
        loginPage.fillLogin (config.getValidLogin ())
                .fillPassword (config.getValidPassword ())
                .logIn ();
        projectsPage.waitToLoadPage ();
        softAssert.assertEquals (driver.getCurrentUrl (), config.getPROJECTS_URL ());
        softAssert.assertAll ();
    }

    @Test
    public void ValidCredentialAfterInvalid() {
        loginPage.fillLogin ("fooo")
                .fillPassword ("bar!")
                .logIn ();

        softAssert.assertEquals (driver.getCurrentUrl (), config.getLOG_IN_URL ());
        softAssert.assertEquals (loginPage.getPasswordInput (), "");
        softAssert.assertEquals (loginPage.getLoginInput (), "");

        loginPage.fillLogin (config.getValidLogin ())
                .fillPassword (config.getValidPassword ())
                .logIn ();

        projectsPage.waitToLoadPage ();
        softAssert.assertEquals (driver.getCurrentUrl (), config.getPROJECTS_URL ());
        softAssert.assertAll ();
    }
}
