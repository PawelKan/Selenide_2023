package pageObjects;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.testng.Assert;

public class BasePage {

    public void verifyUrl(String expectedUrl) {
        String currentUrl = WebDriverRunner.url();
        Assert.assertEquals(currentUrl, expectedUrl);
    }

    public void verifyTitle(String expectedTitle) {
        String actualTitle = Selenide.title();
        Assert.assertEquals(actualTitle, expectedTitle);
    }
}
