package helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class baseClass {

	public static WebDriver driver;
	public static WebDriverWait wait;
	public static Properties prop;
	public Logger log;

	static {
		try {
			FileInputStream file = new FileInputStream("./src/test/java/resources/env.properties");
			prop = new Properties();
			prop.load(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Before
	public void setup() {
		log=LogManager.getLogger(this.getClass());

		String br = prop.getProperty("browser");
		if (br.equals("chrome")) {
			ChromeOptions option = new ChromeOptions();
			option.addArguments("--incognito");
			driver = new ChromeDriver(option);
		} else if (br.equals("firefox")) {
			FirefoxOptions option = new FirefoxOptions();
			option.addArguments("--incognito");
			driver = new FirefoxDriver(option);
		} else if (br.equals("edge")) {
			EdgeOptions option = new EdgeOptions();
			option.addArguments("--incognito");
			driver = new EdgeDriver(option);
		}

		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	public void explicitwait(WebElement elm, String type) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));

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
		}
	}

	public void handleWindow(Set<String> set, String title) {
		List<String> list = new ArrayList<>(set);
		for (int i = 0; i < list.size(); i++) {
			String actTitle = driver.switchTo().window(list.get(i)).getTitle();
			if (actTitle.equals(title)) {
				driver.switchTo().window(list.get(i));
			}
		}
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
		try {
			if (s.isFailed()) {
				TakesScreenshot ts = (TakesScreenshot) driver;
				File src = ts.getScreenshotAs(OutputType.FILE);
				File target = new File(System.getProperty("user.dir") + "/Screenshots/" + s.getName() + ".png");
				FileUtils.copyFile(src, target);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			driver.quit();
		}
	}

	public void handleFrame(String type, String value) {
		switch (type) {
		case "name":
			driver.switchTo().frame(value);
			break;
		case "index":
			driver.switchTo().frame(Integer.parseInt(value));
		}
	}

	public void explicitwaitForlist(List<WebElement> list) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfAllElements(list));
	}
}
