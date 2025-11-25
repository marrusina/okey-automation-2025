package lib.ui.android;
import io.appium.java_client.AppiumDriver;
import lib.ui.AllPageObject;
import lib.ui.MainPageObject;

public class AndroidMainPageObject extends MainPageObject {
    static
    {
        BUTTON_BACK = "xpath://android.widget.ImageButton[@content-desc=\"Navigate up\"]";
        MAIN_SEARCH_TEXT = "xpath://android.widget.TextView[@resource-id=\"ru.reksoft.okey:id/search_in\" and @text = 'Искать в О’КЕЙ']";
        MAIN_SCANNER_ICON = "id:ru.reksoft.okey:id/scanner";
        ITEM_CARDS_LIST_IN_CATALOG = "id:ru.reksoft.okey:id/refining_items_list";
        CHOOSE_ADDRESS_BLOCK_MAIN_SCREEN = "xpath://*[@resource-id='ru.reksoft.okey:id/book_delivery']//*[@text='Выберите адрес и время доставки']";
        AUTH_BLOCK_MAIN_SCREEN = "xpath://android.widget.TextView[@resource-id=\"ru.reksoft.okey:id/login_text\" and @text = 'Войдите в личный кабинет или оформите\\nО'КАРТУ, чтобы узнать вашу скидку']";
    }

    public AndroidMainPageObject(AppiumDriver driver)
    {
        super(driver);
    }
}
