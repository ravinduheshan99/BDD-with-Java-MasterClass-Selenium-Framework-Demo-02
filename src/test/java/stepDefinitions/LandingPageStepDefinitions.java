package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.LandingPage;
import utils.TestContextSetup;

public class LandingPageStepDefinitions {

    TestContextSetup testContextSetup;

    public LandingPageStepDefinitions(TestContextSetup testContextSetup){
        this.testContextSetup=testContextSetup;
    }

    @Given("user is on GreenKart landing page")
    public void user_is_on_green_kart_landing_page() {
        System.setProperty("webdriver.chrome,driver", "C:\\Repositories\\My_Upwork_Projects\\ChromeDriver\\chromedriver.exe");
        testContextSetup.driver = new ChromeDriver();
        testContextSetup.driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
    }

    @When("user searched for shortname {string} and extracted actual name of product")
    public void user_searched_for_shortname_and_extracted_actual_name_of_product(String shortName) throws InterruptedException {
        LandingPage landingPage = testContextSetup.pageObjectManager.getLandingPage();
        landingPage.searchItem(shortName);
        testContextSetup.actualProductNameLandingPage = landingPage.getProductName();
        System.out.println(testContextSetup.actualProductNameLandingPage+" is extracted from Landing Page");
    }

}
