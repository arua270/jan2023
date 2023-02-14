package UserMenuDropdown;

import java.util.List;

import org.apache.hc.core5.util.Asserts;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MySettings extends BaseTest1 {
	
	public static void optionMySettings() throws InterruptedException  {
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
		
		WebElement userDropDown = driver.findElement(By.xpath("//*[@id=\"userNavLabel\"]"));
		userDropDown.click();
//Select MySettings option		
		WebElement linkMySettings = driver.findElement(By.cssSelector("#userNav-menuItems > a:nth-child(2)"));
		linkMySettings.click();
		Thread.sleep(2000);
		
////Click on Display & Layout link and then on Customize My Tabs link	
//		WebElement linkDisplayLayout = driver.findElement(By.cssSelector("#DisplayAndLayout_font"));
//		linkDisplayLayout.click();
//		WebElement linkCustomizeMyTabs = driver.findElement(By.xpath("//*[@id=\"CustomizeTabs_font\"]"));
//		linkCustomizeMyTabs.click();
		
		
		
		
		
	}		


	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		optionMySettings();

	}

}
