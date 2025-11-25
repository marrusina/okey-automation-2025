package lib.ui;

import io.appium.java_client.AppiumDriver;

public class MainPageObject extends AllPageObject{
    protected static String MAIN_SEARCH_TEXT, MAIN_SCANNER_ICON, CHOOSE_ADDRESS_BLOCK_MAIN_SCREEN,
    AUTH_BLOCK_MAIN_SCREEN, ITEM_CARDS_LIST_IN_CATALOG;

    public MainPageObject(AppiumDriver driver)
    {super(driver);}

    public void checkSearchBlockAppearanceMainPage()
    {
        this.waitForElementPresent(MAIN_SEARCH_TEXT, "Cannot see search text and block on Main screen", 10);
        this.waitForElementPresent(MAIN_SCANNER_ICON, "Cannot see scanner icon on Main screen", 10);
    }

    public void clickSearchFieldMainScreen()
    {
        this.waitForElementPresentAndClick(MAIN_SEARCH_TEXT, "Cannot click search field", 10);
    }
    public void searchMilkOnMainScreen()
    {
        this.waitForElementAndSendKeys(MAIN_SEARCH_TEXT, "молоко", "Cannot type молоко", 10);
    }

    public void checkItemsListAfterSearch()
    {
        this.waitForElementPresent(ITEM_CARDS_LIST_IN_CATALOG, "No items after search", 10);
        for (:
             ) {
            
        }
    }

}
