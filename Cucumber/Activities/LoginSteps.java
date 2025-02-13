package stepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps 
{
	WebDriver driver;
	WebDriverWait wait;
	
	@Given("User is on Login page")
	public void loginPage() 
	{
		//Initialize the driver and wait instance.
		driver = new FirefoxDriver();
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		//Use get() to open the Google home page.
		driver.get("https://training-support.net/webelements/login-form");
	}

	
	@When("User enters username and password")
	public void entersCredientials() 
	{
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("password");
		
		driver.findElement(By.xpath("//button[text()=\"Submit\"]")).click();
		
	}
	
	
	@Then("Read the page title and confirmation message")
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
		
		//Assertions.assertEquals(msg, "Login Success!");
        
       
        if(confirmMessage.contains("Success!")) 
        {
        	confirmMessage = driver.findElement(By.xpath("/html/body/div/main/div/div/div/div/div/h2")).getText();
         	
            Assert.assertEquals(confirmMessage, "Welcome Back, Admin!");
        } 
        else 
        {
        	confirmMessage = driver.findElement(By.xpath("//*[@id='subheading']")).getText();
        	
            Assert.assertEquals(confirmMessage, "Invalid credentials");
        }
		
	}

	@And("Close the Web Browser")
    public void closeBrowser() {
        //Close browser
        driver.close();
    }

}