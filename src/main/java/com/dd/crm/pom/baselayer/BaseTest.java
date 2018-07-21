package com.dd.crm.pom.baselayer;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.dd.crm.pom.util.TestUtil;
import com.dd.crm.pom.util.testEventListener;

public class BaseTest {

    public static  WebDriver driver;	
	//Reading properties file
	public static  Properties envprop ;
	//= new Properties();
	public  static EventFiringWebDriver e_driver;
	public static testEventListener eventListener;
	
	public BaseTest()  {
	try {
		envprop = new Properties();
		FileInputStream fs = new FileInputStream("C:\\Users\\Debarati\\Desktop\\Selenium_Workspace\\FreeCRMTestAutomation\\src\\main\\java\\com\\dd\\crm\\pom\\env\\vars\\config.properties");
		envprop.load(fs);
		System.out.println("Property file caught in an object");
		System.out.println(envprop.getProperty("url"));
	    
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	   }
	
     }
	
	
	public static void  init() {
		String browserName = envprop.getProperty("browser");
		if (browserName.equalsIgnoreCase("Chrome"))  {
			System.setProperty("webdriver.chrome.driver", "F:\\Softwares\\chromedriver_win32\\chromedriver_win32_2ndMarch\\chromedriver.exe");
			driver = new ChromeDriver();
			
			e_driver = new EventFiringWebDriver(driver);
			// Now create object of EventListerHandler to register it with EventFiringWebDriver
			eventListener = new testEventListener();
			e_driver.register(eventListener);
			driver = e_driver;
			
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_TIMEOUT, TimeUnit.SECONDS);
			
		}
		else
			System.out.println("Browser is not chrome");
		
		driver.get(envprop.getProperty("url"));
	}
}	
