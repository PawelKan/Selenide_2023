package tests;

import com.codeborne.selenide.Config;
import com.codeborne.selenide.Selenide;
import configuration.ConfigSelenide;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

public class HomePage extends TestBase{
    @Test
    public void openHomePage(){
        open("/");
    }
}
