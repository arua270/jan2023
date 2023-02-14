package CreateAccount;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class MergeAccounts extends BaseTest2 {

	public static void linkMergeAccounts() throws InterruptedException {
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
		Thread.sleep(3000);
//Get Account name
		WebElement availableAccounts = driver.findElement(By.cssSelector("tr.dataRow:nth-child(2) > th:nth-child(1) > a:nth-child(1)"));
		String accountName = availableAccounts.getText().substring(0, 3);	
		System.out.println(accountName);
		Thread.sleep(1000);
		
////Get Tools table elements
//		WebElement table = driver.findElement(By.cssSelector("#toolsContent"));
//		List<WebElement> rows = (List<WebElement>) table.findElement(By.tagName("a")); 
//		for(int rnum=0; rnum<rows.size(); rnum++) {
//			System.out.println(rows);
//		}
			
//Click Merge Accounts link
		WebElement linkMergeAccounts = driver.findElement(By.xpath("//table[@id='toolsContent']/tbody/tr/td[2]/div/div/div/ul/li[4]/span/a[text()='Merge Accounts']"));
		linkMergeAccounts.click();
		
//Enter Account Name to find
		WebElement fieldFingAccount = driver.findElement(By.cssSelector("#srch"));
		fieldFingAccount.sendKeys(accountName);
		
//Click Find Accounts bttn
		WebElement bttnFindAccounts = driver.findElement(By.cssSelector("input.btn:nth-child(2)"));
		bttnFindAccounts.click();		
		Thread.sleep(3000);
		
//Check accounts to merge  
		WebElement checkBox1 =driver.findElement(By.cssSelector("#cid0"));
		if(!checkBox1.isSelected()) {
			checkBox1.click();
		}
		WebElement checkBox2 =driver.findElement(By.cssSelector("#cid1"));
		if(!checkBox2.isSelected()) {
			checkBox1.click();
		}
		Thread.sleep(3000);
		
//Click Next bttn
		WebElement bttnNext = driver.findElement(By.cssSelector(".pbBottomButtons > input:nth-child(1)"));
		bttnNext.click();		
		Thread.sleep(3000);
		
//Click Merge bttn
		WebElement bttnMerge = driver.findElement(By.cssSelector(".pbTopButtons > input:nth-child(2)"));
		bttnMerge.click();		
		Thread.sleep(3000);
		
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
//Popup window handling 
//		Set<String> getAllWindows = driver.getWindowHandles();
//		Iterator<String> it = getAllWindows.iterator();
//		String parentWindowID = it.next();
//		System.out.println("Parent window id: "+parentWindowID);
//		String childWindowID = it.next();
//		System.out.println("Child window id: "+childWindowID);
//		
//		driver.switchTo().window(childWindowID);	
		
	
//		driver.close();

		


		
}		
	
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		linkMergeAccounts(); 

	}

}

