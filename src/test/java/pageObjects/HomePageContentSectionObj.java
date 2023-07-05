package pageObjects;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

@Getter
public class HomePageContentSectionObj {

    private SelenideElement sectionContent = $("body > section:nth-child(3)");

    public void verifySectionContent() {
        getSectionContent().shouldBe(visible);
    }
}
