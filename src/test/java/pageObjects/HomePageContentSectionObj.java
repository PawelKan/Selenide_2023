package pageObjects;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;
import textsOnPages.EN_HomePageTexts;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

@Getter
public class HomePageContentSectionObj {

    private SelenideElement sectionContent = $("body > section:nth-child(3)");
    public void verifySectionContent(){ getSectionContent().shouldBe(visible); }
}
