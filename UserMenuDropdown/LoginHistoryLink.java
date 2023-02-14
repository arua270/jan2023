package UserMenuDropdown;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginHistoryLink extends BaseTest1 {
	
	public static void downloadLoginHistory() throws InterruptedException  {
		//String expectedTitle = "Home Tab";
				
		GetDriverInstance("firefox");
		goToURL("https://login.salesforce.com");

		WebElement username = driver.findElement(By.id("username"));
		enterText(username, "rybii70@gmail.com", "username"); 
//		Thread.sleep(3000);
		WebElement password = driver.findElement(By.id("password"));
		enterText(password, "pass@123", "password"); 
		driver.findElement(By.id("Login")).click();
		Thread.sleep(3000);
		
		WebElement userDropDown = driver.findElement(By.id("userNavLabel"));
		userDropDown.click();
		
		WebElement linkMySettings = driver.findElement(By.cssSelector("#userNav-menuItems > a:nth-child(2)"));
		linkMySettings.click();
		Thread.sleep(2000);
//Click on Personal drop-down
		WebElement linkPersonal = driver.findElement(By.cssSelector("#PersonalInfo_font"));
		linkPersonal.click();
//Select Login History option		
		List<WebElement> listPersonal = driver.findElements(By.tagName("a"));
		int count = listPersonal.size();
		System.out.println("Number of options= "+ count);
		String expectLoginHistory = "Login History";
		for (WebElement ele : listPersonal) {
			if(ele.getText().equalsIgnoreCase(expectLoginHistory)) {
				ele.click();
				break;
			}
		}
//Click on Download login history link
		WebElement linkDownloadHistory = driver.findElement(By.xpath("/html/body/div/div[2]/table/tbody/tr/td[2]/div[3]/div[1]/div/div[2]/div/a"));
		linkDownloadHistory.click();
	
	}		

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		downloadLoginHistory(); 

	}

}
