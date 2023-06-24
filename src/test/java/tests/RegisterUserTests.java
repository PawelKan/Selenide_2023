package tests;

import com.codeborne.selenide.Condition;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.*;
import testData.DataForUserRegistration;
import testData.Users;
import textsOnPages.EN_LoginPageTexts;
import utils.Urls;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.open;

public class RegisterUserTests extends TestBase {

    LoginPageObj onLoginPage = new LoginPageObj();
    RegisterPageObj onRegisterPage = new RegisterPageObj();
    //HomePageObj homePage = new HomePageObj();
    HomePageHeaderSectionObj onPageHeader = new HomePageHeaderSectionObj();
    RegistrationSuccessPageObj onRegistrationSuccessPageObj = new RegistrationSuccessPageObj();
    DeleteUserSuccessPageObj onDeleteUserSuccessPage = new DeleteUserSuccessPageObj();

    DataForUserRegistration onRegisterUserData;

    @BeforeClass
    public void setupDataForTest(){
        onRegisterUserData = DataForUserRegistration.dataForAllRegistrationFormFields();
    }
    @Test
    public void registerNewUserAndDeleteItAfterSuccessfullRegistration(){
        open(Urls.LOGIN_PAGE);

        onLoginPage.registerUserLoginPage(onRegisterUserData.getEmail(), onRegisterUserData.getName());

        onLoginPage.clickOnSignupButton();

        onRegisterPage.fillAllRegistrationFieldsWithData(onRegisterUserData);

        onRegisterPage.clickOnCreateAccount();

        onRegistrationSuccessPageObj.verifyPageElements();
        onRegistrationSuccessPageObj.clickBtnContinue();

        onPageHeader.clickDeleteUserAccount();
        onDeleteUserSuccessPage.verifyPageElements();

        onDeleteUserSuccessPage.clickBtnContinue();
    }

    @Test
    public void tryToRegisterTheSameUserSecondTime(){
        open(Urls.LOGIN_PAGE);
        onLoginPage.registerUserLoginPage(Users.VALID_USER_EMAIL, Users.VALID_USER_NAME);
        onLoginPage.clickOnSignupButton();
        onLoginPage.getErrorMsg_EmailAlreadyExist().shouldHave(exactText(EN_LoginPageTexts.ERROR_MSG_EMAIL_ALREADY_EXIST));
    }
}
