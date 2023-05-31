package StepDefinitions;

import Pages.LoginPage;
import Utils.CommonMethods;
import Utils.ConfigReader;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Login extends CommonMethods {


   /* @Given("open the browser and launch HRMS")
    public void open_the_browser_and_launch_hrms() {
        CommonMethods.openBrowserAndLaunchApplication();
    }*/
    @When("user enters valid email {string} and valid password {string}")
    public void user_enters_valid_email_and_valid_password(String string, String string2) {

      sentText(login.usernameTextBox,string);


      sentText(login.passwordTextBox,string2);
    }

    @When("user enters username and pasword and verifies login")
    public void user_enters_username_and_pasword_and_verifies_login(DataTable dataTable) {
        List< Map <String, String>> userCreds=dataTable.asMaps();
        for (Map<String, String> userCred : userCreds) {
            String username = userCred.get("username");
            String password = userCred.get("password");

            sentText(login.usernameTextBox, username);

            sentText(login.passwordTextBox, password);

            doClick(login.loginbtn);


            doClick(login.welcomeIcon);


            doClick(login.logoutLink);
        }
    }

    @When("click on login button")
    public void click_on_login_button() {

        doClick(login.loginbtn);
    }
    @Then("user is logged in successfully")
    public void user_is_logged_in_successfully() {
       boolean userLoggedin=driver.findElement(By.xpath("//*[contains(text(), 'Welcome')]")).isDisplayed();
       if (userLoggedin){
           System.out.println("User is logged in successfully");
       }
    }


}
