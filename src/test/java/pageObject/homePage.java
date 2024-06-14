package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import helper.baseClass;

public class homePage extends baseClass{
	
	public void clickonMaximizer() {
		WebElement elm = driver.findElement(By.xpath(" //span[@id='maximizeAvatar']//*[name()='svg']"));
		explicitwait(elm,"visibilityof");
		clickonelement(elm);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	

}
