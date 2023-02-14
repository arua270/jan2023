package com.jan3.commontests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.opera.OperaDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OperaSelenium {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.operadriver().setup();
		WebDriver driver = new OperaDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
		driver.close();

	}

}
