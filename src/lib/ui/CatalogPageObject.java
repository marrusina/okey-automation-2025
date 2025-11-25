package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;


abstract public class CatalogPageObject extends AllPageObject {

    public static String
            PORRIDGE_FRUTO_NYANYA,
            PRODUCT_BREAD;
    protected static String
            NAVIGATION_CATALOG_BUTTON,
            ALL_CATALOG_SCREEN_NAME;


    public CatalogPageObject(AppiumDriver driver)
    {
        super(driver);
    }

    //клик по кнопке Каталог на панели навигации
    public void clickCatalogButtonNavigationPanel()
    {
        this.waitForElementPresentAndClick(NAVIGATION_CATALOG_BUTTON,
                "Cannot click Catalog button",
                10);
        this.waitForElementPresent(ALL_CATALOG_SCREEN_NAME,
                "cannot find Catalogue", 30);
    }

    //проверка названия товара, берет текст
    public void productSmallCartCheckVision(String locator, String error, long timeOutInSeconds, String expected)
    {
        WebElement element = this.waitForElementPresent(locator, error, timeOutInSeconds);
        String result = element.getAttribute("text");
        Assert.assertEquals(
                "Text is wrong",
                expected,
                result
        );
    }

    //проверка, что товара не видно по названию
    public void productSmallCartCheckNotVision(String locator, String error, long timeOutInSeconds)
    {
        this.waitForElementNotPresent(locator, error, timeOutInSeconds);
    }

    //открыть товар с маленькой карточки товара
    public void openProductCard(String locator, String error, long timeOutInSeconds)
    {
        this.waitForElementPresentAndClick(locator, error, timeOutInSeconds);
    }}
