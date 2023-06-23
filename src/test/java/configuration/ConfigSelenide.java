package configuration;

import com.codeborne.selenide.Configuration;
import lombok.SneakyThrows;
import org.testng.internal.ConfigurationGroupMethods;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigSelenide {

    @SneakyThrows
    public void setupConfigForBrowser(){
        Properties prop = new Properties();

        prop.load(new FileInputStream("src/main/resources/envProperties.properties"));

        Configuration.browser = prop.get("browser").toString();
        Configuration.baseUrl = prop.get("baseUrl").toString();
        Configuration.timeout = Long.parseLong(prop.get("timeout").toString());
        Configuration.browserSize = prop.get("browserSize").toString();
        Configuration.holdBrowserOpen = Boolean.parseBoolean(prop.get("holdBrowserOpen").toString());
    }
}
