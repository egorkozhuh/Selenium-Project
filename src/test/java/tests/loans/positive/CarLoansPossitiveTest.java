package tests.loans.positive;

import org.junit.jupiter.api.Test;
import tests.base.BaseTest;

import static constants.Constant.Urls.CAR_LOANS_URL;

public class CarLoansPossitiveTest extends BaseTest {
    @Test
    public void selectAgreementsTabInPublicSession(){
        basePage.goToURL(CAR_LOANS_URL);
        carLoansPage.selectAgreementsTab();
        basePage.isAuthWidgetPresented();
    }
}
