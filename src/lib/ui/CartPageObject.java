package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CartPageObject extends MainPageObject{

    public static final String
            NAVIGATION_PANEL_CART_BUTTON = "(//android.widget.ImageView[@resource-id=\"ru.reksoft.okey:id/navigation_bar_item_icon_view\"])[4]",
            ADD_TO_CART_BUTTON_BIG_PRODUCT_CARD = "ru.reksoft.okey:id/add";

    public CartPageObject(AppiumDriver driver)
    {
        super(driver);
    }

    public void clickCartButtonNavigationPanel()
    {
        this.waitForElementPresentAndClick(By.xpath(NAVIGATION_PANEL_CART_BUTTON),
                "Cannot click navigation panel cart button", 10);
    }

    public void clickAddToCartFromBigCart()
    {
        this.waitForElementPresentAndClick(By.id(ADD_TO_CART_BUTTON_BIG_PRODUCT_CARD),
                "Cannot add product to cart from big product cart", 10);
    }

    public void checkForProductInCartWhenItsAlone()
    {
        this.waitForElementPresent(
                By.id("ru.reksoft.okey:id/name"),
                "No product in cart",
                20);
    }

    public void clickChQtyInCartWhenProductIsAlone() {
        this.waitForElementPresentAndClick(
                By.id("ru.reksoft.okey:id/itemQuantity"),
                "Cannot click to change quantity",
                10);
    }
}
