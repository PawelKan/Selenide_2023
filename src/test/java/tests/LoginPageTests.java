package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.LoginPageObj;
import testData.Users;
import utils.Urls;

import static com.codeborne.selenide.Selenide.open;

public class LoginPageTests extends TestBase{

    LoginPageObj loginPage = new LoginPageObj();

    @BeforeMethod
    public void openLoginPage(){ open(Urls.LOGIN_PAGE);    }
    @Test
    public void verifyLoginPageElementsAreVisible(){
        loginPage.verifyLoginPageElements();
    }

    @Test
    public void verifyUserIsAbleToLoginIntoApp(){
        loginPage.loginAsUser(Users.VALID_USER_EMAIL, Users.VALID_USER_PASS);
    }
}
