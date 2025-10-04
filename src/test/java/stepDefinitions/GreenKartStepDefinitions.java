package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.Iterator;
import java.util.Set;

public class GreenKartStepDefinitions {

    public WebDriver driver;
    String actualProductNameHomePage;
    String actualProductNameOffersPage;

    @Given("user is on GreenKart landing page")
    public void user_is_on_green_kart_landing_page() {
        System.setProperty("webdriver.chrome,driver", "C:\\Repositories\\My_Upwork_Projects\\ChromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
    }

    @When("user searched for shortname {string} and extracted actual name of product")
    public void user_searched_for_shortname_and_extracted_actual_name_of_product(String shortName) throws InterruptedException {
        driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortName);
        Thread.sleep(2000);
        actualProductNameHomePage = driver.findElement(By.cssSelector("h4.product-name")).getText().split("-")[0].trim();
        System.out.println(actualProductNameHomePage+" is extracted from Home Page");
    }

    @Then("user searched for same shortname {string} in offers page and extracted actual name of product")
    public void user_searched_for_same_shortname_in_offers_page_to_check_if_product_exist(String shortName) throws InterruptedException {
        driver.findElement(By.linkText("Top Deals")).click();
        Set<String> s1 = driver.getWindowHandles();
        Iterator<String> i1 = s1.iterator();
        String parentWindow = i1.next();
        String childWindow = i1.next();

        driver.switchTo().window(childWindow);

        driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortName);
        Thread.sleep(2000);
        actualProductNameOffersPage = driver.findElement(By.cssSelector("tr td:nth-child(1)")).getText();
        System.out.println(actualProductNameOffersPage+" is extracted from Offers Page");
    }

    @Then("validate product name in offers page matches with landing page")
    public void validate_product_name_in_offers_page_matches_with_landing_page(){
        Assert.assertEquals(actualProductNameHomePage,actualProductNameOffersPage);
        System.out.println("Assertion Success : Both product names are equal");
    }


}
