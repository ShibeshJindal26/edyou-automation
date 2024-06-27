package helper;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Set;

public class baseClass {

    public static WebDriver driver;
    private static WebDriverWait wait;
    private static Properties prop;
    public static Logger logger = LogManager.getLogger(baseClass.class);
    protected static ExtentReports extent;
    public static ExtentTest test;

    static {
        try {
            FileInputStream file = new FileInputStream("./src/test/java/resources/env.properties");
            prop = new Properties();
            prop.load(file);
        } catch (IOException e) {
            logger.error("Failed to load environment properties file: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Before
    public void setup(Scenario scenario) throws IOException {
        extent = ExtentManager.getInstance();
        test = extent.createTest(scenario.getName());
        setupDriver();
        openUrl();
    }

    private void setupDriver() {
        logger.info("Setting up the driver and browser properties");

        String browser = prop.getProperty("browser");
        if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--incognito");
            driver = new ChromeDriver(options);
        } else if (browser.equalsIgnoreCase("firefox")) {
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--incognito");
            driver = new FirefoxDriver(options);
        } else if (browser.equalsIgnoreCase("edge")) {
            EdgeOptions options = new EdgeOptions();
            options.addArguments("--incognito");
            driver = new EdgeDriver(options);
        } else {
            logger.error("Unsupported browser: " + browser);
            throw new IllegalArgumentException("Unsupported browser: " + browser);
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private void openUrl() {
        String url = prop.getProperty("url");
        if (url != null && !url.isEmpty()) {
            driver.get(url);
        }
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public String captureScreenshot(String testName) {
        if (driver == null) {
            logger.error("Driver is not initialized");
            return "Driver not initialized, screenshot not captured";
        }

        String timestamp = new SimpleDateFormat("yy.MM.dd.HH.mm.ss").format(new Date());
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File source = screenshot.getScreenshotAs(OutputType.FILE);
        String destination = System.getProperty("user.dir") + "/screenshots/" + testName + "_" + timestamp + ".png";
        try {
            FileUtils.copyFile(source, new File(destination));
        } catch (IOException e) {
            logger.error("Failed to capture screenshot: " + e.getMessage());
        }
        logger.info("Screenshot captured: " + destination);
        return destination;
    }

    public void explicitWait(WebElement element, String type) {
        try {
            switch (type.toLowerCase()) {
                case "visibilityof":
                    wait.until(ExpectedConditions.visibilityOf(element));
                    break;
                case "elementtobeclickable":
                    wait.until(ExpectedConditions.elementToBeClickable(element));
                    break;
                case "presenceofelementlocated":
                    wait.until(ExpectedConditions.presenceOfElementLocated((By) element));
                    break;
                case "alertispresent":
                    wait.until(ExpectedConditions.alertIsPresent());
                    break;
                default:
                    logger.warn("Unsupported explicit wait type: " + type);
                    break;
            }
        } catch (Exception e) {
            logger.error("Explicit wait failed: " + e.getMessage());
        }
    }

    public void switchToWindow(String title) {
        Set<String> windowHandles = driver.getWindowHandles();
        for (String windowHandle : windowHandles) {
            driver.switchTo().window(windowHandle);
            if (driver.getTitle().equals(title)) {
                break;
            }
        }
    }

    public void handleBrowserPopup(String message) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments(message);
        driver = new ChromeDriver(options);
    }

    public void handleAlert(String action) {
        Alert alert = driver.switchTo().alert();
        switch (action.toLowerCase()) {
            case "accept":
                alert.accept();
                break;
            case "dismiss":
                alert.dismiss();
                break;
            default:
                logger.warn("Unsupported alert action: " + action);
                break;
        }
    }

    public void clickElement(WebElement element) {
        try {
            element.click();
        } catch (StaleElementReferenceException e) {
            logger.warn("Stale element reference exception: " + e.getMessage());
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", element);
        } catch (NoSuchElementException e) {
            logger.error("Element not found: " + e.getMessage());
        } catch (Exception e) {
            logger.error("Click operation failed: " + e.getMessage());
        }
    }

    public void validateText(WebElement element, String expectedText) {
        String actualText = element.getText().trim();
        Assert.assertEquals(actualText, expectedText);
    }

    public void validateListSize(List<WebElement> elements, int expectedSize) {
        int actualSize = elements.size();
        Assert.assertEquals(actualSize, expectedSize);
    }

    @After
    public void tearDown(Scenario s) {
        try {
            if (s.isFailed()) {
                TakesScreenshot ts = (TakesScreenshot) driver;
                File src = ts.getScreenshotAs(OutputType.FILE);
                File target = new File(System.getProperty("user.dir") + "/Screenshots/" + s.getName() + ".png");
                FileUtils.copyFile(src, target);
                test.log(Status.FAIL, "Scenario failed: " + s.getName());
                test.addScreenCaptureFromPath(target.getPath());
            } else {
                test.log(Status.PASS, "Scenario passed: " + s.getName());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (driver != null) {
                driver.quit();
            }
            extent.flush();
        }
    }

    // Additional reusable methods for Actions class can be added here

    // Example: Method to perform mouse hover
    public void hoverOverElement(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }
}