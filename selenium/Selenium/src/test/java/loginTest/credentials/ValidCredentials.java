package loginTest.credentials;

import base.Pages;
import org.testng.annotations.Test;

public class ValidCredentials extends Pages {

    @Test
    public void ValidCredentialsLogIn() throws InterruptedException {
        loginPage.fillLogin (config.getValidLogin ())
                .fillPassword (config.getValidPassword ())
                .logIn ();
        projectsPage.loadPage (config.getPROJECTS_URL ());

        softAssert.assertEquals (driver.getCurrentUrl (), config.getPROJECTS_URL ());
        softAssert.assertAll ();
    }

    @Test
    public void ValidCredentialAfterInvalid() {
        loginPage.fillLogin ("fooo")
                .fillPassword ("bar!")
                .logIn ();

        softAssert.assertEquals (driver.getCurrentUrl (), config.getLOG_IN_URL ());
        softAssert.assertTrue (loginPage.pageLoaded ());
        softAssert.assertEquals (loginPage.getPasswordInput (), "");
        softAssert.assertEquals (loginPage.getLoginInput (), "");

        loginPage.fillLogin (config.getValidLogin ())
                .fillPassword (config.getValidPassword ())
                .logIn ();

        softAssert.assertEquals (driver.getCurrentUrl (), config.getPROJECTS_URL ());
        softAssert.assertTrue (projectsPage.pageLoaded ());
        softAssert.assertAll ();
    }
}
