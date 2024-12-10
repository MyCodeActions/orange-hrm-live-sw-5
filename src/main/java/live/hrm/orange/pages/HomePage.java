package live.hrm.orange.pages;

import com.aventstack.extentreports.Status;
import live.hrm.orange.customlisteners.CustomListeners;
import live.hrm.orange.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class HomePage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//img[@alt='client brand banner']")
    WebElement orangeHRMLogo;

    @FindBy(xpath = "//img[@alt='client brand banner']")
    WebElement homepageLogo;

    @CacheLookup
    @FindBy(xpath = "//li[1]//a[1]//span[1]")
    WebElement adminTab;

    @CacheLookup
    @FindBy(xpath = "//span[normalize-space()='PIM']")
    WebElement pimTab;

    @CacheLookup
    @FindBy(xpath = "//span[normalize-space()='Leave']")
    WebElement leaveTab;

    @CacheLookup
    @FindBy(xpath = "//span[text() = 'Dashboard']")
    WebElement dashboardTab;

    @FindBy(xpath = "//span[text() = 'Dashboard']")
    WebElement dashboard;

    @FindBy(xpath = "//a[contains(text(),'Logout')]")
    WebElement  logoutOption;

    public boolean isLogoDisplayed(){
        return orangeHRMLogo.isDisplayed();
    }

    public void clickAdminTab(){
        adminTab.click();
        Reporter.log("Clicking on admin tab");
        CustomListeners.test.log(Status.PASS, "Clicking on admin tab");
    }

    public void clickOnPimTab(){
        pimTab.click();
        Reporter.log("Clicking on pim tab");
        CustomListeners.test.log(Status.PASS, "Clicking on pim tab");
    }

    public void clickOnLeaveTab(){
        leaveTab.click();
        Reporter.log("Clicking on leave tab");
        CustomListeners.test.log(Status.PASS, "Clicking on leave tab");
    }

    public void clickOnDashboardTab(){
        dashboardTab.click();
        Reporter.log("Clicking on dashboard tab");
        CustomListeners.test.log(Status.PASS, "Clicking on dashboard tab");
    }

    public boolean isDashboardDisplayed(){
        return dashboard.isDisplayed();
    }

    public void clickOnHomePageLogo(){
        homepageLogo.click();
        Reporter.log("Clicking on homepage logo");
        CustomListeners.test.log(Status.PASS, "Clicking on homepage logo");

    }
    public void selectLogOutOption(){
        logoutOption.click();
        Reporter.log("Clicking on log out");
        CustomListeners.test.log(Status.PASS, "Clicking on log out");
    }
}
