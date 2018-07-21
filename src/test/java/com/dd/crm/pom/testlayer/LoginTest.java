package com.dd.crm.pom.testlayer;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dd.crm.pom.baselayer.BaseTest;
import com.dd.pom.pagelayer.AfterLoginHome;
import com.dd.pom.pagelayer.LoginPage;

public class LoginTest  extends BaseTest{
	LoginPage login;
	
	AfterLoginHome homepage;
	public LoginTest() {
		
		super();
		System.out.println("In logintest() method");
	}

	@BeforeMethod
     public void setUp() {
    	init();
    	System.out.println("In init() method");
		login = new LoginPage();
      }
	
	@Test(priority=1)
	public void testLoginPageTitle() {
		
		String loginPageTitle = login.validateLoginPageTitle();
		Assert.assertEquals(loginPageTitle, "Free CRM software in the cloud powers sales and customer service");
	}
	
	@Test(priority=2)
	public void testCRMlogoImage() {
		boolean flag = login.validateCRMlogo();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3,dependsOnMethods = {"testLoginPageTitle", "testCRMlogoImage"})
	public void testLogin() {
		homepage = login.validatelogin(envprop.getProperty("username"), envprop.getProperty("password"));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
