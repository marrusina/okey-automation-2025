import com.google.common.collect.ImmutableMap;
import io.appium.java_client.TouchAction;
import lib.CoreTestCase;
import lib.ui.MainPageObject;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FirstTest extends CoreTestCase
{
    private MainPageObject MainPageObject;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        MainPageObject = new MainPageObject(driver);
    }

    @Test
    public void testFirst()
    {
        WebElement elementPermission = MainPageObject.waitForElementPresentAndClick(
                By.id("com.android.permissioncontroller:id/permission_deny_button"),
                "cannot find permission deny button", 10);
        WebElement elementLocationCancel = MainPageObject.waitForElementPresentAndClick(
                By.xpath("//*[contains(@text,'CANCEL')]"),
                "no cancel button",10);
        WebElement elementChooseCity = MainPageObject.waitForElementPresentAndClick(
                By.xpath("//android.widget.TextView[@text=\"Санкт-Петербург\"]"),
                "cannot find city button", 10);
        WebElement elementNextButton = MainPageObject.waitForElementPresentAndClick(
                By.id("ru.reksoft.okey:id/next"),
                "Cannot find button Next", 10);
        WebElement elementSkip = MainPageObject.waitForElementPresentAndClick(
                By.id("ru.reksoft.okey:id/skip"),
                "Cannot find button SKIP", 10);
        WebElement elementNotificationAllow = MainPageObject.waitForElementPresentAndClick(
                By.xpath("//*[contains(@text,'ALLOW')]"),
                "Cannot find button Allow notification", 10);

        WebElement elementCatalog = MainPageObject.waitForElementPresentAndClick(
                By.xpath("(//android.widget.ImageView[@resource-id=\"ru.reksoft.okey:id/navigation_bar_item_icon_view\"])[2]"),
                "cannot find catalog button", 10);
        MainPageObject.waitForElementPresent(By.xpath("(//android.widget.TextView[@text=\"Catalogue\"])[1]"),
            "cannot find Catalogue", 30);
        MainPageObject.swipeUpAndFindElement(
               By.xpath("//*[@text='Books and stationery']\"]"),
               "No such element after swipe",
                10);
        MainPageObject.swipeUpQuick();
        WebElement elementSearch = MainPageObject.waitForElementPresentAndClick(
                By.xpath("//*[contains(@text,'Search')]"),
                "no field Search", 20);
        WebElement elementSearchSendKeys = MainPageObject.waitForElementAndSendKeys(
                By.id("ru.reksoft.okey:id/search_field"),
                "хлеб", "cannot find search field and send keys", 10);
        MainPageObject.sendEnter();
        MainPageObject.waitForElementPresent(
                By.xpath("//*[@resource-id='ru.reksoft.okey:id/items']//*[@text='Хлеб Английский диетический в нар.400г Каравай']"),
       "Cannot find bread", 50);

        MainPageObject.waitForElementAndClear(By.id(
                "ru.reksoft.okey:id/search_field"),
                "cannot clear search field", 10);
        WebElement elementBack = MainPageObject.waitForElementPresentAndClick(
                By.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]"),
                "cannot find back and click",
                10);
        MainPageObject.waitForElementNotPresent(
                By.xpath("//*[@resource-id='ru.reksoft.okey:id/items']//*[@text='Хлеб Английский диетический в нар.400г Каравай']"),
                "Still seen bread", 30);
        MainPageObject.waitForElementPresentAndClick(
                By.xpath("//*[@resource-id='ru.reksoft.okey:id/items']//*[@text='Хлеб Английский диетический в нар.400г Каравай']"),
                "Cannot find bread", 50);
        WebElement elementBread = MainPageObject.waitForElementPresent(
                        By.xpath("//*[@resource-id='ru.reksoft.okey:id/items']//*[@text='Хлеб Английский диетический в нар.400г Каравай']"),
                "Cannot find bread", 50);
        String bread = elementBread.getAttribute("text");
        Assert.assertEquals(
                "Text for bread is wrong",
                "Хлеб Английский диетический в нар.400г Каравай",
                bread
        );
    }

    @Test
    public void testSwipe() throws InterruptedException {
        WebElement elementPermission = MainPageObject.waitForElementPresentAndClick(
                By.id("com.android.permissioncontroller:id/permission_deny_button"),
                "cannot find permission deny button", 10);
        WebElement elementLocationCancel = MainPageObject.waitForElementPresentAndClick(
                By.xpath("//*[contains(@text,'CANCEL')]"),
                "no cancel button", 10);
        WebElement elementChooseCity = MainPageObject.waitForElementPresentAndClick(
                By.xpath("//android.widget.TextView[@text=\"Санкт-Петербург\"]"),
                "cannot find city button", 10);
        WebElement elementNextButton = MainPageObject.waitForElementPresentAndClick(
                By.id("ru.reksoft.okey:id/next"),
                "Cannot find button Next", 10);
        WebElement elementOnlineShop = MainPageObject.waitForElementPresentAndClick(
                By.xpath("//android.widget.FrameLayout[@resource-id=\"ru.reksoft.okey:id/online\"]/android.view.ViewGroup"),
                "Cannot find online shop button",
                20);
        WebElement elementSkip = MainPageObject.waitForElementPresentAndClick(
                By.id("ru.reksoft.okey:id/skip"),
                "Cannot find button SKIP", 10);
        WebElement elementNotificationAllow = MainPageObject.waitForElementPresentAndClick(
                By.xpath("//*[contains(@text,'ALLOW')]"),
                "Cannot find button Allow notification", 10);
        WebElement elementStoriesToClose = MainPageObject.waitForElementPresentAndClick(
                By.id("ru.reksoft.okey:id/ias_close_button"),
                "Cannot close Stories",
                10);
        WebElement elementCatalog = MainPageObject.waitForElementPresentAndClick(
                By.xpath("(//android.widget.ImageView[@resource-id=\"ru.reksoft.okey:id/navigation_bar_item_icon_view\"])[1]"),
                "cannot find main button", 10);
        MainPageObject.waitForElementPresent(
                By.id("ru.reksoft.okey:id/book_delivery"),
                "it's not the main screen", 30);
        MainPageObject.swipeUpAndFindElement(
                //By.xpath("//android.widget.TextView[@resource-id=\"ru.reksoft.okey:id/title\" and @text=\"Children\"]"),
                By.xpath("//android.widget.TextView[@resource-id=\"ru.reksoft.okey:id/name\" and @text=\"Кашка без молока ФрутоНяня гречневая ...\"]"),
                "No such element after swipe",
                20);
        MainPageObject.waitForElementPresentAndClick(
                        By.xpath("//android.widget.TextView[@resource-id=\"ru.reksoft.okey:id/name\" and @text=\"Кашка без молока ФрутоНяня гречневая ...\"]"),
                "Cannot find porridge",
                50);
        WebElement elementAddToCart = MainPageObject.waitForElementPresentAndClick(
                By.id("ru.reksoft.okey:id/add"),
                "Cannot add product to cart",
                10);
        WebElement elementCart = MainPageObject.waitForElementPresentAndClick(
                By.xpath("(//android.widget.ImageView[@resource-id=\"ru.reksoft.okey:id/navigation_bar_item_icon_view\"])[4]"),
                "cannot find cart button", 10);
        MainPageObject.waitForElementPresent(
                By.id("ru.reksoft.okey:id/name"),
                "No product in cart",
                20);
        WebElement elementChQty = MainPageObject.waitForElementPresentAndClick(
                By.id("ru.reksoft.okey:id/itemQuantity"),
                "Cannot click to change quantity",
                10);
        WebElement elementTwoPcs = MainPageObject.waitForElementPresentAndClick(
                By.xpath("//*[@text='2 pcs']"),
                "Cannot choose 2 pcs",
                10);
        WebElement elementQuantity = MainPageObject.waitForElementPresent(
                By.xpath("//android.widget.TextView[@resource-id=\"ru.reksoft.okey:id/itemQuantity\" and @text=\"2 pcs\"]"),
                "cannot find quantity",
                10);
        MainPageObject.swipeLeft(
                By.id("ru.reksoft.okey:id/name"),
                "cannot swipe left"
        );
        WebElement elementDeleteInCart = MainPageObject.waitForElementPresentAndClick(
                By.xpath("//android.widget.LinearLayout[@resource-id=\"ru.reksoft.okey:id/bottom_wrapper\"]/android.widget.ImageButton[2]"),
                "Cannot delete product in cart",
                15);

    }

}
