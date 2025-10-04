package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {

    public WebDriver driver;

    public LandingPage(WebDriver driver){
        this.driver=driver;
    }

    private By search = By.xpath("//input[@type='search']");
    private By productName = By.cssSelector("h4.product-name");
    private By topDeals = By.linkText("Top Deals");

    public void searchItem(String productNameSearching) throws InterruptedException {
        driver.findElement(search).sendKeys(productNameSearching);
        Thread.sleep(2000);
    }

    public String getProductName(){
        return driver.findElement(productName).getText().split("-")[0].trim();
    }

    public void selectTopDeals(){
        driver.findElement(topDeals).click();
    }

}
