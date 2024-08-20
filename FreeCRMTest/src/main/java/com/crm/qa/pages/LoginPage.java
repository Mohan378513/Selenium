package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {
	// Page Factory - Object Repository

	@FindBy(name = "username")
	WebElement username1;

	@FindBy(name = "password")
	WebElement password1;

	@FindBy(xpath = "//input[@type='submit']")
	WebElement LoginBtn;

	@FindBy(xpath = "//a[contains(text(),'Sign Up')]")
	WebElement SignupBtn;

	@FindBy(xpath = "//img[@class='img-responsive'][1]")
	WebElement crmLogo;

	// Initializing the Page Objects:
	public LoginPage() throws IOException {
		super();

		PageFactory.initElements(driver, this);
	}

	// Actions
	public String ValidateloginPageTitle() {
		return driver.getTitle();

	}
	
	public boolean ValidateCRMImage() {
		return crmLogo.isDisplayed();
	}
	
	public HomePage login(String un, String pwd) throws IOException {
		username1.sendKeys(un);
		password1.sendKeys(pwd);
		LoginBtn.click();
		return new HomePage();
		
	}

}
