package Project;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity9
{
	//create a WebDriver instance
	 WebDriver	driver = new FirefoxDriver();
     Actions point = new Actions(driver);
     
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
 
	@Test(priority = 1)
    public void EmergencyDetails() throws InterruptedException
    {
		//Find the “My Info” menu item and click it.
		String info = driver.findElement(By.xpath("//*[@id=\"menu_pim_viewMyDetails\"]")).getText();
		System.out.println("You are on " + info);
		WebElement info1 = driver.findElement(By.xpath("//*[@id=\"menu_pim_viewMyDetails\"]"));
		point.moveToElement(info1).pause(1000).click(info1).pause(2000).build().perform();
		
		System.out.println("Clicked on My Info tab");
		
		driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[1]/ul/li[3]/a")).click();
		System.out.println("Clicked on Emergency Contact Details");
		//Find the number of columns from header in the table and print them.
	    List<WebElement> cols = driver.findElements(By.xpath("/html/body/div[1]/div[3]/div/div[3]/div[2]/form/table/thead/tr/th"));
	    System.out.println("total number of columns in header: " + cols.size()); 
        
        //Find the number of rows in the table and print them. 
	    List<WebElement> row = driver.findElements(By.xpath("/html/body/div[1]/div[3]/div/div[3]/div[2]/form/table/tbody/tr"));
	    System.out.println("total number of rows : " + row.size());

	    for (int i = 1; i <= row.size(); ++i)
	    {
	    	String a = String.valueOf(i);
	    	
	    	//Find and print all the cell values in the first row of the table.
	    	List<WebElement> rowData = driver.findElements(By.xpath("/html/body/div[1]/div[3]/div/div[3]/div[2]/form/table/tbody/tr[" + a + "]"));
	    
	    	System.out.println(a + " row cell values: ");
	    	for(WebElement cell : rowData) 
    		{
    			System.out.println(cell.getText());
    		}	    	
	    }
    }

}