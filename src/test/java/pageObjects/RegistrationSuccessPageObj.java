package pageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import lombok.Value;
import textsOnPages.EN_RegistrationUserSuccessPageTexts;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;

@Value
public class RegistrationSuccessPageObj {

    SelenideElement labHeader = $("[data-qa=account-created] > b");
    SelenideElement labFirstParagraph = $("#form > div > div > div > p:nth-child(2)");
    SelenideElement labSecondParagraph = $("#form > div > div > div > p:nth-child(3)");
    SelenideElement btnClick = $("[data-qa=continue-button]");


    public void clickBtnContinue(){ btnClick.click(); }

    public void verifyPageElements(){
        btnClick.shouldHave(exactText(EN_RegistrationUserSuccessPageTexts.btnContinueText));
        labHeader.shouldHave(exactText(EN_RegistrationUserSuccessPageTexts.header));
        labFirstParagraph.shouldHave(exactText(EN_RegistrationUserSuccessPageTexts.firstParagraph));
        labSecondParagraph.shouldHave(exactText(EN_RegistrationUserSuccessPageTexts.secondParagraph));
    }
}
