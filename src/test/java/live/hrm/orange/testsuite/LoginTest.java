package live.hrm.orange.testsuite;


import live.hrm.orange.excelutility.ExcelUtility;
import live.hrm.orange.pages.*;
import live.hrm.orange.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import resources.testdata.TestData;

// @Listeners(CustomListeners.class)
public class LoginTest extends BaseTest {
    public static final String FILE_PATH = System.getProperty("user.dir") + "/src/test/java/resources/testdata/ExcelRead.xlsx";
    public void getExcel(){
        try {
            //Tell the code about the location of the excel file
            ExcelUtility.setExcelFile(FILE_PATH, "LoginTest");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @DataProvider(name = "dataFromExcel")
    public Object[][] getInvalidLoginDataFromExcel(){
        return ExcelUtility.getTestData("Invalid_Login");
    }

   LoginPage loginPage;
    HomePage homePage;
    AdminPage adminPage;
    ViewSystemUsersPage viewSystemUsersPage;
    AddUserPage addUserPage;

    @BeforeMethod
    public void inIt() {
        loginPage = new LoginPage();
        adminPage = new AdminPage();
        homePage = new HomePage();
        viewSystemUsersPage = new ViewSystemUsersPage();
        addUserPage = new AddUserPage();
    }

    @Test(groups = {"sanity"})
    public void verifyUserShouldLoginSuccessFully() {
        //Login to Application
        loginPage.enterUserName("Admin");
        loginPage.enterPassword("admin123");
        loginPage.clickLoginButton();

        //verify welcome message
        Assert.assertTrue(homePage.isLogoDisplayed());
    }

    @Test(groups = {"smoke"})
    public void verifyThatTheLogoDisplayOnHomePage() {
        loginPage.enterUserName("Admin");
        loginPage.enterPassword("admin123");
        loginPage.clickLoginButton();
        Assert.assertTrue(homePage.isLogoDisplayed());
    }

    @Test(groups = {"regression"}, retryAnalyzer = RetryAnalyser.class)
    public void verifyUserShouldLogOutSuccessFully() {
        loginPage.enterUserName("Admin");
        loginPage.enterPassword("admin123");
        loginPage.clickLoginButton();
        loginPage.logOutFromHomePage();
        Assert.assertTrue(loginPage.isLoginPanelDisplay());
    }

    @Test(dataProviderClass = TestData.class,groups = {"regression"})
    public void verifyErrorMessageWithInvalidCredentials() {
        loginPage.enterUserName("Admin");
        loginPage.enterPassword("admin12");
        loginPage.clickLoginButton();

        String expectedText = "Invalid credentials";
        String actualText = loginPage.getErrorMessage();
        Assert.assertEquals(actualText, expectedText, "Invalid credentials");
    }
}


