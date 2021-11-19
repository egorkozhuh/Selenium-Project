package common;

import com.codeborne.selenide.Selenide;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static common.Config.CLEAR_COOKIES;

public class CommonActions {

    private static final Logger LOGGER = LoggerFactory.getLogger(CommonActions.class);

    public static void clearBrowserCookieAndStorage() {
        if (CLEAR_COOKIES) {
            try {
                Selenide.clearBrowserCookies();
                Selenide.clearBrowserLocalStorage();
                Selenide.executeAsyncJavaScript("window.sessionStorage.clear()");
            }catch(Exception e){
                LOGGER.error("Fail to clearBrowserCookieAndStorage() - {}" + e.getMessage());
            }
        }
    }

}
