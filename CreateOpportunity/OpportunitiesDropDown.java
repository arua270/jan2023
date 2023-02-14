package CreateOpportunity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import CreateAccount.BaseTest2;

public class OpportunitiesDropDown extends BaseTest3 {

	public static void linkOpportunities() throws InterruptedException {
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

//Click on Opportunities link
		WebElement linkOpportunities = driver.findElement(By.cssSelector("#Opportunity_Tab > a"));
		linkOpportunities.click();
		Thread.sleep(2000);
		
		driver.findElement(By.cssSelector("#lexNoThanks")).click();
		driver.findElement(By.cssSelector("#lexSubmit")).click();
		
//Click All Opportunities dropdown		
		WebElement dropdownAllOpportunities = driver.findElement(By.cssSelector("#fcf"));
		dropdownAllOpportunities.click();
		
// All Opportunities dropdown list
		List<WebElement> optionsAllOpportunities = driver.findElements(By.tagName("option"));
			for (WebElement ele : optionsAllOpportunities) {
				ele.getText();
		}


		
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
//		Alert alert = driver.switchTo().alert();
//		alert.accept();
		
//Popup window handling 
//		Set<String> getAllWindows = driver.getWindowHandles();
//		Iterator<String> it = getAllWindows.iterator();
//		String parentWindowID = it.next();
//		System.out.println("Parent window id: "+parentWindowID);
//		String childWindowID = it.next();
//		System.out.println("Child window id: "+childWindowID);
//		
//		driver.switchTo().window(childWindowID);		

		
}		
	
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		linkOpportunities(); 

	}

}
