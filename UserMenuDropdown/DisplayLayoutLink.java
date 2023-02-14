package UserMenuDropdown;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class DisplayLayoutLink extends BaseTest1 {

	public static void linkDisplayLayout() throws InterruptedException {
		// String expectedTitle = "Home Tab";

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

//Click on Display & Layout link
		WebElement linkDisplayLayout = driver.findElement(By.cssSelector("#DisplayAndLayout_font"));
		linkDisplayLayout.click();

//Click on Customize My Tabs link
		WebElement linkCustomizeTabs = driver
				.findElement(By.cssSelector("#DisplayAndLayout_child > div:nth-child(1) > a"));
		linkCustomizeTabs.click();

//Click on Custom App dropdown
		WebElement dropdownCustomApp = driver.findElement(By.cssSelector("#p4"));
		dropdownCustomApp.click();

//Select CustomApp dropdown options		
		List<WebElement> listCustomApp = driver.findElements(By.tagName("option"));
		int count = listCustomApp.size();
		System.out.println("Number of options= " + count);
		String expectedvalue = "Salesforce Chatter";
		for (WebElement ele : listCustomApp) {
			if (ele.getText().equalsIgnoreCase(expectedvalue)) {
				ele.click();
				break;
			}
		}

//Select Available Tabs options		
		WebElement AvailableTabs = driver.findElement(By.cssSelector("#p4"));
		AvailableTabs.click();		
		List<WebElement> listAvailableTabs = driver.findElements(By.tagName("option"));
		int count1 = listAvailableTabs.size();
		System.out.println("Number of options= " + count1);
		String expectedOption = "Reports";
		for (WebElement ele : listAvailableTabs) {
			if (ele.getText().equalsIgnoreCase(expectedOption)) {
				ele.click();
				break;
			}
		}
		
//Click Add button
		WebElement buttonAdd = driver.findElement(By.cssSelector("#duel_select_0_right"));
		buttonAdd.click();	
		Thread.sleep(2000);
		driver.close();
		
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		linkDisplayLayout();

	}

}
