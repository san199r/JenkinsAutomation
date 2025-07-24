package tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.junit.*;
import pages.LoginPage;
import utils.ExtentManager;
import base.BaseTest;

import java.io.File;

public class LoginTests extends BaseTest {
    static ExtentReports extent;
    ExtentTest test;

    @BeforeClass
    public static void startReport() {
        extent = ExtentManager.createInstance("test-output/extent-report.html");
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

        Assert.assertTrue(loginPage.getSuccessMessage().contains("You logged into a secure area!"));
        test.log(Status.PASS, "Valid Login Test Passed");
    }
}
