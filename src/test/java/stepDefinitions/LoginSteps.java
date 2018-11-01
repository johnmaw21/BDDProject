package stepDefinitions;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginSteps {
		
	WebDriver driver = Hooks.driver;
	
	@Given("the user is on the login page")
	public void user_on_login_page() {
		System.out.println("Step 1: User is on the Login Page");
		driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
	}
		
	@When("the user enters valid login credentials")
	public void user_enters_valid_login_cridentials() {		
		System.out.println("Step 2: User enters Valid Credentials");
		driver.findElement(By.id("MainContent_txtUserName")).sendKeys("tim@testemail.com");
		driver.findElement(By.id("MainContent_txtPassword")).sendKeys("trpass");
		driver.findElement(By.id("MainContent_btnLogin")).click();
	}
		
	@Then("the user should be able to view their account balance")
	public void user_can_view_account_balance() {
		System.out.println("Step 3: User sees Account Balance");
		String bodyText = driver.findElement(By.xpath("html/body")).getText();
		String welcomeMessage = "Logged in successfully";
		Assert.assertTrue(bodyText.contains(welcomeMessage));
	}
	
    @When("the user enters invalid login credentials")
	public void user_enters_invalid_login_cridentials() {		
		System.out.println("Step 2: User enters Valid Credentials");
		driver.findElement(By.id("MainContent_txtUserName")).sendKeys("tim@testemail.com");
		driver.findElement(By.id("MainContent_txtPassword")).sendKeys("badpassword");
		driver.findElement(By.id("MainContent_btnLogin")).click();
    }
    
    @Then("the user should be able to login")
    public void user_should_not_login() {
		System.out.println("Step 3: User sees Account Balance");
		String bodyText = driver.findElement(By.xpath("html/body")).getText();
		String welcomeMessage = "Logged in successfully";
		Assert.assertFalse(bodyText.contains(welcomeMessage));
    }
	
    @And("the user should get an invalid login message")
    public void user_gets_invalid_login_message() {
		System.out.println("Step 4: User gets an Invalid Login Message");
		String bodyText = driver.findElement(By.xpath("html/body")).getText();
		String invalidMessage = "Invalid password, try again!";
		Assert.assertTrue(bodyText.contains(invalidMessage));
    }
    
    @When("^user enters username as \"(.*)\"$")
    public void enterUserName(String username) {
    	driver.findElement(By.id("MainContent_txtUserName")).sendKeys(username);	
    }
    
    @When("^user enters password as \"(.*)\"$")
    public void enterPassword(String password) {
    	driver.findElement(By.id("MainContent_txtPassword")).sendKeys(password);	
    }  

    @And("user clicks on login")
    public void clickLogin() {
    	driver.findElement(By.id("MainContent_btnLogin")).click();
    }
    
    @When("^the user enters \"(.*)\" and \"(.*)\"$")
    public void user_enters_username_and_password(String username, String password) {
    	driver.findElement(By.id("MainContent_txtUserName")).sendKeys(username);
    	driver.findElement(By.id("MainContent_txtPassword")).sendKeys(password);
    	clickLogin();
    }
    
    @When("^the user enters set of username and password")
    public void user_enters_credentials(DataTable credentials) {
    	//Extract the data into a Map and iterate over Map
    	for (Map<String, String> data : credentials.asMaps(String.class, String.class)) {
    		// Parse Map into Local Variables
    		String username = data.get("username");
    		String password = data.get("password");
    		
    		//Perform Action
        	driver.findElement(By.id("MainContent_txtUserName")).clear();
        	driver.findElement(By.id("MainContent_txtUserName")).sendKeys(username);
        	driver.findElement(By.id("MainContent_txtPassword")).clear();
        	driver.findElement(By.id("MainContent_txtPassword")).sendKeys(password);
        	clickLogin();
    	}
    	
    }
    
    @When("the user enters login details as table")
    public void user_enters_username_and_password(DataTable loginDetails) {
    	List<List<String>> data = loginDetails.raw();
    	String username = data.get(0).get(0);
    	String password = data.get(1).get(0);
       	driver.findElement(By.id("MainContent_txtUserName")).sendKeys(username);
        driver.findElement(By.id("MainContent_txtPassword")).sendKeys(password);
       	clickLogin();
    }
    
}
