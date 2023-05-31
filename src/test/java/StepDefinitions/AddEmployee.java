package StepDefinitions;

import Pages.AddEmployeePage;
import Utils.CommonMethods;
import Utils.ConfigReader;
import Utils.DBUtility;
import Utils.GlobalVariables;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AddEmployee extends CommonMethods {

    @When("user clicks on PIM option")
    public void user_clicks_on_pim_option() {
        doClick(addEmployeePage.pimTab);

    }
    @When("user clicks on add employee button")
    public void user_clicks_on_add_employee_button() {

       doClick(addEmployeePage.employeebtn);
    }
    @When("user enters firstname {string} , middlename {string} , and lastname {string}")
    public void user_enters_firstname_middlename_and_lastname(String string, String string2, String string3){
        sentText(addEmployeePage.fNameTxtBox, string);


        sentText(addEmployeePage.mNameTxtBox,string2);


        sentText(addEmployeePage.lNameTxtBox, string3);

    }
    @When("user clicks on save button")
    public void user_clicks_on_save_button(){

        doClick(addEmployeePage.savebttn);
    }
    @When("user enters {string} and {string} and {string}")
    public void user_enters_and_and(String fname, String mname, String lname) {
    sentText(addEmployeePage.fNameTxtBox, fname);
    sentText(addEmployeePage.mNameTxtBox, mname);
    sentText(addEmployeePage.lNameTxtBox, lname);
    }
    @When("user captures the employee id")
    public void user_captures_the_employee_id() {
        GlobalVariables.emp_id=addEmployeePage.empid_locator.getAttribute("value");
        System.out.println("The employee id is: "+ GlobalVariables.emp_id);

    }
    @When("query the information on the backend")
    public void query_the_information_on_the_backend() {
        String query = "select * from hs_hr_employees where employee_id='" + GlobalVariables.emp_id +"'";
        GlobalVariables.tabeldata=DBUtility.getListOfMapsFromRset(query);
    }
    @Then("verify the results from front end and back end")
    public void verify_the_results_from_front_end_and_back_end() {
        String firstNameFromDB=GlobalVariables.tabeldata.get(0).get("emp_firstname");
        System.out.println(firstNameFromDB);
        String lastNameFromDB=GlobalVariables.tabeldata.get(0).get("emp_lastname");
        System.out.println(lastNameFromDB);

        Assert.assertEquals(firstNameFromDB, "john");
        Assert.assertEquals(lastNameFromDB, "johnson");

    }
}
