package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.LoginPageObj;
import pageObjects.RegisterPageObj;
import testData.DataForUserRegistration;
import utils.Urls;

import static com.codeborne.selenide.Selenide.open;

public class RegisterUserTests extends TestBase {

    LoginPageObj loginPage = new LoginPageObj();
    RegisterPageObj registerPage = new RegisterPageObj();
    DataForUserRegistration registerUserData;

    @BeforeClass
    public void setupDataForTest(){
        registerUserData = DataForUserRegistration.dataForAllRegistrationFormFields();
    }
    @Test
    public void registerNewUser(){
        open(Urls.LOGIN_PAGE);

        loginPage.registerUserLoginPage(registerUserData.getEmail(), registerUserData.getName());

        loginPage.clickOnSignupButton();

        registerPage.fillAllRegistrationFieldsWithData(registerUserData);

        registerPage.clickOnCreateAccount();
    }
}
