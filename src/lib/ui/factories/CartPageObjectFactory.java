package lib.ui.factories;

import io.appium.java_client.AppiumDriver;
import lib.Platform;
import lib.ui.CartPageObject;
import lib.ui.android.AndroidCartPageObject;
import lib.ui.ios.IOSCartPageObject;

public class CartPageObjectFactory {

    public static CartPageObject get(AppiumDriver driver)
    {
        if (Platform.getInstance().isAndroid())
        {
            return new AndroidCartPageObject(driver);
        } else
        {
            return new IOSCartPageObject(driver);
        }

    }
}
