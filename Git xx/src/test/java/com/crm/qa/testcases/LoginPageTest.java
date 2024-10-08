package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;

	public LoginPageTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@BeforeMethod
	public void setUp() throws IOException {
		
		initialization();
		loginPage = new LoginPage();
	}

	@Test(priority=2)
	public void loginPageTitleTest() {
	String title =	loginPage.ValidateloginPageTitle();
	Assert.assertEquals(title, "Free CRM software for customer relationship management, sales, and support.");

	}
	
	@Test(priority=3)
	public void crmLogoImgTest() {
		boolean flag =loginPage.ValidateCRMImage();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=1)
	public void LoginTest() throws IOException {
		homePage = loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
