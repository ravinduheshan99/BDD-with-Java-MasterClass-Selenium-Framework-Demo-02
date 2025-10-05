package cucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

/**
 * TestNGTestRunner is the entry point for executing Cucumber tests with TestNG.
 * It uses the AbstractTestNGCucumberTests class to integrate Cucumber with TestNG.
 * This runner is configured to execute scenarios tagged with @PlaceOrderTest or @SearchTest
 * and generate detailed reports in HTML, JSON, and Extent formats.
 */
@CucumberOptions(features = "src/test/java/features", // Path to feature files
        glue = "stepDefinitions",             // Package containing step definition classes
        monochrome = true,                    // Makes console output more readable
        tags = "@PlaceOrderTest or @SearchTest", // Tags to filter which scenarios to run
        plugin = {"html:target/cucumber.html", // Generate HTML report
                "json:target/cucumber.json", // Generate JSON report
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", // Extent report adapter
                "rerun:target/failed_scenarios.txt" // Store failed scenarios for rerun
        })
public class TestNGTestRunner extends AbstractTestNGCucumberTests {

    /**
     * Overrides the default scenarios() method to enable parallel execution of scenarios.
     * This improves test execution speed for larger test suites.
     *
     * @return two-dimensional array of scenarios for parallel execution
     */
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
