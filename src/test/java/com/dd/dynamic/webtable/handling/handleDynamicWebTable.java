package com.dd.dynamic.webtable.handling;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.dd.crm.pom.util.TestUtil;

public class handleDynamicWebTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "F:\\Softwares\\chromedriver_win32\\chromedriver_win32_2ndMarch\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_TIMEOUT, TimeUnit.SECONDS);
		
		driver.get("https://www.freecrm.com/index.html");
		
		driver.findElement(By.name("username")).sendKeys("naveenk");
		driver.findElement(By.name("password")).sendKeys("test@123");
		driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div/div/input")).click();
		
		driver.switchTo().frame("mainpanel");
		driver.findElement(By.xpath("//a[@title='Contacts']")).click();
		
		String before_xpath ="//*[@id=\"vContactsForm\"]/table/tbody/tr[";
		String after_xpath = "]/td[2]/a";
		
		String chkbx_bfr_xpath = "//*[@id=\"vContactsForm\"]/table/tbody/tr[";
		String chkbx_aft_xpath = "]/td[1]/input";
		
		for(int i=4; i<=9; i++)  {
			
			String tot_xpath = before_xpath + i + after_xpath;
			String name = driver.findElement(By.xpath(tot_xpath)).getText();
			
			if(name.equalsIgnoreCase("aaa ccc"))  {
				
				driver.findElement(By.xpath(chkbx_bfr_xpath + i + chkbx_aft_xpath)).click();
				System.out.println("Checkbox clicked successfully");
				break;
			}
		    
			
	     }

	}	
}
