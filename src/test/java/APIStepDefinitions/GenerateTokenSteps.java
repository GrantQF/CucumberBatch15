package APIStepDefinitions;

import Utils.APIConstants;
import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class GenerateTokenSteps {
    String baseURI = RestAssured.baseURI = "http://hrm.syntaxtechs.net/syntaxapi/api";
    public static String token;
    @Given("a JWT is generated")
    public void a_JWT_is_gernerated(){
        RequestSpecification generateTokenRequest=given().
                header(APIConstants.HEADER_KEY_CONTENT_TYPE,APIConstants.HEADER_VALUE_CONTENT_TYPE).
                body("{\n" +
                        "\"email\": \"15batch15@gmail.com\",\n" +
                        "    \"password\": \"test@123\"\n" +
                        "\n" +
                        "}");
        Response response=generateTokenRequest.when().post("/generateToken.php");
        token ="Bearer "+ response.jsonPath().getString("token");
        System.out.println(token);
    }
}
