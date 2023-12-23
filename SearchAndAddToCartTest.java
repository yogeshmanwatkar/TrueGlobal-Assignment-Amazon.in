package AmazonAutomate;

import java.util.Iterator;
import java.util.Set;

import javax.swing.Action;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;

public class SearchAndAddToCart {
	WebDriver driver;
		@FindBy(xpath = "//input[@id='twotabsearchtextbox']") 
		WebElement searchBox;
		@FindBy(xpath = "//span[text()='Brand']")
		WebElement moveToPrice;
		@FindBy(xpath = "//ancestor::div[@data-index='3']//span[text()='M.R.P: ']")
		WebElement firstResult;
		@FindBy(xpath = "//div[@id='apex_desktop']//child::div[@id='corePriceDisplay_desktop_feature_div']//child::span[@class='a-price-whole']")
		WebElement mobPrice;
		@FindBy(xpath = "//input[@id='add-to-cart-button']")
		WebElement addToCartBtn;
	
	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\eclipse-workspace\\SeleniumWorkPlace\\binary\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		
		PageFactory.initElements(driver, this);
	}
	
	@Test
	void searchIphoneAndAddToCart() {
		
		
		searchBox.sendKeys("Iphone ");
		searchBox.submit();
		firstResult.click();
		
		//get prize 
		String mainwWindow = driver.getWindowHandle();
		
		Set<String> childWindows = driver.getWindowHandles(); 
		Iterator<String>iterator = childWindows.iterator();
		
		while (iterator.hasNext()) {
			String newWindow = iterator.next();
			if (!mainwWindow.equalsIgnoreCase(newWindow)) {
				driver.switchTo().window(newWindow);
				
				String price = mobPrice.getText();
				System.out.println("price is :"+price);
				addToCartBtn.click();
			}
		}	
	//	driver.switchTo().window(mainwWindow);
	}
	
}
