package com.cucumber.test;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DataDrivenTest {

	WebDriver w;
	Select sel;

	@Before("@DataDriven")
	public void preCondition() {
		WebDriverManager.chromedriver().setup();
		w = new ChromeDriver();

	}

	@Given("Open chrome and navigate to calculate page")
	public void open_chrome_and_navigate_to_calculate_page() {

		w.get("https://juliemr.github.io/protractor-demo/");

	}

	@When("Enter two numbers {string} and {string} with operator {string}")
	public void enter_two_numbers_and_with_operator(String firstNumber, String secondNumber, String operator) {

		w.findElement(By.cssSelector("input[ng-model='first']")).sendKeys(firstNumber);

		WebElement op = w.findElement(By.cssSelector("select[ng-model='operator']"));
		sel = new Select(op);
		sel.selectByVisibleText(operator);

		w.findElement(By.cssSelector("input[ng-model='second']")).sendKeys(secondNumber);

		w.findElement(By.id("gobutton")).click();

	}

	@Then("Validate output {string}")
	public void validate_output(String expectedOutput) throws Exception {

		Thread.sleep(3000);

		String actualOutput = w.findElement(By.cssSelector("h2.ng-binding")).getText();

		Assert.assertEquals(expectedOutput, actualOutput);

	}

	@After("@DataDriven")
	public void postCondition() {

		w.quit();

	}

}
