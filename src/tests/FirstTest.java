package tests;

import lib.CoreTestCase;
import lib.ui.*;
import lib.ui.factories.*;
import org.junit.Test;
import org.openqa.selenium.By;

public class FirstTest extends CoreTestCase
{
    private MainPageObject MainPageObject;
    //public SearchPageObject SearchPageObject;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        MainPageObject = MainPageObjectFactory.get(driver);
    }

    @Test
    public void testFirst()
    {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        WelcomePageObject WelcomePageObject = WelcomePageObjectFactory.get(driver);
        CartPageObject CartPageObject = CartPageObjectFactory.get(driver);
        CatalogPageObject CatalogPageObject = CatalogPageObjectFactory.get(driver);
        WelcomePageObject.accessToDeviceLocationDenyButton();
        WelcomePageObject.accessToGeoPositionDenyButton();
        WelcomePageObject.chooseCity(WelcomePageObject.CHOOSE_SAINT_PETERSBURG_BUTTON,
                "Cannot choose Saint-Petersburg", 10);
        WelcomePageObject.clickNextAfterChooseCity();
        WelcomePageObject.skipChooseAddress();
        WelcomePageObject.chooseOnlineShop();
        WelcomePageObject.chooseNotificationAllowButton();
        WelcomePageObject.closeStories();
        CatalogPageObject.clickCatalogButtonNavigationPanel();
        MainPageObject.swipeUpAndFindElement("xpath://*[@text='Books and stationery']\"]",
               "No such element after swipe",
                10);
        MainPageObject.swipeUpQuick();
        SearchPageObject.clickSearchString();
        SearchPageObject.searchSendKeys(SearchPageObject.SEARCH_FIELD,
                "хлеб", "cannot find search field and send keys", 10);
        MainPageObject.sendEnter();
        CatalogPageObject.productSmallCartCheckVision(CatalogPageObject.PRODUCT_BREAD,
                "Cannot find product card of bread", 30, "Хлеб Английский диетический в нар.400г Каравай");
        SearchPageObject.searchClearField(SearchPageObject.SEARCH_FIELD,
                "cannot clear search field", 10);
        MainPageObject.clickBackButton();
        CatalogPageObject.productSmallCartCheckNotVision(CatalogPageObject.PRODUCT_BREAD,
                "Bread is still seen", 30);
        CatalogPageObject.openProductCard(CatalogPageObject.PRODUCT_BREAD,
                "Cannot open product card of bread", 30);
        CatalogPageObject.productSmallCartCheckVision(CatalogPageObject.PRODUCT_BREAD,
                "Cannot find product card of bread", 30,"Хлеб Английский диетический в нар.400г Каравай");

    }

    @Test
    public void testSwipe() throws InterruptedException {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        WelcomePageObject WelcomePageObject = WelcomePageObjectFactory.get(driver);
        CartPageObject CartPageObject = CartPageObjectFactory.get(driver);
        CatalogPageObject CatalogPageObject = CatalogPageObjectFactory.get(driver);
        WelcomePageObject.accessToDeviceLocationDenyButton();
        WelcomePageObject.accessToGeoPositionDenyButton();
        WelcomePageObject.chooseCity(WelcomePageObject.CHOOSE_SAINT_PETERSBURG_BUTTON,
                "Cannot choose Saint-Petersburg", 10);
        WelcomePageObject.clickNextAfterChooseCity();
        WelcomePageObject.chooseOnlineShop();
        WelcomePageObject.skipChooseAddress();
        WelcomePageObject.chooseNotificationAllowButton();
        WelcomePageObject.closeStories();
        SearchPageObject.navigationPanelMainButton();
        SearchPageObject.bookDeliveryBlock();
        MainPageObject.swipeUpAndFindElement(CatalogPageObject.PORRIDGE_FRUTO_NYANYA,
                "No such element after swipe",
                20);
        CatalogPageObject.openProductCard(CatalogPageObject.PORRIDGE_FRUTO_NYANYA,
                "Cannot open product card of porridge", 30);
        CartPageObject.clickAddToCartFromBigCart();
        CartPageObject.clickCartButtonNavigationPanel();
        CartPageObject.checkForProductInCartWhenItsAlone();
        CartPageObject.clickChQtyInCartWhenProductIsAlone();
        CartPageObject.click2pcsInCart();
        CartPageObject.checkProductHas2pcsInCart();
        MainPageObject.swipeLeft(CartPageObject.PRODUCT_NAME_IN_CART_ALONE_PRODUCT,
                "cannot swipe left"
        );
        CartPageObject.deleteProductInCart();

    }

}
