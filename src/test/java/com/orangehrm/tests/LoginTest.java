package com.orangehrm.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.OrangeHRM.base.BaseTest;
import com.OrangeHRM.pages.LoginPage;
import com.OrangeHRM.utils.RetryAnalyzer;
import com.orangHRM.dataprovider.DataProviderClass;

public class LoginTest extends BaseTest {



		private LoginPage login;

		@BeforeMethod
		public void setUpLoginPage() {
			login = new LoginPage(driver);
		}

		@Test(description = "Verify login attempt with invalid username shows appropriate error message.",groups = { "smoke"})
		public void testLoginWithInvalidUsername() {
			login.loginToOrangeHRMWithInvalidUser(prop.getProperty("wrongUser"), prop.getProperty("password"));
			Assert.assertTrue(login.wrongCredentialsError(), "Expected error for invalid username is not displayed.");
		}

		@Test(description = "Verify login attempt with invalid password shows appropriate error message.")
		public void testLoginWithInvalidPassword() {
			login.loginToOrangeHRMWithInvalidUser(prop.getProperty("username"), prop.getProperty("wrongPassword"));
			Assert.assertTrue(login.wrongCredentialsError(), "Expected error for invalid password is not displayed.");
		}

		@Test(description = "Verify login attempt with blank username and password shows validation messages.")
		public void testLoginWithBlankCredentials() {
			login.loginWithBlankUsernameAndPassword();
			Assert.assertTrue(login.blankCredenatiasValidationMessages(),
					"Validation messages for blank credentials are not shown.");
		}

		@Test(description = "Verify login attempt with blank username shows username required error.")
		public void testLoginWithBlankUsername() {
			login.loginWithBlankUsername(prop.getProperty("password"));
			Assert.assertTrue(login.isUserNameErrorVisible(), "Username required error is not displayed.");
		}

		@Test(description = "Verify login attempt with blank password shows password required error.")
		public void testLoginWithBlankPassword() {
			login.loginWithBlankPassword(prop.getProperty("username"));
			Assert.assertTrue(login.isPasswordErrorVisible(), "Password required error is not displayed.");
		}

		@Test(description = "Verify that the username and password placeholders are correctly displayed on the login page.")
		public void testLoginFieldPlaceholders() {
			String[] placeholders = login.getPlaceholders();
			Assert.assertEquals(placeholders[0], "Username", "Username placeholder text mismatch.");
			Assert.assertEquals(placeholders[1], "Password", "Password placeholder text mismatch.");
		}

		@Test(description = "Verify that the 'Forgot your password?' link is visible and enabled on the login page.")
		public void testForgotPasswordLinkVisibility() {
			Assert.assertTrue(login.isForgotPasswordLinkVisibleAndEnabled(),
					"Forgot Password link is either not visible or not enabled.");
		}

		@Test(description = "Verify that the current page URL and title match the expected values.")
		public void testPageUrlAndTitle() {
			String[] urlAndTitle = login.urlAndTitle();
			Assert.assertEquals(urlAndTitle[0], prop.getProperty("baseUrl"),
					"URL does not match the expected base URL.");
			Assert.assertEquals(urlAndTitle[1], prop.getProperty("pageTitle"),
					"Page title does not match the expected title.");
		}

		
		@Test(
			    description = "Verify that the password input field is masked",
			    retryAnalyzer = RetryAnalyzer.class
			)
		public void testPasswordFieldIsMasked() {
			LoginPage login = new LoginPage(driver);
			Assert.assertTrue(login.isPasswordMasked(), "Password field is not masked.");
	
		}

		@Test(dataProvider = "loginData", dataProviderClass = DataProviderClass.class)
		public void testLogin(String username, String password) {
			LoginPage login = new LoginPage(driver);
			login.loginToOrangeHRMWithInvalidUser(username, password);

		}
	}


