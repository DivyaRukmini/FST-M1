package Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity5
{
	//create a WebDriver instance
	 WebDriver	driver = new FirefoxDriver();
     Actions point = new Actions(driver);
     
     //employee details
     String firstName = "Divya";
     String lastName = "Mohan";


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
	public void afterClass() 
	{
 	     // Close the driver
		driver.close();
	}
 
	@SuppressWarnings({ "deprecation"})
	@Test(priority = 1)
    public void myInfo() throws InterruptedException
    {
		//Find the “My Info” menu item and click it.
		String info = driver.findElement(By.xpath("//*[@id=\"menu_pim_viewMyDetails\"]")).getText();
		System.out.println("You are on " + info);
		WebElement info1 = driver.findElement(By.xpath("//*[@id=\"menu_pim_viewMyDetails\"]"));
		point.moveToElement(info1).pause(1000).click(info1).pause(2000).build().perform();
		
		System.out.println("Clicked on My Info tab");
				
		String	personalDetails = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div[1]/h1")).getText();
		System.out.println("You are on " + personalDetails);
		        
		//Find the “Edit” menu item and click it.
		driver.findElement(By.xpath("//input[@id='btnSave']")).click();
		      	
		//Fill in the Name, Gender, Nationality, and the DOB fields. and Click Save.
		driver.findElement(By.id("personal_txtEmpFirstName")).clear();
		driver.findElement(By.id("personal_txtEmpFirstName")).sendKeys(firstName);
		        
		driver.findElement(By.id("personal_txtEmpLastName")).clear();
		driver.findElement(By.id("personal_txtEmpLastName")).sendKeys(lastName);
		    	
		driver.findElement(By.id("personal_optGender_2")).click();
		    	
		driver.findElement(By.id("personal_DOB")).clear();
		driver.findElement(By.id("personal_DOB")).sendKeys("1993-03-18");
		
		driver.findElement(By.id("personal_cmbNation")).sendKeys("Indian");
		    	
		driver.findElement(By.xpath("//input[@id='btnSave']")).click();
		System.out.println("Personal Details updated successfully..!!");
		        
		Thread.sleep(2000);
		    	
		System.out.println("Updated First Name : " + driver.findElement(By.id("personal_txtEmpFirstName")).getAttribute("value"));
		System.out.println("Updated Last Name : " + driver.findElement(By.id("personal_txtEmpLastName")).getAttribute("value"));
		System.out.println("Updated Gender : " + driver.findElement(By.id("personal_optGender_2")).isSelected());
		System.out.println("Updated DOB : " + driver.findElement(By.id("personal_DOB")).getAttribute("value"));
		System.out.println("Updated Nationality : " + driver.findElement(By.id("personal_cmbNation")).getAttribute("value"));
		}

}