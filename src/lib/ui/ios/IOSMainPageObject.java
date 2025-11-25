package lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import lib.ui.AllPageObject;
import lib.ui.MainPageObject;

public class IOSMainPageObject extends MainPageObject {
    static
    {
        BUTTON_BACK = "xpath://android.widget.ImageButton[@content-desc=\"Navigate up\"]";
    }

    public IOSMainPageObject(AppiumDriver driver)
    {
        super(driver);
    }
}
