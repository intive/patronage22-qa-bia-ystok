package loginTest.security;

import base.Pages;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PasswordSecurity extends Pages {

    @BeforeMethod
    public void setUp() {
        driver.get (config.getLOG_IN_URL ());
        loginPage.loadPage ();
    }

    @Test
    public void CopyPasswordFromInput() {
        String passwordToSteal = faker.color ().name ();
        loginPage.fillPassword (passwordToSteal);

        loginPage.stealPassword ();
        softAssert.assertNotEquals (loginPage.getLoginInput (), passwordToSteal);
        softAssert.assertAll ();
    }
}
