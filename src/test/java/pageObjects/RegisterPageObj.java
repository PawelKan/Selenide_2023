package pageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import testData.DataForUserRegistration;

import static com.codeborne.selenide.Selenide.$;

public class RegisterPageObj extends BasePage {
    private SelenideElement rad_TitleMr = $("#id_gender1");
    private SelenideElement rad_titleMrs = $("#id_gender2");
    private SelenideElement txt_name = $("[data-qa=\"name\"]");
    private SelenideElement txt_email = $("[data-qa=\"email\"]");
    private SelenideElement txt_pass = $("[data-qa=\"password\"]");
    private SelenideElement list_dateOfBirthDay = $("[data-qa=\"days\"]");
    private SelenideElement list_dateOfBirthMonth = $("[data-qa=\"months\"]");
    private SelenideElement list_dateOfBirthYear = $("[data-qa=\"years\"]");
    private SelenideElement chk_Newsletter = $("#form > div > div > div > div > form > div:nth-child(7)");
    private SelenideElement chk_SpecialOffers = $("#optin");
    private SelenideElement txt_FirstName = $("[data-qa=\"first_name\"]");
    private SelenideElement txt_LastName = $("[data-qa=\"last_name\"]");
    private SelenideElement txt_Company = $("[data-qa=\"company\"]");
    private SelenideElement txt_Address1 = $("[data-qa=\"address\"]");
    private SelenideElement txt_Address2 = $("[data-qa=\"address2\"]");
    private SelenideElement list_Country = $("[data-qa=\"country\"]");
    private SelenideElement txt_State = $("[data-qa=\"state\"]");
    private SelenideElement txt_City = $("[data-qa=\"city\"]");
    private SelenideElement txt_Zipcode = $("[data-qa=\"zipcode\"]");
    private SelenideElement txt_MobilNumber = $("[data-qa=\"mobile_number\"]");
    private SelenideElement btn_CreateAccount = $("[data-qa=\"create-account\"]");

    public void setTitle(boolean isMale) {
        if (isMale == true) {
            rad_TitleMr.click();
        } else {
            rad_titleMrs.click();
        }
    }

    @Step
    public void setName(String text) {
        txt_name.sendKeys(text);
    }

    @Step
    public void setEmail(String text) {
        txt_email.sendKeys(text);
    }

    @Step
    public void setPass(String text) {
        txt_pass.sendKeys(text);
    }

    @Step
    public void setDoBDay(String listValue) {
        list_dateOfBirthDay.selectOptionByValue(listValue);
    }

    @Step
    public void setDoBMonth(String listValue) {
        list_dateOfBirthMonth.selectOptionByValue(listValue);
    }

    @Step
    public void setDoBYears(String listValue) {
        list_dateOfBirthYear.selectOptionByValue(listValue);
    }

    @Step("Register Page - check Newsletter")
    public void setNewsletter(boolean isNewsletterOn) {
        if (isNewsletterOn == true) {
            chk_Newsletter.click();
            //chk_Newsletter.shouldBe(Condition.selected);
        } else {
            chk_Newsletter.shouldNotBe(Condition.selected);
        }
    }

    @Step("Register Page - check Special Offer")
    public void setSpecialOffer(boolean isSpecialOfferOn) {
        if (isSpecialOfferOn == true) {
            chk_SpecialOffers.click();
            //chk_SpecialOffers.shouldBe(Condition.selected);
        } else {
            chk_SpecialOffers.shouldNotBe(Condition.selected);
        }
    }

    @Step
    public void setFirstName(String text) {
        txt_FirstName.sendKeys(text);
    }

    @Step
    public void setLastName(String text) {
        txt_LastName.sendKeys(text);
    }

    @Step
    public void setCompany(String text) {
        txt_Company.sendKeys(text);
    }

    @Step
    public void setAddress1(String text) {
        txt_Address1.sendKeys(text);
    }

    @Step
    public void setAddress2(String text) {
        txt_Address2.sendKeys(text);
    }

    @Step
    public void setCountry(String listValue) {
        list_Country.selectOptionByValue(listValue);
    }

    @Step
    public void setState(String text) {
        txt_State.sendKeys(text);
    }

    @Step
    public void setCity(String text) {
        txt_City.sendKeys(text);
    }

    @Step
    public void setZipcode(String text) {
        txt_Zipcode.sendKeys(text);
    }

    @Step
    public void setMobileNumber(String mobileNumber) {
        txt_MobilNumber.sendKeys(mobileNumber);
    }

    @Step
    public void clickOnCreateAccount() {
        btn_CreateAccount.click();
    }

    @Step("Register Page - Fill registration fields Data")
    public void fillAllRegistrationFieldsWithData(DataForUserRegistration registerUserData) {
        setTitle(registerUserData.getIsMale());
        setPass(registerUserData.getPass());
        setFirstName(registerUserData.getFirstName());
        setLastName(registerUserData.getLastName());
        setCompany(registerUserData.getCompany());
        setAddress1(registerUserData.getAddress1());
        setDoBDay(registerUserData.getDobDay());
        setDoBMonth(registerUserData.getDobMonth());
        setDoBYears(registerUserData.getDobYear());
        setNewsletter(true);
        setSpecialOffer(true);
        setFirstName(registerUserData.getFirstName());
        setLastName(registerUserData.getLastName());
        setCompany(registerUserData.getCompany());
        setAddress1(registerUserData.getAddress1());
        setAddress2(registerUserData.getAddress2());
        setCountry(registerUserData.getRandomCountry());
        setState(registerUserData.getState());
        setCity(registerUserData.getCity());
        setZipcode(registerUserData.getZipCode());
        setMobileNumber(registerUserData.getMobileNumber());
    }
}
