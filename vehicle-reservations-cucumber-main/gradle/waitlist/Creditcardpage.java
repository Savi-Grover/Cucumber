package com.ford.auto.waitlist;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ford.auto.browser.Browser;
import com.ford.auto.support.WDSupport;

public class Creditcardpage extends Browser {
	WebDriver driver;
	WDSupport driverSupport;

	public Creditcardpage(WebDriver driver) {
		this.driver = driver;
		this.driverSupport = new WDSupport(driver);

	}

	public void fillcreditcardpage(String entercardno, String expdate, String cvc, String zipcode) throws InterruptedException {

		driverSupport.locateByXpath("//button[text()=\"Let's Go!\"]").click();

		driver.switchTo().frame(driver.findElement(By.xpath("(//iframe[contains(@name,'__privateStripeFrame')])[1]")));
		
		Thread.sleep(3000);

		driverSupport.locateByXpath("(//input[@aria-label='Credit or debit card number'])").click();

		driverSupport.locateByXpath("(//input[@aria-label='Credit or debit card number'])").sendKeys(entercardno);

		driver.switchTo().defaultContent();

		driver.switchTo().frame(driver.findElement(By.xpath("(//iframe[contains(@name,'__privateStripeFrame')])[2]")));

		driverSupport.locateByXpath("//input[@placeholder='MM / YY']").click();
		driverSupport.locateByXpath("//input[@placeholder='MM / YY']").sendKeys(expdate);

		driver.switchTo().defaultContent();

		driver.switchTo().frame(driver.findElement(By.xpath("(//iframe[contains(@name,'__privateStripeFrame')])[3]")));

		driverSupport.locateByXpath("//input[@placeholder='CVC']").click();
		driverSupport.locateByXpath("//input[@placeholder='CVC']").sendKeys(cvc);

		driver.switchTo().defaultContent();

		driverSupport.locateByXpath("//input[@id='zipcode']").click();
		driverSupport.locateByXpath("//input[@id='zipcode']").sendKeys(zipcode);
		Thread.sleep(3000);
		driverSupport.locateByXpath("//button[text()='Submit Card']").click();

	}
	
	public void Passwordpage() {
		
		try {
		driverSupport.locateByXpath("//input[@data-testid='password']").sendKeys("Ford123!");
		
		}catch(Exception e) {
			driverSupport.locateByXpath("//input[@data-testid='password']").sendKeys("Ford123!");
			
		}
		driverSupport.locateByXpath("//input[@data-testid='confirmation']").sendKeys("Ford123!");
        driverSupport.locateByXpath("//button[text()='Create Password']").click();
	}
	

}
