package tests;

import com.codeborne.selenide.SelenideConfig;
import com.codeborne.selenide.SelenideDriver;
import com.codeborne.selenide.WebDriverRunner;
import configuration.ConfigSelenide;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class TestBase {

    @BeforeMethod
    public void setUp(){
        ConfigSelenide config = new ConfigSelenide();
        config.setupConfigForBrowser();
    }

    @AfterMethod
    public void tearDown(){
        WebDriverRunner.closeWebDriver();
    }
}
