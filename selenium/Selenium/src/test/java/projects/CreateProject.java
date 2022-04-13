package projects;

import base.Pages;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateProject extends Pages {

    @BeforeMethod
    public void setUp() {
        loginPage.loadPage ();
        loginPage.fillLogin (config.getValidLogin ())
                .fillPassword (config.getValidPassword ())
                .logIn ();
    }

    @Test
    public void CreateProjectWithValidData() {
        String projectName = faker.company ().name ().replaceAll ("[^a-zA-Z0-9]", " ");
        projectsPage.createNewProject (projectName);

        String projectNameOnPage = projectsPage.waitToAddProjectOnPage ();
        softAssert.assertEquals (projectName, projectNameOnPage);
        softAssert.assertAll ();
    }

    @Test
    public void CreateProjectWithInvalidDataComma() {
        String projectName = faker.company ().name () + ",";
        projectsPage.fillProjectName (projectName);

        softAssert.assertEquals (config.getErrorMessage (), projectsPage.getErrorMessage ());
        softAssert.assertAll ();
        projectsPage.clickCancelButton ();
    }

    @Test
    public void CreateProjectWithInvalidDataSpaceAtTheEnd() {
        String projectName = faker.company ().name () + " ";
        projectsPage.fillProjectName (projectName);

        softAssert.assertEquals (config.getErrorMessage (), projectsPage.getErrorMessage ());
        softAssert.assertAll ();
        projectsPage.clickCancelButton ();
    }

    @AfterMethod
    public void logOut() {
        projectsPage.logOut ();
    }
}
