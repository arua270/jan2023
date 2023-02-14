package com.jan3.commontests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TakarchAutomation {
	
	private static void enterText(WebElement element, String text, String name) throws InterruptedException {
		if(element.isDisplayed())
		{
			element.clear();
			element.sendKeys(text);
		}
		else {
			System.out.println(name+" web element is not displayed");
		}
	}

	private static void loginToFirebase() throws InterruptedException {
	String expected = "Student Registration Form";
	WebDriverManager.firefoxdriver().setup();
	WebDriver driver = new FirefoxDriver();
	driver.manage().window().maximize();
	driver.get("https://qa-tekarch.firebaseapp.com");

	By idLoc = By.id("email_field");
	WebElement username = driver.findElement(idLoc);
	enterText(username, "admin123@gmail.com", "username");
			

	WebElement password = driver.findElement(By.id("password_field"));
	enterText(password, "admin123", "passwordField");

	By ob = By.tagName("button");
	WebElement button = driver.findElement(ob);if(button.getText().contains("Login to")==true)
		{
			button.click();
		}
	Thread.sleep(3000);
	WebElement text = driver.findElement(By.xpath("/html/body/div[2]/div[2]/h1"));
		if(text.isDisplayed())	{
			String actual = text.getText();
			if (actual.equalsIgnoreCase(expected)) {
				System.out.println("Testcase passed");
			} 
			else {
				System.out.println("Testcase failed");
			}
		}
		else{
			System.out.println("The element is not displayed for student registration form");
		}
		driver.close();
		
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
	
	public static void main(String[] args)  throws InterruptedException {
		// TODO Auto-generated method stub
		//loginToFirebase();
		error_Login_Salesforce();
		
	}


}
