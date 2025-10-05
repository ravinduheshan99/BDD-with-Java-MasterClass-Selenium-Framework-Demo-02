package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

/**
 * TestBase class serves as the foundation for initializing and managing WebDriver instances.
 * It handles browser configuration, driver setup, and environment URL loading based on the
 * values defined in the 'global.properties' file or system properties passed through Maven.
 */
public class TestBase {

    // WebDriver instance used across the test framework
    public WebDriver driver;

    /**
     * Initializes and returns a configured WebDriver instance.
     * The method determines which browser to use based on either Maven runtime parameters
     * or the configuration defined in the 'global.properties' file.
     *
     * @return WebDriver instance (Chrome or Firefox based on configuration)
     * @throws IOException if there is an issue loading the properties file
     */
    public WebDriver WebDriverManager() throws IOException {

        // Load configuration settings from the 'global.properties' file
        FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\resources\\global.properties");
        Properties properties = new Properties();
        properties.load(fileInputStream);

        // Retrieve test environment URL and browser type from properties
        String url = properties.getProperty("QAUrl");
        String browser_properties = properties.getProperty("browser");

        // Allow overriding the browser type through Maven command line
        String browser_maven = System.getProperty("browser");

        // Determine the browser to execute tests on (Maven setting takes priority)
        String executingBrowser = browser_maven != null ? browser_maven : browser_properties;

        // Initialize WebDriver only if not already instantiated
        if (driver == null) {

            // Setup for Chrome browser
            // Setup for Firefox browser
            // Placeholder for Microsoft Edge browser setup (to be implemented later)
            if (executingBrowser.equalsIgnoreCase("chrome")) {
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\main\\resources\\ChromeDriver\\chromedriver.exe");
                driver = new ChromeDriver();
            }

            if (executingBrowser.equalsIgnoreCase("firefox")) {
                System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\src\\main\\resources\\GeckoDriver\\geckodriver.exe");
                driver = new FirefoxDriver();
            }

            if (executingBrowser.equalsIgnoreCase("edge")) {
                // Edge WebDriver setup code can be added here
            }

            // Apply implicit wait to handle dynamic web elements
            // Launch the specified application URL
            // Return the configured WebDriver instance
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            driver.get(url);
            return driver;
        }

        // Return existing WebDriver instance if already initialized
        return driver;
    }
}
