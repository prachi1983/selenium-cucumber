package com.selenium.keyword;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static WebDriver w;
	public  static String projectPath = System.getProperty("user.dir");

	public void openBrowser(String br) {

		if (br.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			w = new ChromeDriver();
			w.manage().window().maximize();
			w.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		} else if (br.equalsIgnoreCase("firefox")) {

			WebDriverManager.firefoxdriver().setup();
			w = new FirefoxDriver();
			w.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		} else if (br.equalsIgnoreCase("edge")) {

			WebDriverManager.edgedriver().setup();
			w = new EdgeDriver();
			w.manage().window().maximize();
			w.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		}
	}

	public void quitBrowser() {
		w.quit();
	}

	public void closeBrowser() {
		w.close();
	}

	public void openApplication(String url) {
		w.get(url);
	}

	public void handleTextBox(WebElement we, String value) {
		we.clear();
		we.sendKeys(value);
	}

	public void handleDropDown(WebElement we, String value) {
		Select sel = new Select(we);
		sel.selectByVisibleText(value);
	}

	public void handleClickEvent(WebElement we) {
		we.click();
	}

	public String verifyTitle() {
		return w.getTitle();
	}
	
	public String verifyPageURL() {
		return w.getCurrentUrl();
	}


	public String verifyText(WebElement we) {
		return we.getText();
	}

	public void waitSec(int sec) throws Exception {
		sec = sec * 1000;
		Thread.sleep(sec);
	}

	public String readPropertiesFileValue(String key) throws Exception {

		String projectPath = System.getProperty("user.dir");
		String configFilePath = projectPath + "\\Config_Info\\config.properties";

		FileInputStream fin = new FileInputStream(configFilePath);

		Properties prop = new Properties();
		prop.load(fin);
		String data = prop.getProperty(key);
		fin.close();

		return data;

	}

	public static void takeScreenshotCode(String folder,String fileName) throws Exception {
		String screenshotPath = projectPath + "\\Screenshot\\"+folder+"\\"+fileName;

		TakesScreenshot ts = (TakesScreenshot) w;
		File f = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(f, new File(screenshotPath));
	}

}
