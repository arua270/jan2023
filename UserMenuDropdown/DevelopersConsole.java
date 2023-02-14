package UserMenuDropdown;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class DevelopersConsole extends BaseTest1 {

	public static void linkDevelopersConsole() throws InterruptedException {
		
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

		WebElement linkDevelopersConsole = driver.findElement(By.cssSelector(".debugLogLink"));
		linkDevelopersConsole.click();
		Thread.sleep(2000);

//Verify Sample Event window is displayed
		Set<String> getAllWidows = driver.getWindowHandles();
	
		Iterator<String> it = getAllWidows.iterator();
		String parentWindowID = it.next();
		System.out.println("Parent window id: "+parentWindowID);
		String childWindowID = it.next();
		System.out.println("Child window id: "+childWindowID);
				
//Switch to child window		
		driver.switchTo().window(childWindowID);
		driver.manage().window().maximize();
		driver.close();
		
		driver.switchTo().window(parentWindowID);
		
		userDropDown.click();
		driver.close();
		

		
}		
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		linkDevelopersConsole(); 

	}

}
