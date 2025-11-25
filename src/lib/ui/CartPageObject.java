package lib.ui;

import io.appium.java_client.AppiumDriver;

abstract public class CartPageObject extends AllPageObject {

    public static String
        PRODUCT_NAME_IN_CART_ALONE_PRODUCT;

    protected static String
            NAVIGATION_PANEL_CART_BUTTON,
            QTY_CHANGE_PRODUCT_IN_CART_ALONE_PRODUCT,
            CHOOSE_QUANTITY_TWO_IN_CART,
            DELETE_PRODUCT_IN_CART_PRODUCT_ALONE,
            CHECK_QUANTITY_TWO_IN_CART,
            ADD_TO_CART_BUTTON_BIG_PRODUCT_CARD;

    public CartPageObject(AppiumDriver driver)
    {
        super(driver);
    }

    public void clickCartButtonNavigationPanel()
    {
        this.waitForElementPresentAndClick(NAVIGATION_PANEL_CART_BUTTON,
                "Cannot click navigation panel cart button", 10);
    }

    // клик по Добавить в корзину с большой карточки товара
    public void clickAddToCartFromBigCart()
    {
        this.waitForElementPresentAndClick(ADD_TO_CART_BUTTON_BIG_PRODUCT_CARD,
                "Cannot add product to cart from big product cart", 10);
    }

    //клик по товару в корзине, когда товар единственный в корзине
    public void checkForProductInCartWhenItsAlone()
    {
        this.waitForElementPresent(
                PRODUCT_NAME_IN_CART_ALONE_PRODUCT,
                "No product in cart",
                20);
    }

    //клик по кнопке изменения кол-ва товара в корзине, когда товар единственный в корзине
    public void clickChQtyInCartWhenProductIsAlone() {
        this.waitForElementPresentAndClick(
                QTY_CHANGE_PRODUCT_IN_CART_ALONE_PRODUCT,
                "Cannot click to change quantity",
                10);
    }

    //клик на 2 шт/кг при изменении кол-ва товаров
    public void click2pcsInCart()
    {
        this.waitForElementPresentAndClick(
                CHOOSE_QUANTITY_TWO_IN_CART,
                "Cannot choose 2 pcs",
                10);
    }

    //проверка, что в корзине 2 шт/кг товара
    public void checkProductHas2pcsInCart()
    {
        this.waitForElementPresent(
                CHECK_QUANTITY_TWO_IN_CART,
                "cannot find quantity",
                10);
    }

    //удалить товар из корзины
    public void deleteProductInCart()
    {
        this.waitForElementPresentAndClick(DELETE_PRODUCT_IN_CART_PRODUCT_ALONE,
                "Cannot delete product in cart",
                15);
    }
}
