package lib.ui.android;
import io.appium.java_client.AppiumDriver;
import lib.ui.MainPageObject;

public class AndroidMainPageObject extends MainPageObject {
    static
    {
        BUTTON_BACK = "xpath://android.widget.ImageButton[@content-desc=\"Navigate up\"]";
    }

    public AndroidMainPageObject(AppiumDriver driver)
    {
        super(driver);
    }
}
