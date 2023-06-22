package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.HomePageObj;

import static com.codeborne.selenide.Selenide.open;

public class HomePageTests extends TestBase{

    HomePageObj homePage = new HomePageObj();
    @BeforeMethod
    public void openHomePage(){ open("/");    }

    @Test
    public void verifyHomePageHeaderContentFooterSections(){
        homePage.verifySectionHeader();
        homePage.verifySectionContent();
        homePage.verifySectionFooter();
    }
}
