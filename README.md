# 🧩 Selenium Java BDD Framework with TestNG & Cucumber  
**End-to-End Automation Framework | Developed as part of the "Learn Cucumber BDD with Java - MasterClass Selenium Framework" course by Rahul Shetty**

---

## 📘 Overview  

This repository contains a **Behavior-Driven Development (BDD)** automation framework built using **Selenium WebDriver, Java, Cucumber, and TestNG**. It demonstrates how to design, implement, and execute a scalable, modular, and data-driven automation framework from scratch - following real-world QA automation standards and best practices.

The framework supports:
- Cross-browser test execution  
- Parallel scenario runs  
- Extent Spark & Cucumber HTML/JSON reporting  
- Hooks for failure screenshots  
- Reusable page components with **Page Object Model (POM)**  
- Centralized configuration management  
- CI/CD integration via Jenkins  

---

## 🏗️ High-Level Architecture  

Below is a visual representation of the overall architecture and flow:  

![Framework Architecture](https://github.com/ravinduheshan99/BDD-with-Java-MasterClass-Selenium-Framework-TestNG/blob/main/Selenium%20Java%20BDD%20Automation%20Framework%20Architecture%20Diagram/Selenium%20Java%20BDD%20Automation%20Framework%20Architecture.gif)

### **End-to-End Flow**

1. **Test Execution** starts via **TestNGTestRunner** or **FailedTestRunner**.  
2. **Cucumber** scans feature files tagged with `@PlaceOrderTest` or `@SearchTest`.  
3. For each scenario, Cucumber injects a fresh **TestContextSetup** instance.  
4. `TestContextSetup`:
   - Initializes `TestBase`, creating a single WebDriver instance.
   - Loads configuration from `global.properties` (browser, URL).
   - Shares driver and data across Page Objects through `PageObjectManager`.
5. **Steps execute**:
   - `LandingPage`: Searches products, adds to cart, validates title.  
   - `OffersPage`: Verifies product consistency across pages.  
   - `CheckoutPage`: Confirms item details and validates checkout UI elements.
6. **Hooks**:
   - `@AfterStep`: Captures screenshots on failure.  
   - `@After`: Closes driver instance post-scenario.  
7. **Reports** generated under:
   - `target/` → Cucumber HTML, JSON  
   - `test-output/SparkReport/` → Extent Spark HTML Report  
8. **Rerun file** `target/failed_scenarios.txt` logs failed scenarios for quick reruns.

---

## ⚙️ Framework Components  

| Component | Description |
|------------|-------------|
| **Test Runner** | `TestNGTestRunner.java` and `FailedTestRunner.java` control execution flow, parallelization, and reruns. |
| **Configuration** | `global.properties` defines browser and environment URLs. `pom.xml` manages all dependencies. |
| **TestBase** | Sets up and manages WebDriver instances per scenario lifecycle. |
| **PageObjectManager** | Factory class that provides driver-bound instances of all page objects. |
| **Page Objects** | Encapsulated UI interactions for Landing, Offers, and Checkout pages. |
| **Step Definitions** | Glue code bridging Gherkin feature steps and automation logic. |
| **Hooks** | Handles teardown and screenshot capture for failed scenarios. |
| **Reports** | Extent Spark Reports, Cucumber HTML, and JSON reports generated automatically. |

---

## 🧰 Tools & Technologies  

| Category | Tools / Frameworks |
|-----------|--------------------|
| Language | Java 21 |
| Automation | Selenium 4, Cucumber 7, TestNG |
| Build Tool | Maven |
| Reporting | ExtentReports, ExtentCucumberAdapter |
| Dependency Management | PicoContainer |
| CI/CD | Jenkins Integration |
| Version Control | Git & GitHub |
| Browser Drivers | ChromeDriver, GeckoDriver |

---

## 🚀 Key Features  

- **BDD with Cucumber** - Natural language test specification using Gherkin syntax  
- **Parallel Execution** - TestNG DataProvider integration for concurrent runs  
- **Data-Driven Testing** - Parameterized feature steps and datatables  
- **Dependency Injection** - Shared driver and context across steps via PicoContainer  
- **Page Object Model** - Maintainable UI abstraction layer  
- **Screenshot Capture** - On-failure snapshots embedded in reports  
- **Reports** - Cucumber HTML/JSON + Extent Spark Reports with screenshots  
- **CI/CD Ready** - Seamless Jenkins pipeline integration with runtime property overrides  
