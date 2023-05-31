package StepDefinitions;

import Utils.CommonMethods;
import Utils.ConfigReader;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class EmployeeSearch extends CommonMethods {
    @When("user enters valid employee id {string}")
    public void user_enters_valid_employee_id(String string) {
        WebElement empIDTextBox=driver.findElement(By.id("empsearch_id"));
        sentText(empIDTextBox, string);

    }
    @When("user enters valid Job title {string}")
    public void user_enters_valid_job_title(String string) {
        WebElement empJobTitleTextBox=driver.findElement(By.id("empsearch_job_title"));
        selectByOption(empJobTitleTextBox,string);

/*        WebElement EmpStatus=driver.findElement(By.id("empsearch_employee_status"));
        selectByOption(EmpStatus, "Active");

        WebElement includeDdl=driver.findElement(By.id("empsearch_termination"));
        selectByOption(includeDdl, "Current and Past Employees");*/

    }
    @When("Clicks on search button")
    public void clicks_on_search_button() {
        WebElement searchButton=driver.findElement(By.id("searchBtn"));
        doClick(searchButton);

    }
    @When("user see employee information is displayed")
    public void user_see_employee_information_is_displayed() {
        System.out.println("The employee is Displayed");
    }

}
