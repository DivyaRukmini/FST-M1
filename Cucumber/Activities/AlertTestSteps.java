package stepDefinitions;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AlertTestSteps 
{
	WebDriver driver;
	WebDriverWait wait;
	Alert alert;
	
	@Given("User is on the page")
	public void openHomePage() 
	{
		//Initialize the driver and wait instance.
		driver = new FirefoxDriver();
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		//Use get() to open the Google home page.
		driver.get("https://training-support.net/webelements/alerts");
	}

	@When("User clicks the Simple Alert button")
	public void openSimpleAlert() 
	{
		driver.findElement(By.id("simple")).click();
	}
	
	@When("User clicks the Confirm Alert button")
	public void openConfirmAlert() 
	{
		driver.findElement(By.cssSelector("#confirmation")).click();
	}
	
	@When("User clicks the Prompt Alert button")
	public void openPromptAlert() 
	{
		driver.findElement(By.xpath("//button[@id='prompt']")).click();
	}

	@Then("Alert opens")
	public void switchFocus() 
	{
        alert = driver.switchTo().alert();
    }
	
	@And("Read the text from it and print it")
    public void readAlertText() 
	{
        System.out.println("Alert says: " + alert.getText());
    }
 
    @And("Write a custom message in it")
    public void writeToPrompt() 
    {
        alert.sendKeys("Custom Message");
    }
 
    @And("Close the alert")
    public void closeAlertWithOk() 
    {
        alert.accept();
    }
 
    @And("^Close the alert with Cancel$")
    public void closeAlertWithCAncel() 
    {
        alert.dismiss();
    }

    @And("Read the result text")
    public void readResultText() 
    {
    	String msg = driver.findElement(By.xpath("//p[@id='result']")).getText();    
    	System.out.println("Confirmation Message says: " + msg);
    }
    
	@And("Close Browser")
    public void closeWebBrowser() 
	{
        //Close browser
        driver.close();
    }


}