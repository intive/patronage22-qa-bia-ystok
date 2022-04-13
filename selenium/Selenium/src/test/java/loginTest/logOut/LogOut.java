package loginTest.logOut;

import base.Pages;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class LogOut extends Pages {

    @BeforeGroups
    public void setUp() {
        loginPage.loadPage ();
        loginPage.fillLogin (config.getValidLogin ())
                .fillPassword (config.getValidPassword ())
                .logIn ();
        projectsPage.logOut ();
    }

    @Test
    public void AccessToProjects() {
        driver.get (config.getPROJECTS_URL ());

        softAssert.assertEquals (driver.getCurrentUrl (), config.getPROJECTS_URL ());
        softAssert.assertTrue (loginPage.pageLoaded ());
        softAssert.assertAll ();
    }

    @Test
    public void LogInAfterLogOut() {
        loginPage.loadPage ();
        loginPage.fillLogin (config.getValidLogin ())
                .fillPassword (config.getValidPassword ())
                .logIn ();

        softAssert.assertEquals (driver.getCurrentUrl (), config.getPROJECTS_URL ());
        softAssert.assertAll ();
    }
}
