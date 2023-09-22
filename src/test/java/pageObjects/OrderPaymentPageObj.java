package pageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class OrderPaymentPageObj extends BasePage {
    private final SelenideElement btn_PayAndConfirmOrder = $("[data-qa=\"pay-button\"]");
    private final SelenideElement txt_NameOnCard = $("[data-qa=\"name-on-card\"]");
    private final SelenideElement txt_CardNumber = $("[data-qa=\"card-number\"]");
    private final SelenideElement txt_CVC = $("[data-qa=\"cvc\"]");
    private final SelenideElement txt_ExpirationMM = $("[data-qa=\"expiry-month\"]");
    private final SelenideElement txt_ExpirationYYYY = $("[data-qa=\"expiry-year\"]");

    //TODO: Add texts verification
    //TODO: Change setup for payment data to builder
    public void verifyPaymentPage() {
        btn_PayAndConfirmOrder.shouldBe(Condition.visible);
        txt_NameOnCard.shouldBe(Condition.visible);
        txt_CardNumber.shouldBe(Condition.visible);
        txt_CVC.shouldBe(Condition.visible);
        txt_ExpirationMM.shouldBe(Condition.visible);
        txt_ExpirationYYYY.shouldBe(Condition.visible);
    }
    public void fillPaymentData(){
        txt_NameOnCard.setValue("Card Name");
        txt_CardNumber.setValue("1234567890");
        txt_CVC.setValue("311");
        txt_ExpirationMM.setValue("11");
        txt_ExpirationYYYY.setValue("2028");
    }
    @Step("Order Payment Page - Click Btn Pay And Confirm")
    public void clickPayAndConfirmOrder() {
        btn_PayAndConfirmOrder.click();
    }
}
