package com.ford.auto.waitlist;

import com.ford.auto.support.PageBaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.ford.auto.browser.Browser;
import com.ford.auto.logging.Logger;
import com.ford.auto.support.WDSupport;

public class Creditcardpage extends PageBaseClass {

	public static final String CREDITCARDPAGEURLEXCERPT = "/approved";

	public Creditcardpage(WebDriver driver) throws InterruptedException {
		super(driver, CREDITCARDPAGEURLEXCERPT, 25);

	}

	public void fillcreditcardpage(String entercardno, String expdate, String cvc, String zipcode) throws InterruptedException {
		Logger.LogEnterMethod("");

		driverSupport.locateByXpath("//button[text()=\"Let's Go!\"]").click();

		driver.switchTo().frame(driver.findElement(By.xpath("(//iframe[contains(@name,'__privateStripeFrame')])[1]")));

		driverSupport.locateByXpath("(//input[@aria-label='Credit or debit card number'])").click();
		
		Thread.sleep(5000);
		WebElement element = driverSupport.locateByXpath("(//input[@aria-label='Credit or debit card number'])"); 
		 JavascriptExecutor jse = (JavascriptExecutor)driver;
		 jse.executeScript("arguments[0].value='4111 1111 1111 1111';", element);
         //element.sendKeys("4111 1111 1111 1111");
		Thread.sleep(5000);
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
		
	    Thread.sleep(2000);

		driverSupport.locateByXpath("//button[text()='Submit Card']").click();

	}

	public void Passwordpage() {
		Logger.LogEnterMethod("");

		try {
			driverSupport.locateByXpath("//input[@data-testid='password']").sendKeys("Ford123!");

		} catch (Exception e) {
			driverSupport.locateByXpath("//input[@data-testid='password']").sendKeys("Ford123!");

		}
		driverSupport.locateByXpath("//input[@data-testid='confirmation']").sendKeys("Ford123!");
		driverSupport.locateByXpath("//button[text()='Create Password']").click();
	}

	public void entercreditcardpage() throws InterruptedException {
		Logger.LogEnterMethod("");

		driverSupport.locateByXpath("//button[text()=\"Let's Go!\"]").click();

		driver.switchTo().frame(driver.findElement(By.xpath("(//iframe[contains(@name,'__privateStripeFrame')])[1]")));
		//Thread.sleep(5000);
		driverSupport.locateByXpath("(//input[@aria-label='Credit or debit card number'])").click();
		
		Thread.sleep(5000);
		WebElement element = driverSupport.locateByXpath("(//input[@aria-label='Credit or debit card number'])"); // you can use any locator
		 JavascriptExecutor jse = (JavascriptExecutor)driver;
		 jse.executeScript("arguments[0].value='4111 1111 1111 1111';", element);
         //element.sendKeys("4111 1111 1111 1111");
		Thread.sleep(5000);
		driver.switchTo().defaultContent();

		driver.switchTo().frame(driver.findElement(By.xpath("(//iframe[contains(@name,'__privateStripeFrame')])[2]")));

		driverSupport.locateByXpath("//input[@placeholder='MM / YY']").click();
		driverSupport.locateByXpath("//input[@placeholder='MM / YY']").sendKeys("1125");

		driver.switchTo().defaultContent();

		driver.switchTo().frame(driver.findElement(By.xpath("(//iframe[contains(@name,'__privateStripeFrame')])[3]")));

		driverSupport.locateByXpath("//input[@placeholder='CVC']").click();
		driverSupport.locateByXpath("//input[@placeholder='CVC']").sendKeys("111");

		driver.switchTo().defaultContent();

		driverSupport.locateByXpath("//input[@id='zipcode']").click();
		driverSupport.locateByXpath("//input[@id='zipcode']").sendKeys("11111");
		Thread.sleep(2000);
        driverSupport.locateByXpath("//button[text()='Submit Card']").click();

	}

}
