package Leads;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import CreateOpportunity.BaseTest3;

public class LeadsTab extends BaseTest4 {

public static void linkLeadsTab() throws InterruptedException {
		
	GetDriverInstance("firefox");
	goToURL("https://login.salesforce.com");
	
	WebElement username = driver.findElement(By.id("username"));
	enterText(username, "rybii70@gmail.com", "username");
//	Thread.sleep(3000);
	WebElement password = driver.findElement(By.id("password"));
	enterText(password, "pass@123", "password");
	driver.findElement(By.id("Login")).click();
	Thread.sleep(3000);

//Click Leads link
	WebElement linkLeads = driver.findElement(By.cssSelector("#Lead_Tab"));
	linkLeads.click();
	Thread.sleep(2000);
	
	driver.findElement(By.cssSelector("#lexNoThanks")).click();
	driver.findElement(By.cssSelector("#lexSubmit")).click();
	
//Select Quarterly Summary Interval
	WebElement dropdownQuarterlySummary = driver.findElement(By.cssSelector("#quarter_q"));
	dropdownQuarterlySummary.click();
	Select selectInterval = new Select(dropdownQuarterlySummary);
	selectInterval.selectByVisibleText("Current FQ");
	
//Select Include
	WebElement dropdownInclude = driver.findElement(By.cssSelector("#quarter_q"));
	dropdownInclude.click();
	Thread.sleep(4000);
	Select selectInclude = new Select(dropdownInclude);
	selectInclude.selectByIndex(0);	
	
//Click Run Report bttn		
	WebElement bttnRunReport = driver.findElement(By.xpath("//table/tbody/tr[3]/td/input[@title='Run Report']"));
	bttnRunReport.click();
	
//Verify Opportunity Report page is displayed	
	String pageName = "Opportunity Report";
		WebElement checkPageName = driver.findElement(By.cssSelector(".noSecondHeader"));
			if(checkPageName.getText().equalsIgnoreCase(pageName)) {
				System.out.println("Test passed"); 
				System.out.println(checkPageName.getText());
				System.out.println(pageName);
			}
			else{
				System.out.println("Test failed");
				System.out.println(checkPageName.getText());
				System.out.println(pageName);
			}
//		driver.close();

	
}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		linkLeadsTab();

	}

}


