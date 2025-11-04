import lib.CoreTestCase;
import lib.ui.MainPageObject;
import lib.ui.SearchPageObject;
import lib.ui.WelcomePageObject;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class FirstTest extends CoreTestCase
{
    private MainPageObject MainPageObject;
    public SearchPageObject SearchPageObject;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        MainPageObject = new MainPageObject(driver);
    }

    @Test
    public void testFirst()
    {
        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        WelcomePageObject WelcomePageObject = new WelcomePageObject(driver);
        WelcomePageObject.accessToDeviceLocation(By.id(WelcomePageObject.DEVICE_LOCATION_DENY_BUTTON),
                "Cannot click location deny button", 10);
        WelcomePageObject.accessToGeoPosition(By.xpath(WelcomePageObject.GEOPOSITION_ACESS_BUTTON),
                "Cannot click deny button for geoposition",
                10);
        WelcomePageObject.chooseCity(By.xpath(WelcomePageObject.CHOOSE_SAINT_PETERSBURG_BUTTON),
                "Cannot choose Saint-Petersburg", 10);
        WelcomePageObject.clickNextAfterChooseCity();
        WelcomePageObject.skipChooseAddress();
        //WelcomePageObject.chooseOnlineShop(By.xpath(WelcomePageObject.ONLINE_SHOP_BUTTON),
        //        "Cannot find online shop button",
        //        20);
        WelcomePageObject.chooseNotificationButton(By.xpath(WelcomePageObject.NOTIFICATION_ALLOW_BUTTON),
                "Cannot find button Allow notification",
                10);
        SearchPageObject.clickCatalogButtonNavigationPanel();
        MainPageObject.swipeUpAndFindElement(
               By.xpath("//*[@text='Books and stationery']\"]"),
               "No such element after swipe",
                10);
        MainPageObject.swipeUpQuick();
        SearchPageObject.clickSearchString();
        SearchPageObject.searchSendKeys(By.id(SearchPageObject.SEARCH_FIELD),
                "хлеб", "cannot find search field and send keys", 10);
        MainPageObject.sendEnter();
        SearchPageObject.productSmallVision(By.xpath(SearchPageObject.PRODUCT_BREAD),
                "Cannot find product card of bread", 30, "Хлеб Английский диетический в нар.400г Каравай");
        SearchPageObject.searchClearField(By.id(SearchPageObject.SEARCH_FIELD),
                "cannot clear search field", 10);
        MainPageObject.clickBackButton();
        SearchPageObject.productSmallNotVision(By.xpath(SearchPageObject.PRODUCT_BREAD),
                "Bread is still seen", 30);
        SearchPageObject.openProductCard(By.xpath(SearchPageObject.PRODUCT_BREAD),
                "Cannot open product card of bread", 30);
        SearchPageObject.productSmallVision(By.xpath(SearchPageObject.PRODUCT_BREAD),
                "Cannot find product card of bread", 30,"Хлеб Английский диетический в нар.400г Каравай");

    }

    @Test
    public void testSwipe() throws InterruptedException {
        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        WelcomePageObject WelcomePageObject = new WelcomePageObject(driver);
        WelcomePageObject.accessToDeviceLocation(By.id(WelcomePageObject.DEVICE_LOCATION_DENY_BUTTON),
                "Cannot click location deny button", 10);
        WelcomePageObject.accessToGeoPosition(By.xpath(WelcomePageObject.GEOPOSITION_ACESS_BUTTON),
                "Cannot click deny button for geoposition",
                10);
        WelcomePageObject.chooseCity(By.xpath(WelcomePageObject.CHOOSE_SAINT_PETERSBURG_BUTTON),
                "Cannot choose Saint-Petersburg", 10);
        WelcomePageObject.clickNextAfterChooseCity();
        WelcomePageObject.chooseOnlineShop(By.xpath(WelcomePageObject.ONLINE_SHOP_BUTTON),
                "Cannot find online shop button",
                20);
        WelcomePageObject.skipChooseAddress();
        WelcomePageObject.chooseNotificationButton(By.xpath(WelcomePageObject.NOTIFICATION_ALLOW_BUTTON),
                "Cannot find button Allow notification", 10);
        WelcomePageObject.closeStories();
        SearchPageObject.navigationPanelMainButton();
        SearchPageObject.bookDeliveryBlock();
        MainPageObject.swipeUpAndFindElement(
                By.xpath(SearchPageObject.PORRIDGE_FRUTO_NYANYA),
                "No such element after swipe",
                20);
        SearchPageObject.openProductCard(By.xpath(SearchPageObject.PORRIDGE_FRUTO_NYANYA),
                "Cannot open product card of porridge", 30);
        SearchPageObject.clickAddToCart();
        SearchPageObject.clickCartButtonNavigationPanel();
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
