package Contacts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CreateNewViewContact extends BaseTest5 {

	public static void newViewContact() throws InterruptedException {

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

//Click Create New View link
		WebElement linkCreateNewView = driver.findElement(By.cssSelector(".fFooter > a:nth-child(2)"));
		linkCreateNewView.click();
		Thread.sleep(3000);

// Enter Contact View Name
		int randomNum = (int) (Math.random() * 101); // 0 to 100
		WebElement fieldViewName = driver.findElement(By.cssSelector("#fname"));
		String nameNewViewContact = "View Contact" + randomNum;
		fieldViewName.sendKeys(nameNewViewContact);

// Enter Contact View Unique Name
		// int randomNum = (int) (Math.random() * 101); // 0 to 100
		// System.out.println(randomNum);
		WebElement fieldViewUniqueName = driver.findElement(By.cssSelector("#devname"));

		fieldViewUniqueName.sendKeys("Contact_" + randomNum);

// Click Save bttn
		WebElement bttnSave = driver
				.findElement(By.xpath("//table/tbody/tr/td[2]/div[2]/form/div[1]/table/tbody/tr/td[2]/input[1]"));
		bttnSave.click();

		Thread.sleep(5000);
//Verify New Contact page is displayed
		System.out.println(driver.switchTo().activeElement().getTagName());
		WebElement dropdownList = driver.findElement(By.xpath("//*[@id=\"ext-gen6\"]/div/div[2]/table/tbody/tr/td[2]/div/div/form/div/div/select"));
		
		Thread.sleep(2000);
		dropdownList.click();
		List<WebElement> options = driver.findElements(By.tagName("option"));
		for (WebElement ele : options) {
			if (nameNewViewContact.equalsIgnoreCase(ele.getText())) {
				System.out.println(ele.getText());
				System.out.println("Test passed");
			} 
		}

	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		newViewContact();

	}

}
