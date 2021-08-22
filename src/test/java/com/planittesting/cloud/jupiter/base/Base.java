package com.planittesting.cloud.jupiter.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.planittesting.cloud.jupiter.utilities.ExcelReader;

public class Base {

	public static Properties properties;
	public static WebDriver driver;
	public static ExcelReader excel = new ExcelReader(
			System.getProperty("user.dir") + "\\src\\test\\resources\\excelSheet\\TestData.xlsx");
	public static WebDriverWait wait;

	public static void initConfigaration() {

		// Code to read configProperties file
		properties = new Properties();
		FileInputStream fileInputStream = null;
		try {
			fileInputStream = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\test\\resources\\configProperties\\config.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			properties.load(fileInputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Initializing the browser based on the value(browser) present in
		// configProperties file
		if ((properties.getProperty("browser")).equalsIgnoreCase("chrome")) {
			System.out.println(System.getProperty("user.dir") + properties.getProperty("excelPath"));
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + properties.getProperty("chromeDriverPath"));
			driver = new ChromeDriver();

		} else {
			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir") + properties.getProperty("fireFoxDriverPath"));
			driver = new FirefoxDriver();
		}

		// Navigating to the given url and initializing the explicit wait
		driver.get(properties.getProperty("url"));
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, 16);
	}

	public static void tearDown() {

		// Closing all the opened webpages or quiting the browser
		driver.quit();

	}

}
