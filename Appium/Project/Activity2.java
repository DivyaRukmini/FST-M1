package appiumProject;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity2
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
	    public void googleKeep() throws InterruptedException 
	    {      
	        
	    	//Click on google keep app
	        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"Predicted app: Keep Notes\"]")).click();
	        //Click on add
	        driver.findElement(AppiumBy.id("com.google.android.keep:id/speed_dial_create_close_button")).click();
	        //click on text task
	        driver.findElement(AppiumBy.id("com.google.android.keep:id/new_note_button")).click();
	        
	        Thread.sleep(1000);
	        
	        //add description
	        driver.findElement(AppiumBy.id("com.google.android.keep:id/edit_note_text")).sendKeys("KN Description");
	        
	        //add title
	        driver.findElement(AppiumBy.id("com.google.android.keep:id/editable_title")).sendKeys("KN Title");
	        
	        //click back
	        driver.findElement(AppiumBy.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]")).click();
	        
	        Thread.sleep(1000);
	        
	        String title = driver.findElement(AppiumBy.id("com.google.android.keep:id/index_note_title")).getText();
	        
	        System.out.println(title);
	        Assert.assertEquals(title, "KN Title");
	        
	    }


	    // Tear down method
	    @AfterClass
	    public void tearDown() 
	    {
	        // Close the app
	        driver.quit();
	    }

}
