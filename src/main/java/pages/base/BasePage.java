package pages.base;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static constants.Constant.timeOutVeriables.EXPLICIT_WAIT;

public class BasePage {

    public final SelenideElement authWidget = $x("//iframe[@src='https://login-widget.privat24.ua/']");

    /**
     * The method for navigating to a specific URl
     *
     */
    public void goToURL(String url){
        open(url);
    }

    /**
     * A method that cleans the element of the text and enters the desired text
     * @param element - Selenide WebElement
     * @param value - text
     */
    protected void clearAndType(SelenideElement element, String value){
        while(!element.getAttribute("value").equals("")) element.sendKeys(Keys.BACK_SPACE);
        element.setValue(value);
    }

    /**
     * Check is auth Frame is visible
     */

    public void isAuthWidgetPresented(){
        authWidget.shouldBe(Condition.visible);
    }

    public void checkMessage(String message){
        $(byText(message)).shouldBe(Condition.visible);
    }
}
