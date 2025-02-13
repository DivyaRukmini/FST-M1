package stepDefinitions;

import java.time.Duration;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginTestSteps_Activity5 
{
	WebDriver driver;
	WebDriverWait wait;
	
	@Given("the user is on the login page")
	public void loginPage() 
	{
		//Initialize the driver and wait instance.
		driver = new FirefoxDriver();
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		//Use get() to open the Google home page.
		driver.get("https://training-support.net/webelements/login-form");
	}
	
	@When("the user enters {string} and {string}") 
	public void entersCredientials(String username, String password) 
	{
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
	}

	@And("clicks the submit button")
    public void clickSubmit() {
        // Find the submit button and click it
		driver.findElement(By.xpath("//button[text()=\"Submit\"]")).click();
    }
	
	@Then("Read the page title and confirmation message on page")
	public void showLoginResult() 
	{
		//wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("action-confirmation")));
	       
		wait.until(ExpectedConditions.titleContains("Login"));
		
		String pageTitle = driver.getTitle();
		
		String confirmMessage = driver.findElement(By.xpath("//h1")).getText();
		//String confirmMessage = driver.findElement(By.id("action-confirmation")).getText();
		
		//Print the page title and heading
        System.out.println("Page title is: " + pageTitle);
        System.out.println("Login message is: " + confirmMessage);
		
        if(confirmMessage.contains("Success!")) 
        {
        	confirmMessage = driver.findElement(By.xpath("/html/body/div/main/div/div/div/div/div/h2")).getText();
        	System.out.println("confirmation message is: " + confirmMessage);
        	
            Assert.assertEquals(confirmMessage, "Welcome Back, Admin!");
        } 
        else 
        {
        	confirmMessage = driver.findElement(By.xpath("//*[@id='subheading']")).getText();
        	System.out.println("confirmation message is: " + confirmMessage);
        	
            Assert.assertEquals(confirmMessage, "Invalid credentials");
        }
		
	}

	 @Then("get the confirmation text and verify message as {string}")
	 public void confirmMessageAsInput(String expectedMessage) 
	 {
		// Find the confirmation message
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//h1"), "Login"));
		String message = driver.findElement(By.xpath("//h1")).getText();
		// Assert message
		Assertions.assertEquals(expectedMessage, message);
	 }
	 
	@And("close the Web Browser now")
    public void closeBrowser() {
        //Close browser
        driver.close();
    }


}