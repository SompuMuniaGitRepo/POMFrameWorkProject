package com.dd.crm.pom.testlayer;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.dd.crm.pom.baselayer.BaseTest;
import com.dd.crm.pom.util.TestUtil;
import com.dd.pom.pagelayer.AfterLoginHome;
import com.dd.pom.pagelayer.ContactsPage;
import com.dd.pom.pagelayer.LoginPage;

public class ContactsPageTest extends BaseTest {
	
	LoginPage login;
	AfterLoginHome homepage;
	ContactsPage contactpage;
	public static String sheetname ="Contacts";

	public ContactsPageTest() {
		super();
	
	}
	
	@BeforeMethod
	public void setUp() {
		init();
		login = new LoginPage();
  //  	contactpage = new ContactsPage();
		homepage = login.validatelogin(envprop.getProperty("username"), envprop.getProperty("password"));
		contactpage = homepage.clickonContacts();
		
	}
	
	@Test(priority=1)
	public void contactsLabelTest() {
		contactpage.checkContactsLabel();
	}
	
	@Test(priority=2)
	public void ExportlabelTest() {
		contactpage.checkExportLink();
	}
	
	@Test(priority=3,dependsOnMethods= {"contactsLabelTest","ExportlabelTest"})
	public void contactSelecttest() {
		contactpage.selectContactfromTable("chinna Reddy");
	}
	
	@DataProvider
	public Object[] [] getCRMTestData() {
		Object data[] [] = TestUtil.getTestData(sheetname);
		return data;
	}
	
	@Test(priority=4, dataProvider = "getCRMTestData")
	public void newContactcreatetest(String title, String fName, String lName, String company) {
		homepage.clickOnNewContactsLink();
	//	contactpage.createNewContact("Mr.", "Morgan", "Harris", "ABCCompany");
		contactpage.createNewContact(title, fName, lName, company);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
