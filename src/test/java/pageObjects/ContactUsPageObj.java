package pageObjects;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import textsOnPages.EN_ContactUsPageTexts;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

@Getter
public class ContactUsPageObj extends BasePage {

    private final SelenideElement headerContactUs = $(".col-sm-12 h2");
    //region Contact Us Form
    private final SelenideElement headerGetInTouch = $(".contact-form h2");
    private final SelenideElement txtName = $("[data-qa='name']");
    private final SelenideElement txtEmail = $("[data-qa='email']");
    private final SelenideElement txtSubject = $("[data-qa='subject']");
    private final SelenideElement txtYourMessageHere = $("[data-qa='message']");
    private final SelenideElement btnChooseFileUpload = $("input[name=\"upload_file\"]");
    private final SelenideElement btnSubmit = $("[data-qa='submit-button']");
    //endregion
    //region FEEDBACK FOR US section
    private final SelenideElement headerFeedbackForUs = $(".contact-info h2");
    private final SelenideElement paragraphOne_FeedbackForUs = $("div address p:nth-child(1)");
    private final SelenideElement paragraphTwo_FeedbackForUs = $("div address p:nth-child(3)"); // with mail
    private final SelenideElement paragraphThree_FeedbackForUs = $("div address p:nth-child(5)");
    private final SelenideElement paragraphFour_FeedbackForUs = $("div address p:nth-child(7)");
    //endregion
    private final SelenideElement alertForSuccessMessage = $(".contact-form div.alert-success");
    private final SelenideElement btnBackToHomePage = $("a.btn.btn-success");

    public void verifyContactUsPage() {
        headerContactUs.shouldHave(text(EN_ContactUsPageTexts.HEADER_CONTACT_US));

        headerGetInTouch.shouldHave(text(EN_ContactUsPageTexts.HEADER_GET_IN_TOUCH));
        txtName.shouldHave(attribute("placeholder", EN_ContactUsPageTexts.TXT_NAME_PLACEHOLDER));
        txtEmail.shouldHave(attribute("placeholder", EN_ContactUsPageTexts.TXT_EMAIL_PLACEHOLDER));
        txtSubject.shouldHave(attribute("placeholder", EN_ContactUsPageTexts.TXT_SUBJECT_PLACEHOLDER));
        txtYourMessageHere.shouldHave(attribute("placeholder", EN_ContactUsPageTexts.TXT_YOUR_MESSAGE_HERE_PLACEHOLDER_));
        btnChooseFileUpload.shouldBe(visible);
        btnSubmit.shouldHave(attribute("value", EN_ContactUsPageTexts.BTN_SUBMIT_VALUE));

        headerFeedbackForUs.shouldHave(text(EN_ContactUsPageTexts.HEADER_FEEDBACK_FOR_US));
        paragraphOne_FeedbackForUs.shouldHave(text(EN_ContactUsPageTexts.FEEDBACK_FOR_US_FIRST_PARAGRAPH));
        paragraphTwo_FeedbackForUs.shouldHave(text(EN_ContactUsPageTexts.FEEDBACK_FOR_US_SECOND_PARAGRAPH));
        paragraphThree_FeedbackForUs.shouldHave(text(EN_ContactUsPageTexts.FEEDBACK_FOR_US_THIRD_PARAGRAPH));
        paragraphFour_FeedbackForUs.shouldHave(text(EN_ContactUsPageTexts.FEEDBACK_FOR_US_LAST_PARAGRAPH));
    }


}
