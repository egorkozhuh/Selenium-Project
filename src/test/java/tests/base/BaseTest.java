package tests.base;

import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.base.BasePage;
import pages.loans.CarLoansPage;
import pages.telecommunications.MobilePhoneReplenishmentPage;

import java.io.File;
import java.time.LocalTime;
import java.util.Objects;

import static common.Config.*;

//@Execution(ExecutionMode.CONCURRENT)
//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseTest {

    protected BasePage basePage = new BasePage();
    protected CarLoansPage carLoansPage = new CarLoansPage();
    protected MobilePhoneReplenishmentPage mobilePhoneReplenishmentPage = new MobilePhoneReplenishmentPage();
    private static final Logger LOGGER = LoggerFactory.getLogger(BaseTest.class);


    static{
        LOGGER.info("Start clear reports dir: build/reports ...");
        File allureResults = new File("allure-results");
        if(allureResults.isDirectory()){
            for(File item : Objects.requireNonNull(allureResults.listFiles()))
                item.delete();

        }

        if(CLEAR_REPORTS_DIR){
            File allureScreenshots = new File("build/reports/tests");
            for(File item : Objects.requireNonNull(allureScreenshots.listFiles()))
                item.delete();
        }
        File downloads = new File("build/downloads/");
        if(downloads.isDirectory()){
            for(File item : Objects.requireNonNull(downloads.listFiles())){
                item.delete();
            }
        }
    }
}
