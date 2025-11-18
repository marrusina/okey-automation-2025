package lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import lib.ui.WelcomePageObject;

public class IOSWelcomePageObject extends WelcomePageObject
{
    static
    {
        DEVICE_LOCATION_DENY_BUTTON = "id:com.android.permissioncontroller:id/permission_deny_button";
        GEOPOSITION_ACESS_DENY_BUTTON  = "xpath://*[contains(@text,'CANCEL')]";
        CHOOSE_SAINT_PETERSBURG_BUTTON = "xpath://android.widget.TextView[@text=\"Санкт-Петербург\"]";
        NEXT_AFTER_CITY_BUTTON = "id:ru.reksoft.okey:id/next";
        SKIP_CHOOSING_ADRESS = "id:ru.reksoft.okey:id/skip";
        ONLINE_SHOP_BUTTON = "xpath://android.widget.FrameLayout[@resource-id=\"ru.reksoft.okey:id/online\"]/android.view.ViewGroup";
        NOTIFICATION_ALLOW_BUTTON = "xpath://*[contains(@text,'ALLOW')]";
        STORIES_CLOSE = "id:ru.reksoft.okey:id/ias_close_button";
    }

    public IOSWelcomePageObject(AppiumDriver driver)
    {
        super(driver);
    }

}