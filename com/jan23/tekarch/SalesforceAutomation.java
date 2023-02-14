package com.jan23.tekarch;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SalesforceAutomation extends BaseTest {
	
		
	public static void error_Login_Salesforce() throws InterruptedException{
		String expectedError = "Please enter your password.";
		
		GetDriverInstance("firefox");
		goToURL("https://login.salesforce.com");

		WebElement username = driver.findElement(By.id("username"));
		enterText(username, "invalid_username", "username"); 
				
		driver.findElement(By.id("Login")).click();
		
		WebElement missingPassword = driver.findElement(By.id("error"));
		getWebElementText(missingPassword, "empty PW field"); 
		if(missingPassword.getText().equalsIgnoreCase(expectedError)) {
			System.out.println("Error_Login_Salesforce testcase passed");
		}
		else {
			System.out.println("Error_Login_Salesforce testcase failed");
		}
	}
	
	
	public static void login_Salesforce() throws InterruptedException{
		String expectedTitle = "Home Tab";
				
		GetDriverInstance("firefox");
		goToURL("https://login.salesforce.com");

		WebElement username = driver.findElement(By.id("username"));
		enterText(username, "rybii70@gmail.com", "username"); 
//		Thread.sleep(3000);
		WebElement password = driver.findElement(By.id("password"));
		enterText(password, "pass@123", "password"); 
		driver.findElement(By.id("Login")).click();
		Thread.sleep(3000);
		
		WebElement homeTab = driver.findElement(By.xpath("/html/body/div/div[1]/div/div/nav/ul/li[1]/a"));
		String actualTitle = homeTab.getAttribute("title");
		System.out.println("Attribute of the Home Tab = "+actualTitle);
		if(actualTitle.equalsIgnoreCase(expectedTitle)) {
			System.out.println("Login_Salesforce testcase passed");
		}
		else {
			System.out.println("Login_Salesforce testcase failed");
		}
	}
	
	public static void rememberUsernameCheckBox() throws InterruptedException{
		String expectedLable = "1 Saved Username";
				
		GetDriverInstance("firefox");
		goToURL("https://login.salesforce.com");

		WebElement username = driver.findElement(By.id("username"));
		enterText(username, "rybii70@gmail.com", "username"); 
		Thread.sleep(3000);
		WebElement password = driver.findElement(By.id("password"));
		enterText(password, "pass@123", "password"); 
		
		driver.findElement(By.id("rememberUn")).click();
		driver.findElement(By.id("Login")).click();
		//driver.wait(2000);
		Thread.sleep(5000);
		
		driver.navigate().back();
		
		WebElement chooserLabel = driver.findElement(By.id("chooser_label"));
		String actualLable = chooserLabel.getText();
		System.out.println(actualLable);
		if(expectedLable.equalsIgnoreCase(actualLable)) {
			System.out.println("RememberUsernameCheckBox testcase passed");
		}
		else {
			System.out.println("RememberUsernameCheckBox testcase failed");
		}
}	
	
	public static void forgotPassword() throws InterruptedException{
		String expectedHeader = "Forgot Your Password";
		String expectedMessage = "We’ve sent you an email with a link to finish resetting your password.";	
				
		GetDriverInstance("firefox");
		goToURL("https://login.salesforce.com");

		WebElement forgotPWLink = driver.findElement(By.id("forgot_password_link"));
		if(forgotPWLink.isDisplayed()) {
			forgotPWLink.click();
		}
		else {
			System.out.println("forgot_password_link is not displayed");
		}
		
		WebElement headerForgotPW = driver.findElement(By.cssSelector("#header"));
		WebElement fieldUsername = driver.findElement(By.id("un"));
		String actualHeader = headerForgotPW.getText();
		if(expectedHeader.equalsIgnoreCase(actualHeader)){
			enterText(fieldUsername, "rybii70@gmail.com", "username");
		}
		//click Continue button
		driver.findElement(By.id("continue")).click();
		
		WebElement resetPWMessage = driver.findElement(By.cssSelector("p.senttext:nth-child(1)"));
		String actualMessage = resetPWMessage.getText();
		System.out.println("ActualMessage is: "+actualMessage);
		if(actualMessage.equalsIgnoreCase(expectedMessage)) {
			System.out.println("ForgotPassword testcase passed");
		}
		else {
			System.out.println("ForgotPassword testcase failed");
		}
}	
	
	
	public static void loginErrorMessage() throws InterruptedException{
		String expectedErrorMessage = "Please check your username and password. If you still can't log in, contact your Salesforce administrator.";
				
		GetDriverInstance("firefox");
		goToURL("https://login.salesforce.com");

		WebElement username = driver.findElement(By.id("username"));
		enterText(username, "123", "username"); 

		WebElement password = driver.findElement(By.id("password"));
		enterText(password, "22131", "password"); 
		driver.findElement(By.id("Login")).click();
		//Thread.sleep(5000);
		
		WebElement loginErrorMessage = driver.findElement(By.id("error"));
		String actualErrorMessage = loginErrorMessage.getText();
		System.out.println("LoginErrorMessage = "+actualErrorMessage);
		if(actualErrorMessage.equalsIgnoreCase(expectedErrorMessage)) {
			System.out.println("LoginErrorMessage testcase passed");
		}
		else {
			System.out.println("LoginErrorMessage testcase failed");
		}
	}
	
	
	public static void main(String[] args)  throws InterruptedException {
		// TODO Auto-generated method stub
		
		//error_Login_Salesforce();
		login_Salesforce();
		//rememberUsernameCheckBox();
		//forgotPassword();
		//loginErrorMessage();
		
	}


}
