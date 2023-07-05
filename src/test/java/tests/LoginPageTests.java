package tests;

import com.codeborne.selenide.Condition;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.HomePageHeaderSectionObj;
import pageObjects.LoginPageObj;
import testData.Users;
import utils.Urls;

import static com.codeborne.selenide.Selenide.open;

public class LoginPageTests extends TestBase {

    LoginPageObj loginPage = new LoginPageObj();
    HomePageHeaderSectionObj headerSection = new HomePageHeaderSectionObj();

    @BeforeMethod
    public void openLoginPage() {
        open(Urls.LOGIN_PAGE);
    }

    @Test
    public void verifyLoginPageElementsAreVisible() {
        loginPage.verifyLoginPageElements();
    }

    @Test
    public void verifyUserIsAbleToLoginAndLogoutFromTheApp() {
        loginPage.loginAsUser(Users.VALID_USER_EMAIL, Users.VALID_USER_PASS);
        headerSection.verifyUserNameIsVisibleInHeaderAfterLogin(Users.VALID_USER_NAME);
        headerSection.clickLogoutBtn();
        headerSection.verifySectionHeaderForNotLoggedInUser();
    }

    @Test
    public void verifyEmptyFieldProperties() {
        //Given
        String expectedText = "Wypełnij to pole.";
        String propLoginUsername = loginPage.getTxt_LoginEmailAddress().getDomProperty("validationMessage");
        String propLoginPassword = loginPage.getTxt_LoginPassword().getDomProperty("validationMessage");
        String propRegisterUsername = loginPage.getTxt_RegisterUserName().getDomProperty("validationMessage");
        String propRegisterEmailAddress = loginPage.getTxt_RegisterEmailAddress().getDomProperty("validationMessage");
        //When
        headerSection.clickSignupLoginBtn();
        //Then
        Assert.assertEquals(propLoginUsername, expectedText);
        Assert.assertEquals(propLoginPassword, expectedText);
        Assert.assertEquals(propRegisterUsername, expectedText);
        Assert.assertEquals(propRegisterEmailAddress, expectedText);
    }
}
