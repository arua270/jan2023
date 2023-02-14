package Contacts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SaveAndNewButton extends BaseTest5 {

	public static void buttonSaveAndNew() throws InterruptedException {

		GetDriverInstance("firefox");
		goToURL("https://login.salesforce.com");

		WebElement username = driver.findElement(By.id("username"));
		enterText(username, "rybii70@gmail.com", "username");
//	Thread.sleep(3000);
		WebElement password = driver.findElement(By.id("password"));
		enterText(password, "pass@123", "password");
		driver.findElement(By.id("Login")).click();
		Thread.sleep(4000);

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

//Click New bttn 
		WebElement bttnNew = driver.findElement(By.cssSelector(".pbButton > input:nth-child(1)"));
		bttnNew.click();
		Thread.sleep(3000);

// Enter Last Name
		int randomNum = (int) (Math.random() * 101); // 0 to 100
		WebElement fieldLastName = driver.findElement(By.cssSelector("#name_lastcon2"));
		String inputName = ("Indian"+randomNum);
		fieldLastName.sendKeys(inputName);

// Enter Account Name
		String accountName = "new";
		WebElement fieldAccountName = driver.findElement(By.cssSelector("#con4"));
		fieldAccountName.sendKeys(accountName);

// Click Save & New  bttn
		String bttnValue = "Save & New";
		WebElement bttnSaveNew = driver.findElement(By.cssSelector("#topButtonRow > input:nth-child(2)"));
		bttnSaveNew.click();

		Thread.sleep(5000);
//Verify New Contact page is displayed
		String lableNameExpected = "Contact Edit";
		WebElement lableContactEdit = driver.findElement(By.cssSelector(".mainTitle"));
		String lableNameActual = lableContactEdit.getText();
		if (lableNameExpected.equalsIgnoreCase(lableNameActual)) {
			System.out.println(lableNameActual);
			System.out.println("Test passed");
		} else {
			System.out.println("Test failed");
		}


	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		buttonSaveAndNew();

	}

}
