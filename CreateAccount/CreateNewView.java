package CreateAccount;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CreateNewView  extends BaseTest2 {

	public static void linkCreateNewView() throws InterruptedException {
//		SimpleDateFormat myTime1 = new SimpleDateFormat("hh:mm:aa");
//		String dateString = myTime1.format(new Date()).toString();
		
		GetDriverInstance("firefox");
		goToURL("https://login.salesforce.com");
		
		WebElement username = driver.findElement(By.id("username"));
		enterText(username, "rybii70@gmail.com", "username");
//		Thread.sleep(3000);
		WebElement password = driver.findElement(By.id("password"));
		enterText(password, "pass@123", "password");
		driver.findElement(By.id("Login")).click();
		Thread.sleep(3000);

//Click on Accounts link
		WebElement linkAccts = driver.findElement(By.cssSelector("#Account_Tab > a:nth-child(1)"));
		linkAccts.click();
		Thread.sleep(2000);
		
		driver.findElement(By.cssSelector("#lexNoThanks")).click();
		driver.findElement(By.cssSelector("#lexSubmit")).click();
//Click Create New View link
		WebElement linkCreateNewView = driver.findElement(By.cssSelector(".fFooter > a:nth-child(2)"));
		linkCreateNewView.click();
		
// Enter View Name
		WebElement fieldViewName = driver.findElement(By.cssSelector("#fname"));
		fieldViewName.sendKeys("View Name");
		
// Enter View Unique Name
		int randomNum = (int)(Math.random() * 101);  // 0 to 100
		System.out.println(randomNum);
		WebElement fieldViewUniqueName = driver.findElement(By.cssSelector("#devname"));
		
		fieldViewUniqueName.sendKeys("Test_"+randomNum);

//Click Save bttn 
		WebElement bttnSave = driver.findElement(By.cssSelector(".pbBottomButtons > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(2) > input:nth-child(1)"));
		bttnSave.click();		
	
		Thread.sleep(2000);

}		
	
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		linkCreateNewView(); 

	}

}
