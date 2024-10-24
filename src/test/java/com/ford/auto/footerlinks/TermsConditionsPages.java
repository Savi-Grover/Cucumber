package com.ford.auto.footerlinks;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.ford.auto.browser.Browser;
import com.ford.auto.support.WDSupport;

public class TermsConditionsPages extends Browser {

	WebDriver driver;
	WDSupport driverSupport;

	public TermsConditionsPages(WebDriver driver) {
		this.driver = driver;
		this.driverSupport = new WDSupport(driver);

	}

	public void clickonTaclink() throws InterruptedException {


		Thread.sleep(2000);

		String pagetitle = driverSupport.locateByXpath("//p[text()='Enter the six-digit verification code sent to ']").getText();

		System.out.println("PageTiltle " + pagetitle);

		if (pagetitle.contains("Enter the six-digit verification code sent to "))

		{
			System.out.println("Switch to the Home page Successfully");
		} else {
			Assert.fail();
		}

		WebElement footer = driverSupport.locateByXpath("//a[@id='terms']");
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", footer);
		Thread.sleep(3000);
		footer.click();

	}

	public void verifyTermsConditionlink() throws InterruptedException {
		// Get the current window handle
		String mainWindowHandle = driver.getWindowHandle();

		// Get all window handles
		Set<String> allWindowHandles = driver.getWindowHandles();

		// Switch to the new tab
		for (String Handle : allWindowHandles) {

			if (!Handle.equals(mainWindowHandle)) {
				driver.switchTo().window(Handle);
				// break;

				Thread.sleep(5000);
				// Verify page content on the new tab
				String expectedContent = "Terms and Conditions";
				String actualContent = driver.findElement(By.xpath("//div[text()='Terms and Conditions']")).getText();
				System.out.println("actualtext msg " + actualContent);

				// Assert to verify the content
				Assert.assertTrue(actualContent.contains(expectedContent), "Page content verification failed");

			}
		}

		// Switch back to the main window
		driver.switchTo().window(mainWindowHandle);
	}

}
