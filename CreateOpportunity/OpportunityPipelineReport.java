package CreateOpportunity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class OpportunityPipelineReport extends BaseTest3 {

public static void linkOpportunityPipeline() throws InterruptedException {
		
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
	
//Click Opportunity Pipeline link	
	WebElement linkOptyPipeline = driver.findElement(By.xpath("//table[@id=\"toolsContent\"]/tbody/tr/td/div/div/div/ul/li/a[text()='Opportunity Pipeline']"));
	linkOptyPipeline.click();
	
//Verify Opportunity Pipeline page is displayed	
	String pageName = "Opportunity Pipeline";
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
		linkOpportunityPipeline();

	}

}
