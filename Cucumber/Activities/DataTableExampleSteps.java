package stepDefinitions;
import java.util.List;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DataTableExampleSteps extends BaseClass 
{

	WebDriver driver;
	WebDriverWait wait;
	
	@Given("User completes the requirement")
	public void completeRequirement() {
        driver.get("https://training-support.net/webelements/todo-list");
		System.out.println("Given completed");
	}

	@When("User enters the following tasks")
	public void inputTasks(DataTable inputTasks) throws InterruptedException {
		List<String> tasks = inputTasks.asList();
		System.out.println(tasks);

		for(String task : tasks) {
			driver.findElement(By.id("todo-input")).sendKeys(task);
			driver.findElement(By.id("todo-add")).click();
			Thread.sleep(2000);
		}
	}

	@Then("Verify results")
	public void verifyResults() {
		System.out.println("Verification complete");
	}
}