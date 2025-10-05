package stepDefinitions;

import io.cucumber.java.en.Then;
import org.testng.Assert;
import pageObjects.CheckoutPage;
import utils.TestContextSetup;

/**
 * The CheckoutPageStepDefinitions class contains Cucumber step definitions
 * related to actions and validations performed on the checkout page.
 * It validates product details in the checkout process and verifies
 * the availability of key actions such as applying promo codes and placing orders.
 */
public class CheckoutPageStepDefinitions {

    // Reference to the CheckoutPage object for interacting with checkout UI elements
    public CheckoutPage checkoutPage;

    // Shared test context containing WebDriver, page objects, and utility classes
    TestContextSetup testContextSetup;

    /**
     * Constructor initializes the CheckoutPageStepDefinitions class with shared test context.
     * This ensures consistent use of WebDriver and page object instances across steps.
     *
     * @param testContextSetup shared test context for maintaining framework state
     */
    public CheckoutPageStepDefinitions(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
        checkoutPage = testContextSetup.pageObjectManager.getCheckoutPage();
    }

    /**
     * Step Definition: Validates whether the product name displayed in the checkout page
     * matches the product name extracted from the landing page.
     * This ensures the correct item has been added to the cart before checkout.
     *
     * @param productName expected product name from the feature file step
     */
    @Then("^validate the (.+) items in checkout page$")
    public void validate_the_product_item_name_in_checkout_page(String productName) {
        Assert.assertEquals(checkoutPage.checkoutPageProductItemName(), testContextSetup.actualProductNameLandingPage);
    }

    /**
     * Step Definition: Verifies whether the promo code entry button and the
     * “Place Order” button are available on the checkout page.
     * This ensures the checkout page UI is ready for completing the purchase process.
     */
    @Then("verify user has ability to enter promo code and place the order")
    public void verify_user_has_ability_to_enter_promo_code_and_place_the_order() {
        Assert.assertTrue(checkoutPage.verifyPromoButton());
        Assert.assertTrue(checkoutPage.verifyPlaceOrderButton());
    }
}
