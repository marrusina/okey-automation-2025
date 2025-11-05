package lib.ui;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class WelcomePageObject extends MainPageObject {
    public static final String
    DEVICE_LOCATION_DENY_BUTTON = "com.android.permissioncontroller:id/permission_deny_button",
    GEOPOSITION_ACESS_BUTTON = "//*[contains(@text,'CANCEL')]",
    CHOOSE_SAINT_PETERSBURG_BUTTON = "//android.widget.TextView[@text=\"Санкт-Петербург\"]",
    NEXT_AFTER_CITY_BUTTON = "ru.reksoft.okey:id/next",
    SKIP_CHOOSING_ADRESS = "ru.reksoft.okey:id/skip",
    ONLINE_SHOP_BUTTON = "//android.widget.FrameLayout[@resource-id=\"ru.reksoft.okey:id/online\"]/android.view.ViewGroup",
    NOTIFICATION_ALLOW_BUTTON = "//*[contains(@text,'ALLOW')]",
    STORIES_CLOSE = "ru.reksoft.okey:id/ias_close_button";

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
                this.waitForElementPresentAndClick(By.id(WelcomePageObject.DEVICE_LOCATION_DENY_BUTTON),
                        "Cannot click location deny button", 10);
    }

    public void accessToGeoPositionDenyButton()
    {
        this.waitForElementPresentAndClick(By.xpath(WelcomePageObject.GEOPOSITION_ACESS_BUTTON),
                "Cannot click deny button for geoposition",
                10);
    }

    public void chooseCity(By by, String error, int time)
    {
        this.waitForElementPresentAndClick(by,error,time);
    }

    public void clickNextAfterChooseCity()
    {
        this.waitForElementPresentAndClick(By.id(NEXT_AFTER_CITY_BUTTON),
                "Cannot click Next button after choosing city",
                10);
    }

    public void skipChooseAddress()
    {
        this.waitForElementPresentAndClick(By.id(SKIP_CHOOSING_ADRESS),
                "Cannot click Skip for choosing address",
                10);
    }

    public void chooseOnlineShop()
    {
        this.waitForElementPresentAndClick(By.xpath(WelcomePageObject.ONLINE_SHOP_BUTTON),
                "Cannot find online shop button",
                20);
    }

    public void chooseNotificationAllowButton()
    {
        this.waitForElementPresentAndClick(By.xpath(WelcomePageObject.NOTIFICATION_ALLOW_BUTTON),
                "Cannot find button Allow notification",
                10);
    }

    public void closeStories()
    {
        this.waitForElementPresentAndClick(By.id(STORIES_CLOSE),
                "Cannot close Stories", 10);
    }
}
