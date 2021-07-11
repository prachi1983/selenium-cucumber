package com.cucumber.test;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		features= {"Features"},
		glue= {"com.cucumber.test"},
		plugin= {"pretty","html:target/cucumber-test/SauceTest.html","json:target/cucumber.json" },
		monochrome=true
		
		)





public class TestRunner {

}
