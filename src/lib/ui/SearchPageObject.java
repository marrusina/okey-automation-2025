package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;


public class SearchPageObject extends MainPageObject
{
    public static final String
        DEVICE_LOCATION_DENY_BUTTON = "com.android.permissioncontroller:id/permission_deny_button",
        GEOPOSITION_ACESS_BUTTON = "//*[contains(@text,'CANCEL')]",
        CHOOSE_SAINT_PETERSBURG_BUTTON = "//android.widget.TextView[@text=\"Санкт-Петербург\"]",
        NEXT_AFTER_CITY_BUTTON = "ru.reksoft.okey:id/next",
        SKIP_CHOOSING_ADRESS = "ru.reksoft.okey:id/skip";


    public SearchPageObject(AppiumDriver driver)
    {
        super(driver);
    }

    public void accessToDeviceLocation(By by, String error, int time)
    {
        this.waitForElementPresentAndClick(by,error,time);
    }

    public void accessToGeoPosition(By by, String error, int time)
    {
        this.waitForElementPresentAndClick(by,error,time);
    }

    public void choosecity(By by, String error, int time)
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


}
