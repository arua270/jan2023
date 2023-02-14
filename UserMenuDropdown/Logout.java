package UserMenuDropdown;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Logout extends BaseTest1 {

	public static void linkLogout() throws InterruptedException {
		
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
//Click Logout link
		WebElement linkLogout = driver.findElement(By.cssSelector("#userNav-menuItems > a:nth-child(5)"));
		linkLogout.click();
		Thread.sleep(4000);
//Verify page Title		
		String loginPageTitle = driver.getTitle();
		System.out.println("Page title is "+loginPageTitle);
		Thread.sleep(2000);

		driver.close();
		

		
}		
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		linkLogout();

	}

}
