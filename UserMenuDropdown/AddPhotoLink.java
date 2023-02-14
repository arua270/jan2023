package UserMenuDropdown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.jan23.tekarch.BaseTest;

public class AddPhotoLink extends BaseTest1 {
	
	public static void addPhoto() throws InterruptedException  {
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
		
		//mouseOver AddPhoto
		WebElement linkAddPhoto = driver.findElement(By.id("uploadLink"));
		
		Actions action = new Actions(driver);
		action.moveToElement(linkAddPhoto).build().perform();
		linkAddPhoto.click();
		Thread.sleep(3000);
		// switch to frame
		WebElement frameUploadPhoto = driver.findElement(By.xpath("//*[@id=\"uploadPhotoContentId\"]"));
		
		driver.switchTo().frame(frameUploadPhoto);
		Thread.sleep(4000);
		
		
		//Upload file
		WebElement BrowseBttn = driver.findElement(By.cssSelector("#j_id0\\:uploadFileForm\\:uploadInputFile"));
		//type="file" should be present for Browse/AttachFile/UpploadFile buttons
		BrowseBttn.sendKeys("C:\\Users\\A\\Desktop\\Angry_Cat.png");
		Thread.sleep(3000);
		//driver.switchTo().defaultContent();
		
//Click on two Save bttns		
		WebElement SaveBttn = driver.findElement(By.xpath("//*[@id=\"j_id0:uploadFileForm:uploadBtn\"]"));
		SaveBttn.click();
		Thread.sleep(4000);
		WebElement SaveBttn1 = driver.findElement(By.xpath("//*[@id=\"j_id0:j_id7:save\"]"));
		SaveBttn1.click();
		Thread.sleep(3000);
		
		driver.close();
		
	}		

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		addPhoto();

	}

}
