package CreateOpportunity;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CreateNewOpportunity extends BaseTest3 {

public static void linkNewOpportunity() throws InterruptedException {
		
	GetDriverInstance("firefox");
	goToURL("https://login.salesforce.com");
	
	WebElement username = driver.findElement(By.id("username"));
	enterText(username, "rybii70@gmail.com", "username");
//	Thread.sleep(3000);
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
	
//Click New bttn		
	WebElement bttnNew = driver.findElement(By.cssSelector(".pbButton > input:nth-child(1)"));
	bttnNew.click();
	
// Enter Opportunity Name
	WebElement fieldOpportunityName = driver.findElement(By.cssSelector("#opp3"));
	fieldOpportunityName.sendKeys("testOpportunity");	
	
// Enter Account Name
	WebElement fieldAccountName = driver.findElement(By.cssSelector("#opp4"));
	fieldAccountName.sendKeys("new");	
	
// Enter Close Date
	WebElement linkCurrentDate = driver.findElement(By.cssSelector(".dateFormat > a:nth-child(1)"));
	linkCurrentDate.click();	
	Thread.sleep(2000);	
	
// Select Stage
	WebElement dropdownStage = driver.findElement(By.cssSelector("#opp11"));
	dropdownStage.click();	

	Select select = new Select(dropdownStage);
	select.selectByIndex(3);
	
// Select Lead Source
	WebElement dropdownLeadSource = driver.findElement(By.cssSelector("#opp6"));
	dropdownLeadSource.click();	

	Select select1 = new Select(dropdownStage);
	select1.selectByIndex(3);
			
// Enter Probability 
	WebElement fieldProbability  = driver.findElement(By.cssSelector("#opp12"));
	fieldProbability.sendKeys("");	
	
// Enter Primary Campaign Source 
	WebElement fieldPrimaryCampaign  = driver.findElement(By.cssSelector("#opp17"));
	fieldPrimaryCampaign.sendKeys("d");		
	Thread.sleep(2000);
		
//All Opportunities dropdown list
	WebElement bttnSave = driver.findElement(By.xpath("//table/tbody/tr/td[2]/form/div/div[3]/table/tbody/tr/td[2]/input[1]"));
	bttnSave.click();



	//driver.close();
//	Alert alert = driver.switchTo().alert();
//	alert.accept();
	
//Popup window handling 
//	Set<String> getAllWindows = driver.getWindowHandles();
//	Iterator<String> it = getAllWindows.iterator();
//	String parentWindowID = it.next();
//	System.out.println("Parent window id: "+parentWindowID);
//	String childWindowID = it.next();
//	System.out.println("Child window id: "+childWindowID);
//	
//	driver.switchTo().window(childWindowID);		

	
}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		linkNewOpportunity();

	}

}
