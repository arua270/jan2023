package Contacts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CheckRecentContact extends BaseTest5 {

	public static void dropdownRecentlyCreated() throws InterruptedException {

		GetDriverInstance("firefox");
		goToURL("https://login.salesforce.com");

		WebElement username = driver.findElement(By.id("username"));
		enterText(username, "rybii70@gmail.com", "username");
//	Thread.sleep(3000);
		WebElement password = driver.findElement(By.id("password"));
		enterText(password, "pass@123", "password");
		driver.findElement(By.id("Login")).click();
		Thread.sleep(4000);

//Click Contacts link
		WebElement linkContacts = driver.findElement(By.cssSelector("#Contact_Tab > a"));
		linkContacts.click();
		Thread.sleep(2000);

		driver.findElement(By.cssSelector("#lexNoThanks")).click();
		driver.findElement(By.cssSelector("#lexSubmit")).click();

//Select Recently Created option in dropdown
		WebElement dropdownRecentCreated = driver.findElement(By.cssSelector("#hotlist_mode"));
		dropdownRecentCreated.click();
		Select selectOption = new Select(dropdownRecentCreated);
		selectOption.selectByVisibleText("Recently Created");
				
		Thread.sleep(3000);

	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		dropdownRecentlyCreated();

	}

}

