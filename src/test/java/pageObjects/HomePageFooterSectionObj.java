package pageObjects;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Getter;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

@Getter
public class HomePageFooterSectionObj {

    private SelenideElement sectionFooter = $("#footer");

    @Step("HomePage - Footer - verify section element")
    public void verifySectionFooter() {
        getSectionFooter().shouldBe(visible);
    }
}
