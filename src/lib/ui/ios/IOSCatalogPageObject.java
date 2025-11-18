package lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import lib.ui.CatalogPageObject;

public class IOSCatalogPageObject extends CatalogPageObject
{
    static
    {
        NAVIGATION_CATALOG_BUTTON ="id:ru.reksoft.okey:id/catalog_fragment";
        PRODUCT_BREAD = "xpath://*[@resource-id='ru.reksoft.okey:id/items']//*[@text='Хлеб Английский диетический в нар.400г Каравай']";
        ALL_CATALOG_SCREEN_NAME = "xpath:(//android.widget.TextView[@text=\"Catalogue\"])[1]";
        PORRIDGE_FRUTO_NYANYA = "xpath://android.widget.TextView[@resource-id=\"ru.reksoft.okey:id/name\" and @text=\"Кашка молочная ФрутоНяня овсяная банан/яблоко с ...\"]";


    }
    public IOSCatalogPageObject(AppiumDriver driver)
    {
        super(driver);
    }
}