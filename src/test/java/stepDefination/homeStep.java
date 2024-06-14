package stepDefination;

import io.cucumber.java.en.When;
import pageObject.*;
public class homeStep {
	homePage hm=new homePage();
	
	@When("Click on maximizer")
	public void click_on_maximizer() {
	    hm.clickonMaximizer();
	}

}
