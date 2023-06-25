package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.*;
import testData.Users;
import utils.Urls;

import static com.codeborne.selenide.Selenide.open;

public class ContactUsTests extends TestBase{

    ContactUsPageObj onContactUsPage = new ContactUsPageObj();
    @BeforeMethod
    public void openContactUsPage(){ open(Urls.CONTACT_US_PAGE);    }
    @Test
    public void verifyContactUsPageElements(){
        onContactUsPage.verifyContactUsPage();
    }

}
