package com.OrangeHRM.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;

	@FindBy(xpath = "//input[@placeholder='Username']")
	WebElement username;

	@FindBy(xpath = "//input[@placeholder='Password']")
	WebElement password;

	@FindBy(xpath = "//button[normalize-space()='Login']")
	WebElement loginBtn;

	@FindBy(xpath = "//p[@class='oxd-text oxd-text--p oxd-alert-content-text']")
	WebElement vaidationError;

	@FindBy(xpath = "//div[@class='orangehrm-login-slot-wrapper']//div[1]//div[1]//span[1]")
	WebElement userNameVaidationMessage;

	@FindBy(xpath = "//div[@class='orangehrm-login-form']//div[2]//div[1]//span[1]")
	WebElement userPasswordVaidationMessage;
	
	@FindBy(xpath = "//p[@class='oxd-text oxd-text--p orangehrm-login-forgot-header']")
	WebElement forgotPasswordLink;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void enterUsername(String user) {
		username.sendKeys(user);
	}

	public void enterPassword(String pass) {
		password.sendKeys(pass);
	}

	public void clickLogin() {
		loginBtn.click();
	}

	public void loginToOrangeHRM(String user, String pass) {
		enterUsername(user);
		enterPassword(pass);
		clickLogin();
	}

	public void loginToOrangeHRMWithInvalidUser(String user, String pass) {
		enterUsername(user);
		enterPassword(pass);
		clickLogin();

	}

	public void loginToOrangeHRMWithInvalidPassword(String user, String pass) {
		enterUsername(user);
		enterPassword(pass);
		clickLogin();

	}

	public void loginWithBlankUsernameAndPassword() {
		username.click();
		password.click();
		clickLogin();

	}

	public void loginWithBlankUsername(String pass) {
		username.click();
		password.sendKeys(pass);
		clickLogin();

	}

	public void loginWithBlankPassword(String user) {
		username.sendKeys(user);
		password.click();
		clickLogin();

	}
		
	public boolean  isForgotPasswordLinkVisibleAndEnabled() {
	return	forgotPasswordLink.isDisplayed() &&  forgotPasswordLink.isEnabled();	

	}
	
	public boolean isPasswordMasked() {
		return password.getAttribute("type").equals("password");
	}
	

	

	public String[] getPlaceholders() {
		return new String[] { username.getAttribute("placeholder"), password.getAttribute("placeholder") };
	}

	public boolean isUserNameErrorVisible() {

		return userNameVaidationMessage.isDisplayed();
	}

	public boolean isPasswordErrorVisible() {

		return userPasswordVaidationMessage.isDisplayed();
	}

	public boolean wrongCredentialsError() {

		return vaidationError.isDisplayed();
	}

	public boolean blankCredenatiasValidationMessages() {

		return userNameVaidationMessage.isDisplayed() && userPasswordVaidationMessage.isDisplayed();
	}
	
	public String[] urlAndTitle() {
	    return new String[] { driver.getCurrentUrl(), driver.getTitle() };
	}
}
		
