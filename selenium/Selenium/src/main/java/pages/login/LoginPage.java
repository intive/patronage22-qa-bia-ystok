package pages.login;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;

import java.util.List;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super (driver);
    }

    @FindBy(css = "input[name=\"password\"]")
    WebElement passwordInput;

    @FindBy(css = "input[name=\"login\"]")
    WebElement loginInput;

    @FindBy(css = ".MuiGrid-grid-xl-3")
    List<WebElement> projects;

    public LoginPage fillLogin(String login) {
        loginInput.sendKeys (login);
        return this;
    }

    public LoginPage fillPassword(String passwd) {
        passwordInput.sendKeys (passwd);
        return this;
    }

    public void logIn() {
        passwordInput.sendKeys (Keys.ENTER);
    }

    public String getLoginInput(){
        return loginInput.getAttribute ("value");
    }

    public String getPasswordInput(){
        return passwordInput.getAttribute ("value");
    }
}
