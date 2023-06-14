package tests;

import com.codeborne.selenide.Condition;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.HomePageObj;
import pageObjects.LoginPageObj;
import testData.Users;
import utils.Urls;

import static com.codeborne.selenide.Selenide.open;

public class LoginPageTests extends TestBase{

    HomePageObj homePage = new HomePageObj();
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
        homePage.verifyUserNameIsVisibleInHeaderAfterLogin(Users.VALID_USER_NAME);
    }
}
