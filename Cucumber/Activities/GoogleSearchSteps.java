package stepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GoogleSearchSteps 
{
	WebDriver driver;
	WebDriverWait wait;
	
	@Given("User is on Google Home Page")
	public void homePage() 
	{
		//Initialize the driver and wait instance.
		driver = new FirefoxDriver();
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		//Use get() to open the Google home page.
		driver.get("https://www.google.com");
	}

	@When("User types in Cheese and hits ENTER")
	public void searchCheese() 
	{
		//Use findElement() to find the search bar and enter "Cheese" in it and emulate hitting ENTER.
		WebElement search = driver.findElement(By.xpath("//textarea[@id='APjFqb']"));
		search.sendKeys("Cheese", Keys.RETURN);
		//search.click();
	}

	@Then("Show how many search results were shown")
	public void showResult() 
	{
		//Wait till the results stats are shown.
		//Use getText() to get the text and print it.
		wait.until(ExpectedConditions.elementToBeClickable(By.id("hdtb-tls")));
		
		//driver.findElement(By.id("hdtb-tls")).click();
		driver.findElement(By.xpath("//div[@id='hdtb-tls']")).click();
		
		//wait.until(ExpectedConditions.elementToBeClickable(By.id("hdtb-tls"))).click();
				
		String resultStats = driver.findElement(By.id("result-stats")).getText();
        System.out.println("Total number of results : " + resultStats);
	}

	@And("Close the browser")
	public void teardown()
	{
		//close() the browser
		driver.close();
	}
}