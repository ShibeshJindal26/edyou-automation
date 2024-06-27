package pageObject;

import static org.testng.Assert.assertEquals;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.xml.sax.Locator;

import com.aventstack.extentreports.Status;

import helper.baseClass;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.ExtentReportUtility;

@Test
public class homePage extends baseClass {
	WebDriver driver;
	 public homePage(WebDriver driver) {
	        this.driver = driver;
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	    }
	
	 @Test
	public void clickonMaximizer() {
		 
        WebElement elm = driver.findElement(By.xpath("//span[@id='maximizeAvatar']"));
        explicitWait(elm, "visibilityof");
		clickElement(elm);
      
        ExtentReportUtility.test.get().log(Status.INFO, "Maximizer clicked and video displayed");

	        } 
		
	
	 @Test
	public void Minimizer_should_be_displayed() {
		WebElement elm = driver.findElement(By.xpath("//img[@id='cross1']"));
		explicitWait(elm, "visibilityof");
		Boolean bool = elm.isDisplayed();
		assertEquals(true, bool);
		 ExtentReportUtility.test.get().log(Status.INFO, "Maximizer is displayed");
	}

	 @Test
	public void Avatar_video_is_displayed() {
		WebElement elm = driver.findElement(By.xpath("//video[@id='smVideo']"));
		explicitWait(elm, "visibilityof");
		Boolean bool = elm.isDisplayed();
		System.out.println(bool);
		assertEquals(true, bool);

	}

	 @Test
	public void Click_on_minimizer() throws InterruptedException {
		WebElement elm = driver.findElement(By.xpath("//img[@id='cross1']"));
		explicitWait(elm, "visibilityof");
		clickElement(elm);
		logger.info("click on minimizer");
		Thread.sleep(2000);

	}
    
	 @Test
	public void maximizer_should_be_displayed() {
		WebElement elm = driver.findElement(By.xpath(" //span[@id='maximizeAvatar']//*[name()='svg']"));
		explicitWait(elm, "visibilityof");
		Boolean bool = elm.isDisplayed();
		System.out.println(bool);
		assertEquals(true, bool);

	}

	 @Test
	public void Click_on_hide_hannah_button() throws InterruptedException {
		WebElement elm = driver.findElement(By.xpath("//img[@class='avatar_icon chat_icon']"));
		explicitWait(elm, "visibilityof");
		clickElement(elm);
		Thread.sleep(2000);
	}
     
	 @Test
	public void Show_hannah_button_should_be_displayed() {
		WebElement elm = driver.findElement(By.xpath("//img[@class='avatar_icon imgSet chat_icon']"));
		explicitWait(elm, "visibilityof");
		Boolean bool = elm.isDisplayed();
		System.out.println(bool);
		assertEquals(true, bool);

	}

	 @Test
	public void Click_on_show_hannah_button() throws InterruptedException {
		WebElement elm = driver.findElement(By.xpath("//img[@class='avatar_icon imgSet chat_icon']"));
		explicitWait(elm, "visibilityof");
		clickElement(elm);
		Thread.sleep(2000);
	}

	 @Test
	public void Hide_hannah_button_should_be_displayed() {
		WebElement elm = driver.findElement(By.xpath("//img[@class='avatar_icon chat_icon']"));
		explicitWait(elm, "visibilityof");
		Boolean bool = elm.isDisplayed();
		System.out.println(bool);
		assertEquals(true, bool);

	}

	 @Test
	public void Type_a_greeting_message() {
		WebElement elm = driver.findElement(By.xpath("//input[@id='textTourBox']"));
		explicitWait(elm, "visibilityof");
		elm.sendKeys("hey");

	}

	 @Test
	public void Click_on_send_button() throws InterruptedException {
		WebElement elm = driver.findElement(By.xpath("//img[@id='sendId1']"));
		explicitWait(elm, "visibilityof");
		clickElement(elm);
		
		
		
	}
	
	 @Test
    public void Response_message_should_be_as_expected(){
    	WebElement elm = driver.findElement(By.xpath("//span[normalize-space()='Hi, hope you are doing well. How can I help?']"));
    	explicitWait(elm, "visibilityof");
    	String txt=elm.getText();
    	assertEquals(txt,"Hi, hope you are doing well. How can I help?");	

    }
    
	 @Test
    public void Type_a_question() {
    	WebElement elm = driver.findElement(By.xpath("//input[@id='textTourBox']"));
		explicitWait(elm, "visibilityof");
		elm.sendKeys("who are you");
   	 
    }
    
