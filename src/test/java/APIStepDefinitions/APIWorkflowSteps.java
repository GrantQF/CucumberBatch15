package APIStepDefinitions;

import Utils.APIConstants;
import Utils.APIPayloadConstants;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.runner.Request;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.given;

public class APIWorkflowSteps {
public static RequestSpecification request;
public static Response resposne;
public static String employee_id;
    @Given("a request is prepared to create an employee")
    public void a_request_is_prepared_to_create_an_employee() {
        request.given().
                header(APIConstants.HEADER_KEY_CONTENT_TYPE,APIConstants.HEADER_VALUE_CONTENT_TYPE).
                header(APIConstants.AUTHORIZATION,GenerateTokenSteps.token).
                body(APIPayloadConstants.createEmployeePayload());
    }
    @When("a POST call is made to create an employee")
    public void a_post_call_is_made_to_create_an_employee() {
       resposne=request.when().post("/createEmployee.php ");
       resposne.prettyPrint();
    }
    @Then("the status code for creating an employee is {int}")
    public void the_status_code_for_creating_an_employee_is(Integer int1) {
       resposne.then().assertThat().statusCode(int1);
    }
    @Then("the employee contains key {string} and value {string}")
    public void the_employee_contains_key_and_value(String key, String value) {
        resposne.then().assertThat().body(key,equalTo(value));
    }
    @Then("the employee id {string} is stored as a global variable to be viewed")
    public void the_employee_id_is_stored_as_a_global_variable_to_be_viewed(String string) {
        employee_id=resposne.jsonPath().getString(string);
    }
//New set of stepdefinitions
    @Given("a request is prepared to get create an employee")
    public void a_request_is_prepared_to_get_create_an_employee() {
        request.given().
                header(APIConstants.HEADER_KEY_CONTENT_TYPE,APIConstants.HEADER_VALUE_CONTENT_TYPE).
                header(APIConstants.AUTHORIZATION,GenerateTokenSteps.token).
                queryParam("empoyee_id",employee_id);
    }
    @When("a GET call is made to get the employee")
    public void a_get_call_is_made_to_get_the_employee() {
        resposne =request.when().get(APIConstants.GET_ONE_EMPLOYEE_URI);
    }
    @Then("the status code for this employee is {int}")
    public void the_status_code_for_this_employee_is(Integer int1) {
        resposne.then().assertThat().statusCode(int1);
    }
    @Then("the employee data we get having id {string} must match with global store employee id")
    public void the_employee_data_we_get_having_id_must_match_with_global_store_employee_id(String string) {
        String tempEmpID =resposne.jsonPath().getString(string);
    }
    @Then("the retrieved data at {string} object matches with the data of created employee")
    public void the_retrieved_data_at_object_matches_with_the_data_of_created_employee(String empObject, DataTable dataTable) {
        List<Map<String,String>> expectedData= dataTable.asMaps();
        Map<String,String> actualData=resposne.body().jsonPath().get(empObject);
        for(Map<String,String> map :expectedData){
            Set<String> keys=map.keySet();
            for (String key:keys){
                String expectedValue=map.get(key);
                String actualValue=actualData.get(key);
                Assert.assertEquals(expectedValue,actualValue);
            }

        }
    }

    @Given("a request is prepared to create an employee with dynamic data {string} , {string} , {string} , {string} , {string} , {string} , {string}")
    public void a_request_is_prepared_to_create_an_employee_with_dynamic_data(String string, String string2, String string3, String string4, String string5, String string6, String string7) {
        request.given().
                header(APIConstants.HEADER_KEY_CONTENT_TYPE,APIConstants.HEADER_VALUE_CONTENT_TYPE).
                header(APIConstants.AUTHORIZATION,GenerateTokenSteps.token).
                body(APIPayloadConstants.createEmployeeDynamic(string,string2,string3,string4,string5,string6,string7));
    }

    @Given("a request is prepared to update an employee")
    public void a_request_is_prepared_to_update_an_employee() {
     request.given().
             header(APIConstants.HEADER_KEY_CONTENT_TYPE,APIConstants.HEADER_VALUE_CONTENT_TYPE).
             header(APIConstants.AUTHORIZATION,GenerateTokenSteps.token).
             body(APIPayloadConstants.updateEmployeePayloadJSON());
      }
    @When("a PUT call is made to update an employee")
    public void a_put_call_is_made_to_update_an_employee() {
        resposne=request.when().put(APIConstants.UDPATE_EMPLOYEE_URI);
        resposne.prettyPrint();
    }
}
