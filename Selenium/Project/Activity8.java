package Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity8 {

	//create a WebDriver instance
	 WebDriver	driver = new FirefoxDriver();
	 WebDriverWait wait;
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
    public void applyLeave() throws InterruptedException 
    {
		//click on apply leave
		String apply = driver.findElement(By.xpath("//*[@id=\"dashboard-quick-launch-panel-menu_holder\"]/table/tbody/tr/td[4]/div/a/span")).getText();
		System.out.println("Clicked on Apply Leave?" + apply);
		Thread.sleep(500);
		
		driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div[1]/div/div/div/fieldset/div/div/table/tbody/tr/td[4]/div/a")).click();
		
		Thread.sleep(500);
		//select drop down
		driver.findElement(By.id("applyleave_txtLeaveType")).click();
		Thread.sleep(500);
		//select value from drop down
		driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/div[2]/form/fieldset/ol/li[1]/select/option[2]")).click();
		String dayoff = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/div[2]/form/fieldset/ol/li[1]/select/option[2]")).getText();
		System.out.println("You selected " + dayoff);
		driver.findElement(By.id("applyleave_txtFromDate")).clear();
		driver.findElement(By.id("applyleave_txtFromDate")).sendKeys("2025-02-18");
		driver.findElement(By.id("applyleave_txtToDate")).clear();
		driver.findElement(By.id("applyleave_txtToDate")).sendKeys("2025-02-18");
		driver.findElement(By.id("applyleave_txtComment")).sendKeys("Applied leave for Divya Rukmini");
		driver.findElement(By.xpath("//input[@id='applyBtn']")).click();
		driver.findElement(By.xpath("//*[@id=\"menu_leave_viewMyLeaveList\"]")).click();
		driver.findElement(By.id("calFromDate")).clear();
		driver.findElement(By.id("calFromDate")).sendKeys("2025-02-18");
		driver.findElement(By.id("calToDate")).clear();
		driver.findElement(By.id("calToDate")).sendKeys("2025-02-18");
		driver.findElement(By.id("btnSearch")).click();
		String leaveAppliedFor = driver.findElement(By.id("commentContainer-241")).getText();
		Assert.assertEquals(leaveAppliedFor, "Applied leave for Divya Rukmin...");
		String status = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div/form/div[3]/table/tbody/tr/td[6]/a")).getText();
		Assert.assertEquals(status, "Pending Approval(1.00)");
		
    }
}