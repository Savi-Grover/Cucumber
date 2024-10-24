package com.ford.auto.creditcardpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.ford.auto.browser.Browser;
import com.ford.auto.support.WDSupport;

public class ValidateCreditCardPage extends Browser {

	WebDriver driver;
	WDSupport driverSupport;

	public ValidateCreditCardPage(WebDriver driver) {
		this.driver = driver;
		this.driverSupport = new WDSupport(driver);

	}

	public void entercreditcardpagedetails(String entercardno, String expdate, String cvc, String zipcode) {

		driverSupport.locateByXpath("//button[text()=\"Let's Go!\"]").click();

		driver.switchTo().frame(driver.findElement(By.xpath("(//iframe[contains(@name,'__privateStripeFrame')])[1]")));

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

		driverSupport.locateByXpath("//button[text()='Submit Card']").click();

	}

	public void verifyDeclinedCreditcard() throws InterruptedException {

		Thread.sleep(2000);

		WebElement DeclinedCreditcardmsg = driverSupport.locateByXpath("//p[text()='Your card has been declined.']");

		String actualErrorMessage = DeclinedCreditcardmsg.getText();
		System.out.println(
				"Error msg displaying on the creditcard page after clicking submit button   :" + actualErrorMessage);
        /*
		 * String expectedErrorMessage = "Your card has been declined.";
		 * Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
		 */

	
	 // Validate error message for DeclinedCreditcard
	  
	  if (actualErrorMessage.contains("Your card has been declined"))
	  
	  { System.out.
	  println("DeclinedCreditcard validations error messages displayed succesfully   "
	  + "**********");
	  
	  } else {
	  
	  System.out.println("User enter the vaild credit card number" + "**********");
	  }
	  
	 

	}

	public void verifyIncorrectCreditcardNumber() throws InterruptedException {

		Thread.sleep(2000);

		WebElement DeclinedCreditcardmsg = driverSupport.locateByXpath("//p[text()='Your card number is invalid.']");

		String actualErrorMessage = DeclinedCreditcardmsg.getText();
		System.out.println(
				"Error msg displaying on the creditcard page after clicking submit button   :" + actualErrorMessage);

		// Validate error message for IncorrectCreditcardNumber

		if (actualErrorMessage.contains("Your card number is invalid."))

		{
			System.out.println(
					"IncorrectCreditcardNumber validations error messages displayed succesfully   " + "**********");
		} else {

			System.out.println("User enter the vaild credit card number" + "**********");
		}

	}

	public void verifyIncorrectCVCNumber() throws InterruptedException {

		Thread.sleep(2000);

		WebElement DeclinedCreditcardmsg = driverSupport
				.locateByXpath("//*[@id='root']/main/section[1]/div/div[2]/form/p[2]");

		String actualErrorMessage = DeclinedCreditcardmsg.getText();
		System.out.println(
				"Error msg displaying on the creditcard page after clicking submit button   :" + actualErrorMessage);

		// Validate error message for IncorrectCVCNumber

		if (actualErrorMessage.contains("Your card's security code is incorrect."))

		{
			System.out.println("IncorrectCVCNumber validations error messages displayed succesfully   " + "**********");
		} else {

			System.out.println("User enter the vaild credit card number" + "**********");
		}

	}

	public void verifyExpiredCreditCard() throws InterruptedException {

		Thread.sleep(2000);

		WebElement DeclinedCreditcardmsg = driverSupport.locateByXpath("//p[text()='Your card has expired.']");

		String actualErrorMessage = DeclinedCreditcardmsg.getText();
		System.out.println(
				"Error msg displaying on the creditcard page after clicking submit button   :" + actualErrorMessage);

		// Validate error message for ExpiredCreditCard

		if (actualErrorMessage.contains("Your card has expired."))

		{
			System.out
					.println("Expired credit card validations error messages displayed succesfully   " + "**********");
		} else {

			System.out.println("User enter the vaild credit card number" + "**********");
		}

	}

	public void verifyDebitCard() throws InterruptedException {

		Thread.sleep(2000);

		WebElement DeclinedCreditcardmsg = driverSupport.locateByXpath(
				"//p[text()='Invalid card number. Please enter a valid credit card number. Debit cards are not accepted.']");

		String actualErrorMessage = DeclinedCreditcardmsg.getText();
		System.out.println(
				"Error msg displaying on the creditcard page after clicking submit button   :" + actualErrorMessage);

		// Validate error message for DebitCard

		if (actualErrorMessage.contains(
				"Invalid card number. Please enter a valid credit card number. Debit cards are not accepted."))

		{
			System.out.println(
					"Invalid debit card number validations error messages displayed succesfully   " + "**********");
		} else {

			System.out.println("User enter the vaild credit card number" + "**********");
		}

	}

	public void verifyInsufficientFunds() throws InterruptedException {

		Thread.sleep(2000);

		WebElement DeclinedCreditcardmsg = driverSupport
				.locateByXpath("//p[text()='Your card has insufficient funds.']");

		String actualErrorMessage = DeclinedCreditcardmsg.getText();
		System.out.println(
				"Error msg displaying on the creditcard page after clicking submit button   :" + actualErrorMessage);

		// Validate error message for DeclinedCreditcard

		if (actualErrorMessage.contains("Your card has insufficient funds."))

		{
			System.out.println(
					"InsufficientFunds card validations error messages displayed succesfully   " + "**********");
		} else {

			System.out.println("User enter the vaild credit card number" + "**********");
		}

	}

	public void verifyIncorrectnumberdecline() throws InterruptedException {
		Thread.sleep(2000);

		WebElement Incorrectdeclinemsg = driverSupport.locateByXpath("//p[text()='Your card number is incomplete.']");

		String actualErrorMessage = Incorrectdeclinemsg.getText();
		System.out.println(
				"Error msg displaying on the creditcard page after clicking submit button   :" + actualErrorMessage);

		// Validate error message for Incorrect declined message

		if (actualErrorMessage.contains("Your card number is incomplete."))

		{
			System.out.println(
					"Incorrect declined card validations error messages displayed succesfully   " + "**********");
		} else {

			System.out.println("User enter the vaild credit card number" + "**********");
		}

	}

}
