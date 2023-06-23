package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.*;
import testData.DataForUserRegistration;
import utils.Urls;

import static com.codeborne.selenide.Selenide.open;

public class RegisterUserTests extends TestBase {

    LoginPageObj onLoginPage = new LoginPageObj();
    RegisterPageObj onRegisterPage = new RegisterPageObj();
    //HomePageObj homePage = new HomePageObj();
    HeaderSectionPageObj onPageHeader = new HeaderSectionPageObj();
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
}
