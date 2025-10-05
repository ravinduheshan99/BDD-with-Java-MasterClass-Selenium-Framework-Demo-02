package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utils.TestContextSetup;

import java.io.File;
import java.io.IOException;

/**
 * The Hooks class contains Cucumber hooks that execute before or after each scenario
 * or step. It manages setup and teardown processes, including closing the browser
 * after test execution and capturing screenshots when a step fails.
 */
public class Hooks {

    // Shared test context containing WebDriver, page objects, and utility classes
    TestContextSetup testContextSetup;

    /**
     * Constructor initializes Hooks with shared test context.
     *
     * @param testContextSetup shared context object for maintaining framework state
     */
    public Hooks(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
    }

    /**
     * Executes after each scenario.
     * Closes the WebDriver session to ensure a fresh browser state for the next scenario.
     *
     * @throws IOException if WebDriver fails to close
     */
    @After
    public void AfterScenario() throws IOException {
        System.out.println("AfterScenario : Method Executed");
        testContextSetup.testBase.WebDriverManager().quit();
    }

    /**
     * Executes after each step of a scenario.
     * If the step fails, captures a screenshot and attaches it to the Cucumber report.
     *
     * @param scenario current scenario context provided by Cucumber
     * @throws IOException if screenshot file creation or reading fails
     */
    @AfterStep
    public void AddScreenshot(Scenario scenario) throws IOException {
        WebDriver driver = testContextSetup.testBase.WebDriverManager();

        if (scenario.isFailed()) {
            // Capture screenshot as file
            File sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            // Convert screenshot file to byte array for attachment
            byte[] fileContent = FileUtils.readFileToByteArray(sourcePath);

            // Attach screenshot to scenario report in Cucumber
            scenario.attach(fileContent, "image/png", "Failure step screenshot");
        }
    }
}
