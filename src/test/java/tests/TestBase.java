package tests;

import configuration.ConfigSelenide;
import org.testng.annotations.BeforeClass;

public class TestBase {

    @BeforeClass
    public void setUp(){
        ConfigSelenide config = new ConfigSelenide();
        config.setupConfigForBrowser();
    }
}
