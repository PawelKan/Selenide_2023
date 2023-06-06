package configuration;

import com.codeborne.selenide.Configuration;

public class config {

    public void setupConfigForBrowser(){
        Configuration.browser = System.getProperty("browser");
        Configuration.baseUrl = System.getProperty("baseUrl");
        Configuration.timeout = Long.parseLong(System.getProperty("timeout"));
        Configuration.browserSize = System.getProperty("browserSize");
        Configuration.holdBrowserOpen = Boolean.parseBoolean(System.getProperty("holdBrowserOpen"));
    }
}
