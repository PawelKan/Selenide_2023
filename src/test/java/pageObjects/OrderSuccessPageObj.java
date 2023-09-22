package pageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class OrderSuccessPageObj extends BasePage {
    private final SelenideElement btn_DownloadInvoice = $(".btn.btn-default.check_out");
    private final SelenideElement btn_Continue = $("[data-qa=\"continue-button\"]");
    private final SelenideElement header = $("[data-qa=\"order-placed\"]");
    private final SelenideElement paragraph = $("p[style]");

    //TODO: Add Texts verification to Page

    public void verifyOrderSuccessPage() {
        btn_DownloadInvoice.shouldBe(Condition.visible);
        btn_Continue.shouldBe(Condition.visible);
        header.shouldBe(Condition.visible);
        paragraph.shouldBe(Condition.visible);
    }
    public void clickContinue() {
        btn_Continue.click();
    }
}
