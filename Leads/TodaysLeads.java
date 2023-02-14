package Leads;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class TodaysLeads extends BaseTest4 {

public static void selectTodaysLeads() throws InterruptedException {
		
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
	
//Leads View dropdown options
	WebElement dropdownView = driver.findElement(By.cssSelector("#fcf"));
	dropdownView.click();
	Thread.sleep(2000);
	Select selectOption = new Select(dropdownView);
	selectOption.selectByVisibleText("Today's Leads");
	System.out.println(selectOption);
	
//Click Go bttn 
	WebElement bttnGo = driver.findElement(By.cssSelector("input.btn:nth-child(2)"));
	bttnGo.click();
	Thread.sleep(3000);	
	
//Verify View displayed
		WebElement selectedView = driver.findElement(By.xpath("//*[@id=\"00BDn00000J6YJm_topNav\"]/div/select/option[@selected='selected']"));
		selectedView.click();
		Thread.sleep(2000);
		String selection = selectedView.getText();
		if(selection.equalsIgnoreCase("Today's Leads")){
			System.out.println(selection);
			System.out.println("Test passed");
		}
		else {
			System.out.println(selection);
			System.out.println("Test failed");
		}

	
}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		selectTodaysLeads();

	}

}


