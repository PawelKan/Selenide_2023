package pageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import testData.Users;
import textsOnPages.EN_HomePageTexts;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@Getter
public class HomePageObj {

    private SelenideElement sectionHeader = $("#header");
    private SelenideElement sectionContent = $("body > section:nth-child(3)");
    private SelenideElement sectionFooter = $("#footer");
    private SelenideElement header_LoggedInUserName = $("#header > div > div > div > div.col-sm-8 > div > ul > li:nth-child(10) > a");
    private SelenideElement header_btnDeleteUser = $("#header > div > div > div > div.col-sm-8 > div > ul > li:nth-child(5) > a");
    //private String textLoggedInUser = " Logged in as ";

    public void verifySectionHeader(){ getSectionHeader().shouldBe(visible); }
    public void verifySectionContent(){ getSectionContent().shouldBe(visible); }
    public void verifySectionFooter(){ getSectionFooter().shouldBe(visible); }
    public void verifyUserNameIsVisibleInHeaderAfterLogin(String userName){
        header_LoggedInUserName.shouldHave(text(EN_HomePageTexts.headerLoggedIn));
        header_LoggedInUserName.shouldHave(text(userName));
    }

    public void clickDeleteUserAccount(){ header_btnDeleteUser.click(); }
}
