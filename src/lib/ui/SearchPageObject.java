package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class SearchPageObject extends MainPageObject
{
    public static final String
        NAVIGATION_CATALOG_BUTTON ="(//android.widget.ImageView[@resource-id=\"ru.reksoft.okey:id/navigation_bar_item_icon_view\"])[2]",
        ALL_CATALOG_SCREEN_NAME = "(//android.widget.TextView[@text=\"Catalogue\"])[1]",
        CHECK_SEARCH_STRING = "//*[contains(@text,'Search')]",
        SEARCH_FIELD = "ru.reksoft.okey:id/search_field",
        PRODUCT_BREAD = "//*[@resource-id='ru.reksoft.okey:id/items']//*[@text='Хлеб Английский диетический в нар.400г Каравай']",
        NAVIGATION_PANEL_MAIN = "(//android.widget.ImageView[@resource-id=\"ru.reksoft.okey:id/navigation_bar_item_icon_view\"])[1]",
        DELIVERY_BLOCK_MAIN_SCREEN = "ru.reksoft.okey:id/book_delivery",
        PORRIDGE_FRUTO_NYANYA = "//android.widget.TextView[@resource-id=\"ru.reksoft.okey:id/name\" and @text=\"Кашка без молока ФрутоНяня гречневая ...\"]";



    public SearchPageObject(AppiumDriver driver)
    {
        super(driver);
    }

    public void clickCatalogButtonNavigationPanel()
    {
        this.waitForElementPresentAndClick(By.id(NAVIGATION_CATALOG_BUTTON),
                "Cannot click Catalog button",
                10);
        this.waitForElementPresent(By.xpath(ALL_CATALOG_SCREEN_NAME),
                "cannot find Catalogue", 30);
    }

    public void clickSearchString()
    {
        this.waitForElementPresentAndClick(By.xpath(CHECK_SEARCH_STRING),
                "no field Search", 20);
    }

    public void searchSendKeys(By by, String value, String error, long timeOutInSeconds)
    {
        this.waitForElementAndSendKeys(by, value, error, timeOutInSeconds);
    }

    public void productSmallVision(By by, String error, long timeOutInSeconds, String expected)
    {
        WebElement element = this.waitForElementPresent(by, error, timeOutInSeconds);
        String result = element.getAttribute("text");
        Assert.assertEquals(
                        "Text is wrong",
                expected,
                result
        );
    }

    public void navigationPanelMainButton()
    {
        this.waitForElementPresentAndClick(By.xpath(NAVIGATION_PANEL_MAIN),
                "Cannot click Main in navigation panel", 10);
    }

    public void productSmallNotVision(By by, String error, long timeOutInSeconds)
    {
        this.waitForElementNotPresent(by, error, timeOutInSeconds);
    }

    public void searchClearField(By by, String error, long timeOutInSeconds)
    {
        this.waitForElementAndClear(by, error, timeOutInSeconds);
    }

    public void openProductCard(By by, String error, long timeOutInSeconds)
    {
        this.waitForElementPresentAndClick(by, error, timeOutInSeconds);
    }

    public void bookDeliveryBlock()
    {
        this.waitForElementPresent(By.id(DELIVERY_BLOCK_MAIN_SCREEN),
                "Cannot find block delivery on main screen", 10);
    }


}
