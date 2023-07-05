package pageObjects;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;
import org.testng.Assert;

public class BasePage {

    @Step("Verify Page URL")
    public void verifyUrl(String expectedUrl) {
        String currentUrl = WebDriverRunner.url();
        Assert.assertEquals(currentUrl, expectedUrl);
    }
    @Step("Verify Page Title")
    public void verifyTitle(String expectedTitle) {
        String actualTitle = Selenide.title();
        Assert.assertEquals(actualTitle, expectedTitle);
    }
}
