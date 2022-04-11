package common;

import enums.Browser;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {
    private String LOG_IN_URL;
    private String PROJECTS_URL;
    private Browser browser;
    private String validPassword;
    private String validLogin;


    public void loadConfig() throws FileNotFoundException {
        InputStream input = new FileInputStream("src/main/resources/config.properties");
        Properties prop = new Properties();

        try {
            prop.load(input);
            this.setLOG_IN_URL (prop.getProperty("LOG_IN_URL"));
            this.setPROJECTS_URL(prop.getProperty("PROJECTS_URL"));
            this.setBrowser(prop.getProperty("browser"));
            this.setValidPassword (prop.getProperty("validPassword"));
            this.setValidLogin (prop.getProperty("validLogin"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getLOG_IN_URL() {
        return LOG_IN_URL;
    }

    public void setLOG_IN_URL(String LOG_IN_URL) {
        this.LOG_IN_URL = LOG_IN_URL;
    }

    public Browser getBrowser() {
        return browser;
    }

    public void setBrowser(String browser) {
        this.browser = Browser.valueOf(browser);    }

    public String getValidPassword() {
        return validPassword;
    }

    public void setValidPassword(String validPassword) {
        this.validPassword = validPassword;
    }

    public String getValidLogin() {
        return validLogin;
    }

    public void setValidLogin(String validLogin) {
        this.validLogin = validLogin;
    }

    public String getPROJECTS_URL() {
        return PROJECTS_URL;
    }

    public void setPROJECTS_URL(String PROJECTS_URL) {
        this.PROJECTS_URL = PROJECTS_URL;
    }
}