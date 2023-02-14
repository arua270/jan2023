package UserMenuDropdown;

import java.awt.Component;
import java.awt.Dialog;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.jan23.tekarch.BaseTest;

public class MyProfile extends BaseTest1 {

	public static void userMenuTest() throws InterruptedException {
		// String expectedTitle = "Home Tab";

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

		WebElement linkMyProfile = driver.findElement(By.cssSelector("#userNav-menuItems > a:nth-child(1)"));
		linkMyProfile.click();
		Thread.sleep(2000);
//Click About button
		WebElement buttonUserAction = driver.findElement(By.id("moderatorMutton"));
		buttonUserAction.click();
//select Edit Profile option
		WebElement linkEditProfile = driver
				.findElement(By.cssSelector(".zen-open > ul:nth-child(2) > li:nth-child(2) > a:nth-child(1)"));
		linkEditProfile.click();
		Thread.sleep(4000);

//Select Frame
		
		WebElement frameEditProfile = driver.findElement(By.cssSelector("#aboutMeContentId"));
		driver.switchTo().frame(frameEditProfile);
 //enter and save last name		
		WebElement fieldLastName = driver.findElement(By.cssSelector("#lastName"));
		fieldLastName.clear();
		fieldLastName.sendKeys("test");
		
		WebElement bttnSaveAll = driver.findElement(By.cssSelector("input.zen-btn:nth-child(1)"));
		bttnSaveAll.click();	
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
//verify last name is displayed		
		String expectedUserName = "test";
		String userName = driver.findElement(By.cssSelector("#tailBreadcrumbNode")).getText();
		if(userName.contains(expectedUserName)) {
			System.out.println("Test passed");
			}
		
		driver.close();

		
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		userMenuTest();
	}

}
