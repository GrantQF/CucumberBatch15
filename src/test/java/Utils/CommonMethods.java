package Utils;

import StepDefinitions.PageInitializer;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;

import static org.apache.commons.io.FileUtils.copyFile;

public class CommonMethods extends PageInitializer {
    public static WebDriver driver;

    public static void openBrowserAndLaunchApplication() {
        ConfigReader.readProperties();

        String browserType = ConfigReader.getPropertyValue("browserType");
        switch (browserType) {
            case "Chrome":
                ChromeOptions ops=new ChromeOptions();
                ops.addArguments("--no-sandbox--");
                ops.addArguments("--remote-allow-origins=*");
                if(ConfigReader.getPropertyValue("Headless").equals("true")){
                    ops.addArguments("headless=new");
                }
                driver = new ChromeDriver();
                break;

            case "Firefox":
                driver = new FirefoxDriver();
                break;

            case "IE":
                driver = new InternetExplorerDriver();
                break;

            default:
                driver = new EdgeDriver();
                break;

        }

        driver.manage().window().maximize();
        driver.get(ConfigReader.getPropertyValue("url"));
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(Constants.WAIT_TIME));
        initializePageObjects();

        DOMConfigurator.configure("log4j.xml");
        Log.startTestCase("Start of TestCase");
        Log.info("Test case is running");
        Log.warning("Test case may failed");


    }
    public static void closeBrowser(){
        Log.info("Test case had finished.");
        Log.endTestCase("End of TestCase");
        driver.close();
    }

    public static void doClick(WebElement element){
        element.click();
    }
    public static void sentText(WebElement element, String words){
        element.clear();
        element.sendKeys(words);
    }

    public static Select clickOnDropdown(WebElement element){
        Select select = new Select(element);
        return select;
    }
    public static void selectByValue(WebElement element, String value){
        clickOnDropdown(element).selectByValue(value);
    }

    public static void selectbyVisibleText(WebElement element, String text){
        clickOnDropdown(element).selectByVisibleText(text);
    }

    public static void selectByIndex(WebElement element, int index){
        clickOnDropdown(element).selectByIndex(index);
    }

    public static void selectByOption(WebElement element, String text){
        List<WebElement> options=clickOnDropdown(element).getOptions();
        for (WebElement option : options) {
            String optionTxt=option.getText();
            if(optionTxt.equals(text)){
                doClick(option);
            }
        }
    }

    public static byte [] takeScreenshot(String imageName){
        //This casts the webDriver instance 'driver' to take (interface)
        TakesScreenshot ts= (TakesScreenshot)driver;

        //This stores the screenshots in an array of called picBytes
        byte[] picBytes= ts.getScreenshotAs(OutputType.BYTES);

        //This stores the screenshots in a file called sourcePath
        File sourcePath=ts.getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(sourcePath, new File(Constants.SCREENSHOT_FILEPATH+imageName+getTimeStamp("yyyy-MM-dd-HH-mm-ss")+".png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return picBytes;

    }

    public static String getTimeStamp(String pattern){
        Date date =new Date();
        SimpleDateFormat sdf=new SimpleDateFormat(pattern);
        return sdf.format(date);

    }

}