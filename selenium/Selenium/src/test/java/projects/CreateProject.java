package projects;

import base.Pages;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateProject extends Pages {

    @BeforeMethod
    public void setUp() {
        driver.get (config.getLOG_IN_URL ());
    }

    @Test
    public void CreateProjectWithValidData(){
        loginPage.fillLogin (config.getValidLogin ())
                .fillPassword (config.getValidPassword ())
                .logIn ();
        projectsPage.waitToLoadPage ();

        String projectName = faker.company ().name ();
        projectsPage.createNewProject (projectName);
        String projectNameOnPage = projectsPage.waitToAddProjectOnPage ();
        softAssert.assertEquals (projectName, projectNameOnPage);
        softAssert.assertAll ();
    }
}
