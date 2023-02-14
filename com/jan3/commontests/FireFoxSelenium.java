package com.jan3.commontests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FireFoxSelenium {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://qa-tekarch.firebaseapp.com");
		// driver.navigate().to("https://about.google/?fg=1&utm_source=google-US&utm_medium=referral&utm_campaign=hp-header");
		// driver.navigate().back();
		// driver.quit();

		driver.findElement(By.id("email_field")).sendKeys("admin123@gmail.com");
		driver.findElement(By.id("password_field")).sendKeys("admin123");

		By ob = By.tagName("button");
		WebElement button = driver.findElement(ob);
		if (button.getText().contains("Login to") == true) {
			button.click();
		}
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		By ob1 = By.id("name");
		WebElement inputBoxFirst = driver.findElement(ob1);
		inputBoxFirst.sendKeys("Alex");

		By ob2 = By.id("lname");
		WebElement inputBoxLast = driver.findElement(ob2);
		inputBoxLast.sendKeys("Rybii");

		By ob3 = By.id("postaladdress");
		WebElement postalAddress = driver.findElement(ob3);
		postalAddress.sendKeys("San Francisco");
//		
		By ob4 = By.id("personaladdress");
		WebElement personalAddress = driver.findElement(ob4);
		personalAddress.sendKeys("the same as postal");
		
		By ob5 = By.className("bootbutton");
		WebElement buttonSubmit = driver.findElement(ob5);
		buttonSubmit.click();
//		
		

	}

}
