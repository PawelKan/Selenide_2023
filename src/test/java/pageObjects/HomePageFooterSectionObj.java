package pageObjects;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

@Getter
public class HomePageFooterSectionObj {

    private SelenideElement sectionFooter = $("#footer");

    public void verifySectionFooter(){ getSectionFooter().shouldBe(visible); }
}
