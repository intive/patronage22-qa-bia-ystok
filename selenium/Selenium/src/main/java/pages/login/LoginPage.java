package pages.login;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;

public class LoginPage extends BasePage {
    @FindBy(css = "input[name=\"password\"]")
    WebElement passwordInput;
    @FindBy(css = "input[name=\"login\"]")
    WebElement loginInput;

    public LoginPage(WebDriver driver) {
        super (driver);
    }

    public LoginPage fillLogin(String login) {
        loginInput.sendKeys (login);
        return this;
    }

    public LoginPage fillPassword(String passwd) {
        passwordInput.sendKeys (passwd);
        return this;
    }

    public LoginPage logIn() {
        passwordInput.sendKeys (Keys.ENTER);
        return this;
    }

    public String getLoginInput() {
        return loginInput.getAttribute ("value");
    }

    public String getPasswordInput() {
        return passwordInput.getAttribute ("value");
    }

    public void loadPage() {
        waitToBeDisplayed (loginInput);
    }

    public boolean pageLoaded() {
        return loginInput.isDisplayed ();
    }

    public WebElement getWebElementPasswordInput() {
        return passwordInput;
    }

    public void stealPassword() {
        passwordInput.sendKeys (Keys.CONTROL + "a");
        passwordInput.sendKeys (Keys.CONTROL + "c");
        loginInput.sendKeys (Keys.CONTROL + "v");
    }
}
