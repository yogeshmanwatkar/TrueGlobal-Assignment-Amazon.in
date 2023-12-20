package com.maven.selenium.maven_project;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class RegisterUser {
	WebDriver driver;
	@Test
	public void register() {
		 
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\eclipse-workspace\\SeleniumWorkPlace\\binary\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		
		WebElement signIn = driver.findElement(By.xpath("//div[@class='nav-line-1-container']"));
		signIn.click();
		
		WebElement createAccount = driver.findElement(By.xpath("//a[@id='createAccountSubmit']"));
		createAccount.click();
		
		WebElement name = driver.findElement(By.xpath("//input[@id='ap_customer_name']"));
		
		Actions act  = new Actions(driver);
		act.sendKeys(name, "Yogesh Manwatkar").perform();
		act.sendKeys(Keys.TAB).perform();
		act.sendKeys("7028700511").perform();
		act.sendKeys(Keys.TAB).perform();
		act.sendKeys("manwatkaryogesh90@gmail.com").perform();
		act.sendKeys(Keys.TAB).perform();
		act.sendKeys("Password@123").perform();
		act.sendKeys(Keys.TAB).sendKeys(Keys.ENTER).build().perform();
		
		//WebElement startPuzzle = driver.findElement(By.xpath("//button[@class='sc-nkuzb1-0 sc-d5trka-0 eZxMRy button']"));
		//startPuzzle.click();
		//Captcha and puzzle is not possible to automate in Selenium, to solve this issue we have to solve this step manually. 
		
		
	}
}
