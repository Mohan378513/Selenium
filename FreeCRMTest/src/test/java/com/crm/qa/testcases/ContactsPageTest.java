package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;

	public ContactsPageTest() throws IOException {
		super();

	}

	@BeforeMethod
	public void setUp() throws IOException {

		initialization();
		testUtil = new TestUtil();
		contactsPage = new ContactsPage();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil.switchToFrame();
		contactsPage=homePage.clickOnContactsLink();
		
	}

	@Test(priority=1)
	public void verifyContactsLabelTest() {
		Assert.assertTrue(contactsPage.verifyContactsLabel(), "contacts label is missing on the page");
	}
    @Test(priority=2)
	public void selectSingleContactsTest() {
		contactsPage.selectContactsbyName("	Alex Berth ");
	}
    @Test(priority=3)
	public void selectMultiContactsTest() {
		contactsPage.selectContactsbyName("Apple Malvia  ");
		contactsPage.selectContactsbyName("David Cris ");
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
