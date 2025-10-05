package stepDefinitions;

import io.cucumber.java.en.Then;
import org.testng.Assert;
import pageObjects.LandingPage;
import pageObjects.OffersPage;
import utils.TestContextSetup;

/**
 * The OffersPageStepDefinitions class contains Cucumber step definitions
 * related to actions and validations performed on the Offers (Top Deals) page.
 * It verifies whether a product found on the landing page is also available in the offers section.
 */
public class OffersPageStepDefinitions {

    // Stores product name extracted from the offers page for validation
    public String actualProductNameOffersPage;

    // Shared test context containing WebDriver, page objects, and utility classes
    TestContextSetup testContextSetup;

    /**
     * Constructor initializes the OffersPageStepDefinitions class with shared context.
     * This enables the reuse of WebDriver, page objects, and other utilities across steps.
     *
     * @param testContextSetup shared context for maintaining framework state
     */
    public OffersPageStepDefinitions(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
    }

    /**
     * Switches the WebDriver focus to the Offers (Top Deals) page.
     * This involves clicking the "Top Deals" link from the landing page
     * and switching the driver context if a new window or tab opens.
     */
    public void switchToOffersPage() {
        LandingPage landingPage = testContextSetup.pageObjectManager.getLandingPage();
        landingPage.selectTopDealsPage();

        // If not already on the offers page URL, switch to the new window
        if (!(landingPage.driver.getCurrentUrl().equals("https://rahulshettyacademy.com/seleniumPractise/#/offers"))) {
            testContextSetup.genericUtils.switchWindowToChild();
        }
    }

    /**
     * Step Definition: Searches for the same product short name in the offers page
     * and extracts its actual full name for comparison with the landing page result.
     *
     * @param shortName the product short name to be searched
     * @throws InterruptedException if the thread sleep during search execution is interrupted
     */
    @Then("^user searched for same shortname (.+) in offers page and extracted actual name of product$")
    public void user_searched_for_same_shortname_in_offers_page_to_check_if_product_exist(String shortName) throws InterruptedException {
        switchToOffersPage();
        OffersPage offersPage = testContextSetup.pageObjectManager.getOffersPage();
        offersPage.searchItem(shortName);
        actualProductNameOffersPage = offersPage.getProductName();
        System.out.println(actualProductNameOffersPage + " is extracted from Offers Page");
    }

    /**
     * Step Definition: Validates whether the product name extracted from the offers page
     * matches the product name extracted from the landing page.
     * This ensures consistency across different sections of the application.
     */
    @Then("validate product name in offers page matches with landing page")
    public void validate_product_name_in_offers_page_matches_with_landing_page() {
        Assert.assertEquals(testContextSetup.actualProductNameLandingPage, actualProductNameOffersPage);
        System.out.println("Assertion Success: Both product names are equal");
    }
}
