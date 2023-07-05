package pageObjects;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Getter;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

@Getter
public class HomePageContentSectionObj {

    private SelenideElement sectionContent = $("body > section:nth-child(3)");
    @Step("HomePage - Content - verify section element")
    public void verifySectionContent() {
        getSectionContent().shouldBe(visible);
    }
}
