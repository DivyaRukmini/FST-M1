package Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity6 

{

	//create a WebDriver instance
	 WebDriver	driver = new FirefoxDriver();
		
	@BeforeClass
	public void beforeClass() 
    {
		//go to a web page
		driver.get("http://alchemy.hguy.co/orangehrm");
		
		
		//Title of the page
        System.out.println("Title of the new page is : " + driver.getTitle());
        		
		//Find the username and password fields
        WebElement username = driver.findElement(By.id("txtUsername"));
        WebElement password = driver.findElement(By.name("txtPassword"));

        //Enter credentials
        username.sendKeys("orange");
        password.sendKeys("orangepassword123");
        

        //Click login
        driver.findElement(By.xpath("//*[@id=\"btnLogin\"]")).click();
        
        // Read login message
        String welcome = driver.findElement(By.id("welcome")).getText();
        
        System.out.println("User logged in to the application. On home page :  " + welcome);
                
        //Verify that the homepage has opened
        String homepageHeader = driver.findElement(By.tagName("h1")).getText();
        System.out.println("You are on home page " + homepageHeader);
        
        Assert.assertEquals(homepageHeader, "Dashboard");
        
    }
 
	@AfterClass
	public void tearDown() 
	{
 	     // Close the driver
		driver.close();
	}
	
	
	

	@Test(priority = 1)
    public void directoryMenu() throws InterruptedException 
    {
		//Verify that the “Directory” menu item is visible and clickable
		System.out.println("“Directory” menu item is visible : " + driver.findElement(By.xpath("//a[@id='menu_directory_viewDirectory']")).isDisplayed());
		System.out.println("“Directory” menu item is clickable : " + driver.findElement(By.xpath("//a[@id='menu_directory_viewDirectory']")).isEnabled());
		
		driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/div[1]/h1")).click();
		System.out.println("Clicked on Directory tab");
		
		String directory = driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/div[1]/h1")).getText();
        System.out.println("You are on " + directory);
        
       
    }
}