package pageObjects;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Getter;
import textsOnPages.EN_PopupProductAddedToCartTexts;
import textsOnPages.EN_ProductCardPageTexts;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

@Getter
public class PopupProductAddedToCartObj extends BasePage {

    //Login Section
    private final SelenideElement popupWholeSection = $("#cartModal .modal-dialog .modal-content");
    private final SelenideElement txt_Added = popupWholeSection.find(".modal-title");
    private final SelenideElement txt_YourProductHasBeenAddedToCart = popupWholeSection.find(".modal-body p", 0);
    private final SelenideElement btn_ViewCart = popupWholeSection.find(".modal-body p a");
    private final SelenideElement btn_ContinueShopping = popupWholeSection.find(".modal-footer button");
    private final SelenideElement icon_GreenCheckmark = popupWholeSection.find(".material-icons");

    @Step("Verify elements on Popup after Product was added to Cart")
    public void verifyPopupElementsAfterProductWasAddedToCart() {
        popupWholeSection.shouldBe(visible);
        icon_GreenCheckmark.shouldBe(visible);
        txt_Added.shouldBe(visible).shouldHave(exactText(EN_PopupProductAddedToCartTexts.ADDED));
        txt_YourProductHasBeenAddedToCart.shouldBe(visible).shouldHave(exactText(EN_PopupProductAddedToCartTexts.PRODUCT_HAS_BEEN_ADDED_MSG));
        btn_ViewCart.shouldBe(visible).shouldHave(exactText(EN_PopupProductAddedToCartTexts.VIEW_CART));
        btn_ContinueShopping.shouldBe(visible).shouldHave(exactText(EN_PopupProductAddedToCartTexts.CONTINUE_SHOPPING));
    }
}
