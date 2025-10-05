package utils;

import pageObjects.PageObjectManager;
import java.io.IOException;

/**
 * The TestContextSetup class acts as a centralized context container
 * for sharing common test objects and utilities across different step definition files.
 * It ensures that all components within a test scenario use the same WebDriver instance,
 * page objects, and utility classes for consistent test execution.
 */
public class TestContextSetup {

    // Stores product name captured from the landing page (used for validation in test scenarios)
    public String actualProductNameLandingPage;

    // Manages and provides instances of all page object classes
    public PageObjectManager pageObjectManager;

    // Provides access to the WebDriver setup and browser configuration
    public TestBase testBase;

    // Provides commonly used reusable methods and helper functions
    public GenericUtils genericUtils;

    /**
     * Constructor initializes the shared test context.
     * It creates a single WebDriver instance using TestBase,
     * then passes that same driver to PageObjectManager and GenericUtils
     * to maintain consistency throughout the test execution.
     *
     * @throws IOException if an issue occurs while reading configuration files
     */
    public TestContextSetup() throws IOException {
        testBase = new TestBase();
        pageObjectManager = new PageObjectManager(testBase.WebDriverManager());
        genericUtils = new GenericUtils(testBase.WebDriverManager());
    }
}
