package tests;

import base.BaseTest;
import org.junit.Test;
import pages.LoginPage;

import static org.junit.Assert.assertTrue;

public class LoginTests extends BaseTest {

    @Test
    public void testValidLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("tomsmith");
        loginPage.enterPassword("SuperSecretPassword!");
        loginPage.clickLogin();

        assertTrue(loginPage.getSuccessMessage().contains("You logged into a secure area!"));
    }

    @Test
    public void testInvalidLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("wrongusername");
        loginPage.enterPassword("wrongpassword");
        loginPage.clickLogin();

        assertTrue(loginPage.getErrorMessage().contains("Your username is invalid!"));
    }

    @Test
    public void testEmptyFields() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("");
        loginPage.enterPassword("");
        loginPage.clickLogin();

        assertTrue(loginPage.getErrorMessage().contains("Your username is invalid!")); // actual behavior
    }
}
