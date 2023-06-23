package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.*;
import testData.DataForUserRegistration;
import utils.Urls;

import static com.codeborne.selenide.Selenide.open;

public class RegisterUserTests extends TestBase {

    LoginPageObj loginPage = new LoginPageObj();
    RegisterPageObj registerPage = new RegisterPageObj();

    HomePageObj homePage = new HomePageObj();
    RegistrationSuccessPageObj registrationSuccessPageObj = new RegistrationSuccessPageObj();

    DeleteUserSuccessPageObj deleteUserSuccessPage = new DeleteUserSuccessPageObj();

    DataForUserRegistration registerUserData;

    @BeforeClass
    public void setupDataForTest(){
        registerUserData = DataForUserRegistration.dataForAllRegistrationFormFields();
    }
    @Test
    public void registerNewUserAndDeleteItAfterSuccessfullRegistration(){
        open(Urls.LOGIN_PAGE);

        loginPage.registerUserLoginPage(registerUserData.getEmail(), registerUserData.getName());

        loginPage.clickOnSignupButton();

        registerPage.fillAllRegistrationFieldsWithData(registerUserData);

        registerPage.clickOnCreateAccount();

        registrationSuccessPageObj.verifyPageElements();
        registrationSuccessPageObj.clickBtnContinue();

        homePage.clickDeleteUserAccount();
        deleteUserSuccessPage.verifyPageElements();

        deleteUserSuccessPage.clickBtnContinue();
    }
}
