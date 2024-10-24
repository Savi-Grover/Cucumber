package com.ford.auto.waitlist;

import com.ford.auto.support.PageBaseClass;
import com.ford.auto.support.PageWithUrlContainsNotFoundException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ford.auto.browser.Browser;
import com.ford.auto.logging.Logger;
import com.ford.auto.support.WDSupport;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Otppage extends PageBaseClass {
	public static final String OTP_FIRSTINPUTXPATH = "//div[@id='otp']/input[@id='first']";
	public static final String OTP_PAGEURLSNIP = "authorize";

	public Otppage(WebDriver driver) throws InterruptedException{
		super(driver, OTP_PAGEURLSNIP, 25);
	}

	public void OtpPage() throws InterruptedException, PageWithUrlContainsNotFoundException {

		Logger.LogEnterMethod("");

		String OTPCode = "000000";
		setOTPCode(OTPCode);
		clickVerifyAndWaitForPageToDismiss();
	}

	private void clickVerifyAndWaitForPageToDismiss() throws InterruptedException {
		Logger.LogInfo("Waiting 5 seconds before clicking Verify");
		Thread.sleep(5000);
		WebElement verifyElement =  driver.findElement(By.xpath("//button[text()='Verify and Continue']"));
		verifyElement.click();

		Logger.LogInfo("'Verify and Continue' clicked. Waiting to disappear from DOM.");

		WebDriver driver1 = driver;
		WDSupport.waitUntilElementIsGoneFromDOM(driver1, 20, verifyElement);
	}

	private void setOTPCode(String OTPCode) throws InterruptedException {
		driver.findElement(By.xpath(OTP_FIRSTINPUTXPATH)).sendKeys(OTPCode);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		Logger.LogInfo("Wait until first input box on OTP matches first character of OTPCOde or fail. OTPCode=" + OTPCode);
		wait.until(ExpectedConditions.textToBePresentInElementValue(driver.findElement(By.xpath(OTP_FIRSTINPUTXPATH)),OTPCode.substring(0,1)));
	}

}
