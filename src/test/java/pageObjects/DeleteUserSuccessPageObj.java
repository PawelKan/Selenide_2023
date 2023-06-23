package pageObjects;

import com.codeborne.selenide.SelenideElement;
import lombok.Value;

import static com.codeborne.selenide.Selenide.$;

@Value
public class DeleteUserSuccessPageObj {

    SelenideElement btnClick = $("[data-qa=continue-button]");

    public void clickBtnContinue(){ btnClick.click(); }
}
