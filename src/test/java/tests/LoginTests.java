package tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.junit.*;
import pages.LoginPage;
import utils.ExtentManager;
import base.BaseTest;

public class LoginTests extends BaseTest {
    static ExtentReports extent;
    ExtentTest test;

    @BeforeClass
    public static void startReport() {
        extent = ExtentManager.createInstance("test-output/Spark.html");
    }

    @AfterClass
    public static void endReport() {
        extent.flush();
    }

    @Test
    public void testValidLogin() {
        test = extent.createTest("Valid Login Test");
        LoginPage loginPage = new LoginPage(driver);

        loginPage.enterUsername("tomsmith");
        loginPage.enterPassword("SuperSecretPassword!");
        loginPage.clickLogin();

        try {
            Assert.assertTrue(loginPage.getSuccessMessage().contains("You logged into a secure area!"));
            test.log(Status.PASS, "Valid Login Test Passed");
        } catch (AssertionError e) {
            test.log(Status.FAIL, "Valid Login Test Failed");
            throw e;
        }
    }

    @Test
    public void testInvalidLogin() {
        test = extent.createTest("Invalid Login Test");
        LoginPage loginPage = new LoginPage(driver);

        loginPage.enterUsername("wrongusername");
        loginPage.enterPassword("wrongpassword");
        loginPage.clickLogin();

        try {
            Assert.assertTrue(loginPage.getErrorMessage().contains("Your username is invalid!"));
            test.log(Status.PASS, "Invalid Login Test Passed");
        } catch (AssertionError e) {
            test.log(Status.FAIL, "Invalid Login Test Failed");
            throw e;
        }
    }

    @Test
    public void testEmptyFields() {
        test = extent.createTest("Empty Fields Login Test");
        LoginPage loginPage = new LoginPage(driver);

        loginPage.enterUsername("");
        loginPage.enterPassword("");
        loginPage.clickLogin();

        try {
            // The site shows same error for empty fields as invalid input
            Assert.assertTrue(loginPage.getErrorMessage().contains("Your username is invalid!"));
            test.log(Status.PASS, "Empty Fields Login Test Passed");
        } catch (AssertionError e) {
            test.log(Status.FAIL, "Empty Fields Login Test Failed");
            throw e;
        }
    }
}
