package stepDefination;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.*;
public class homeStep {
	homePage hm=new homePage();
	
	@When("Click on maximizer")
	public void click_on_maximizer() {
	    hm.clickonMaximizer();
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
}
