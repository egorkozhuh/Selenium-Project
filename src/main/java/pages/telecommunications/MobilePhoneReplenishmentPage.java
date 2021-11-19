package pages.telecommunications;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import pages.base.BasePage;

import static com.codeborne.selenide.Selenide.$x;

public class MobilePhoneReplenishmentPage extends BasePage {


    private final SelenideElement inputPhoneNumber = $x("//input[@class='sc-bYSBpT exvPPD']");
    private final SelenideElement inputAmount = $x("//input[@data-qa-node='amount']");
    private final SelenideElement inputCardFrom = $x("//input[@data-qa-node='numberdebitSource']");
    private final SelenideElement inputExpDate = $x("//input[@data-qa-node='expiredebitSource']");
    private final SelenideElement inputCardCvv = $x("//input[@data-qa-node='cvvdebitSource']");
    private final SelenideElement buttonSubmitToTheCard = $x("//button[@data-qa-node='submit']");
    private final SelenideElement buttonWallet = $x("//div[contains(text(), 'My wallet')]");
//    private final SelenideElement paymentDetails = $x("//span[@data-qa-node='details']");
    /**
     *
     * Choose a card from the wallet
     */
    public MobilePhoneReplenishmentPage selectCardFromWallet(){
        buttonWallet.click();
        return this;
    }

    /**
     * Enter phone number excluding country code
     * @param number  - phone number
     *
     */
    public MobilePhoneReplenishmentPage enterPhoneNumber(String number){
        clearAndType(inputPhoneNumber, number);
        return this;
    }

    /**
     * Enter amount of payment
     * @param amount - amount of payment
     * @return
     */
    public MobilePhoneReplenishmentPage enterAmount(String amount){
        clearAndType(inputAmount, amount);
        return this;
    }

    /**
     * Enter number of card
     * @param card - number of card
     * @return
     */
    public MobilePhoneReplenishmentPage enterCardFrom(String card){
        clearAndType(inputCardFrom, card);
        return this;
    }

    /**
     * Enter expire date
     * @param expDate - expire date
     * @return
     */
    public MobilePhoneReplenishmentPage enterCardExpDate(String expDate){
        clearAndType(inputExpDate, expDate);
        return this;
    }

    /**
     * Enter cvv code
     * @param cvv - cvv code
     * @return
     */
    public MobilePhoneReplenishmentPage enterCardFromCvv(String cvv){
        clearAndType(inputCardCvv, cvv);
        return this;
    }

    /**
     * click to button "To The Card"
     * @return
     */
    public MobilePhoneReplenishmentPage submitToTheCard(){
        buttonSubmitToTheCard.shouldBe(Condition.visible).click();
        return this;
    }

    /**
     * check payment detais in the card
     * @param text
     * @return
     */

    public MobilePhoneReplenishmentPage checkPaymentDetailsIsPresentInTheCard(String text){
        checkMessage(text);
        return this;
    }

}
