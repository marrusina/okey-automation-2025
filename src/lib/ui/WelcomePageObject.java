package lib.ui;
import io.appium.java_client.AppiumDriver;

abstract public class WelcomePageObject extends MainPageObject {
    public static String
    CHOOSE_SAINT_PETERSBURG_BUTTON;
    protected static String
    DEVICE_LOCATION_DENY_BUTTON,
    GEOPOSITION_ACESS_BUTTON,
    NEXT_AFTER_CITY_BUTTON,
    SKIP_CHOOSING_ADRESS,
    ONLINE_SHOP_BUTTON,
    NOTIFICATION_ALLOW_BUTTON,
    STORIES_CLOSE,
    CITY_SCREEN_NAME;

    public WelcomePageObject(AppiumDriver driver)
    {
        super(driver);
    }
//    public void accessToDeviceLocation(By by, String error, int time)
//    {
//        this.waitForElementPresentAndClick(by,error,time);
//    }
    public void accessToDeviceLocationDenyButton()
    {
                this.waitForElementPresentAndClick(DEVICE_LOCATION_DENY_BUTTON,
                        "Cannot click location deny button", 10);
    }

    public void accessToGeoPositionDenyButton()
    {
        this.waitForElementPresentAndClick(GEOPOSITION_ACESS_BUTTON,
                "Cannot click deny button for geoposition",
                10);
    }

    public void checkCityScreenName()
    {
        this.waitForElementPresent(CITY_SCREEN_NAME, "Cannot see city screen name");
    }

    public void chooseCity(String locator, String error, int time)
    {
        this.waitForElementPresentAndClick(locator,error,time);
    }

    public void clickNextAfterChooseCity()
    {
        this.waitForElementPresentAndClick(NEXT_AFTER_CITY_BUTTON,
                "Cannot click Next button after choosing city",
                10);
    }

    public void skipChooseAddress()
    {
        this.waitForElementPresentAndClick(SKIP_CHOOSING_ADRESS,
                "Cannot click Skip for choosing address",
                10);
    }

    public void chooseOnlineShop()
    {
        this.waitForElementPresentAndClick(ONLINE_SHOP_BUTTON,
                "Cannot find online shop button",
                20);
    }

    public void chooseNotificationAllowButton()
    {
        this.waitForElementPresentAndClick(NOTIFICATION_ALLOW_BUTTON,
                "Cannot find button Allow notification",
                10);
    }

    public void closeStories()
    {
        this.waitForElementPresentAndClick(STORIES_CLOSE,
                "Cannot close Stories", 10);
    }
}
