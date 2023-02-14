package CreateAccount;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import UserMenuDropdown.BaseTest1;

public class CreateNewAccount extends BaseTest2 {

	public static void linkAccounts() throws InterruptedException {
		SimpleDateFormat myTime1 = new SimpleDateFormat("hh:mm:aa");
		String dateString = myTime1.format(new Date()).toString();
		
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
//Click New bttn		
		WebElement bttnNew = driver.findElement(By.cssSelector("input.btn:nth-child(1)"));
		bttnNew.click();
		
// Enter Account Name
		WebElement fieldAccountName = driver.findElement(By.xpath("//*[@id=\"acc2\"]"));
		fieldAccountName.sendKeys("new account "+dateString);
		
//Select Account type
		WebElement dropdownType = driver.findElement(By.cssSelector("#acc6"));
		Select selectDropdown = new Select(dropdownType);
		selectDropdown.selectByVisibleText("Technology Partner");

//Select Customer Priority 
		WebElement dropdownCustPriority = driver.findElement(By.cssSelector("#\\30 0NDn00000TOv2X"));
		Select selectCustPriority = new Select(dropdownCustPriority);
		selectCustPriority.selectByValue("High");		
	
		Thread.sleep(2000);

		driver.close();

}		
	
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		linkAccounts(); 

	}

}
