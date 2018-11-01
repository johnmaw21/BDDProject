package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {
	
	public static WebDriver driver;
	
	@Before		//Cucumber Hook
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@After		//Cucumber Hook 
	public void tearDown() {
		driver.quit();
	}

}
