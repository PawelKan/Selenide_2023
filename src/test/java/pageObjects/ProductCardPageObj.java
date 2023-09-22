package pageObjects;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Getter;
import textsOnPages.EN_LoginPageTexts;
import textsOnPages.EN_ProductCardPageTexts;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

@Getter
public class ProductCardPageObj extends BasePage {

    //Login Section
    private final SelenideElement label_ProductName = $(".product-information > h2");
    private final SelenideElement txt_Quantity = $("#quantity");
    private final SelenideElement btn_AddToCart = $(".product-information button");


    @Step("Product Card Page - Verify elements")
    public void verifyProductCardPageElements(String productName) {
        label_ProductName.shouldBe(visible);
        label_ProductName.shouldHave(text(productName));

        txt_Quantity.shouldBe(visible);
        txt_Quantity.shouldHave(value("1"));

        btn_AddToCart.shouldBe(visible);
        btn_AddToCart.shouldHave(text(EN_ProductCardPageTexts.BUTTON_ADD_TO_CART));
    }

    public void clickAddToProduct(){ btn_AddToCart.click(); }

}
