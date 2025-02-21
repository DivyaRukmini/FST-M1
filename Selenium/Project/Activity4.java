package Project;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity4
{
	//create a WebDriver instance
	 WebDriver	driver = new FirefoxDriver();
	 
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
 
	@Test(priority = 1)
    public void addEmployee() 
    {
		//Find the PIM option in the menu and click it.
		WebElement pim = driver.findElement(By.xpath("//*[@id=\"menu_pim_viewPimModule\"]"));
				
		System.out.println("name of header - " + pim.getText());
				
		pim.click();
						
		//click Add button to add employee
		WebElement addButton = driver.findElement(By.xpath("//*[@id=\"menu_pim_addEmployee\"]"));
		
		    	    	
		addButton.click();
		
		//Verify that the add employee page has opened
        String add = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[1]/h1")).getText();
        System.out.println("You are on " + add);
        
        Assert.assertEquals(add, "Add Employee");

		
		driver.findElement(By.xpath("//*[@id=\"firstName\"]")).sendKeys(firstName);
		driver.findElement(By.xpath("//*[@id=\"lastName\"]")).sendKeys(lastName);
		    	
		//click on save button.    	
		driver.findElement(By.xpath("//*[@id=\"btnSave\"]")).click();
		System.out.println("Added Employee details");
		    	        
	}

	@Test(priority = 2)
	public void searchEmployeeOnPim() throws InterruptedException
	{
		//Find the PIM option in the menu and click it.
		driver.findElement(By.xpath("//*[@id=\"menu_pim_viewPimModule\"]")).click();
				
		//click on Employee list
		driver.findElement(By.xpath("//*[@id=\"menu_pim_viewEmployeeList\"]")).click();
						
		//Verify that the search employee page has opened
		String EmpInfo = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/div[1]/h1")).getText();
		System.out.println("You are on " + EmpInfo);
		        
		String name = firstName + " " + lastName;
		System.out.println("Searching for employee :  " + name);
				
		WebElement employee = driver.findElement(By.xpath("//*[@id=\"empsearch_employee_name_empName\"]"));
		employee.sendKeys(name);
		employee.click();
		        
		List<WebElement> searchData = driver.findElements(By.xpath("//div[@class=\"ac_results\"]/ul/li"));
		        
		System.out.println("Select name from dropdown : ");
		            
		System.out.println("Dropdown list values : " + searchData.size());
			   
		//iterate the dropdown list
		for(int i=0; i < searchData.size(); i++) 
		{
		     	System.out.println(searchData.get(i).getText());
		           
		        if (searchData.get(i).getText().contains(name))
		        {
		          	System.out.println("Match found, selecting the option : " + searchData.get(i).getText());
		          	searchData.get(i).click();
		          	System.out.println("Clicked!");
		          	break;
		         }
		         else 
		         {
		           	System.out.println("Match not found, selecting next option ");
		         }
		}
		        
		WebElement search = driver.findElement(By.xpath("//*[@id=\"searchBtn\"]"));
		        
		// click on search button
		search.click(); 
		        
			    //get detail form result table
		        //Find the number of columns from header in the table and print them.
			    List<WebElement> cols = driver.findElements(By.xpath("/html/body/div[1]/div[3]/div[2]/div/form/div[4]/table/thead/tr/th"));
			    System.out.println("total number of columns in header: " + cols.size()); 
		        
		        //Find the number of rows in the table and print them. 
			    List<WebElement> row = driver.findElements(By.xpath("/html/body/div[1]/div[3]/div[2]/div/form/div[4]/table/tbody/tr"));
			    System.out.println("total number of rows in header: " + row.size());

			    for (int i = 1; row.size() >= i; ++i)
			    {
			    	String a = String.valueOf(i);
			    	
			    	//Find and print all the cell values in the first row of the table.
			    	List<WebElement> rowData = driver.findElements(By.xpath("/html/body/div[1]/div[3]/div[2]/div/form/div[4]/table/tbody/tr[" + a + "]"));
			    
			    	System.out.println(a + " row cell values: ");
			    	
			    	if (rowData.get(0).getText().contains("No Records Found"))
		    		{
		    			System.out.println("No Records Found..!!");
		    			break;
		    		}
			    	else
			    	{
			    		for(WebElement cell : rowData) 
			    		{
			    			System.out.println(cell.getText());
			    		}
			    	}
			    
			    	//Find and print the first name and last name from column.
			    	WebElement fName = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div/form/div[4]/table/tbody/tr[" + a + "]/td[3]"));
			    	System.out.println("First Name: " + fName.getText());
			    	
			    	WebElement lName = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div/form/div[4]/table/tbody/tr[" + a + "]/td[4]"));
			    	System.out.println("Last Name: " + lName.getText());
			    }
    }
}