package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * The CheckoutPage class represents the checkout section of the application,
 * where users can review selected items, apply promo codes, and place their final order.
 * It adheres to the Page Object Model (POM) design, encapsulating all relevant web elements
 * and actions that can be performed on the checkout page.
 */
public class CheckoutPage {

    // Shared WebDriver instance for interacting with checkout page elements
    public WebDriver driver;

    /**
     * Constructor initializes the CheckoutPage class with a WebDriver instance.
     * This allows all actions in this class to use the same browser session managed by the test context.
     *
     * @param driver WebDriver instance provided from the PageObjectManager
     */
    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators for key elements on the checkout page
    private By productName = By.xpath("//p[@class='product-name']");
    private By promoButton = By.cssSelector(".promoBtn");
    private By placeOrderButton = By.xpath("//button[contains(text(),'Place Order')]");

    /**
     * Retrieves the name of the product displayed on the checkout page.
     * The method trims unnecessary text, keeping only the product name.
     *
     * @return String representing the product name on the checkout page
     */
    public String checkoutPageProductItemName() {
        System.out.println("checkoutPageProductItemName : Method Executed");
        return driver.findElement(productName).getText().split("-")[0].trim();
    }

    /**
     * Checks whether the promo code button is visible on the checkout page.
     * Useful for validating UI components or functional readiness before applying a promo code.
     *
     * @return Boolean value indicating whether the promo button is displayed
     */
    public Boolean verifyPromoButton() {
        System.out.println("verifyPromoButton : Method Executed");
        return driver.findElement(promoButton).isDisplayed();
    }

    /**
     * Checks whether the “Place Order” button is visible on the checkout page.
     * This ensures that the page has loaded completely and is ready for user interaction.
     *
     * @return Boolean value indicating whether the place order button is displayed
     */
    public Boolean verifyPlaceOrderButton() {
        System.out.println("verifyPlaceOrderButton : Method Executed");
        return driver.findElement(placeOrderButton).isDisplayed();
    }
}
