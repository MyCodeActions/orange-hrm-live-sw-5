package live.hrm.orange.testsuite;

import live.hrm.orange.excelutility.ExcelUtility;
import live.hrm.orange.pages.*;
import live.hrm.orange.testbase.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import resources.testdata.TestData;

// @Listeners(CustomListeners.class)
public class UserTest extends BaseTest {

    public static final String FILE_PATH = System.getProperty("user.dir") + "/src/test/java/resources/testdata/ExcelRead.xlsx";


    @BeforeClass
    public void getExcel() {
        try {
            //Tell the code about the location of the excel file
            ExcelUtility.setExcelFile(FILE_PATH, "UserTest");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @DataProvider(name = "dataFromExcel")
    public Object[][] getData() {
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


    @Test(groups = "sanity")
    public void adminShouldAddUserSuccessFully() {
        //Login to Application
        loginPage.enterUserName("Admin");
        loginPage.enterPassword("admin123");
        loginPage.clickLoginButton();

        // Navigate to Admin and add a user
        homePage.clickAdminTab();
        Assert.assertEquals(viewSystemUsersPage.getSystemUsersText(), "System Users");

        //click On "Add" button
        viewSystemUsersPage.clickAddButton();

        String expectedText = "Add User";
        String actualText = driver.findElement(By.xpath("//h6[normalize-space()='Add User']")).getText();
        Assert.assertEquals(expectedText, actualText);

        addUserPage.clickOnRole();
        addUserPage.selectRoleAdmin("Admin");
        addUserPage.enterEmployeeName("Ananya Dash");
        addUserPage.enterUsername("AnanyaDash789");
        //  addUserPage.clickOnElement(By.cssSelector("body > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > form:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1)"));
        //  addUserPage.selectStatus("Disabled");
        addUserPage.enterPassword("Test@123");
        addUserPage.enterConfirmPassword("Test@123");
        addUserPage.clickOnSaveButton();
    }

    @Test(groups = {"smoke"})
    public void searchTheUserCreatedAndVerifyIt(String username, String userRole, String employeeName, String status) {

        //Login to Application
        loginPage.enterUserName("Admin");
        loginPage.enterPassword("admin123");
        loginPage.clickLoginButton();
        //click On "Admin" Tab
        homePage.clickAdminTab();
        //Verify "System Users" Text
        Assert.assertEquals(viewSystemUsersPage.getSystemUsersText(), "System Users");

        viewSystemUsersPage.enterUsername(username);
        viewSystemUsersPage.selectUserRole(userRole);
        viewSystemUsersPage.selectStatus(status);
        viewSystemUsersPage.clickSearchButton();

        // Verify the user is in the result list
        Assert.assertTrue(driver.getPageSource().contains(username));
    }

    //   @Test(groups = {"regression"})
    public void verifyThatAdminShouldDeleteTheUserSuccessfully() {

        //Login to Application
        loginPage.enterUserName("Admin");
        loginPage.enterPassword("admin123");
        loginPage.clickLoginButton();

        //click On "Admin" Tab
        homePage.clickAdminTab();
        //Verify "System Users" Text
        Assert.assertEquals(viewSystemUsersPage.getSystemUsersText(), "System Users");

        // Use username of the user created above
        viewSystemUsersPage.enterUsername("AnanyaD123");
        viewSystemUsersPage.selectUserRole("Admin");
        viewSystemUsersPage.selectStatus("Disable");
        viewSystemUsersPage.clickSearchButton();

        // Verify the user is in the result list
        Assert.assertTrue(driver.getPageSource().contains("AnanyaD123"));

        viewSystemUsersPage.clickCheckBox("AnanyaD123");
        viewSystemUsersPage.clickDeleteButton();
        viewSystemUsersPage.clickOkButtonInPopup();

        //verify message "Successfully Deleted"


    }

     @Test(dataProvider = "dataFromExcel", dataProviderClass = TestData.class, groups = {"regression"})
    public void searchTheUserAndVerifyTheMessageRecordFound(String username, String userRole, String employeeName, String status) {

        //Login to Application
        loginPage.enterUserName("Admin");
        loginPage.enterPassword("admin123");
        loginPage.clickLoginButton();

        //click On "Admin" Tab
        homePage.clickAdminTab();
        //Verify "System Users" Text
        Assert.assertEquals(viewSystemUsersPage.getSystemUsersText(), "System Users");

        viewSystemUsersPage.enterUsername(username);
        viewSystemUsersPage.selectUserRole(userRole);
        viewSystemUsersPage.enterEmployeeName(employeeName);
        viewSystemUsersPage.selectStatus(status);
        viewSystemUsersPage.clickSearchButton();
        Assert.assertEquals(viewSystemUsersPage.getRecordText(), "(1) Record Found");
        Assert.assertTrue(driver.getPageSource().contains(username));
        viewSystemUsersPage.clickResetButton();
    }
}






















