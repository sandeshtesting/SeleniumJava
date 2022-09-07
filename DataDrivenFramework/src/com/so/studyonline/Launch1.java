package com.so.studyonline;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class Launch1
{
	public static void main(String[] args) throws IOException
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		// Establishing the Connection from Property File to Java File
		FileInputStream fis = new FileInputStream("E:\\Selenium_June\\DataDrivenFramework\\src\\com\\so\\utilities\\datadriven.properties");
		
		// Creation of Properties object to load the data
		Properties p = new Properties();
		p.load(fis);
		
		//Fetching the data from a Property File
		String url_data = p.getProperty("url");
		String ph_data = p.getProperty("phone_number");
		String pw_data = p.getProperty("password");
		
		System.out.println(url_data);
		System.out.println(ph_data);
		System.out.println(pw_data);
		
		driver.get(url_data);
		driver.findElement(By.linkText("Log In")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.id("app_user_login")).sendKeys(ph_data);
		driver.findElement(By.id("password-field")).sendKeys(pw_data);
		driver.findElement(By.name("commit")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.id("navbarProfileDropdown")).click();
		driver.findElement(By.linkText("Log out")).click();
		driver.close();
		
		
	}
}	
