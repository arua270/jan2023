package Leads;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class NewButton extends BaseTest4 {

	public static void checkNewButton() throws InterruptedException {

		GetDriverInstance("firefox");
		goToURL("https://login.salesforce.com");

		WebElement username = driver.findElement(By.id("username"));
		enterText(username, "rybii70@gmail.com", "username");
//	Thread.sleep(3000);
		WebElement password = driver.findElement(By.id("password"));
		enterText(password, "pass@123", "password");
		driver.findElement(By.id("Login")).click();
		Thread.sleep(4000);

//Click Leads link
		WebElement linkLeads = driver.findElement(By.cssSelector("#Lead_Tab"));
		linkLeads.click();
		Thread.sleep(2000);

		driver.findElement(By.cssSelector("#lexNoThanks")).click();
		driver.findElement(By.cssSelector("#lexSubmit")).click();

//Click New bttn 
		WebElement bttnNew = driver.findElement(By.cssSelector(".pbButton > input:nth-child(1)"));
		bttnNew.click();
		Thread.sleep(3000);

// Enter Last Name
		WebElement fieldLastName = driver.findElement(By.cssSelector("#name_lastlea2"));
		String inputName = "ABCD";
		fieldLastName.sendKeys(inputName);

// Enter Company Name
		WebElement fieldCompanyName = driver.findElement(By.cssSelector("#lea3"));
		fieldCompanyName.sendKeys(inputName);

// Click Save bttn
		String bttnValue = "Save";
		WebElement table = driver.findElement(By.xpath("//form[@id='editPage']/div/div/table"));
		List<WebElement> trows = table.findElements(By.tagName("input"));
		for (WebElement ele : trows) {
			String rowValue = ele.getAttribute("title");
			if(rowValue.equalsIgnoreCase(bttnValue)) {
				ele.click();
			}
		}	
		
		Thread.sleep(5000);

//Verify New Leads page is displayed
//		String nameValue = "ABCD";
//		WebElement table1 = driver.findElement(By.xpath("//*[@id=\"bodyTable\"]"));
//		List<WebElement> trows1 = table1.findElements(By.tagName("h2"));
//		for (WebElement ele : trows1) {
//			String rowValue1 = ele.getText();
//			if(rowValue1.equalsIgnoreCase(nameValue)) {
//				System.out.println(rowValue1);
//				System.out.println("Test passed");
//			} else {
//				System.out.println(rowValue1);
//				System.out.println("Test failed");
		
			
		

	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		checkNewButton();

	}

}
