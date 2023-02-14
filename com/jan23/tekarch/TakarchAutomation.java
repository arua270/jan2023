package com.jan23.tekarch;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TakarchAutomation extends BaseTest {
	
	
	public static void loginToFirebase() throws InterruptedException {
	String expected = "Student Registration Form";
	GetDriverInstance("firefox");
	goToURL("https://qa-tekarch.firebaseapp.com");

	By idLoc = By.id("email_field");
	WebElement username = driver.findElement(idLoc);
	enterText(username, "admin123@gmail.com", "username");
			

	WebElement password = driver.findElement(By.id("password_field"));
	enterText(password, "admin123", "passwordField");

	By ob = By.tagName("button");
	WebElement button = driver.findElement(ob);
	if(button.getText().contains("Login to")==true)
		{
			button.click();
		}
	Thread.sleep(3000);
	WebElement textElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/h1"));
	String actual = getTextFromWebElement(textElement, "Student Registration Form");
			if (actual.equalsIgnoreCase(expected)) {
				System.out.println("Testcase passed");
			} 
			else {
				System.out.println("Testcase failed");
			}
		
		//driver.close();
		
	} 
	
		
	public static void error_Login_Salesforce() {
		String expectedError = "Please enter your password.";
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com");
		WebElement username = driver.findElement(By.id("username"));
		String attributeValue = username.getAttribute("class");
		System.out.println("Attribute of the class = "+attributeValue);
		String name = username.getTagName();
		System.out.println("Tagname for username fiels = " + name);
		
		driver.findElement(By.id("username")).sendKeys("invalid_username");
		driver.findElement(By.id("password")).sendKeys("");
		driver.findElement(By.id("Login")).click();
		String actualError = driver.findElement(By.id("error")).getText();
		if(actualError.equalsIgnoreCase(actualError)) {
			System.out.println("Error_Login_Salesforce testcase passed");
		}
		else {
			System.out.println("Error_Login_Salesforce testcase failed");
		}
	}
	
	public static void student_Registration_Form() throws InterruptedException {
		GetDriverInstance("firefox");
		goToURL("https://qa-tekarch.firebaseapp.com");

		By idLoc = By.id("email_field");
		WebElement username = driver.findElement(idLoc);
		enterText(username, "admin123@gmail.com", "username");
				

		WebElement password = driver.findElement(By.id("password_field"));
		enterText(password, "admin123", "passwordField");

		driver.findElement(By.tagName("button")).click();
		Thread.sleep(3000);
		
		WebElement nameEle = driver.findElement(By.id("name"));
		enterText(nameEle, "divya", "name field");
		WebElement femaleRadioButton = driver.findElement(By.xpath("//*[@id='radiobut' and @value='female']"));  //"span.col-35:nth-child(3) > input:nth-child(1)"
		femaleRadioButton.click();
		
		WebElement cityDropdown = driver.findElement(By.id("city"));
		Select obj = new Select(cityDropdown); 
		obj.selectByVisibleText("PATNA");
		
		printAllDropdownOptions(driver.findElement(By.id("city")), "City");
		
		printAllDropdownOptions(driver.findElement(By.id("state")), "State");
		
		
		//Select obj1 = new Select(
		List<WebElement> linkNum = driver.findElements(By.tagName("a"));
		int count = linkNum.size();
		System.out.println("Number of links= "+ count);
		for(int i = 1; i <=count; i++) {
			String result = driver.findElements(By.tagName("a")).get(i).getText();
			System.out.println(i+" "+result);
		}
		
	}
	
	public static void main(String[] args)  throws InterruptedException {
		// TODO Auto-generated method stub
		//loginToFirebase();
		error_Login_Salesforce();
		//student_Registration_Form(); 
		
	}


}
