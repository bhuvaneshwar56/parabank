package com.qa.baseClass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import com.qa.utilities.WebEventListener;

import io.github.bonigarcia.wdm.WebDriverManager;

public class baseCLassDecleration {
	public static WebDriver driver;
	public static Properties prop;
	public static Actions action;
	public static WebDriverWait wait;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;

	// create constructor oof baseClass
	public baseCLassDecleration() {
		prop = new Properties();
		
		try {
			FileInputStream ip;	ip = new FileInputStream(
					System.getProperty("user.dir") + "/src/main/java/com.qa.config/configuration.properties");
		//	System.getProperty("./src/main/java/com.qa.config/configuration.properties");
			
			prop.load(ip);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Parameters("browser")
	public static void setup() {
		String browserName = prop.getProperty("browser");
		if (browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		} else if (browserName.equals("FF")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browserName.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		 else if (browserName.equals("safari")) {
				WebDriverManager.safaridriver().setup();
				driver = new SafariDriver();
			}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 30); // explicit wait
		action = new Actions(driver);

		// Initializing EventFiringWebDriver using any WebDriver instance
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with
		// EventFiringWebDriver
	eventListener = new WebEventListener();
	e_driver.register(eventListener);
		driver = e_driver;
	}

}
