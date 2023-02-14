package Contacts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CancelButton extends BaseTest5 {

	public static void checkErrorMessage() throws InterruptedException {

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

// Click Create New View link
		WebElement linkCreateNewView = driver.findElement(By.cssSelector(".fFooter > a:nth-child(2)"));
		linkCreateNewView.click();
		Thread.sleep(3000);

// Enter Contact View Name
		WebElement fieldViewName = driver.findElement(By.cssSelector("#fname"));
		String nameNewViewContact = "ABCD";
		fieldViewName.sendKeys(nameNewViewContact);

// Enter Contact View Unique Name
		WebElement fieldViewUniqueName = driver.findElement(By.cssSelector("#devname"));
		fieldViewUniqueName.sendKeys("EFGH");

// Click Cancel bttn
		WebElement bttnCancel = driver
				.findElement(By.xpath("//table/tbody/tr/td[2]/div[2]/form/div[1]/table/tbody/tr/td[2]/input[2]"));
		bttnCancel.click();

		Thread.sleep(3000);
//Verify Home page is displayed

		WebElement nameHomePage = driver.findElement(By.cssSelector(".pageDescription"));
		String namePageExpected = "Home";
		String namePageActual = nameHomePage.getText();
		if (namePageExpected.equalsIgnoreCase(namePageActual)) {
			System.out.println(namePageActual);
			System.out.println("Test passed");
		} else {
			System.out.println("Test failed");
		}

	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		checkErrorMessage();

	}

}
