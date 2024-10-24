package com.ford.auto.waitlist;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.ford.auto.browser.Browser;
import com.ford.auto.support.WDSupport;

public class LoginWithUberPage extends Browser {

	WebDriver driver;
	WDSupport driverSupport;

	public LoginWithUberPage(WebDriver driver) {
		this.driver = driver;
		this.driverSupport = new WDSupport(driver);

	}

	public void loginWithUber() throws InterruptedException {

		Thread.sleep(2000);

		//driverSupport.locateByXpath("(//button[contains(@class,'Text_button01')])[1]").click();
		
		driverSupport.locateByXpath("//button[text()='Join Now']").click();

		driverSupport.locateByXpath("//button[text()='Login with Uber']").click();
	}

	public void signInwithUber(String email, String password) throws InterruptedException {

		Thread.sleep(2000);

		driverSupport.locateByXpath("//a[text()='Sign In']").click();

		driverSupport.locateByXpath("//input[@placeholder='Enter phone number or email']").click();

		driverSupport.locateByXpath("//input[@placeholder='Enter phone number or email']").sendKeys(email);

		driverSupport.locateByXpath("//button[@data-testid='forward-button']").click();

		
		  try {
		  
		  WebElement OTPpagelink = driverSupport
		  .locateByXpath("//*[text()='Enter the 4-digit code sent to you at ']");
		  
		  boolean linkisdisplay = OTPpagelink.isDisplayed();
		  
		  driverSupport.locateByXpath(
		  "//button[@data-testid='More options']").click();
		 /* 
		  try {
		  
		  driverSupport.locateByXpath("//p[text()='Resend code via SMS]").click();
		  
		  driverSupport.locateByXpath("//button[@data-testid='Login with password']").
		  click();
		  
		  } catch (Exception e) {
		  
		  }*/
		  
		  Actions actions = new Actions(driver);
		  
		  WebElement selectpassword =
		  driverSupport.locateByXpath("//p[text()='Password']");
		  
		  actions.click(selectpassword).build().perform();
		  
		  } catch (Exception e) {
		  
		  }
		 

		driverSupport.locateByXpath("//input[@placeholder='Enter your password']").click();

		driverSupport.locateByXpath("//input[@placeholder='Enter your password']").sendKeys(password);

		driverSupport.locateByXpath("//div[text()='Next']").click();

	}

	public void selectfordDriveImage() throws InterruptedException {
		Thread.sleep(2000);
		driverSupport.locateByXpath("//div[text()='Ford Mustang Mach-E']").click();

		

		Thread.sleep(5000);
		driverSupport.locateByXpath("(//button[@data-tracking-name='book-button']/div[@data-testid='button'])[2]")
				.click();
		// driver.findElement(By.xpath("(//div[text()='Get Started'])[1]")).click();
	}
}
