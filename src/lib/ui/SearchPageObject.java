package lib.ui;

import io.appium.java_client.AppiumDriver;

abstract public class SearchPageObject extends MainPageObject
{
    public static String
            SEARCH_FIELD;
    protected static String
        CHECK_SEARCH_STRING,
        NAVIGATION_PANEL_MAIN,
        DELIVERY_BLOCK_MAIN_SCREEN;


    public SearchPageObject(AppiumDriver driver)
    {
        super(driver);
    }

    public void clickSearchString()
    {
        this.waitForElementPresentAndClick(CHECK_SEARCH_STRING,
                "no field Search", 20);
    }

    public void searchSendKeys(String locator, String value, String error, long timeOutInSeconds)
    {
        this.waitForElementAndSendKeys(locator, value, error, timeOutInSeconds);
    }

    public void navigationPanelMainButton()
    {
        this.waitForElementPresentAndClick(NAVIGATION_PANEL_MAIN,
                "Cannot click Main in navigation panel", 10);
    }

    public void searchClearField(String locator, String error, long timeOutInSeconds)
    {
        this.waitForElementAndClear(locator, error, timeOutInSeconds);
    }


    public void bookDeliveryBlock()
    {
        this.waitForElementPresent(DELIVERY_BLOCK_MAIN_SCREEN,
                "Cannot find block delivery on main screen", 10);
    }


}
