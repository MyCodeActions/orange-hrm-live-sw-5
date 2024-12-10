package live.hrm.orange.pages;

import com.aventstack.extentreports.Status;
import live.hrm.orange.customlisteners.CustomListeners;
import live.hrm.orange.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class ViewSystemUsersPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//h5[normalize-space()='System Users']")
    WebElement systemUsersText;

    @CacheLookup
    @FindBy(xpath = "//span[normalize-space()='(1) Record Found']")
    WebElement recordText;

    @CacheLookup
    @FindBy(xpath = "//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@class='oxd-input oxd-input--active']")
    WebElement userNameField;

    @CacheLookup
    @FindBy(xpath = "//body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]")
    WebElement userRoleDropdown;


    @CacheLookup
    @FindBy(xpath = "//input[@placeholder='Type for hints...']")
    WebElement employeeNameField;

    @CacheLookup
    @FindBy(xpath = "//body/div/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[4]/div/div[2]/div/div")
    WebElement statusRole;

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Search']")
    WebElement searchButton;

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Reset']")
    WebElement resetButton;

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Add']")
    WebElement addButton;

    @CacheLookup
    @FindBy(xpath = "//div[@class='oxd-toast-content oxd-toast-content--success']")
    WebElement successMessage;

    @CacheLookup
    @FindBy(xpath = "(//input[@type = 'checkbox'])[4]")
    WebElement checkBox;

    @CacheLookup
    @FindBy(xpath = " (//i[@class='oxd-icon bi-trash'])[4]")
    WebElement deleteButton;

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Yes, Delete']")
    WebElement okButtonInPopup;

    @CacheLookup
    @FindBy(xpath = "//div[@id = 'oxd-text.oxd-text--p.oxd-text--toast-message.oxd-toast-content-text']")
    WebElement deleteMessage;

    public String getSystemUsersText() {
        Reporter.log("Getting system users text " + systemUsersText);
        CustomListeners.test.log(Status.PASS, "Getting system users text " + systemUsersText);
        return systemUsersText.getText();
    }

    public String getRecordText() {
        Reporter.log("Getting record text " + recordText);
        CustomListeners.test.log(Status.PASS, "Getting record text " + recordText);
        return recordText.getText();
    }

    public void enterUsername(String username) {
        userNameField.sendKeys(username);
        Reporter.log("Entering user name " + userNameField);
        CustomListeners.test.log(Status.PASS, "Entering user name " + userNameField);
    }

    public void selectUserRole(String role) {
        selectByVisibleTextFromDropDown(userRoleDropdown, role);
        Reporter.log("Selecting role from dropdown");
        CustomListeners.test.log(Status.PASS,"Selecting role from dropdown");
    }

    public void enterEmployeeName(String employeeName) {
        employeeNameField.sendKeys(employeeName);
        Reporter.log("Entering employee name");
        CustomListeners.test.log(Status.PASS,"Entering employee name");
    }

    public void selectStatus(String status) {
        selectByVisibleTextFromDropDown(statusRole, status);
        Reporter.log("Selecting status role from dropdown");
        CustomListeners.test.log(Status.PASS,"Selecting status role from dropdown");
    }

    public void clickSearchButton() {
        searchButton.click();
        Reporter.log("Clicking on search button");
        CustomListeners.test.log(Status.PASS,"Clicking on search button");
    }

    public void clickResetButton() {
        resetButton.click();
        Reporter.log("Clicking on reset button");
        CustomListeners.test.log(Status.PASS,"Clicking on reset button");
    }

    public void clickAddButton() {
        addButton.click();
        Reporter.log("Clicking on add button");
        CustomListeners.test.log(Status.PASS,"Clicking on add button");
    }

    public void clickCheckBox(String username) {
        sendTextToElement(checkBox, username);
        Reporter.log("Clicking on checkbox");
        CustomListeners.test.log(Status.PASS,"Clicking on checkbox");
    }

    public void clickDeleteButton() {
        deleteButton.click();
        Reporter.log("Clicking on delete button");
        CustomListeners.test.log(Status.PASS,"Clicking on delete button");
    }

    public void clickOkButtonInPopup() {
        okButtonInPopup.click();
        Reporter.log("Clicking on ok button in pop up");
        CustomListeners.test.log(Status.PASS,"Clicking on ok button in pop up");
    }

    public String verifySuccessfullySavedMessage() {
        Reporter.log("Getting successful message after saved "+successMessage);
        CustomListeners.test.log(Status.PASS,"Getting successful message after saved "+successMessage);
        return getTextFromElement(successMessage);
    }
}
