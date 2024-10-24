package com.ford.auto.PackageselectionPage;

import java.util.Random;

import org.openqa.selenium.WebDriver;

import com.ford.auto.browser.Browser;
import com.ford.auto.support.WDSupport;
import com.ford.auto.waitlist.RegisterPage;

public class BundleInsurance extends Browser {

	WebDriver driver;
	WDSupport driverSupport;

	public BundleInsurance(WebDriver driver) {
		this.driver = driver;
		this.driverSupport = new WDSupport(driver);

	}

	public void registerPage(String firstname, String lastname, String email, String phoneno, String zipcode)
			throws InterruptedException {

		driverSupport.locateByXpath("//input[@id='firstName']").sendKeys(firstname);

		driverSupport.locateByXpath("//input[@id='lastName']").sendKeys(lastname);

		driverSupport.locateByXpath("//input[@id='email']").sendKeys(email);
		driverSupport.locateByXpath("//input[@id='phoneNo']").sendKeys(phoneno);

		driverSupport.locateByXpath("//input[@id='homeZipCode']").sendKeys(zipcode);
		driverSupport.locateByXpath("//input[@data-testid='consents'][@type='checkbox']").click();
		Thread.sleep(1000);

		driverSupport.locateByXpath("//button[text()='Get Started']").click();

	}

	public static String getRandomEmailId() {
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		int length = 3;
		for (int i = 0; i < length; i++) {
			int index = random.nextInt(alphabet.length());
			char randomChar = alphabet.charAt(index);
			sb.append(randomChar);
		}
		String randomString = sb.toString();
		System.out.println("Random String is: " + randomString);
		return "testmail" + randomString + "@yopmail.com";

	}

	public void otpPage() {

		driverSupport.locateByXpath("//div[@id='otp']/input[@id='first']").sendKeys("000000");
		driverSupport.locateByXpath("//button[text()='Verify and Continue']").click();

	}

	public String verifypackageselectionpage() throws Exception {

		String packagepage = driverSupport.locateByXpath("//p[text()='Package Selection']").getText();

		return packagepage;

	}

}
