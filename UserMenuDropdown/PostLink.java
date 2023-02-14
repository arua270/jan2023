package UserMenuDropdown;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.jan23.tekarch.BaseTest;

public class PostLink extends BaseTest1 {

	public static void clickPostLink() throws InterruptedException  {
		//String expectedTitle = "Home Tab";
		SimpleDateFormat myTime1 = new SimpleDateFormat("hh:mm:aa");
		String dateString = myTime1.format(new Date()).toString();
    	//System.out.println("Current time in AM/PM: "+dateString);
				
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
		
		WebElement linkMyProfile = driver.findElement(By.cssSelector("#userNav-menuItems > a:nth-child(1)"));
		linkMyProfile.click();
		Thread.sleep(2000);
		
		WebElement linkPost = driver.findElement(By.cssSelector("#publisherAttachTextPost > span"));
		linkPost.click();
		Thread.sleep(5000);
//Switch to frame
		WebElement  framePost = driver.findElement(By.cssSelector(".cke_wysiwyg_frame"));
		driver.switchTo().frame(framePost);
		
//enter text to text Box	
		framePost.click();
		framePost.sendKeys("test-text "+dateString);	
		
		driver.switchTo().defaultContent();
//Click Share button		
		WebElement bttnShare = driver.findElement(By.cssSelector("#publishersharebutton"));
		bttnShare.click();
		Thread.sleep(5000);
		driver.switchTo().defaultContent();
//verify entered text is displayed		
		String expectedInput = "test-text "+dateString;
		WebElement containerRecentActivity = driver.findElement(By.cssSelector(".feedcontainer"));
		String result = containerRecentActivity.getText();
				
		if(result.contains(expectedInput)) {
			System.out.println("Test passed" );
		}	
		else {
			System.out.println("Not found");
		}
	
		Thread.sleep(3000);
		driver.close();
		
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		clickPostLink();
	}

}
