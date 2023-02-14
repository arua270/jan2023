package UserMenuDropdown;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class EmailLink extends BaseTest1 {

	public static void linkEmail() throws InterruptedException {
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

		WebElement linkMySettings = driver.findElement(By.cssSelector("#userNav-menuItems > a:nth-child(2)"));
		linkMySettings.click();
		Thread.sleep(2000);

//Click on Email link
		WebElement linkEmail = driver.findElement(By.cssSelector("#EmailSetup > a:nth-child(1)"));
		linkEmail.click();

//Click on Customize My Email Settings link
		WebElement linkMyEmailSettings = driver.findElement(By.xpath("//*[@id=\"EmailSettings_font\"]"));
		linkMyEmailSettings.click();
		Thread.sleep(3000);

//Enter email name
		WebElement fieldEmailName = driver.findElement(By.cssSelector("#sender_name"));
		fieldEmailName.clear();
		fieldEmailName.sendKeys("sender name");

//Enter email address
		WebElement fieldEmailAddress = driver.findElement(By.cssSelector("#sender_email"));
		fieldEmailAddress.clear();
		fieldEmailAddress.sendKeys("test@gmail.com");
		
//Select Automatic Bcc radio-bttn
		WebElement bttnAutomaticBCC = driver.findElement(By.cssSelector("#auto_bcc1"));
		boolean bttnValue;
		bttnValue = bttnAutomaticBCC.isSelected();
		if(bttnValue==false) {
			bttnAutomaticBCC.click();
		}
		else {
			System.out.println("Automatic Bcc radio-bttn is selected");
		}
		
//Click on Save bttn 		
		WebElement bttnSave = driver.findElement(By.cssSelector("input.btn:nth-child(1)"));
		bttnSave.click();

		Alert alert = driver.switchTo().alert();
		alert.accept();
		Thread.sleep(3000);
		
		driver.close();
		
	

//		WebElement buttonUserAction = driver.findElement(By.id("moderatorMutton"));
//		buttonUserAction.click();
//		//select Edit Profile option
//		WebElement linkEditProfile = driver.findElement(By.cssSelector(".zen-open > ul:nth-child(2) > li:nth-child(2) > a:nth-child(1)"));
//		linkEditProfile.click();
//		
//		driver.switchTo().activeElement().findElement(By.xpath("//*[@id=\"aboutMe\" and @role=\"dialog\"]"));
		
	}


	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		linkEmail();

	}

}
