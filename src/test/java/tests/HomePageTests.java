package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.*;
import testData.Users;
import textsOnPages.EN_HomePageTexts;

import static com.codeborne.selenide.Selenide.open;

public class HomePageTests extends TestBase {

    HomePageHeaderSectionObj headerSection = new HomePageHeaderSectionObj();
    HomePageLeftSidebarSectionObj leftSidebarSection = new HomePageLeftSidebarSectionObj();
    HomePageContentSectionObj contentSection = new HomePageContentSectionObj();
    HomePageFooterSectionObj footerSection = new HomePageFooterSectionObj();
    LoginPageObj loginPage = new LoginPageObj();

    @BeforeMethod
    public void openHomePage() {
        open("/");
    }

    @Test
    public void verifyHomePageElements() {
        headerSection.verifyTitle(EN_HomePageTexts.TITLE);
        headerSection.verifySectionHeaderForNotLoggedInUser();
        contentSection.verifySectionContent();
        footerSection.verifySectionFooter();
    }

    @Test
    public void verifyHeaderForLoggedInUser() {
        headerSection.clickSignupLoginBtn();
        loginPage.loginAsUser(Users.VALID_USER_EMAIL, Users.VALID_USER_PASS);
        headerSection.verifySectionHeaderForLoggedInUser();
    }

    @Test
    public void verifyLeftSidebarCategoryAndBrands() {
        leftSidebarSection.verifyLeftSidebarCategory();
        leftSidebarSection.verifyLeftSidebarBrands();
    }
}
