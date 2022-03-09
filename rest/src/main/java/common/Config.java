package common;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {
    private String URL;
    public void loadConfig() throws FileNotFoundException {
        InputStream input = new FileInputStream ("src/test/resources/application.properties");
        Properties prop = new Properties();

        try {
            prop.load(input);
            this.setURL (prop.getProperty("URL"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }
}
