package lib.ui.factories;

import io.appium.java_client.AppiumDriver;
import lib.Platform;
import lib.ui.CatalogPageObject;
import lib.ui.android.AndroidCatalogPageObject;
import lib.ui.ios.IOSCatalogPageObject;


public class CatalogPageObjectFactory {
    public static CatalogPageObject get(AppiumDriver driver)
    {
        if (Platform.getInstance().isAndroid())
        {
            return new AndroidCatalogPageObject(driver);
        }
        else
        {
            return new IOSCatalogPageObject(driver);
        }
    }
}
