package com.ford.auto.footerlinks;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.ford.auto.browser.Browser;
import com.ford.auto.support.WDSupport;

public class FAQlinkPages extends Browser {
	WebDriver driver;
	WDSupport driverSupport;

	public FAQlinkPages(WebDriver driver) {
		this.driver = driver;
		this.driverSupport = new WDSupport(driver);

	}

	public void verifyFAQlink() throws InterruptedException {

		Thread.sleep(2000);

		String pagetitle = driverSupport.locateByXpath("//p[text()='Enter the six-digit verification code sent to ']").getText();

		System.out.println("PageTiltle " + pagetitle);

		if (pagetitle.contains("Enter the six-digit verification code sent to "))

		{
			System.out.println("Switch to the Home page Successfully");
		} else {
			Assert.fail();
		}

		WebElement footer = driverSupport.locateByXpath("//a[@id='faq']");
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", footer);
		Thread.sleep(3000);
        footer.click();

	}

	public void verifyFAQTitle() throws InterruptedException {

		Thread.sleep(5000);
		String FAQtitle = driverSupport.locateByXpath("(//a[contains(@href,'/faq')])[1]").getText();
		
		//String FAQtitle = driver.findElement(By.xpath("//h1[contains(@class,'FAQ_faqHeaderTitle')]")).getText();
		
		System.out.println("PageTiltle " + FAQtitle);

		if (FAQtitle.contains("FAQ")) {

			System.out.println("Switch to the FAQlink Successfully");
		} else {
			Assert.fail();
		}

		//driverSupport.locateByXpath("//img[@alt='left arrow']").click();

	}

}
