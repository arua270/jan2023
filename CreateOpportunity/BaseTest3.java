package CreateOpportunity;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest3 {

	public static WebDriver driver = null;

	public static void GetDriverInstance(String browserName) {
		switch (browserName) {
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			break;
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.manage().window().maximize();
			break;
		default:
			System.out.println("Not entered proper browser name");
		}
	}


	public static void enterText(WebElement element, String text, String name) {
		if (element.isDisplayed()) {
			element.clear();
			element.sendKeys(text);
		} else {
			System.out.println(name + " web element is not displayed");
		}
		driver.getTitle();
	}

	
	public static void goToURL(String url) {
		driver.get(url); // ("https://qa-tekarch.firebaseapp.com");
	}


	
	public static String getTextFromWebElement(WebElement element, String name) {
		if (element.isDisplayed()) {
			return element.getText();
		} else {
			System.out.println(name + " web element is not displayed");
			return null;
		}
	}
	
	
	public static void getWebElementText(WebElement element, String name) {
		System.out.println("The actual text of "+name+" is: "+ element.getText());
	}
	
	

	public static void printAllDropdownOptions(WebElement dropdownName, String name) {
		Select obj = new Select(dropdownName);
		List<WebElement> listName = obj.getOptions();
		System.out.println("\nTotal number of "+name+" elements = "+listName.size());
		int i = 1;
		for (WebElement ele : listName) {
			System.out.println(i + " "+ele.getText());
			i++;
			
		}
		
	}
	
	
}
