package com.selenium.keyword;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SaucePageObject extends TestBase{
	
	
	@FindBy(id = "user-name")
	public WebElement username;

	@FindBy(id = "password")
	public WebElement password;

	@FindBy(name = "login-button")
	public WebElement loginButton;

	@FindBy(css = "select.product_sort_container")
	public WebElement filterDropDown;

	@FindBy(xpath = "(//button[text()='Add to cart'])[1]")
	public WebElement addToCartButton;

	@FindBy(xpath = "(//button[text()='Remove'])[1]")
	public WebElement removeButton;
	
	
	
	public void exportPageObject() {
		PageFactory.initElements(w, this);
	}

	
	

}
