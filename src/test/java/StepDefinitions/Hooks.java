package StepDefinitions;

import Utils.CommonMethods;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends CommonMethods {
    @Before
    public void preCondition(){
        openBrowserAndLaunchApplication();
    }
    @Before(value = "@empSearch")
    public void empSearchPreCon(){
        System.out.println("This is Employee Search test");
    }
    @After
    public void postConditions(Scenario scenario)
    {
        byte[] pic;
        if(scenario.isFailed()){
            pic=takeScreenshot("failed/" +scenario.getName());
        }else {
            pic=takeScreenshot("passwed/"+scenario.getName());
        }

        //attaches screenshot to reports
        scenario.attach (pic,"image/png", scenario.getName());


        closeBrowser();

    }
}
