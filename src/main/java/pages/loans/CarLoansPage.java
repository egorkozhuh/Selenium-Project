package pages.loans;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;

import static com.codeborne.selenide.Selenide.$x;

public class CarLoansPage extends BasePage {


    public final SelenideElement tabAgreements = $x("//div[contains(text(), 'Agreements')]");
    public final SelenideElement amountFieldCarCost = $x("//input[@data-qa-node='amount']");
    public final SelenideElement amountFieldPrepaidExpense = $x("//input[@data-qa-node='prepaid']");
    public final SelenideElement phoneCodeButton = $x("//button[@data-qa-node='phone-code']");
    public final SelenideElement searchPhoneCodeField = $x("//input[@placeholder='Search']");
    public final SelenideElement phoneNumberField = $x("//input[@data-qa-node='phone-number']");
    public final SelenideElement applyOrderButton = $x("//button[@class='sc-VigVT giewij']");

    /**
     * Selecting a tab agreements
     * @return
     */
    public CarLoansPage selectAgreementsTab(){
        tabAgreements.shouldBe(Condition.visible).click();
        return this;
    }

    /**
     * Enter the amount of the car value
     * @param amount - the full cost of a car
     * @return
     */
    public CarLoansPage enterAmountFieldCarCost(String amount){
        clearAndType(amountFieldCarCost, amount);
        return this;
    }

    /**
     * Enter for advance amount for the loan
     * @param amount - the amount for the advance payment
     * @return
     */
    public CarLoansPage enterAmountFieldPrepaidExpense(String amount){
        clearAndType(amountFieldPrepaidExpense, amount);
        return this;
    }

    /**
     *  Filling in the mobile number to apply
     * @param phoneNumber - mobile number for apply
     * @return
     */
    public CarLoansPage enterPhoneNumber(String phoneNumber){
        clearAndType(phoneNumberField, phoneNumber);
        return this;
    }

    /**
     * Search country code for mobile communications
     * @param phoneNumber - mobile number to apply
     * @return
     */
    public CarLoansPage enterPhoneCountryCodeField(String phoneNumber){
        clearAndType(searchPhoneCodeField, phoneNumber);
        return this;
    }

    /**
     *  Selection of drop down list of codes of countries, mobile communications
     * @return
     */
    public CarLoansPage selectPhoneCodeButton(){
        phoneCodeButton.shouldBe(Condition.visible).click();
        return this;
    }

    /**
     * Confirmation for application for credit
     * @return
     */
    public CarLoansPage submitOrderButton(){
        applyOrderButton.shouldBe(Condition.visible).click();
        return this;
    }


}
