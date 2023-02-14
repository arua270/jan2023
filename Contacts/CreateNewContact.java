package Contacts;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Leads.BaseTest4;

public class CreateNewContact extends BaseTest5 {

	public static void createContact() throws InterruptedException, AWTException {

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
		// explicit wait - to wait for the linkContacts to be click-able
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#Contact_Tab > a")));
		WebElement linkContacts = driver.findElement(By.cssSelector("#Contact_Tab > a"));
		linkContacts.click();
		Thread.sleep(2000);

		driver.findElement(By.cssSelector("#lexNoThanks")).click();
		driver.findElement(By.cssSelector("#lexSubmit")).click();

//Click New bttn 
		WebElement bttnNew = driver.findElement(By.cssSelector(".pbButton > input:nth-child(1)"));
		bttnNew.click();
		Thread.sleep(3000);

// Enter Last Name
		WebElement fieldLastName = driver.findElement(By.cssSelector("#name_lastcon2"));
		String inputName = "test";
		fieldLastName.sendKeys(inputName);

// Enter Account Name
		String accountName = "new";
		WebElement fieldAccountName = driver.findElement(By.cssSelector("#con4"));
		fieldAccountName.sendKeys(accountName);

// Click Save bttn
		String bttnValue = "Save";
		WebElement table = driver.findElement(By.xpath("//form[@id='editPage']/div/div/table"));
		List<WebElement> trows = table.findElements(By.tagName("input"));
		for (WebElement ele : trows) {
			String rowValue = ele.getAttribute("title");
			if (rowValue.equalsIgnoreCase(bttnValue)) {
				ele.click();
			}
		}

		Thread.sleep(5000);
//Verify New Contact page is displayed
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_F5);
		r.keyRelease(KeyEvent.VK_F5);
				
//		driver.navigate().back();
//		Thread.sleep(4000);
//		driver.navigate().forward();
		Thread.sleep(4000);
		WebElement selectedView = driver.findElement(By.xpath("/html"));
		System.out.println(driver.switchTo().activeElement().getTagName());
		selectedView.click();
		Thread.sleep(2000);
		String selection = selectedView.getText();
		if (selection.equalsIgnoreCase("Today's Leads")) {
			System.out.println(selection);
			System.out.println("Test passed");
		} else {
			System.out.println(selection);
			System.out.println("Test failed");
		}

	}

	public static void main(String[] args) throws InterruptedException, AWTException {
		// TODO Auto-generated method stub
		createContact();

	}

}
