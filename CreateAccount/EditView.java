package CreateAccount;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class EditView extends BaseTest2 {

	public static void linkEditView() throws InterruptedException {
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
//Select Account to Edit link
		WebElement linkEditView = driver.findElement(By.cssSelector("#fcf"));
		linkEditView.click();	
		Thread.sleep(1000);
		linkEditView.click();
		List<WebElement> listOption = driver.findElements(By.tagName("option"));
		int count = listOption.size();
		String[] arrDropdown = new String[count];
		for(int i =0; i<count; i++) {
			arrDropdown[i] = listOption.get(i).getText();
		}
		
		Select selectItem = new Select(linkEditView);
		selectItem.selectByIndex(1);
	
		Thread.sleep(2000);
//Click Edit link
		WebElement linkEdit = driver.findElement(By.cssSelector(".fFooter > a:nth-child(1)"));
		linkEdit.click();
		
//Enter New ViewName
		WebElement fieldText = driver.findElement(By.cssSelector("#fname"));
		String newInput = "New "+arrDropdown[1];
		fieldText.sendKeys(newInput);
		Thread.sleep(5000);
//Select Account Name in the Filter dropdown  
		WebElement filterDropdown =driver.findElement(By.cssSelector("#fcol1"));
		Select filterOption = new Select(filterDropdown);
		filterOption.selectByVisibleText("Account Name");
		Thread.sleep(3000);
//Select contains option in the Operator dropdown  
		WebElement operatopDropdown =driver.findElement(By.cssSelector("#fop1"));
		Select operatorOption = new Select(operatopDropdown);
		operatorOption.selectByVisibleText("contains");		
		Thread.sleep(3000);
//Enter 'a' into Value field
		WebElement fieldValue =driver.findElement(By.cssSelector("#fval1"));
		fieldValue.clear();
		fieldValue.sendKeys("a");	
		Thread.sleep(3000);

//Click Save bttn 
		WebElement bttnSave = driver.findElement(By.cssSelector(".pbBottomButtons > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(2) > input:nth-child(1)"));
		bttnSave.click();		
	
		Thread.sleep(2000);

//		driver.close();
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
		linkEditView(); 

	}

}
