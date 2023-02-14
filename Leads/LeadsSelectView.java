package Leads;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class LeadsSelectView extends BaseTest4 {

public static void dropdownLeadsView() throws InterruptedException {
		
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
	List<WebElement> optionsView = dropdownView.findElements(By.tagName("option"));
	for (WebElement ele : optionsView) {
		System.out.println(ele.getText());
		
	}
	

}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		dropdownLeadsView();

	}

}


