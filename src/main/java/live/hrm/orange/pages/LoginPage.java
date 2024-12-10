package live.hrm.orange.pages;

import com.aventstack.extentreports.Status;
import live.hrm.orange.customlisteners.CustomListeners;
import live.hrm.orange.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class LoginPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//input[@placeholder='Username']")
    WebElement usernameField;

    @CacheLookup
    @FindBy(xpath = "//input[@placeholder='Password']")
    WebElement passwordField;

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Login']")
    WebElement loginButton;

    @CacheLookup
    @FindBy(xpath = "//h5[normalize-space()='Login']")
    WebElement loginPanelText;

    @CacheLookup
    @FindBy(xpath = "//p[@class='oxd-text oxd-text--p oxd-alert-content-text']")
    WebElement errorMessage;

    @FindBy(css = ".oxd-userdropdown-tab")
    WebElement optionTab;

    @FindBy(xpath = "//a[normalize-space()='Logout']")
    WebElement logout;


    public void enterUserName(String username) {
        sendTextToElement(usernameField, username);
        Reporter.log("Entering username "+usernameField);
        CustomListeners.test.log(Status.PASS, "Entering username "+usernameField);
    }

    public void enterPassword(String password) {
        sendTextToElement(passwordField, password);
        Reporter.log("Entering password "+passwordField);
        CustomListeners.test.log(Status.PASS, "Entering password "+passwordField);
    }

    public void clickLoginButton() {
        loginButton.click();
        Reporter.log("Clicking on login  "+loginButton);
        CustomListeners.test.log(Status.PASS, "Clicking on login  "+loginButton);
    }

   public boolean isLoginPanelDisplay(){
        return loginPanelText.isDisplayed();
   }

   public String getErrorMessage(){
       Reporter.log("Getting error message  "+errorMessage);
       CustomListeners.test.log(Status.PASS, "Getting error message  "+errorMessage);
       return getTextFromElement(errorMessage);
   }

   public void logOutFromHomePage() {
        clickOnElement(optionTab);
        clickOnElement(logout);
       Reporter.log("In dropdown clicking on Logout");
       CustomListeners.test.log(Status.PASS, "In dropdown clicking on Logout");
   }
}
