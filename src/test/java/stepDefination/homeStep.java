package stepDefination;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import helper.baseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.*;
import utilities.Log;

@Test
public class homeStep{
	public static Logger logger = LogManager.getLogger(baseClass.class);
	homePage hm=new homePage(baseClass.driver);
	
	@When("Click on maximizer")
	public void click_on_maximizer() {
	    hm.clickonMaximizer();
	    logger.debug("Click on maximizer");
	    
	}

	@Then("Minimizer should be displayed")
	public void Minimizer_should_be_displayed() {
		hm.Minimizer_should_be_displayed();
	}
	
	@Then("Avatar video is displayed")
	public void Avatar_video_is_displayed() {
		hm.Avatar_video_is_displayed();
	}
	
	@And("Click on minimizer")
	public void Click_on_minimizer() throws InterruptedException {
		hm.Click_on_minimizer();
		
	}
	
	@Then("Maximizer should be displayed")
	public void maximizer_should_be_displayed() {
		hm.maximizer_should_be_displayed();
		
	}
	
	@When("Click on hide hannah button")
	public void Click_on_hide_hannah_button() throws InterruptedException {
		hm.Click_on_hide_hannah_button();
		
	}
	
	@Then("Show hannah button should be displayed")
	public void Show_hannah_button_should_be_displayed() {
		hm.Show_hannah_button_should_be_displayed();
	}
	
	@And ("Click on show hannah button")
	public void Click_on_show_hannah_button() throws InterruptedException {
		hm.Click_on_show_hannah_button();
	}
	
	 @Then ("Hide hannah button should be displayed")
	 public void Hide_hannah_button_should_be_displayed() {
		 hm.Hide_hannah_button_should_be_displayed();
	 }
	 
     @And("Type a greeting message")
     public void Type_a_greeting_message() {
    	 hm.Type_a_greeting_message();
    	 
     }
     @And("Click on send button")
     public void Click_on_send_button() throws InterruptedException {
    	hm.Click_on_send_button();
     }
     
     @Then("Response message should be as expected")
     public void Response_message_should_be_as_expected(){
    	 hm.Response_message_should_be_as_expected();
     }
     
     @And("Type a question")
     public void Type_a_question() {
    	 hm.Type_a_question();
     }
     
     @Then("Audio waves shoudl be displayed")
     public void Audio_waves_should_be_displayed() {
    	 hm.Audio_waves_should_be_displayed();
     }
     @And("Click on unmute button")
     public void Click_on_unmute_button() throws InterruptedException {
    	 hm.Click_on_unmute_button();
     }
     
     @When("Click on mic button")
     public void Click_on_mic_button() throws InterruptedException {
    	 hm.Click_on_mic_button();
    	 Log.info("started");
    	 logger.debug("Click on mic button");
    	 
     }
     
     @Then("Mic button should be enable")
     public void Mic_button_should_be_enable() {
    	 Log.info("started");
    	 hm.Mic_button_should_be_enable();
    	 
    	 
     }

}