	 @Test
    public void Audio_waves_should_be_displayed() {
    	WebElement elm = driver.findElement(By.xpath("//div[@id='box3Main']//div[3]"));
		explicitWait(elm, "visibilityof");
		Boolean bool=elm.isDisplayed();
		assertEquals(true,bool);

    }
    
	 @Test
    public void Click_on_unmute_button() throws InterruptedException {
    	WebElement elm = driver.findElement(By.xpath("//img[@class='stopIcon mt-2']"));
		explicitWait(elm, "visibilityof");
		clickElement(elm);
		Thread.sleep(2000);
    }
	 
	 @Test
    public void Click_on_mic_button() throws InterruptedException {
    	WebElement elm = driver.findElement(By.xpath("//img[@id='voiceId']"));
		explicitWait(elm, "visibilityof");
		clickElement(elm);
		handleBrowserPopup("--use-fake-ui-for-media-stream");
		Thread.sleep(2000);
    }
	 
	 @Test
    public void Mic_button_should_be_enable() {
    	WebElement elm = driver.findElement(By.xpath("//img[@src='../../assets/micNewOrange.png']"));
		explicitWait(elm, "visibilityof");
		Boolean bool=elm.isDisplayed();
		assertEquals(true, bool);
    }
	 
	 @Test
    public void type_a_query_for_openai() {
    	WebElement elm = driver.findElement(By.xpath("//input[@id='textTourBox']"));
		explicitWait(elm, "visibilityof");
		elm.sendKeys("who is dhoni");
    }
	 
	 @Test
    public void Response_should_be_generate() {
    	WebElement elm = driver.findElement(By.xpath("//*[contains(text(),'Dhoni is a former Indian cricketer')]"));
    	explicitWait(elm, "visibilityof");
		Boolean bool=elm.isDisplayed();
		assertEquals(true,bool);

    	
    }
	 
	 @Test
  public void Hover_on_safety_dropdown() throws InterruptedException {
	WebElement elm = driver.findElement(By.linkText("Safety"));
	explicitWait(elm, "visibilityof");
	hoverOverElement(elm);
	Thread.sleep(2000);
	
	
    }

	 @Test
public void select_physical_safety() {
	WebElement elm =driver.findElement(By.linkText("Physical Safety"));
	clickElement(elm); 
}
	 @Test
public void physical_safety_page_should_be_open() {
    String url=driver.getCurrentUrl();
   Assert.assertEquals(url,"https://edyou.com/safety#physical-safety");
}
	 
	 public void click_on_investor_area() {
		 WebElement elm = driver.findElement(By.linkText("Investor Area"));
			explicitWait(elm, "visibilityof");
			clickElement(elm);
	    }
	 
	    public void fill_all_required_field() throws InterruptedException {
	    	WebElement firstName = driver.findElement(By.xpath("//input[@placeholder='First Name']"));
	    	 firstName.sendKeys("Shibesh");
	    	WebElement lastName = driver.findElement(By.xpath("//input[@placeholder='Last Name']"));
	    	lastName.sendKeys("Jindal");
	    	WebElement email = driver.findElement(By.xpath("//input[@placeholder='Email']"));
	    	email.sendKeys("shibesh.vdoit@gmail.com");
	    	WebElement phoneNumber = driver.findElement(By.xpath("//input[@placeholder='Phone']"));
	    	phoneNumber.sendKeys("237874874333");
	    	WebElement companyName = driver.findElement(By.xpath("//input[@placeholder='Company Name']"));
	    	companyName.sendKeys("VDOIT");
	    	WebElement Dsc = driver.findElement(By.xpath("//textarea[@placeholder='Tell us about yourself.']"));
	    	Dsc.sendKeys("I'm a QA Analyst");
	    	
	    	
	    }
	    
	    public void click_on_request_access_button() throws InterruptedException {
	    	WebElement elm = driver.findElement(By.xpath("//span[@class='signIn']"));
			explicitWait(elm, "visibilityof");
			clickElement(elm);
			logger.info("click on request access button");
	        Thread.sleep(2000);
	    }
	    
	    public void validate_success_message() {
	    	WebElement elm = driver.findElement(By.xpath("//span[@role='alert']"));
	    	Boolean bool=elm.isDisplayed();
	    	System.out.println(bool);
	    	Assert.assertEquals(true, bool);
	    }

}
