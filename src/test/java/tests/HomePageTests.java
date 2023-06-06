package tests;

import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

public class HomePageTests extends TestBase{
    @Test
    public void openHomePage(){
        open("/");
    }
}
