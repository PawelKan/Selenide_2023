package pageObjects;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Value;
import textsOnPages.EN_DeleteUserSuccessPageTexts;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;

@Value
public class DeleteUserSuccessPageObj {

    SelenideElement labHeader = $("[data-qa=account-deleted] > b");
    SelenideElement labFirstParagraph = $("#form > div > div > div > p:nth-child(2)");
    SelenideElement labSecondParagraph = $("#form > div > div > div > p:nth-child(3)");
    SelenideElement btnClick = $("[data-qa=continue-button]");

    @Step
    public void clickBtnContinue() {
        btnClick.click();
    }

    @Step("Delete user success page - verify page elements")
    public void verifyPageElements() {
        btnClick.shouldHave(exactText(EN_DeleteUserSuccessPageTexts.BTN_CONTINUE_TEXT));
        labHeader.shouldHave(exactText(EN_DeleteUserSuccessPageTexts.HEADER));
        labFirstParagraph.shouldHave(exactText(EN_DeleteUserSuccessPageTexts.FIRST_PARAGRAPH));
        labSecondParagraph.shouldHave(exactText(EN_DeleteUserSuccessPageTexts.SECOND_PARAGRAPH));
    }
}
