package pageObjects;

import org.openqa.selenium.WebDriver;

/**
 * The PageObjectManager class is responsible for creating and managing instances
 * of all page object classes used in the test framework.
 * It helps maintain a clean structure and ensures that each test uses
 * a single shared WebDriver instance across all page objects.
 * <p>
 * This approach follows the Page Object Model (POM) and promotes
 * better code organization, reusability, and maintainability.
 */
public class PageObjectManager {

    // Declarations for page object references
    public LandingPage landingPage;
    public OffersPage offersPage;
    public CheckoutPage checkoutPage;

    // Shared WebDriver instance used across all page objects
    public WebDriver driver;

    /**
     * Constructor initializes the PageObjectManager with the active WebDriver instance.
     * This ensures all page objects operate within the same browser session.
     *
     * @param driver WebDriver instance passed from TestContextSetup
     */
    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Returns an instance of the LandingPage class.
     * A new instance is created each time this method is called.
     *
     * @return LandingPage instance
     */
    public LandingPage getLandingPage() {
        landingPage = new LandingPage(driver);
        return landingPage;
    }

    /**
     * Returns an instance of the OffersPage class.
     * A new instance is created each time this method is called.
     *
     * @return OffersPage instance
     */
    public OffersPage getOffersPage() {
        offersPage = new OffersPage(driver);
        return offersPage;
    }

    /**
     * Returns an instance of the CheckoutPage class.
     * A new instance is created each time this method is called.
     *
     * @return CheckoutPage instance
     */
    public CheckoutPage getCheckoutPage() {
        checkoutPage = new CheckoutPage(driver);
        return checkoutPage;
    }
}
