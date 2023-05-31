package Pages;

import Utils.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.openqa.selenium.support.PageFactory.initElements;

public class AddEmployeePage extends CommonMethods {
    @FindBy(id="menu_pim_viewPimModule")
    public WebElement pimTab;

    @FindBy(id="menu_pim_addEmployee")
    public WebElement employeebtn;

    @FindBy(xpath = "//*[@id='firstName']")
    public WebElement fNameTxtBox;

    @FindBy(xpath ="//*[@id='middleName']" )
    public WebElement mNameTxtBox;

    @FindBy(xpath = "//*[@id='lastName']")
    public WebElement lNameTxtBox;

    @FindBy(xpath = "//*[@id='btnSave']")
    public WebElement savebttn;

    @FindBy(xpath = "//*[@id='employeeId']")
    public WebElement empid_locator;

    public AddEmployeePage() {
        initElements(driver, this);
    }

}
