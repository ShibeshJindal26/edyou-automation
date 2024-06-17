package pageObject;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import helper.baseClass;

public class homePage extends baseClass {

	public void clickonMaximizer() {
		WebElement elm = driver.findElement(By.xpath(" //span[@id='maximizeAvatar']//*[name()='svg']"));
		explicitwait(elm, "visibilityof");
		clickonelement(elm);
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
}
