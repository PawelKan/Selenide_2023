package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.HeaderSectionPageObj;
import pageObjects.HomePageObj;
import pageObjects.LoginPageObj;
import testData.Users;

import static com.codeborne.selenide.Selenide.open;

public class HomePageTests extends TestBase{

    HomePageObj homePage = new HomePageObj();
    HeaderSectionPageObj headerSection = new HeaderSectionPageObj();
    LoginPageObj loginPage = new LoginPageObj();

    @BeforeMethod
    public void openHomePage(){ open("/");    }

    @Test
    public void verifyHomePageHeaderContentFooterSections(){
        headerSection.verifySectionHeaderForNotLoggedInUser();
        homePage.verifySectionContent();
        homePage.verifySectionFooter();
    }

    @Test
    public void verifyHeaderForLoggedInUser(){
        headerSection.clickSignupLoginBtn();
        loginPage.loginAsUser(Users.VALID_USER_EMAIL, Users.VALID_USER_PASS);
        headerSection.verifySectionHeaderForLoggedInUser();
    }
}
