package appiumProject;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity4 {
	AndroidDriver driver;
	WebDriverWait wait;

	@BeforeClass
	public void setUp() throws MalformedURLException, URISyntaxException {
		// Desired Capabilities
		UiAutomator2Options options = new UiAutomator2Options();
		options.setPlatformName("Android");
		options.setAutomationName("UiAutomator2");
		options.setAppPackage("com.android.chrome");
		options.setAppActivity("com.google.android.apps.chrome.Main");
		options.noReset();

		// Server URL
		URL serverURL = new URI("http://localhost:4723").toURL();

		// Driver initialization
		driver = new AndroidDriver(serverURL, options);
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		// Open Selenium page
		driver.get("https://v1.training-support.net/selenium");
	}

	@Test
	public void todoList() throws InterruptedException {
		
		wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.className("android.webkit.WebView")));
		
    	// Locate heading on page and print it
    	String pageTitle = driver.findElement(AppiumBy.className("android.webkit.WebView")).getText();
    	System.out.println("Web Page Heading: " + pageTitle);

    	driver.findElement(AppiumBy.xpath("//android.widget.Button[@text=\"Get Started!\"]")).click();
    	
    	wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text=\"JavaScript Alerts\"]")));
		
        // UiScrollable object string
     	String UiScrollable = "UiScrollable(UiSelector().scrollable(true))";
     	
     	// Scroll to End
     	driver.findElement(AppiumBy.androidUIAutomator(UiScrollable + ".scrollToEnd(2)"));
     	
     	wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text=\"Tables\"]")));
     	
     	//Scroll to End
     	driver.findElement(AppiumBy.androidUIAutomator(UiScrollable + ".scrollToEnd(2)"));
     	    	
     	
     	// Locate element
     	driver.findElement(AppiumBy.xpath("//android.view.View[@content-desc=\"To-Do List  Elements get added at run time\"]")).click();
     	System.out.println("TO DO List clicked.");
     	
     	wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"taskInput\"]")));
		
		      
     	// Find heading of new page and print to console
        String taskHeading = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"To-Do List\"]")).getText();
        System.out.println("Task Page Heading: " + taskHeading);
        
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"taskInput\"]")));
        
        //Add tasks to list
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"taskInput\"]")).sendKeys("Task1");
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@text=\"Add Task\"]")).click();
        
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"taskInput\"]")));
		
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"taskInput\"]")).sendKeys("Task2");
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@text=\"Add Task\"]")).click();
        
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"taskInput\"]")));
		
        //Get number of tasks
        List<WebElement> list = driver.findElements(AppiumBy.xpath("//android.view.View[@resource-id=\"tasksList\"]"));
        System.out.println("number of tasks: " + list.size());
                
        //Click on each of the tasks added to strike them out.
        for(WebElement element : list)
        {
        	if(element.getText().contains("Add more tasks to this list"))
        		continue;
        	
        	System.out.println("clicked on tasks: " + element.getText());
        	element.click();
        	
        	Thread.sleep(100);
        }
        
        //Clear the list
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\" Clear List\"]")).click();
        String clearL = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\" Clear List\"]")).getText();
        System.out.println(clearL);
        
        Thread.sleep(3000);
        
        List<WebElement> list1 = driver.findElements(AppiumBy.xpath("//android.view.View[@resource-id=\"tasksList\"]"));
        System.out.println("number of tasks: " + list1.size());
        
        Assert.assertEquals(list1.size(), 0);
        
	}


	@AfterClass
	public void tearDown() {
		// Close the browser
		driver.quit();
	}
}