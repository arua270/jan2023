package UserMenuDropdown;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CalendarReminders extends BaseTest1 {

	public static void linkCalendarReminders() throws InterruptedException {
		
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

//Click on Calendar&Reminders link
		WebElement linkCalendarReminders = driver.findElement(By.cssSelector("#CalendarAndReminders_font"));
		linkCalendarReminders.click();

//Click on Activity Reminders link
		WebElement linkActivityReminders = driver.findElement(By.xpath("//*[@id=\"Reminders_font\"]"));
		linkActivityReminders.click();
				
//Click on Open a Test Reminder bttn
		WebElement bttnTestReminder = driver.findElement(By.cssSelector("#testbtn"));
		bttnTestReminder.click();
		Thread.sleep(3000);		
		
//Verify Sample Event window is displayed
		Set<String> getAllWidows = driver.getWindowHandles();
	
		Iterator<String> it = getAllWidows.iterator();
		String parentWindowID = it.next();
		System.out.println("Parent window id: "+parentWindowID);
		String childWindowID = it.next();
		System.out.println("Child window id: "+childWindowID);
				
//Switch to child window		
		driver.switchTo().window(childWindowID);
//Get child window name
		WebElement childWindowName = driver.findElement(By.cssSelector("#summary0 > div:nth-child(1)"));
		String newWindowName = childWindowName.getText();
		System.out.println("Child window name is "+newWindowName);
		
		driver.switchTo().defaultContent();
		driver.close();
		
}		

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		linkCalendarReminders();

	}

}
