package pageObjects;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.By;
import textsOnPages.EN_HomePageTexts;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

@Getter
public class HomePageHeaderSectionObj extends BasePage {

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
    @Step("HomePage - Header - Verify for NOT LOGGED IN user")
    public void verifySectionHeaderForNotLoggedInUser() {
        sectionHeader.shouldBe(visible);
        btnHeaderHome.shouldBe(visible).shouldHave(text(EN_HomePageTexts.HEADER_HOME));
        btnProducts.shouldBe(visible).shouldHave(text(EN_HomePageTexts.HEADER_PRODUCTS));
        btnCart.shouldBe(visible).shouldHave(text(EN_HomePageTexts.HEADER_CART));
        btnNotLoggedInSignupLogin.shouldBe(visible).shouldHave(text(EN_HomePageTexts.HEADER_SIGNUP_LOGIN_FOR_NOT_LOGGED_IN));
        btnTestCases.shouldBe(visible).shouldHave(text(EN_HomePageTexts.HEADER_TEST_CASES));
        btnAPITesting.shouldBe(visible).shouldHave(text(EN_HomePageTexts.HEADER_API_TESTING));
        btnVideoTutorials.shouldBe(visible).shouldHave(text(EN_HomePageTexts.HEADER_VIDEO_TUTORIALS_));
        btnContactUs.shouldBe(visible).shouldHave(text(EN_HomePageTexts.HEADER_CONTACT_US));

        btnLoggedInUserName.shouldNotBe(visible);
        btnLoggedInDeleteUser.shouldNotBe(visible);
        btnLoggedInLogout.shouldNotBe(visible);
    }

    @Step("HomePage - Header - Verify for LOGGED IN User")
    public void verifySectionHeaderForLoggedInUser() {
        sectionHeader.shouldBe(visible);
        btnHeaderHome.shouldBe(visible).shouldHave(text(EN_HomePageTexts.HEADER_HOME));
        btnProducts.shouldBe(visible).shouldHave(text(EN_HomePageTexts.HEADER_PRODUCTS));
        btnLoggedInLogout.shouldBe(visible);
        btnCart.shouldBe(visible).shouldHave(text(EN_HomePageTexts.HEADER_CART));
        btnLoggedInUserName.shouldBe(visible).shouldHave(text(EN_HomePageTexts.HEADER_LOGGED_IN));
        btnLoggedInDeleteUser.shouldBe(visible).shouldHave(text(EN_HomePageTexts.HEADER_DELETE_ACCOUNT_FOR_LOGGED_USER));
        btnTestCases.shouldBe(visible).shouldHave(text(EN_HomePageTexts.HEADER_TEST_CASES));
        btnAPITesting.shouldBe(visible).shouldHave(text(EN_HomePageTexts.HEADER_API_TESTING));
        btnVideoTutorials.shouldBe(visible).shouldHave(text(EN_HomePageTexts.HEADER_VIDEO_TUTORIALS_));
        btnContactUs.shouldBe(visible).shouldHave(text(EN_HomePageTexts.HEADER_CONTACT_US));

        btnNotLoggedInSignupLogin.shouldNot(exist);
    }

    @Step("HomePage - Header - Logged in user NAME is visible")
    public void verifyUserNameIsVisibleInHeaderAfterLogin(String userName) {
        btnLoggedInUserName.shouldHave(text(EN_HomePageTexts.HEADER_LOGGED_IN));
        btnLoggedInUserName.shouldHave(text(userName));
    }

    @Step
    public void clickSignupLoginBtn() {
        btnNotLoggedInSignupLogin.click();
    }

    @Step
    public void clickLogoutBtn() {
        btnLoggedInLogout.click();
    }

    @Step
    public void clickDeleteUserAccount() {
        btnLoggedInDeleteUser.click();
    }
}
