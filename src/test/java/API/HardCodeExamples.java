package API;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;


import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HardCodeExamples {
    String baseURI = RestAssured.baseURI = "http://hrm.syntaxtechs.net/syntaxapi/api";
    String token = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE2ODQ4ODc4NTYsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTY4NDkzMTA1NiwidXNlcklkIjoiNTQ5MCJ9.kTsvrtTHUJ_uOSAIAJCJPiGGf3hzCPVQOD_uBhncTnM";

    @Test
    public void cupdateEmployee(){
        RequestSpecification preparedRequest=given().
                header("Content-Type","application/json").
                header("Authorization",token).body("{\n" +
                        "   \n" +
                        "        \"employee_id\": \"54744A\",\n" +
                        "        \"emp_firstname\": \"Tony\",\n" +
                        "        \"emp_middle_name\": \"Anthony\",\n" +
                        "        \"emp_lastname\": \"Anthonyson\",\n" +
                        "        \"emp_gender\": \"M\",\n" +
                        "        \"emp_birthday\": \"2022-02-22\",\n" +
                        "        \"emp_job_title\": \"HR\",\n" +
                        "        \"emp_status\": \"Retired\"\n" +
                        "    \n" +
                        "}");
        Response response=preparedRequest.when().put("/updateEmployee.php");
        response.prettyPrint();
        response.then().assertThat().statusCode(201);
    }
    @Test
    public void bgetCreatedEmployee(){
        RequestSpecification preparedRequest=given().
                header("Content-Type","application/json").
                header("Authorization",token).
                queryParam("employee_id","54744A");
        Response response=preparedRequest.when().get("/getOneEmployee.php");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);

    }
    @Test
    public void acreateEmployee(){
        RequestSpecification preparedRequest=given().
                header("Content-Type","application/json").
                header("Authorization",token).
                body("{\n" +
                        "   \"emp_firstname\": \"Tony\",\n" +
                        "  \"emp_lastname\": \"Anthonyson\",\n" +
                        "  \"emp_middle_name\": \"Anthony\",\n" +
                        "  \"emp_gender\": \"M\",\n" +
                        "  \"emp_birthday\": \"2023-05-22\",\n" +
                        "  \"emp_status\": \"Confirmed\",\n" +
                        "  \"emp_job_title\": \"Engineer\"\n" +
                        "}");
        Response response=preparedRequest.when().post("/createEmployee.php");
        response.then().assertThat().statusCode(201);
        response.prettyPrint();
        response.then().assertThat().body("Employee.emp_firstname", equalTo("Tony"));
        System.out.println("My test case is passed");
        response.then().assertThat().header("Content-Type", "application/json");
        System.out.println("The Test has passed");
    }
}
