package pageObjects;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class OrderAddressDetailsPageObj extends BasePage {
    private final SelenideElement btn_PlaceOrder = $(".btn.btn-default.check_out");

    //TODO: Add texts verification

    @Step("Address Details - Click Btn Place Order")
    public void clickPlaceOrder() {
        btn_PlaceOrder.shouldBe(enabled);
        btn_PlaceOrder.click();
    }
}
