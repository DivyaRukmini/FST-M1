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

public class Activity7 {
	//create a WebDriver instance
	 WebDriver	driver = new FirefoxDriver();
    Actions point = new Actions(driver);
    
    //employee details
    String company = "DivyaCompany";
    String title = "QA";


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
   public void Qualification() throws InterruptedException
   {
		//Find the “My Info” menu item and click it.
		String info = driver.findElement(By.xpath("//*[@id=\"menu_pim_viewMyDetails\"]")).getText();
		System.out.println("You are on " + info);
		WebElement info1 = driver.findElement(By.xpath("//*[@id=\"menu_pim_viewMyDetails\"]"));
		point.moveToElement(info1).pause(1000).click(info1).pause(2000).build().perform();
		
		System.out.println("Clicked on My Info tab");
				
		String	personalDetails = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div[1]/h1")).getText();
		System.out.println("You are on " + personalDetails);
		
		//Click on Qualifications
		driver.findElement(By.xpath("//*[@id=\"sidenav\"]/li[9]/a")).click();
		
		//click on Add experience
		driver.findElement(By.xpath("//*[@id=\"addWorkExperience\"]")).click();
		
		//Input details
		driver.findElement(By.id("experience_employer")).sendKeys(company);
		driver.findElement(By.id("experience_jobtitle")).sendKeys(title);
		    	
		driver.findElement(By.xpath("//*[@id=\"btnWorkExpSave\"]")).click();
		System.out.println("Work experience added successfully.");
		        
		Thread.sleep(2000);
		    	
		}

}
