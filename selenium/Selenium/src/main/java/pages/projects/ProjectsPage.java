package pages.projects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;

import java.util.List;

public class ProjectsPage extends BasePage {
    @FindBy(css = ".sc-hGPBjI.bYQHSX")
    WebElement header;

    @FindBy(css = ".iRtJkk")
    WebElement newProjectButton;

    @FindBy(css = ".MuiGrid-grid-xl-3")
    List<WebElement> projects;

    @FindBy(css = "input[id=\"styled-text-input\"]")
    WebElement projectNameInput;

    @FindBy(css = "#mui-15")
    WebElement headerCreateProject;

    @FindBy(xpath = "//*/button[text()=\"Utwórz\"]")
    WebElement createProjectButton;

    public ProjectsPage(WebDriver driver) {
        super (driver);
    }

    public void waitToLoadPage(){
        waitToBeClickable (newProjectButton);
    }

    public void createNewProject(String projectName){
        click (newProjectButton);
        waitToBeDisplayed (projectNameInput);
        projectNameInput.sendKeys (projectName);
        click (createProjectButton);
    }

    public String waitToShowProject(String projectName) {
        waitToBeDisplayed (projects.get (projects.size () - 1));
        return  projects.get (projects.size ()-1).getText ();
    }

    public String waitToAddProjectOnPage() {
        waitToElementsListIncrease (projects);
        return projects.get (projects.size ()-1).getText ();
    }
}
