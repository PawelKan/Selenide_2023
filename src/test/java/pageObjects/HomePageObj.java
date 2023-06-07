package pageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@Getter
public class HomePageObj {

    private SelenideElement sectionHeader = $("#header");
    private SelenideElement sectionContent = $("body > section:nth-child(3)");
    private SelenideElement sectionFooter = $("#footer");

    public void verifySectionHeader(){ getSectionHeader().shouldBe(Condition.visible); }
    public void verifySectionContent(){ getSectionContent().shouldBe(Condition.visible); }
    public void verifySectionFooter(){ getSectionFooter().shouldBe(Condition.visible); }




}
