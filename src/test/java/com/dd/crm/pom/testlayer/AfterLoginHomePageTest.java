package com.dd.crm.pom.testlayer;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dd.crm.pom.baselayer.BaseTest;
import com.dd.pom.pagelayer.AfterLoginHome;
import com.dd.pom.pagelayer.ContactsPage;
import com.dd.pom.pagelayer.LoginPage;

public class AfterLoginHomePageTest  extends BaseTest{
//	AfterLoginHome login;
	LoginPage login;
	
 	AfterLoginHome homepage;
 	ContactsPage contactpage;
	public AfterLoginHomePageTest() {
		
		super();
		System.out.println("In AfterLoginHomePageTest() method");
	}

	@BeforeMethod
     public void setUp() {
    	init();
    	System.out.println("In init() method");
    	login = new LoginPage();
    	contactpage = new ContactsPage();
    	homepage = login.validatelogin(envprop.getProperty("username"), envprop.getProperty("password"));
      }
	
	@Test(priority=1)
	public void HomePageTitletest() {
		
		String landPageTitle = homepage.testHomePageTitle();
		Assert.assertEquals(landPageTitle, "CRMPRO", "Titles do not match");
	}
	
	@Test(priority=2)
	public void VerifylandPageUser() {
		
		boolean landPageUser = homepage.testHomePageUser();
		Assert.assertTrue(landPageUser);
	}
	
	@Test(priority=3, dependsOnMethods = {"HomePageTitletest", "VerifylandPageUser"})
	public void contactsPageLinkClickTest()  {
		contactpage = homepage.clickonContacts();
		
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
