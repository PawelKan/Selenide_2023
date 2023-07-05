package pageObjects;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import textsOnPages.EN_LoginPageTexts;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

@Getter
public class LoginPageObj extends BasePage{

    //Login Section
    private SelenideElement header_LoginToYourAccount = $(".login-form > h2");
    private SelenideElement txt_LoginEmailAddress = $("input[data-qa=\"login-email\"]");
    private SelenideElement txt_LoginPassword = $("input[data-qa=\"login-password\"]");
    private SelenideElement btn_Login = $("button[data-qa=\"login-button\"]");

    //Register section
    private SelenideElement header_NewUserSignup = $(".signup-form > h2");
    private SelenideElement txt_RegisterUserName = $("input[data-qa=\"signup-name\"]");
    private SelenideElement txt_RegisterEmailAddress = $("input[data-qa=\"signup-email\"]");
    private SelenideElement btn_Signup = $("button[data-qa=\"signup-button\"]");
    private SelenideElement errorMsg_EmailAlreadyExist = $(".signup-form p");

    public void verifyLoginPageElements() {
        header_LoginToYourAccount.shouldBe(visible);
        header_LoginToYourAccount.shouldHave(text(EN_LoginPageTexts.LOGIN_TO_YOUR_ACCOUNT_HEADER));

        txt_LoginEmailAddress.shouldBe(visible);
        txt_LoginPassword.shouldBe(visible);
        btn_Login.shouldBe(visible);

        header_NewUserSignup.shouldBe(visible);
        header_NewUserSignup.shouldHave(text(EN_LoginPageTexts.NEW_USER_SIGNUP_HEADER));

        txt_RegisterUserName.shouldBe(visible);
        txt_RegisterEmailAddress.shouldBe(visible);
        btn_Signup.shouldBe(visible);
    }

    public void loginAsUser(String userName, String password) {
        txt_LoginEmailAddress.clear();
        txt_LoginEmailAddress.sendKeys(userName);

        txt_LoginPassword.clear();
        txt_LoginPassword.sendKeys(password);

        btn_Login.click();
    }

    public void registerUserLoginPage(String email, String name) {
        txt_RegisterEmailAddress.clear();
        txt_RegisterEmailAddress.sendKeys(email);

        txt_RegisterUserName.clear();
        txt_RegisterUserName.sendKeys(name);
    }

    public void clickOnSignupButton() {
        btn_Signup.click();
    }
}
