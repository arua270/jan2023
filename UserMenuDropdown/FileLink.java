package UserMenuDropdown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.jan23.tekarch.BaseTest;

public class FileLink extends BaseTest1 {
	
	public static void clickFileLink() throws InterruptedException  {
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
		
		WebElement linkMyProfile = driver.findElement(By.cssSelector("#userNav-menuItems > a:nth-child(1)"));
		linkMyProfile.click();
		Thread.sleep(2000);
		// Click File link
		WebElement linkFile = driver.findElement(By.cssSelector("#publisherAttachContentPost > span:nth-child(2)"));
		linkFile.click();
		
		WebElement uploadFileBttn = driver.findElement(By.id("chatterUploadFileAction"));
		uploadFileBttn.click();
		
		
		//Uppload file
		WebElement BrowseBttn = driver.findElement(By.id("chatterFile"));
		//type="file" should be present for Browse/AttachFile/UpploadFile buttons
		System.out.println(BrowseBttn.getAttribute("type"));
		BrowseBttn.sendKeys("C:\\Users\\A\\Desktop\\test.txt");
		
		WebElement ShareBttn = driver.findElement(By.id("publishersharebutton"));
		ShareBttn.click();
		Thread.sleep(2000);
		driver.close();
		
	}		
		
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		clickFileLink();

	}

}
