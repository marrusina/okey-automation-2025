package lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import lib.ui.CartPageObject;

public class IOSCartPageObject extends CartPageObject {
    static
    {
        NAVIGATION_PANEL_CART_BUTTON = "id:ru.reksoft.okey:id/cart_fragment";
        PRODUCT_NAME_IN_CART_ALONE_PRODUCT = "id:ru.reksoft.okey:id/name";
        QTY_CHANGE_PRODUCT_IN_CART_ALONE_PRODUCT = "id:ru.reksoft.okey:id/itemQuantity";
        CHOOSE_QUANTITY_TWO_IN_CART = "xpath://*[@text='2 pcs']";
        DELETE_PRODUCT_IN_CART_PRODUCT_ALONE ="xpath://android.widget.LinearLayout[@resource-id=\"ru.reksoft.okey:id/bottom_wrapper\"]/android.widget.ImageButton[2]";
        CHECK_QUANTITY_TWO_IN_CART = "xpath://android.widget.TextView[@resource-id=\"ru.reksoft.okey:id/itemQuantity\" and @text=\"2 pcs\"]";
        ADD_TO_CART_BUTTON_BIG_PRODUCT_CARD = "id:ru.reksoft.okey:id/add";
    }
    public IOSCartPageObject(AppiumDriver driver)
    {
        super(driver);
    }
}
