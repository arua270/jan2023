package Contacts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ViewContact extends BaseTest5 {

	public static void linkContactName() throws InterruptedException {

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
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#Contact_Tab > a")));
		WebElement linkContacts = driver.findElement(By.cssSelector("#Contact_Tab > a"));
		linkContacts.click();
		Thread.sleep(2000);

		driver.findElement(By.cssSelector("#lexNoThanks")).click();
		driver.findElement(By.cssSelector("#lexSubmit")).click();
		Thread.sleep(3000);

//Select Contact Name in the list 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='list']/tbody/tr[2]/th")));
		WebElement name = driver.findElement(By.xpath("//table[@class='list']/tbody/tr[2]/th/a"));
		String listValue = name.getText();
		System.out.println(listValue);
		name.click();
		String[] arrSplit = listValue.split(", ");
//	    for (int i=0; i < arrSplit.length; i++)
//	    {
//	      System.out.println(arrSplit[i]);
//	    }
		String NameToVerify = arrSplit[0];
	    System.out.println(NameToVerify);

// Verify New Contact page is displayed
		WebElement contactName = driver.findElement(By.cssSelector(".topName"));
		String selectedName = contactName.getText();
		if (selectedName.contains(NameToVerify)) {
			System.out.println(selectedName);
			System.out.println("Test passed");
			}
		else {
			System.out.println("Test failed");
		}

		Thread.sleep(3000);

	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		linkContactName();

	}

}
