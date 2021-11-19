package tests.telecommunications.positive;

import org.junit.jupiter.api.Test;
import tests.base.BaseTest;
import static constants.Constant.Urls.MOBILE_PAYMENT_URL;
import static constants.Constant.mobileReplenishmentTestData.*;

public class MobilePhoneReplenishmentPositiveTest extends BaseTest {
    @Test
    public void checkIsRedirectToAuth(){
        basePage.goToURL(MOBILE_PAYMENT_URL);
        mobilePhoneReplenishmentPage.selectCardFromWallet();
        basePage.isAuthWidgetPresented();
    }

    @Test
    public void checkMinimumReplenishmentAmount(){
        basePage.goToURL(MOBILE_PAYMENT_URL);
        mobilePhoneReplenishmentPage.enterPhoneNumber(MOBILE_PAYMENT_PHONE_NUMBER)
                .enterAmount("1")
                .enterCardFrom(MOBILE_PAYMENT_CARD)
                .enterCardExpDate(MOBILE_PAYMENT_CARD_EXP_DATE)
                .enterCardFromCvv(MOBILE_PAYMENT_CARD_CVV)
                .submitToTheCard()
                .checkPaymentDetailsIsPresentInTheCard("Mobile payment. Phone number +380686979712");
    }
}
