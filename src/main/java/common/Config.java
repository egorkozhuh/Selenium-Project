package common;

import com.codeborne.selenide.Configuration;

public class Config {

    /**
     * Specify the browser and platform for test:
     *
     * */
    public static final String BROWSER_NAME = "chrome"; //firefox opera edge ie
    /** Clean browser cookies after each iteration           */
    public static final boolean CLEAR_COOKIES = false;
    /** To keep the browser open after all scenario/tests    */
    public static final boolean HOLD_BROWSER_OPEN = true;

    /**
     * cLEAR THE DIRECTORY WITH THE SCREEN BEFORE STARTING THE BUILD
     */
    public static final boolean CLEAR_REPORTS_DIR = true;

    static{
        Configuration.holdBrowserOpen = HOLD_BROWSER_OPEN;
        Configuration.reportsFolder = "build/reports/tests";
        Configuration.browser = BROWSER_NAME;
    }
}
