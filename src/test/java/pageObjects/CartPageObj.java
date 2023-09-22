package pageObjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import textsOnPages.EN_CartPageTexts;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class CartPageObj extends BasePage {
    private final SelenideElement section_TableWithProducts = $(".table-responsive.cart_info");
    private final ElementsCollection tableHeaders = section_TableWithProducts.findAll("thead tr td");
    private final ElementsCollection tableProductsList = section_TableWithProducts.findAll("tbody tr");
    private final SelenideElement btn_ProceedToCheckout = $("#cart_items .btn.check_out");

    @Step("Cart Page - Verify Elements on Page")
    public void verifyElementsOnCartPage() {
        section_TableWithProducts.shouldBe(visible);
        tableHeaders.shouldHave(texts(EN_CartPageTexts.TABLE_HEADERS_NAMES));
        btn_ProceedToCheckout.shouldBe(visible).shouldHave(exactText(EN_CartPageTexts.BTN_PROCEED_TO_CHECKOUT));
    }

    public void verifyCartProductListIsNotEmpty(){
        tableProductsList.shouldHave(sizeGreaterThan(0));
    }

    public void clickProceedToCheckout(){
        btn_ProceedToCheckout.click();
    }

}
