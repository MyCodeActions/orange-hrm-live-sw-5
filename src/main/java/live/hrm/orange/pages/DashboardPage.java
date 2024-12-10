package live.hrm.orange.pages;

import com.aventstack.extentreports.Status;
import live.hrm.orange.customlisteners.CustomListeners;
import live.hrm.orange.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class DashboardPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//h6[normalize-space()='Dashboard']")
    WebElement dashboardText;

    public boolean isDashboardTextDisplayed(){
        return dashboardText.isDisplayed();
    }

    public String getDashboardText(){
        Reporter.log("Getting text from dashboard");
        CustomListeners.test.log(Status.PASS, "Getting text from dashboard");
        return dashboardText.getText();
    }
}
