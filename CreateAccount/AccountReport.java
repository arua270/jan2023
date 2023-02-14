package CreateAccount;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AccountReport extends BaseTest2 {

	public static void createAccountReport() throws InterruptedException {
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
		Thread.sleep(5000);
		
//Click 30daysActivity link
		WebElement link30daysActivity  = driver.findElement(By.xpath("//table[@id='toolsContent']/tbody/tr/td[1]/div/div/div/ul/li[2]/a"));
		link30daysActivity.click();
	
//Popup window handle 
//		WebElement frame = driver.findElement(By.cssSelector("#ext-gen195"));
//		driver.switchTo().activeElement();
//		WebElement bttnNoThanks = driver.findElement(By.cssSelector("#ext-gen189"));
//		bttnNoThanks.click();
//		driver.switchTo().defaultContent();
		Thread.sleep(3000);	
		
//Select Report Date From
		WebElement dateFrom = driver.findElement(By.xpath("//*[@id=\"ext-gen152\"]"));
		dateFrom.click();
		Thread.sleep(2000);	
		//Pick todays date
		WebElement calendarFrom = driver.findElement(By.cssSelector("#ext-gen268"));
		driver.switchTo().activeElement();
		WebElement currentDateFrom = driver.findElement(By.cssSelector("#ext-comp-1111"));
		currentDateFrom.click();
		driver.switchTo().defaultContent();
		
//Select Report Date To
		WebElement dateTo = driver.findElement(By.xpath("//*[@id=\"ext-gen154\"]"));
		dateTo.click();
		Thread.sleep(2000);	
		//Pick todays date
		WebElement calendarTo = driver.findElement(By.cssSelector("#ext-gen292"));
		driver.switchTo().activeElement();
		WebElement currentDateTo = driver.findElement(By.cssSelector("#ext-comp-1113"));
		currentDateTo.click();
		driver.switchTo().defaultContent();
		
//Click Save bttn
		WebElement bttnSave = driver.findElement(By.cssSelector("#ext-gen49"));
		bttnSave.click();		
		Thread.sleep(3000);
		
//Popup Window Save Report 
		WebElement popupSaveReport = driver.findElement(By.cssSelector("#saveReportDlg_DeveloperName"));
		driver.switchTo().activeElement();
				
//Enter Report Name
//		SimpleDateFormat myTime = new SimpleDateFormat("hh:mm:aa");
//		String dateString = myTime.format(new Date()).toString();
		int randomNum = (int)(Math.random() * 101);  // 0 to 100
		
		WebElement fieldReportName = driver.findElement(By.cssSelector("#saveReportDlg_reportNameField"));
		String reportName = "test"+randomNum;
		fieldReportName.sendKeys(reportName);
		
//Enter ReportUniqueName
		WebElement fieldReportUniqueName = driver.findElement(By.cssSelector("#saveReportDlg_DeveloperName"));
		String reportUniqueName = ("testUnique");
		fieldReportUniqueName.sendKeys(reportUniqueName);
		
		Thread.sleep(5000);	
		
//Click bttn Save and Run Report	
		WebElement bttnSaveRun = driver.findElement(By.xpath("//*[@id=\"ext-gen312\"]"));
		bttnSaveRun.click();
		Thread.sleep(5000);	
//Verify Report page with details and <report name>is displayed	
		WebElement checkReportName = driver.findElement(By.xpath("//div[@class='content']/img//following::h1"));
		if(checkReportName.getText().equalsIgnoreCase(reportName)) {
			System.out.println("Test passed"); 
			System.out.println(checkReportName.getText());
			System.out.println(reportName);
		}
		else{
			System.out.println("Test failed");
			System.out.println(checkReportName.getText());
			System.out.println(reportName);
		}
//		driver.close();
		
}
		

		
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		createAccountReport(); 

	}

}

