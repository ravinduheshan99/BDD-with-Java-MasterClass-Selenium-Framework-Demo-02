package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pageObjects.LandingPage;
import utils.TestContextSetup;

public class LandingPageStepDefinitions {

    TestContextSetup testContextSetup;

    public LandingPageStepDefinitions(TestContextSetup testContextSetup){
        this.testContextSetup=testContextSetup;
    }

    @Given("user is on GreenKart landing page")
    public void user_is_on_green_kart_landing_page() {

    }

    @When("^user searched for shortname (.+) and extracted actual name of product$")
    public void user_searched_for_shortname_and_extracted_actual_name_of_product(String shortName) throws InterruptedException {
        LandingPage landingPage = testContextSetup.pageObjectManager.getLandingPage();
        landingPage.searchItem(shortName);
        testContextSetup.actualProductNameLandingPage = landingPage.getProductName();
        System.out.println(testContextSetup.actualProductNameLandingPage+" is extracted from Landing Page");
    }

}
