package com.ford.auto.waitlist;

import java.util.Random;

import com.ford.auto.support.PageBaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;

import com.ford.auto.browser.Browser;
import com.ford.auto.support.WDSupport;
import com.ford.auto.logging.Logger;

public class RegisterPage extends PageBaseClass {

	public static final String REGISTER_PAGEURLEXCERPT = "sign-up";

	public RegisterPage(WebDriver driver) throws InterruptedException {
		super(driver, REGISTER_PAGEURLEXCERPT, 25);

	}

	public void registerPage(String firstname, String lastname, String email, String phoneno, String zipcode)
			throws InterruptedException {

		Logger.LogEnterMethod("");

		driverSupport.locateByXpath("//input[@id='firstName']").sendKeys(firstname);

		driverSupport.locateByXpath("//input[@id='lastName']").sendKeys(lastname);

		driverSupport.locateByXpath("//input[@id='email']").sendKeys(email);
		driverSupport.locateByXpath("//input[@id='phoneNo']").sendKeys(phoneno);

		driverSupport.locateByXpath("//input[@id='homeZipCode']").sendKeys(zipcode);
		dismissCookieSettingsPopupIfPresent();
		Logger.LogInfo("click the 'consents' checkbox");
		driverSupport.locateByXpath("//input[@data-testid='consents'][@type='checkbox']").click();
		Thread.sleep(3000);
		Logger.LogInfo("click the 'Get Started' button");

		WebElement getStartedElement = driver.findElement(By.xpath("//button[text()='Get Started']"));
		getStartedElement.click();
		WDSupport.waitUntilElementIsGoneFromDOM(driver,25,getStartedElement);
	}

	private void dismissCookieSettingsPopupIfPresent() {
		try
		{
			Logger.LogInfo("If cookie settings prompt is present, click close button.");
			driverSupport.locateByClassName("onetrust-close-btn-handler").click();
		}
		catch (Exception e)
		{
			System.out.println("Continuing even if the cookies settings prompt is not there. Exception:" + e);
		}
	}

	public static String getRandomEmailId() {
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		int length = 5;
		for (int i = 0; i < length; i++) {
			int index = random.nextInt(alphabet.length());
			char randomChar = alphabet.charAt(index);
			sb.append(randomChar);
		}
		String randomString = sb.toString();
		System.out.println("Random String is: " + randomString);
		return "testmail" + randomString + "@yopmail.com";

	}

}