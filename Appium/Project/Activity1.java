package appiumProject;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity1 
{
		// Driver Declaration
	    AndroidDriver driver;
	    WebDriverWait wait;

	    // Set up method
	    @BeforeClass
	    public void setUp() throws MalformedURLException, URISyntaxException 
	    {
	        // Desired Capabilities
	        UiAutomator2Options options = new UiAutomator2Options();
	        options.setPlatformName("android");
	        options.setAutomationName("UiAutomator2");
	        //options.setAppPackage("com.google.android.apps.tasks");
	        //options.setAppActivity(".ui.TaskListsActivity");
	        options.noReset();

	        // Set the Appium server URL
	        URL serverURL = new URI("http://localhost:4723").toURL();

	        // Driver Initialization
	        driver = new AndroidDriver(serverURL, options);

	        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	    }

	    // Test method
	    @Test
	    public void googleTasks() throws InterruptedException 
	    {      
	        //Open the Google Tasks app.
	    	
	    	//Click on google search button
	        driver.findElement(AppiumBy.id("com.google.android.apps.nexuslauncher:id/g_icon")).click();
	        //Click on my account
	        driver.findElement(AppiumBy.androidUIAutomator("UiSelector().resourceId(\"com.google.android.googlequicksearchbox:id/googleapp_selected_account_disc\")")).click();
	        //click on tasks button
	        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.google.android.googlequicksearchbox:id/og_text_card_title\" and @text=\"Tasks\"]")).click();
	      
	        String[] tasklist = new String[] {
	        		"Complete Activity with Google Tasks", 
	        		"Complete Activity with Google Keep", 
					"Complete the second Activity Google Keep" };
	        
	        //wait for add task to load.	       
	        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.Button[@text=\"Add a task\"]")));
	        String tasksHeader = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"TASKS\"]")).getText();
	        System.out.println("You are on google " + tasksHeader + " app");
	        
	        for(int i=0; i<3; i++)
	        {
	        	driver.findElement(AppiumBy.xpath("//android.widget.Button[@text=\"Add a task\"]")).click();
	        	Thread.sleep(500);
		        System.out.println("Adding new task : " + tasklist[i]);
		        driver.findElement(AppiumBy.className("android.widget.EditText")).sendKeys(tasklist[i]);
		        Thread.sleep(500);
	        }
	        
	        driver.findElement(AppiumBy.className("android.widget.Button")).click();
	        Thread.sleep(500);
	        driver.findElement(AppiumBy.className("android.widget.Button")).click();
	        
	        //After adding all tasks, get the list of task names.
	        String t3 = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Complete the second Activity Google Keep\"]")).getText();
	        Assert.assertEquals(t3, tasklist[2]); 
	        
	        String t2 = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Complete Activity with Google Keep\"]")).getText();
	        Assert.assertEquals(t2, tasklist[1]); 
	        
	        String t1 = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Complete Activity with Google Tasks\"]")).getText();
	        Assert.assertEquals(t1, tasklist[0]); 
	        
	    }


	    // Tear down method
	    @AfterClass
	    public void tearDown() 
	    {
	        // Close the app
	        driver.quit();
	    }

}
