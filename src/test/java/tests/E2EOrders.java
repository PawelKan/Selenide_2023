package tests;

import lombok.val;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.*;
import testData.Users;
import utils.Urls;

import static com.codeborne.selenide.Selenide.open;

public class E2EOrders extends TestBase {

    LoginPageObj loginPage = new LoginPageObj();
    HomePageHeaderSectionObj headerSection = new HomePageHeaderSectionObj();
    HomePageContentSectionObj homePageContent = new HomePageContentSectionObj();
    ProductCardPageObj productCard = new ProductCardPageObj();
    PopupProductAddedToCartObj popUpProductWasAddedToCart = new PopupProductAddedToCartObj();

    @BeforeMethod
    public void openLoginPage() {
        open(Urls.LOGIN_PAGE);
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

        // Continue to end order

    }
}
