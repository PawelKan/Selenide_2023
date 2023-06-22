package pageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class LoginPageObj {

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

    private String textForLoginToYourAccountHeader = "Login to your account";
    private String textForNewUserSignupHeader = "New User Signup!";

    public void verifyLoginPageElements(){
        header_LoginToYourAccount.shouldBe(visible);
        header_LoginToYourAccount.shouldHave(Condition.text(textForLoginToYourAccountHeader));

        txt_LoginEmailAddress.shouldBe(visible);
        txt_LoginPassword.shouldBe(visible);
        btn_Login.shouldBe(visible);

        header_NewUserSignup.shouldBe(visible);
        header_NewUserSignup.shouldHave(Condition.text(textForNewUserSignupHeader));

        txt_RegisterUserName.shouldBe(visible);
        txt_RegisterEmailAddress.shouldBe(visible);
        btn_Signup.shouldBe(visible);
    }
    public void loginAsUser(String userName, String password){
        txt_LoginEmailAddress.clear();
        txt_LoginEmailAddress.sendKeys(userName);

        txt_LoginPassword.clear();
        txt_LoginPassword.sendKeys(password);

        btn_Login.click();
    }

    public void registerUserLoginPage(String email, String name){
        txt_RegisterEmailAddress.clear();
        txt_RegisterEmailAddress.sendKeys(email);

        txt_RegisterUserName.clear();
        txt_RegisterUserName.sendKeys(name);
    }

    public void clickOnSignupButton() { btn_Signup.click();}
}
