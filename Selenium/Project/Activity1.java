package Project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity1 
{
	//create a WebDriver instance
	 WebDriver	driver = new FirefoxDriver();

	@BeforeClass
	public void beforeClass() 
    {
		//go to a web page
		driver.get("http://alchemy.hguy.co/orangehrm");
    }
 
	@AfterClass
	public void afterClass() 
	{
 	     // Close the driver
		driver.close();
	}
 
	@Test
    public void PageTitle() 
    {
		if (driver.getTitle().matches("OrangeHRM")) 
		{
			System.out.println("Title of the page : " + driver.getTitle());
		} 
		else 
		{
			System.out.println("Unknown Error. Title dint match/page not loaded.");
		}
		
		 Assert.assertEquals(driver.getTitle(), "OrangeHRM");
    }
}