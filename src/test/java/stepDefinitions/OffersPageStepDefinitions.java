package stepDefinitions;

import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.testng.Assert;
import utils.TestContextSetup;

import java.util.Iterator;
import java.util.Set;

public class OffersPageStepDefinitions {

    public String actualProductNameOffersPage;
    TestContextSetup testContextSetup;

    public OffersPageStepDefinitions(TestContextSetup testContextSetup){
        this.testContextSetup=testContextSetup;
    }

    @Then("user searched for same shortname {string} in offers page and extracted actual name of product")
    public void user_searched_for_same_shortname_in_offers_page_to_check_if_product_exist(String shortName) throws InterruptedException {
        testContextSetup.driver.findElement(By.linkText("Top Deals")).click();
        Set<String> s1 = testContextSetup.driver.getWindowHandles();
        Iterator<String> i1 = s1.iterator();
        String parentWindow = i1.next();
        String childWindow = i1.next();

        testContextSetup.driver.switchTo().window(childWindow);

        testContextSetup.driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortName);
        Thread.sleep(2000);
        actualProductNameOffersPage = testContextSetup.driver.findElement(By.cssSelector("tr td:nth-child(1)")).getText();
        System.out.println(actualProductNameOffersPage+" is extracted from Offers Page");
    }

    @Then("validate product name in offers page matches with landing page")
    public void validate_product_name_in_offers_page_matches_with_landing_page(){
        Assert.assertEquals(testContextSetup.actualProductNameLandingPage,actualProductNameOffersPage);
        System.out.println("Assertion Success : Both product names are equal");
    }


}
