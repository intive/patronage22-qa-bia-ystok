package loginTest;

import base.Pages;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class InvalidCredentials extends Pages {

    @BeforeMethod
    public void setUp() {
        driver.get (config.getLOG_IN_URL ());
    }

    @Test
    public void InvalidCredentialsLogIn() {
        loginPage.fillLogin ("fooo")
                .fillPassword ("bar!")
                .logIn ();

        softAssert.assertEquals (driver.getCurrentUrl (), config.getLOG_IN_URL ());
        softAssert.assertEquals (loginPage.getPasswordInput (), "");
        softAssert.assertEquals (loginPage.getLoginInput (), "");
        softAssert.assertAll ();
    }

    @Test
    public void ValidLoginInvalidPassword() {
        loginPage.fillLogin (config.getValidLogin ())
                .fillPassword ("bar!")
                .logIn ();

        softAssert.assertEquals (driver.getCurrentUrl (), config.getLOG_IN_URL ());
        softAssert.assertEquals (loginPage.getPasswordInput (), "");
        softAssert.assertEquals (loginPage.getLoginInput (), "");
        softAssert.assertAll ();
    }


    @Test
    public void ValidPasswordInvalidLogin() {
        loginPage.fillLogin ("fooo")
                .fillPassword (config.getValidPassword ())
                .logIn ();

        softAssert.assertEquals (driver.getCurrentUrl (), config.getLOG_IN_URL ());
        softAssert.assertEquals (loginPage.getPasswordInput (), "");
        softAssert.assertEquals (loginPage.getLoginInput (), "");
        softAssert.assertAll ();
    }


}
