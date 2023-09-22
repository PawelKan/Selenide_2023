package tests;

import lombok.val;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.*;
import testData.Users;
import utils.Urls;

import static com.codeborne.selenide.Selenide.open;

public class E2EOrders extends TestBase {

    HomePageContentSectionObj homePageContentSection = new HomePageContentSectionObj();
    LoginPageObj loginPage = new LoginPageObj();
    HomePageHeaderSectionObj headerSection = new HomePageHeaderSectionObj();
    HomePageContentSectionObj homePageContent = new HomePageContentSectionObj();
    ProductCardPageObj productCard = new ProductCardPageObj();
    PopupProductAddedToCartObj popUpProductWasAddedToCart = new PopupProductAddedToCartObj();
    CartPageObj cartPage = new CartPageObj();

    OrderAddressDetailsPageObj orderAddressDetails = new OrderAddressDetailsPageObj();
    OrderPaymentPageObj orderPayment = new OrderPaymentPageObj();
    OrderSuccessPageObj orderSuccessPage = new OrderSuccessPageObj();
    @BeforeMethod
    public void openLoginPage() {
        open(Urls.LOGIN_PAGE);
    }

    @Test
    public void verifyEmptyCart(){
        //TODO: Add test for it later
    }

    @Test
    public void verifyNotLoggedUserCanNotCreateOrder(){
        //TODO: Add test for it later
    }
    @Test
    public void createOrderWithLoggedInUser() {
        //Given
        val productNameText = "Blue Top";

        //When
        loginPage.loginAsUser(Users.VALID_USER_EMAIL, Users.VALID_USER_PASS);
        headerSection.verifyUserNameIsVisibleInHeaderAfterLogin(Users.VALID_USER_NAME);
        //Open Page with product
        homePageContent.clickOnFirstProductInContentList();
        //Then
        productCard.verifyProductCardPageElements(productNameText);
        // Add product to basket
        productCard.clickAddToProduct();
        // Add New Page Object for popup after add to basket from card and from homepage
        popUpProductWasAddedToCart.verifyPopupElementsAfterProductWasAddedToCart();
        // Go to basket
        popUpProductWasAddedToCart.clickOnViewCart();
        // Verify Cart
        cartPage.verifyElementsOnCartPage();
        cartPage.verifyCartProductListIsNotEmpty();
        cartPage.clickProceedToCheckout();
        // Proceed with Order
            // TODO: Add verification for page
        orderAddressDetails.clickPlaceOrder();
        // Payment page
        orderPayment.verifyPaymentPage();
        orderPayment.fillPaymentData();
        orderPayment.clickPayAndConfirmOrder();
        // Success Page
                //TODO: Add Download invoice check
        orderSuccessPage.verifyOrderSuccessPage();
        orderSuccessPage.clickContinue();
        // HomePage is visible
        homePageContentSection.verifySectionContent();

    }
}
