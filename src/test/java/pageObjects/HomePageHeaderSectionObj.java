package pageObjects;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;
import textsOnPages.EN_HomePageTexts;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

@Getter
public class HomePageHeaderSectionObj {

    private SelenideElement sectionHeader = $("#header");

    private SelenideElement btnHeaderHome = sectionHeader.find(By.linkText("Home"));
    private SelenideElement btnProducts = sectionHeader.find(By.partialLinkText("Products"));
    private SelenideElement btnCart = sectionHeader.find(By.linkText("Cart"));
    private SelenideElement btnNotLoggedInSignupLogin = sectionHeader.find(By.partialLinkText("Signup / Login"));
    private SelenideElement btnLoggedInLogout = sectionHeader.find(By.linkText("Logout"));
    private SelenideElement btnTestCases = sectionHeader.find(By.linkText("Test Cases"));
    private SelenideElement btnAPITesting = sectionHeader.find(By.linkText("API Testing"));
    private SelenideElement btnVideoTutorials = sectionHeader.find(By.linkText("Video Tutorials"));
    private SelenideElement btnContactUs = sectionHeader.find(By.linkText("Contact us"));
    private SelenideElement btnLoggedInUserName = sectionHeader.find(By.partialLinkText("Logged in as"));
    private SelenideElement btnLoggedInDeleteUser = sectionHeader.find(By.linkText("Delete Account"));




    //private String textLoggedInUser = " Logged in as ";

    public void verifySectionHeaderForNotLoggedInUser(){
        sectionHeader.shouldBe(visible);
        btnHeaderHome.shouldBe(visible).shouldHave(text(EN_HomePageTexts.headerHome));
        btnProducts.shouldBe(visible).shouldHave(text(EN_HomePageTexts.headerProducts));
        btnCart.shouldBe(visible).shouldHave(text(EN_HomePageTexts.headerCart));
        btnNotLoggedInSignupLogin.shouldBe(visible).shouldHave(text(EN_HomePageTexts.headerSignupLoginForNotLoggedIn));
        btnTestCases.shouldBe(visible).shouldHave(text(EN_HomePageTexts.headerTestCases));
        btnAPITesting.shouldBe(visible).shouldHave(text(EN_HomePageTexts.headerApiTesting));
        btnVideoTutorials.shouldBe(visible).shouldHave(text(EN_HomePageTexts.headerVideoTutorials));
        btnContactUs.shouldBe(visible).shouldHave(text(EN_HomePageTexts.headerContactUs));

        btnLoggedInUserName.shouldNotBe(visible);
        btnLoggedInDeleteUser.shouldNotBe(visible);
        btnLoggedInLogout.shouldNotBe(visible);
    }
    public void verifySectionHeaderForLoggedInUser(){
        sectionHeader.shouldBe(visible);
        btnHeaderHome.shouldBe(visible).shouldHave(text(EN_HomePageTexts.headerHome));
        btnProducts.shouldBe(visible).shouldHave(text(EN_HomePageTexts.headerProducts));
        btnLoggedInLogout.shouldBe(visible);
        btnCart.shouldBe(visible).shouldHave(text(EN_HomePageTexts.headerCart));
        btnLoggedInUserName.shouldBe(visible).shouldHave(text(EN_HomePageTexts.headerLoggedIn));
        btnLoggedInDeleteUser.shouldBe(visible).shouldHave(text(EN_HomePageTexts.headerDeleteAccountForLoggedUser));
        btnTestCases.shouldBe(visible).shouldHave(text(EN_HomePageTexts.headerTestCases));
        btnAPITesting.shouldBe(visible).shouldHave(text(EN_HomePageTexts.headerApiTesting));
        btnVideoTutorials.shouldBe(visible).shouldHave(text(EN_HomePageTexts.headerVideoTutorials));
        btnContactUs.shouldBe(visible).shouldHave(text(EN_HomePageTexts.headerContactUs));

        btnNotLoggedInSignupLogin.shouldNot(exist);
    }


    public void verifyUserNameIsVisibleInHeaderAfterLogin(String userName){
        btnLoggedInUserName.shouldHave(text(EN_HomePageTexts.headerLoggedIn));
        btnLoggedInUserName.shouldHave(text(userName));
    }

    public void clickSignupLoginBtn(){ btnNotLoggedInSignupLogin.click(); }

    public void clickLogoutBtn() { btnLoggedInLogout.click(); }
    public void clickDeleteUserAccount(){ btnLoggedInDeleteUser.click(); }


}
