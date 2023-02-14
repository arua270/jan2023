package com.jan23.tekarch;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class userMenuDropDown extends BaseTest {
	
	public static void userMenuTest() throws Exception   {
		//String expectedTitle = "Home Tab";
				
		GetDriverInstance("firefox");
		goToURL("https://login.salesforce.com");

		WebElement username = driver.findElement(By.id("username"));
		enterText(username, "rybii70@gmail.com", "username"); 
//		Thread.sleep(3000);
		WebElement password = driver.findElement(By.id("password"));
		enterText(password, "pass@123", "password"); 
		driver.findElement(By.id("Login")).click();
		Thread.sleep(3000);
		
		WebElement userDropDown = driver.findElement(By.id("userNavLabel"));
		userDropDown.click();
		
		List<WebElement> userOptions = driver.findElements(By.tagName("a"));
//		int count = userOptions.size();
//		System.out.println("Number of options= "+ count);
		
//		Select obj = new Select(userOptions); 
//		//String result = null;
//		obj.selectByVisibleText(result);
//		System.out.println(result);
		String[] userMenu = new String[5];
			int j=0;	
		for(int i = 3; i <=7; i++) {
			String result = driver.findElements(By.tagName("a")).get(i).getText();
			userMenu[j]=result;
			j++;
			}
			int count =1;
		for(int i = 0; i <=userMenu.length; i++) {
			System.out.println(count+" "+userMenu[i]);
			count++;
		}
//		WebElement homeTab = driver.findElement(By.xpath("/html/body/div/div[1]/div/div/nav/ul/li[1]/a"));
//		String actualTitle = homeTab.getAttribute("title");
//		System.out.println("Attribute of the Home Tab = "+actualTitle);
//		if(actualTitle.equalsIgnoreCase(expectedTitle)) {
//			System.out.println("Login_Salesforce testcase passed");
//		}
//		else {
//			System.out.println("Login_Salesforce testcase failed");
//		}
	}
	

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		userMenuTest();

	}

}
