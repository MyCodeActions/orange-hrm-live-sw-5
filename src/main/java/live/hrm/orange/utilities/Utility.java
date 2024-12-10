package live.hrm.orange.utilities;

import live.hrm.orange.browserfactory.ManageBrowser;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


public class Utility extends ManageBrowser {

    /**
     * This method will get text from element
     */
    public String getTextFromElement(By by) {
        return driver.findElement(by).getText();
    }

    public String getTextFromElement(WebElement element) {
        return element.getText();
    }

    /**
     * This method will click on given locator path
     */
    public void clickOnElement(By by) {
        WebElement loginLink = driver.findElement(by);
        loginLink.click();
    }

    public void clickOnElement(WebElement element) {
        element.click();
    }

    /**
     * This method will select dropdown
     */
    public void selectFromDropDown(By by, String text) {
        WebElement dropdown = driver.findElement(by);
        Select select = new Select(dropdown);
        select.selectByVisibleText(text);
    }

    // This method will get list of we elements
    public List<WebElement> getWebElements(By by) {
        return driver.findElements(by);
    }

    public void sendTextToElement(WebElement element, String str) {
        element.sendKeys(str);
    }

    public void selectByVisibleTextFromDropDown(WebElement element, String text) {
        new Select(element).selectByVisibleText(text);
    }

    /**
     * This method is for hover mouse on element and click it
     */
    public void mouseHoverAndClick(By by) {
        WebElement element = driver.findElement(by);
        new org.openqa.selenium.interactions.Actions(driver).moveToElement(element).click().perform();
    }

    /**
     * This method is for hover mouse on element
     */
    public void mouseToElement(By by) {
        Actions actions = new Actions(driver);
        WebElement element = driver.findElement(by);
        actions.moveToElement(element).perform();
    }

    public void selectByIndexFromDropdown(By by, int value) {
        WebElement dropdownForProcessor = driver.findElement(by);
        Select select1 = new Select(dropdownForProcessor);
        select1.selectByIndex(value);
    }

    public void sendTextToElement(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }


    //************************** ScreenShot Methods *********************************************//
    public int generateRandomNumber() {
        return (int) (Math.random() * 5000 + 1);

    }

    /**
     * This method will generate random string
     */
    public static String getRandomString(int length) {
        StringBuilder sb = new StringBuilder();
        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        for (int i = 0; i < length; i++) {
            int index = (int) (Math.random() * characters.length());
            sb.append(characters.charAt(index));
        }
        return sb.toString();
    }

    /**
     * This method will take screenshot
     */
    public static void takeScreenShot() {
        String filePath = System.getProperty("user.dir") + "/src/main/java/com/nopcommerce/demo/screenshots/";
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File scr1 = screenshot.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scr1, new File(filePath + getRandomString(10) + ".jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String currentTimeStamp() {
        Date d = new Date();
        return d.toString().replace(":", "_").replace(" ", "_");
    }

    public static String getScreenshot(WebDriver driver, String screenshotName) {
        String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);

        // After execution, you could see a folder "FailedTestsScreenshots" under screenshot folder
        String destination = System.getProperty("user.dir") + "/src/main/java/com/demo/nopcommerce/screenshots/" + screenshotName + dateName + ".png";
        File finalDestination = new File(destination);
        try {
            FileUtils.copyFile(source, finalDestination);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return destination;
    }

    /*
     *Screenshot methods
     */
    public static String takeScreenShot(String fileName) {
        String filePath = System.getProperty("user.dir") + "/test-output/html/";
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File scr1 = screenshot.getScreenshotAs(OutputType.FILE);
        String imageName = fileName + currentTimeStamp() + ".jpg";
        String destination = filePath + imageName;
        try {
            FileUtils.copyFile(scr1, new File(destination));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return destination;
    }
}
//    public static String takeScreenShot(String fileName) {
//        String filePath = System.getProperty("user.dir") + "/test-output/html/";
//        TakesScreenshot screenshot = (TakesScreenshot) driver;
//        File scr1 = screenshot.getScreenshotAs(OutputType.FILE);
//        String imageName = fileName + currentTimeStamp() + ".jpg";
//        String destination = filePath + imageName;
//        try {
//            FileUtils.copyFile(scr1, new File(destination));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return destination;
//    }

