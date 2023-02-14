package com.jan3.commontests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TakarchAutomation2 {

	public static void main(String[] args) throws InterruptedException {
		String expected = "Student Registration Form";
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://qa-tekarch.firebaseapp.com");

		By idLoc = By.id("email_field");
		WebElement username = driver.findElement(idLoc);
		if (username.isDisplayed()) {
			username.clear();
			username.sendKeys("admin123@gmail.com");
		} else {
			System.out.println("The element is not displayed");
		}

		driver.findElement(By.id("password_field")).clear();
		driver.findElement(By.id("password_field")).sendKeys("admin123");

		By ob = By.tagName("button");
		WebElement button = driver.findElement(ob);
		if (button.getText().contains("Login to") == true) {
			button.click();
		}
		Thread.sleep(3000);
		WebElement text = driver.findElement(By.xpath("/html/body/div[2]/div[2]/h1"));
		if (text.isDisplayed()) {
			String actual = text.getText();
			if (actual.equalsIgnoreCase(expected)) {
				System.out.println("Testcase passed");
			} else {
				System.out.println("Testcase failed");
			}
		} else {
			System.out.println("The element is not displayed for student registration form");
		}
		driver.close();
	}

}
