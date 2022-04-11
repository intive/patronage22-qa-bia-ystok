package base;

import org.testng.annotations.BeforeMethod;
import pages.login.LoginPage;
import pages.projects.ProjectsPage;


public class Pages extends TestBase {
    public LoginPage loginPage;
    public ProjectsPage projectsPage;


    @BeforeMethod
    public void pagedSetup() {
        loginPage = new LoginPage (driver);
        projectsPage = new ProjectsPage (driver);
    }
}