package stepDefination;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import helper.baseClass;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.*;
import utilities.Log;

@Test
public class homeStep {
    public static Logger logger = LogManager.getLogger(baseClass.class);
    homePage hm = new homePage(baseClass.driver);
      
    @Test
    @When("Click on maximizer")
    public void click_on_maximizer() {
        System.out.println(new Throwable().getStackTrace()[0].getMethodName());
        hm.clickonMaximizer();
        logger.debug("Click on maximizer");
    }

    @Then("Minimizer should be displayed")
    public void Minimizer_should_be_displayed() {
        hm.Minimizer_should_be_displayed();
        logger.debug("Minimizer should be displayed");
    }

    @Then("Avatar video is displayed")
    public void Avatar_video_is_displayed() {
        hm.Avatar_video_is_displayed();
        logger.debug("Avatar video is displayed");
    }

    @And("Click on minimizer")
    public void Click_on_minimizer() throws InterruptedException {
        hm.Click_on_minimizer();
        logger.debug("Click on minimizer");
    }

    @Then("Maximizer should be displayed")
    public void maximizer_should_be_displayed() {
        hm.maximizer_should_be_displayed();
        logger.debug("Maximizer should be displayed");
    }

    @When("Click on hide hannah button")
    public void Click_on_hide_hannah_button() throws InterruptedException {
        hm.Click_on_hide_hannah_button();
        logger.debug("Click on hide hannah button");
    }

    @Then("Show hannah button should be displayed")
    public void Show_hannah_button_should_be_displayed() {
        hm.Show_hannah_button_should_be_displayed();
        logger.debug("Show hannah button should be displayed");
    }

    @And("Click on show hannah button")
    public void Click_on_show_hannah_button() throws InterruptedException {
        hm.Click_on_show_hannah_button();
        logger.debug("Click on show hannah button");
    }

    @Then("Hide hannah button should be displayed")
    public void Hide_hannah_button_should_be_displayed() {
        hm.Hide_hannah_button_should_be_displayed();
        logger.debug("Hide hannah button should be displayed");
    }

    @And("Type a greeting message")
    public void Type_a_greeting_message() {
        hm.Type_a_greeting_message();
        logger.debug("Type a greeting message");
    }

    @And("Click on send button")
    public void Click_on_send_button() throws InterruptedException {
        hm.Click_on_send_button();
        logger.debug("Click on send button");
    }

    @Then("Response message should be as expected")
    public void Response_message_should_be_as_expected() {
        hm.Response_message_should_be_as_expected();
        logger.debug("Response message should be as expected");
    }

    @And("Type a question")
    public void Type_a_question() {
        hm.Type_a_question();
        logger.debug("Type a question");
    }

    @Then("Audio waves should be displayed")
    public void Audio_waves_should_be_displayed() {
        hm.Audio_waves_should_be_displayed();
        logger.debug("Audio waves should be displayed");
    }

    @And("Click on unmute button")
    public void Click_on_unmute_button() throws InterruptedException {
        hm.Click_on_unmute_button();
        logger.debug("Click on unmute button");
    }

    @When("Click on mic button")
    public void Click_on_mic_button() throws InterruptedException {
        hm.Click_on_mic_button();
        logger.debug("Click on mic button");
    }

    @Then("Mic button should be enable")
    public void Mic_button_should_be_enable() {
        hm.Mic_button_should_be_enable();
        logger.debug("Mic button should be enable");
    }

    @And("type a query for openai")
    public void type_a_query_for_openai() {
        hm.type_a_query_for_openai();
        logger.debug("type a query for openai");
    }

    @Then("Response should be generate")
    public void Response_should_be_generate() {
        hm.Response_should_be_generate();
        logger.debug("Response should be generate");
    }
    
    @Test
    @When("Hover on safety dropdown")
    public void Hover_on_safety_dropdown() throws InterruptedException {
    	hm.Hover_on_safety_dropdown();
    }
    
    @Test
    @And("Select physical safety")
    public void select_physical_safety() {
      hm.select_physical_safety();
    }
    @Test
    @Then("Physical safety page should be open")
    public void physical_safety_page_should_be_open() {
       hm.physical_safety_page_should_be_open();
    }
    @When("Click on investor area")
    public void click_on_investor_area() {
       hm.click_on_investor_area();
    }
    @When("Fill all required field")
    public void fill_all_required_field() throws InterruptedException {
        hm.fill_all_required_field();
    }
    @When("Click on request access button")
    public void click_on_request_access_button() throws InterruptedException {
      hm.click_on_request_access_button();
    }
    @Then("Validate success message")
    public void validate_success_message() {
     hm.validate_success_message();
    }
}
