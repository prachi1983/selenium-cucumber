package com.cucumber.test;

import org.junit.Assert;

import com.selenium.keyword.SaucePageObject;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SauceTest {
	
	SaucePageObject sp=new SaucePageObject();
	
	@Given("Open chrome and navigate to Login page")
	public void open_chrome_and_navigate_to_login_page() throws Exception {
		
		sp.openBrowser(sp.readPropertiesFileValue("browser"));
	    sp.openApplication(sp.readPropertiesFileValue("url"));
	
		sp.exportPageObject();
	}

	@When("Valid username and passed is entered")
	public void valid_username_and_passed_is_entered() throws Exception {
		
		sp.handleTextBox(sp.username, sp.readPropertiesFileValue("username"));
		sp.handleTextBox(sp.password, sp.readPropertiesFileValue("password"));
		sp.handleClickEvent(sp.loginButton);
		
		sp.waitSec(3);

		
	}

	@Then("User should be logged in successfully and verify url contains {string}")
	public void user_should_be_logged_in_successfully_and_verify_url_contains(String string) {
		
		String currentURL=sp.verifyPageURL();		
		Assert.assertTrue(currentURL.contains("inventory.html"));
		
	}

	@When("select filter {string} Click on {string} button.")
	public void select_filter_click_on_button(String string, String string2) throws Exception {
	
		sp.exportPageObject();

		sp.handleDropDown(sp.filterDropDown, "Price (low to high)");
		sp.waitSec(2);
		
	}

	@Then("Under {string} order should get entered and {string} button should get change to {string}")
	public void under_order_should_get_entered_and_button_should_get_change_to(String string, String string2, String string3) throws Exception {
	
        sp.handleClickEvent(sp.addToCartButton);
		sp.waitSec(2);

	}

	@When("Click on {string} button.")
	public void click_on_button(String string) throws Exception {

		sp.exportPageObject();

        sp.handleClickEvent(sp.removeButton);
		sp.waitSec(2);

	}

	@Then("Under {string} order should get removed and {string} button should get change to {string}")
	public void under_order_should_get_removed_and_button_should_get_change_to(String string, String string2, String string3) {
	
	    sp.closeBrowser();
		
	}

}
