package utils;

import org.openqa.selenium.WebDriver;
import java.util.Iterator;
import java.util.Set;

/**
 * The GenericUtils class contains reusable utility methods
 * that support common operations performed during test execution.
 * These methods are designed to simplify WebDriver interactions
 * that are used frequently across different test scenarios.
 */
public class GenericUtils {

    // Shared WebDriver instance used for performing browser operations
    public WebDriver driver;

    /**
     * Constructor assigns the active WebDriver instance to this utility class.
     * This ensures that all utility methods operate on the same browser session
     * as the test that invokes them.
     *
     * @param driver WebDriver instance shared from TestContextSetup
     */
    public GenericUtils(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Switches the WebDriver focus from the parent window to a newly opened child window.
     * This is useful in scenarios where a new browser tab or popup is triggered during a test.
     * The method assumes there are exactly two window handles at the time of switching.
     */
    public void switchWindowToChild() {
        // Retrieve all active window handles opened by the WebDriver session
        Set<String> windowHandles = driver.getWindowHandles();

        // Use an iterator to navigate between parent and child window identifiers
        Iterator<String> iterator = windowHandles.iterator();

        // Capture the parent and child window IDs
        String parentWindow = iterator.next();
        String childWindow = iterator.next();

        // Switch WebDriver focus to the child window
        driver.switchTo().window(childWindow);
    }
}
