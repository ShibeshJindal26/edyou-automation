package pageObject;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import helper.baseClass;

@Test
public class homePage extends baseClass {
	WebDriver driver;
	 public homePage(WebDriver driver) {
	        this.driver = driver;
	    }
	
	public void clickonMaximizer() {
		WebElement elm = driver.findElement(By.xpath(" //span[@id='maximizeAvatar']//*[name()='svg']"));
		explicitwait(elm, "visibilityof");
		clickonelement(elm);
		logger.info("click on maximizer");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void Minimizer_should_be_displayed() {
		WebElement elm = driver.findElement(By.xpath("//img[@id='cross1']"));
		explicitwait(elm, "visibilityof");
		Boolean bool = elm.isDisplayed();
		System.out.println(bool);
		assertEquals(true, bool);
	}

	public void Avatar_video_is_displayed() {
		WebElement elm = driver.findElement(By.xpath("//video[@id='smVideo']"));
		explicitwait(elm, "visibilityof");
		Boolean bool = elm.isDisplayed();
		System.out.println(bool);
		assertEquals(true, bool);

	}

	public void Click_on_minimizer() throws InterruptedException {
		WebElement elm = driver.findElement(By.xpath("//img[@id='cross1']"));
		explicitwait(elm, "visibilityof");
		clickonelement(elm);
		logger.info("click on minimizer");
		Thread.sleep(2000);

	}

	public void maximizer_should_be_displayed() {
		WebElement elm = driver.findElement(By.xpath(" //span[@id='maximizeAvatar']//*[name()='svg']"));
		explicitwait(elm, "visibilityof");
		Boolean bool = elm.isDisplayed();
		System.out.println(bool);
		assertEquals(true, bool);

	}

	public void Click_on_hide_hannah_button() throws InterruptedException {
		WebElement elm = driver.findElement(By.xpath("//img[@class='avatar_icon chat_icon']"));
		explicitwait(elm, "visibilityof");
		clickonelement(elm);
		Thread.sleep(2000);
	}

	public void Show_hannah_button_should_be_displayed() {
		WebElement elm = driver.findElement(By.xpath("//img[@class='avatar_icon imgSet chat_icon']"));
		explicitwait(elm, "visibilityof");
		Boolean bool = elm.isDisplayed();
		System.out.println(bool);
		assertEquals(true, bool);

	}

	public void Click_on_show_hannah_button() throws InterruptedException {
		WebElement elm = driver.findElement(By.xpath("//img[@class='avatar_icon imgSet chat_icon']"));
		explicitwait(elm, "visibilityof");
		clickonelement(elm);
		Thread.sleep(2000);
	}

	public void Hide_hannah_button_should_be_displayed() {
		WebElement elm = driver.findElement(By.xpath("//img[@class='avatar_icon chat_icon']"));
		explicitwait(elm, "visibilityof");
		Boolean bool = elm.isDisplayed();
		System.out.println(bool);
		assertEquals(true, bool);

	}

	public void Type_a_greeting_message() {
		WebElement elm = driver.findElement(By.xpath("//input[@id='textTourBox']"));
		explicitwait(elm, "visibilityof");
		elm.sendKeys("hey");

	}

	public void Click_on_send_button() throws InterruptedException {
		WebElement elm = driver.findElement(By.xpath("//img[@id='sendId1']"));
		explicitwait(elm, "visibilityof");
		clickonelement(elm);
		
		
		
	}
	
    public void Response_message_should_be_as_expected(){
    	WebElement elm = driver.findElement(By.xpath("//span[normalize-space()='Hi, hope you are doing well. How can I help?']"));
    	explicitwait(elm, "visibilityof");
    	String txt=elm.getText();
    	assertEquals(txt,"Hi, hope you are doing well. How can I help?");	

    }
    
    public void Type_a_question() {
    	WebElement elm = driver.findElement(By.xpath("//input[@id='textTourBox']"));
		explicitwait(elm, "visibilityof");
		elm.sendKeys("who are you");
   	 
    }
    
    public void Audio_waves_should_be_displayed() {
    	WebElement elm = driver.findElement(By.xpath("//div[@id='box3Main']//div[3]"));
		explicitwait(elm, "visibilityof");
		Boolean bool=elm.isDisplayed();
		assertEquals(true,bool);

    }
    
    public void Click_on_unmute_button() throws InterruptedException {
    	WebElement elm = driver.findElement(By.xpath("//img[@class='stopIcon mt-2']"));
		explicitwait(elm, "visibilityof");
		clickonelement(elm);
		Thread.sleep(2000);
    }
    public void Click_on_mic_button() throws InterruptedException {
    	WebElement elm = driver.findElement(By.xpath("//img[@id='voiceId']"));
		explicitwait(elm, "visibilityof");
		handleBrowserPopup("use-fake-ui-for-media-stream");
		clickonelement(elm);
		
		Thread.sleep(2000);
    }
    public void Mic_button_should_be_enable() {
    	WebElement elm = driver.findElement(By.xpath("//img[@src='../../assets/micNewOrange.png']"));
		explicitwait(elm, "visibilityof");
		Boolean bool=elm.isDisplayed();
		assertEquals(true, bool);
    }


}
