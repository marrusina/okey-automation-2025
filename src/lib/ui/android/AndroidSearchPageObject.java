package lib.ui.android;
import io.appium.java_client.AppiumDriver;
import lib.ui.SearchPageObject;

public class AndroidSearchPageObject extends SearchPageObject
{
    static
    {
    CHECK_SEARCH_STRING = "xpath://*[contains(@text,'Search')]";
    SEARCH_FIELD = "id:ru.reksoft.okey:id/search_field";
    NAVIGATION_PANEL_MAIN = "xpath:(//android.widget.ImageView[@resource-id=\"ru.reksoft.okey:id/navigation_bar_item_icon_view\"])[1]";
    DELIVERY_BLOCK_MAIN_SCREEN = "id:ru.reksoft.okey:id/book_delivery";
    }
     public AndroidSearchPageObject(AppiumDriver driver)
     {
         super(driver);
     }
}
