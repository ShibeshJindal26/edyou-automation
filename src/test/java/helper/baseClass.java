package helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
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

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class baseClass {

    public static WebDriver driver;
    private static WebDriverWait wait;
    private static Properties prop;
    public static Logger logger = LogManager.getLogger(baseClass.class);

    static {
        try {
            FileInputStream file = new FileInputStream("./src/test/java/resources/env.properties");
            prop = new Properties();
            prop.load(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Before
    public void setup() {
        if (driver == null) {
            logger.info("Setting up the driver and browser properties");

            String br = prop.getProperty("browser");
            if (br.equals("chrome")) {
                ChromeOptions option = new ChromeOptions();
                option.addArguments("--incognito");
                driver = new ChromeDriver(option);
            } else if (br.equals("firefox")) {
                FirefoxOptions option = new FirefoxOptions();
                option.addArguments("--incognito");
                driver = new FirefoxDriver(option);
                logger.info("Browser launched");
            } else if (br.equals("edge")) {
                EdgeOptions option = new EdgeOptions();
                option.addArguments("--incognito");
                driver = new EdgeDriver(option);
            }

            driver.get(prop.getProperty("url"));
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        }
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public String captureScreenshot(String tname) {
        if (driver == null) {
            logger.error("Driver is not initialized");
            return "Driver not initialized, screenshot not captured";
        }
        String timestamp = new SimpleDateFormat("yy.MM.dd.HH.mm.ss").format(new Date());
        TakesScreenshot takescreenshot = (TakesScreenshot) driver;
        File source = takescreenshot.getScreenshotAs(OutputType.FILE);
        String destination = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timestamp + ".png";
        try {
            FileUtils.copyFile(source, new File(destination));
        } catch (IOException e) {
            logger.error("Screenshot capture failed: " + e.getMessage());
        }
        System.out.println(destination);
        return destination;
    }

    public void explicitwait(WebElement elm, String type) {
        switch (type) {
            case "visibilityof":
                wait.until(ExpectedConditions.visibilityOf(elm));
                break;
            case "alertisPresent":
                wait.until(ExpectedConditions.alertIsPresent());
                break;
            case "invisibilityofelement":
                wait.until(ExpectedConditions.invisibilityOf(elm));
                break;
            case "visibilityoftext":
                wait.until(ExpectedConditions.textToBePresentInElement(elm, type));
                break;
        }
    }

    public void handleWindow(Set<String> set, String title) {
        List<String> list = new ArrayList<>(set);
        for (String window : list) {
            String actTitle = driver.switchTo().window(window).getTitle();
            if (actTitle.equals(title)) {
                driver.switchTo().window(window);
                break;
            }
        }
    }

    public void handleBrowserPopup(String msg) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments(msg);
    }

    public void windowalert(String type) {
        Alert a = driver.switchTo().alert();
        switch (type) {
            case "accept":
                a.accept();
                break;
            case "dismiss":
                a.dismiss();
                break;
        }
    }

    public void clickonelement(WebElement ele) {
        try {
            ele.click();
        } catch (Exception e) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", ele);
        }
    }

    public void validateText(WebElement ele, String expectedText) {
        String actualText = ele.getText();
        Assert.assertEquals(actualText, expectedText);
    }

    public void validateSizeOfList(List<WebElement> list, int size) {
        int sizeOflist = list.size();
        Assert.assertEquals(sizeOflist, size);
    }

    @After
    public void tearDown(Scenario s) {
        if (s.isFailed()) {
            captureScreenshot(s.getName());
        }
        driver.quit();
        driver = null; // Reset the driver to null after quitting
    }

    public void handleFrame(String type, String value) {
        switch (type) {
            case "name":
                driver.switchTo().frame(value);
                break;
            case "index":
                driver.switchTo().frame(Integer.parseInt(value));
                break;
        }
    }

    public void explicitwaitForlist(List<WebElement> list) {
        wait.until(ExpectedConditions.visibilityOfAllElements(list));
    }
    // Reusable methods for Actions class
    public void moveToElement(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    public void clickElement(WebElement element) {
        Actions actions = new Actions(driver);
        actions.click(element).perform();
    }

    public void doubleClickElement(WebElement element) {
        Actions actions = new Actions(driver);
        actions.doubleClick(element).perform();
    }

    public void rightClickElement(WebElement element) {
        Actions actions = new Actions(driver);
        actions.contextClick(element).perform();
    }

    public void dragAndDropElement(WebElement source, WebElement target) {
        Actions actions = new Actions(driver);
        actions.dragAndDrop(source, target).perform();
    }

    public void clickAndHoldElement(WebElement element) {
        Actions actions = new Actions(driver);
        actions.clickAndHold(element).perform();
    }

    public void releaseElement(WebElement element) {
        Actions actions = new Actions(driver);
        actions.release(element).perform();
    }
}
