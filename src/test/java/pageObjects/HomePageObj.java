package pageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import testData.Users;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@Getter
public class HomePageObj {

    private SelenideElement sectionHeader = $("#header");
    private SelenideElement sectionContent = $("body > section:nth-child(3)");
    private SelenideElement sectionFooter = $("#footer");
    private SelenideElement header_LoggedInUserName = $("#header > div > div > div > div.col-sm-8 > div > ul > li:nth-child(10) > a");
    private String textLoggedInUser = " Logged in as ";

    public void verifySectionHeader(){ getSectionHeader().shouldBe(Condition.visible); }
    public void verifySectionContent(){ getSectionContent().shouldBe(Condition.visible); }
    public void verifySectionFooter(){ getSectionFooter().shouldBe(Condition.visible); }
    public void verifyUserNameIsVisibleInHeaderAfterLogin(String userName){
        header_LoggedInUserName.shouldHave(Condition.text(textLoggedInUser));
        header_LoggedInUserName.shouldHave(Condition.text(userName));
    }
}
