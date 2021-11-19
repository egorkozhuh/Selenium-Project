package common;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static common.CommonActions.clearBrowserCookieAndStorage;

public class Listener implements TestWatcher {

    private static final Logger LOGGER = LoggerFactory.getLogger(Listener.class);

    @Override
    public void testFailed(ExtensionContext context, Throwable cause){
        LOGGER.info("Test {} - Failed!", context.getTestMethod().get().getName());
        String screenshotName = context.getTestMethod().get().getName() +
                String.valueOf(System.currentTimeMillis()).substring(9, 13);
        LOGGER.info("Tring to trace screenshot....");
        Selenide.screenshot(screenshotName);

        attachScreenshotToAllure();
    }

    @Attachment(value = "Attachment screenshot", type = "image/png")
    public byte[] attachScreenshotToAllure(){
        if(WebDriverRunner.hasWebDriverStarted())
            return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
            else return null;
    }


    public void afterEach(ExtensionContext extensionContext){
        clearBrowserCookieAndStorage();
    }

    public void beforeAll(ExtensionContext extensionContext){
        extensionContext.getRoot().getStore(ExtensionContext.Namespace.GLOBAL).put(true, this);
    }



}
