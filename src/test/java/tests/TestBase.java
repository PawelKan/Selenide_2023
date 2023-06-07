package tests;

import configuration.ConfigSelenide;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.BeforeClass;
import pageObjects.HomePageObj;

public class TestBase {

    @BeforeClass
    public void setUp(){
        ConfigSelenide config = new ConfigSelenide();
        config.setupConfigForBrowser();
    }
}
