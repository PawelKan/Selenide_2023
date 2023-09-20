package tests;

import com.codeborne.selenide.Selenide;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.*;
import testData.Users;
import textsOnPages.EN_ContactUsPageTexts;
import textsOnPages.EN_HomePageTexts;
import utils.Urls;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class ContactUsTests extends TestBase {

    ContactUsPageObj onContactUsPage = new ContactUsPageObj();
    HomePageHeaderSectionObj homePageHeader = new HomePageHeaderSectionObj();

    @BeforeMethod
    public void openContactUsPage() {
        open(Urls.CONTACT_US_PAGE);
    }


    @Test(description = "Contact us - Verify Title and Page Elements")
    public void verifyContactUsPageElements() {
        onContactUsPage.verifyTitle(EN_ContactUsPageTexts.TITLE);
        onContactUsPage.verifyContactUsPage();
    }

    @Test(description = "Contact us - Send message without attached file")
    public void sendMessageFromContactUsFormWithoutFile() {
        //When
        onContactUsPage.getTxtName().setValue(Users.VALID_USER_NAME);
        onContactUsPage.getTxtEmail().setValue(Users.VALID_USER_EMAIL);
        onContactUsPage.getTxtSubject().setValue("Subject Example");
        onContactUsPage.getTxtYourMessageHere().setValue("My Example Message Text");
        onContactUsPage.getBtnSubmit().click();
        //Then
        Selenide.prompt();
        onContactUsPage.getAlertForSuccessMessage().shouldHave(text(EN_ContactUsPageTexts.MESSAGE_SENT_SUCCESS_ALERT));
        onContactUsPage.verifyTitle(EN_ContactUsPageTexts.TITLE);
        onContactUsPage.verifyUrl(Urls.CONTACT_US_PAGE);
        //When
        onContactUsPage.getBtnBackToHomePage().click();
        //Then
        step("verify home page is visible after click on Home btn", () -> {
            homePageHeader.verifyTitle(EN_HomePageTexts.TITLE);
            homePageHeader.verifyUrl(Urls.HOME_PAGE);
        });
    }

    @Test(description = "Contact us - Send message with attached file")
    public void sendMessageFromContactUsFormWithUploadedFile() {
        //Given
        File file = new File("./files/FileForTestsContactUs.jpg");
        //When
        onContactUsPage.getTxtName().setValue(Users.VALID_USER_NAME);
        onContactUsPage.getTxtEmail().setValue(Users.VALID_USER_EMAIL);
        onContactUsPage.getTxtSubject().setValue("Subject Example");
        onContactUsPage.getTxtYourMessageHere().setValue("My Example Message Text");
        onContactUsPage.getBtnChooseFileUpload().uploadFile(file);
        onContactUsPage.getBtnChooseFileUpload().shouldHave(value("FileForTestsContactUs.jpg"));
        onContactUsPage.getBtnSubmit().click();
        //Then
        Selenide.prompt();
        onContactUsPage.getAlertForSuccessMessage().shouldHave(text(EN_ContactUsPageTexts.MESSAGE_SENT_SUCCESS_ALERT));
        onContactUsPage.verifyTitle(EN_ContactUsPageTexts.TITLE);
        onContactUsPage.verifyUrl(Urls.CONTACT_US_PAGE);
        //When
        onContactUsPage.getBtnBackToHomePage().click();
        //Then
        //verify home page is visible after click on Home btn
        step("verify home page is visible after click on Home btn", () -> {
            homePageHeader.verifyTitle(EN_HomePageTexts.TITLE);
            homePageHeader.verifyUrl(Urls.HOME_PAGE);
        });
    }
}
