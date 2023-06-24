package pageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import testData.DataForUserRegistration;

import static com.codeborne.selenide.Selenide.$;

public class RegisterPageObj {
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

    public void setTitle(boolean isMale){
        if (isMale == true){ rad_TitleMr.click(); }
        else { rad_titleMrs.click(); }
    }
    public void setName(String text){ txt_name.sendKeys(text); }
    public void setEmail(String text){ txt_email.sendKeys(text);}
    public void setPass (String text) { txt_pass.sendKeys(text);}
    public void setDoBDay (String listValue) { list_dateOfBirthDay.selectOptionByValue(listValue);}
    public void setDoBMonth (String listValue) { list_dateOfBirthMonth.selectOptionByValue(listValue);}
    public void setDoBYears (String listValue) { list_dateOfBirthYear.selectOptionByValue(listValue);}
    public void setNewsletter (boolean isNewsletterOn) {
        if (isNewsletterOn == true){
            chk_Newsletter.click();
            //chk_Newsletter.shouldBe(Condition.selected);
        }
        else { chk_Newsletter.shouldNotBe(Condition.selected);
    }}

    public void setSpecialOffer (boolean isSpecialOfferOn) {
        if (isSpecialOfferOn == true){
            chk_SpecialOffers.click();
            //chk_SpecialOffers.shouldBe(Condition.selected);
        }
        else { chk_SpecialOffers.shouldNotBe(Condition.selected);
        }
    }
    public void setFirstName (String text) { txt_FirstName.sendKeys(text);}
    public void setLastName (String text) { txt_LastName.sendKeys(text);}
    public void setCompany (String text) { txt_Company.sendKeys(text);}
    public void setAddress1 (String text) { txt_Address1.sendKeys(text);}
    public void setAddress2 (String text) { txt_Address2.sendKeys(text);}
    public void setCountry (String listValue) { list_Country.selectOptionByValue(listValue);}
    public void setState (String text) { txt_State.sendKeys(text);}
    public void setCity (String text) { txt_City.sendKeys(text);}
    public void setZipcode (String text) { txt_Zipcode.sendKeys(text);}
    public void setMobileNumber (String mobileNumber) { txt_MobilNumber.sendKeys(mobileNumber);}
    public void clickOnCreateAccount(){ btn_CreateAccount.click();}
    public void fillAllRegistrationFieldsWithData(DataForUserRegistration registerUserData){
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
