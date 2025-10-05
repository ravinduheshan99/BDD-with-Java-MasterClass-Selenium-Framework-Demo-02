package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * The LandingPage class represents the main product listing page of the web application.
 * It follows the Page Object Model (POM) design pattern, providing centralized access
 * to web elements and actions that can be performed on the landing page.
 * <p>
 * This class contains locators and methods for performing product searches,
 * selecting deals, updating quantities, adding items to the cart, and proceeding to checkout.
 */
public class LandingPage {

    // Shared WebDriver instance used for interacting with web elements
    public WebDriver driver;

    /**
     * Constructor initializes the LandingPage class with a WebDriver instance.
     * This ensures all element interactions occur within the active browser session.
     *
     * @param driver WebDriver instance provided from the PageObjectManager
     */
    public LandingPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators for key elements on the landing page
    private By search = By.xpath("//input[@type='search']");
    private By productName = By.cssSelector("h4.product-name");
    private By topDeals = By.linkText("Top Deals");
    private By increment = By.cssSelector("a.increment");
    private By addToCart = By.cssSelector(".product-action button");
    private By cartBag = By.cssSelector("[alt='Cart']");
    private By checkoutButton = By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]");

    /**
     * Returns the title of the landing page.
     * Useful for verifying that the user is on the correct page after navigation.
     *
     * @return String representing the page title
     */
    public String getTitleLandingPage() {
        System.out.println("getTitleLandingPage : Method Executed");
        return driver.getTitle();
    }

    /**
     * Searches for a product using the search bar by entering the provided product name.
     * A short delay is added to allow search results to load.
     *
     * @param productNameSearching The product name or keyword to be searched
     * @throws InterruptedException if thread sleep is interrupted
     */
    public void searchItem(String productNameSearching) throws InterruptedException {
        System.out.println("searchItem : Method Executed");
        driver.findElement(search).sendKeys(productNameSearching);
        Thread.sleep(2000);
    }

    /**
     * Retrieves the name of the first product displayed on the landing page.
     * The method trims the product name to remove any additional characters such as weights or descriptions.
     *
     * @return String representing the product name
     */
    public String getProductName() {
        System.out.println("getProductName : Method Executed");
        return driver.findElement(productName).getText().split("-")[0].trim();
    }

    /**
     * Navigates to the "Top Deals" page by clicking on the link provided in the header.
     */
    public void selectTopDealsPage() {
        System.out.println("selectTopDealsPage : Method Executed");
        driver.findElement(topDeals).click();
    }

    /**
     * Increases the quantity of a selected product by clicking the increment button
     * the specified number of times.
     *
     * @param quantity The number of times to increase the quantity
     */
    public void incrementQuantity(int quantity) {
        System.out.println("incrementQuantity : Method Executed");
        for (int j = 0; j < quantity; j++) {
            driver.findElement(increment).click();
        }
    }

    /**
     * Adds the currently selected product to the shopping cart.
     */
    public void addToCart() {
        System.out.println("addToCart : Method Executed");
        driver.findElement(addToCart).click();
    }

    /**
     * Opens the cart and proceeds to the checkout page.
     * This method combines both steps into a single flow for convenience.
     */
    public void checkoutItems() {
        System.out.println("checkoutItems : Method Executed");
        driver.findElement(cartBag).click();
        driver.findElement(checkoutButton).click();
    }
}
