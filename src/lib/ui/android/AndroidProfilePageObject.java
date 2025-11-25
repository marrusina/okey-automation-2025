package lib.ui.android;

import io.appium.java_client.AppiumDriver;
import lib.ui.ProfilePageObject;

public class AndroidProfilePageObject extends ProfilePageObject {

    static{
        NAVIGATION_PROFILE_BUTTON = "id:ru.reksoft.okey:id/profile_fragment";
        CITY_IN_PROFILE_SPB = "xpath://android.widget.TextView[@resource-id=\"ru.reksoft.okey:id/region\" and @text = 'Санкт-Петербург']";


    }

    public AndroidProfilePageObject(AppiumDriver driver)
    {
        super(driver);
    }
}
