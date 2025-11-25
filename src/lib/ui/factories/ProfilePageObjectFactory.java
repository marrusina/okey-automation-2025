package lib.ui.factories;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import lib.Platform;
import lib.ui.ProfilePageObject;
import lib.ui.android.AndroidProfilePageObject;
import lib.ui.ios.IOSProfilePageObject;

import java.net.URL;

public class ProfilePageObjectFactory {

    public static ProfilePageObject get(AppiumDriver driver)
    {
        if (Platform.getInstance().isAndroid())
        {
            return new AndroidProfilePageObject(driver);
        } else
        {
            return new IOSProfilePageObject(driver);
        }
    }
}
