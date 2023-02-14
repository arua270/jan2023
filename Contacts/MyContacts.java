package Contacts;

import java.sql.DriverManager;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyContacts extends BaseTest5 {

	public static void dropdownMyContacts() throws InterruptedException {

		GetDriverInstance("firefox");
		goToURL("https://login.salesforce.com");

		WebElement username = driver.findElement(By.id("username"));
		enterText(username, "rybii70@gmail.com", "username");
//	Thread.sleep(3000);
		WebElement password = driver.findElement(By.id("password"));
		enterText(password, "pass@123", "password");
		driver.findElement(By.id("Login")).click();
		
// Click Contacts link
// explicit wait - to wait for the linkContacts to be click-able
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#Contact_Tab > a")));
		WebElement linkContacts = driver.findElement(By.cssSelector("#Contact_Tab > a"));
		linkContacts.click();
		Thread.sleep(2000);

		driver.findElement(By.cssSelector("#lexNoThanks")).click();
		driver.findElement(By.cssSelector("#lexSubmit")).click();
		Thread.sleep(3000);
//Select My Contacts option in dropdown
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#fcf")));
		WebElement dropdownMyContacts = driver.findElement(By.cssSelector("#fcf"));
		dropdownMyContacts.click();
		Select selectOption = new Select(dropdownMyContacts);
		selectOption.selectByVisibleText("My Contacts");

		Thread.sleep(3000);

	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		dropdownMyContacts();

	}

}
