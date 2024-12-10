package live.hrm.orange.pages;

import com.aventstack.extentreports.Status;
import live.hrm.orange.customlisteners.CustomListeners;
import live.hrm.orange.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class AddUserPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//h6[normalize-space()='Add User']")
    WebElement addUserText;

    // User Role Dropdown
    @CacheLookup
    @FindBy(xpath = "//body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]")
    WebElement userRoleDropdown;

    @CacheLookup
    @FindBy(xpath = "//input[@placeholder='Type for hints...']")
    WebElement employeeNameField;

    @CacheLookup
    @FindBy(xpath = "//div[@class='oxd-form-row']//div[@class='oxd-grid-2 orangehrm-full-width-grid']//div[@class='oxd-grid-item oxd-grid-item--gutters']//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@class='oxd-input oxd-input--active']")
    WebElement enterUserName;

    // Status Dropdown
    @CacheLookup
    @FindBy(xpath ="//body/div/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[4]/div/div[2]/div/div" )
    WebElement statusRole;

    @CacheLookup
    @FindBy(xpath = "//div[@class='oxd-grid-item oxd-grid-item--gutters user-password-cell']//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@type='password']")
    WebElement passwordFields;

    @CacheLookup
    @FindBy(xpath = "//div[@class='oxd-grid-item oxd-grid-item--gutters']//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@type='password']")
    WebElement confirmPasswordField;

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Save']")
    WebElement saveButton;

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Cancel']")
    WebElement cancelButton;



    public String getAddUserText(){
        Reporter.log("Getting user text");
        CustomListeners.test.log(Status.PASS, "Getting user text");
        return addUserText.getText();
    }

    public void clickOnRole() {
        clickOnElement(userRoleDropdown);
    }

    public void selectRoleAdmin(String key){
        Reporter.log("Selecting admin role");
        CustomListeners.test.log(Status.PASS, "Selecting admin role");
    }

    public void enterEmployeeName(String employeeName) {
        employeeNameField.sendKeys(employeeName);
        Reporter.log("Entering employee name " +employeeNameField);
        CustomListeners.test.log(Status.PASS, "Entering employee name "+employeeNameField);
    }

    public void enterUsername(String username) {
        enterUserName.sendKeys(username);
        Reporter.log("Entering employee name "+enterUserName);
        CustomListeners.test.log(Status.PASS, "Entering employee name "+enterUserName);
    }

    public void selectStatus(String status) {
        selectByVisibleTextFromDropDown(statusRole,status);
        Reporter.log("Selecting status ");
        CustomListeners.test.log(Status.PASS, "Selecting status ");

    }

    public void enterPassword(String password) {
        passwordFields.sendKeys(password);
        Reporter.log("Entering password  "+passwordFields);
        CustomListeners.test.log(Status.PASS, "Entering password  "+passwordFields);
    }

    public void enterConfirmPassword(String confirmPassword){
        confirmPasswordField.sendKeys(confirmPassword);
        Reporter.log("Entering Confirm password  "+confirmPasswordField);
        CustomListeners.test.log(Status.PASS, "Entering Confirm password  "+confirmPasswordField);
    }

    public void clickOnSaveButton(){
        clickOnElement(saveButton);
        Reporter.log("Clicking on save button");
        CustomListeners.test.log(Status.PASS, "Clicking on save button");
    }

    public void clickOnCancelButton(){
        clickOnElement(cancelButton);
        Reporter.log("Clicking on cancle button");
        CustomListeners.test.log(Status.PASS, "Clicking on cancle button");
    }
}
