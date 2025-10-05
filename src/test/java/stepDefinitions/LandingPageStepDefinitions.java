package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageObjects.LandingPage;
import utils.TestContextSetup;

/**
 * The LandingPageStepDefinitions class contains Cucumber step definitions
 * related to user interactions and validations performed on the GreenKart landing page.
 * Each method corresponds to a step in the feature file and delegates actions
 * to the LandingPage object methods to maintain clean separation between
 * step logic and UI interactions.
 */
public class LandingPageStepDefinitions {

    // Reference to the LandingPage object for interacting with UI elements
    public LandingPage landingPage;

    // Shared context setup that manages WebDriver, page objects, and common data
    TestContextSetup testContextSetup;

    /**
     * Constructor initializes the step definition class with the shared test context.
     * It retrieves the LandingPage instance through the PageObjectManager
     * to ensure consistent WebDriver usage across test steps.
     *
     * @param testContextSetup shared context object containing framework dependencies
     */
    public LandingPageStepDefinitions(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
        landingPage = testContextSetup.pageObjectManager.getLandingPage();
    }

    /**
     * Step Definition: Verifies that the user is on the GreenKart landing page.
     * This check is done by comparing the actual page title with the expected title.
     */
    @Given("user is on GreenKart landing page")
    public void user_is_on_green_kart_landing_page() {
        Assert.assertEquals(landingPage.getTitleLandingPage(), "GreenKart - veg and fruits kart");
    }

    /**
     * Step Definition: Searches for a product using a short name,
     * waits for results to appear, and extracts the actual full product name
     * displayed on the landing page for further verification in the test flow.
     *
     * @param shortName the short or partial name of the product entered in the search field
     * @throws InterruptedException if the thread sleep during search execution is interrupted
     */
    @When("^user searched for shortname (.+) and extracted actual name of product$")
    public void user_searched_for_shortname_and_extracted_actual_name_of_product(String shortName) throws InterruptedException {
        landingPage.searchItem(shortName);
        testContextSetup.actualProductNameLandingPage = landingPage.getProductName();
        System.out.println(testContextSetup.actualProductNameLandingPage + " is extracted from Landing Page");
    }

    /**
     * Step Definition: Adds the specified quantity of the selected product to the shopping cart.
     * The method converts the quantity from String to integer and interacts with the
     * increment and add-to-cart elements on the landing page.
     *
     * @param quantity number of items to be added to the cart
     */
    @When("added {string} items of the selected product to cart")
    public void added_items_of_the_selected_product_to_cart(String quantity) {
        testContextSetup.actualProductNameLandingPage = landingPage.getProductName();
        landingPage.incrementQuantity(Integer.parseInt(quantity));
        landingPage.addToCart();
    }

    /**
     * Step Definition: Proceeds from the landing page to the checkout page.
     * This completes the product selection process and moves the test flow
     * into the checkout verification phase.
     */
    @Then("user proceeds to checkout")
    public void user_proceeds_to_checkout_and_validate_the_product_items_in_checkout_page() {
        landingPage.checkoutItems();
    }
}
