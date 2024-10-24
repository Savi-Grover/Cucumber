package com.ford.auto.waitlist;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;

import com.ford.auto.browser.Browser;
import com.ford.auto.support.WDSupport;

public class RegisterPage extends Browser {

	WebDriver driver;
	WDSupport driverSupport;

	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		this.driverSupport = new WDSupport(driver);

	}
	
	public void launchPartialProfilePage() throws InterruptedException {
		
		Thread.sleep(3000);
		driver.switchTo().newWindow(WindowType.TAB);

		driver.navigate().to(" https://stage.rideshare.forddrive.com/sign-up?referrer=https%3A%2F%2Fbonjour.uber.com&flow=UBER");

		
		
	}

	public void registerPage(String firstname, String lastname, String email, String phoneno, String zipcode)
			throws InterruptedException {
		
		Thread.sleep(1000);
		driverSupport.locateByXpath("//input[@id='firstName']").sendKeys(firstname);

		driverSupport.locateByXpath("//input[@id='lastName']").sendKeys(lastname);

		driverSupport.locateByXpath("//input[@id='email']").sendKeys(email);
		driverSupport.locateByXpath("//input[@id='phoneNo']").sendKeys(phoneno);

		driverSupport.locateByXpath("//input[@id='homeZipCode']").sendKeys(zipcode);
		driverSupport.locateByXpath("//input[@data-testid='consents'][@type='checkbox']").click();
		Thread.sleep(2000);
        driver.findElement(By.xpath("//button[text()='Get Started']")).click();

		// driverSupport.locateByXpath("//button[text()='Get Started']").click();

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

}
