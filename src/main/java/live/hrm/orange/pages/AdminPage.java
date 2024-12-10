package live.hrm.orange.pages;

import com.aventstack.extentreports.Status;
import live.hrm.orange.customlisteners.CustomListeners;
import live.hrm.orange.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class AdminPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//span[normalize-space()='User Management']")
    WebElement userManagementTab;

    @CacheLookup
    @FindBy(xpath = "//span[normalize-space()='Job']")
    WebElement jobTab;

    @CacheLookup
    @FindBy(xpath = "//span[normalize-space()='Organization']")
    WebElement organizationTab;


    public void clickOnUserManagementTab(){
        userManagementTab.click();
        Reporter.log("Clicking on user management tab");
        CustomListeners.test.log(Status.PASS, "Clicking on user management tab");
    }

    public void clickOnJobTab(){
        jobTab.click();
        Reporter.log("Clicking on Job tab");
        CustomListeners.test.log(Status.PASS, "Clicking on job tab");
    }

    public void clickOnOrganizationTab(){
       organizationTab.click();
        Reporter.log("Clicking on organization tab");
        CustomListeners.test.log(Status.PASS, "Clicking on organization tab");
    }
}
