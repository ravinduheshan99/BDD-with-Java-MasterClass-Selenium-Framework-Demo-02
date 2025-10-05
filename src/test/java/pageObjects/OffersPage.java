package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * The OffersPage class represents the “Top Deals” or offers page of the web application.
 * It follows the Page Object Model (POM) structure and encapsulates all web elements
 * and user interactions related to searching and retrieving product details from the offers section.
 */
public class OffersPage {

    // Shared WebDriver instance used to interact with elements on the offers page
    public WebDriver driver;

    /**
     * Constructor initializes the OffersPage with the WebDriver instance.
     * This ensures all element interactions occur within the same active browser session.
     *
     * @param driver WebDriver instance provided from the PageObjectManager
     */
    public OffersPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators for elements on the offers page
    private By search = By.xpath("//input[@type='search']");
    private By productName = By.cssSelector("tr td:nth-child(1)");

    /**
     * Searches for a specific product in the offers table using the search bar.
     * A short delay is included to allow the filtered search results to load.
     *
     * @param productNameSearching The product name or keyword to search for
     * @throws InterruptedException if the thread sleep is interrupted
     */
    public void searchItem(String productNameSearching) throws InterruptedException {
        System.out.println("searchItem : Method Executed");
        driver.findElement(search).sendKeys(productNameSearching);
        Thread.sleep(2000);
    }

    /**
     * Retrieves the name of the first product listed in the offers table.
     * Useful for verifying that the searched product appears correctly.
     *
     * @return String representing the product name from the offers page
     */
    public String getProductName() {
        System.out.println("getProductName : Method Executed");
        return driver.findElement(productName).getText();
    }
}
