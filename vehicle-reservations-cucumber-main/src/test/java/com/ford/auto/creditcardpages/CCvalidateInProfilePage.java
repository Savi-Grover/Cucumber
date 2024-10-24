package com.ford.auto.creditcardpages;

import static org.testng.Assert.fail;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.ford.auto.browser.Browser;
import com.ford.auto.support.WDSupport;

public class CCvalidateInProfilePage extends Browser {

	WebDriver driver;
	WDSupport driverSupport;

	public CCvalidateInProfilePage(WebDriver driver) {
		this.driver = driver;
		this.driverSupport = new WDSupport(driver);

	}

	public void loginWithSignupLink(String emailid, String password) throws InterruptedException {

		/*
		 * Thread.sleep(2000);
		 * driverSupport.locateByXpath("//p[text()='Sign In']").click();
		 */
		Thread.sleep(3000);

		// Scroll to the element using JavaScriptExecutor
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element = driverSupport.locateByXpath("//p[text()='Sign In']");
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(2000);
		element.click();
		
		driverSupport.locateByXpath("//input[@placeholder='Enter email']").sendKeys(emailid);
		driverSupport.locateByXpath("//button[@id='continue']").click();
		Thread.sleep(1000);
		driverSupport.locateByXpath("//input[@id='password']").sendKeys(password);
		Thread.sleep(1000);
		driverSupport.locateByXpath("//button[@id='next']").click();
		Thread.sleep(2000);

		WebElement Verifydashboardtitle = driverSupport.locateByXpath("//h2[text()='Welcome']");

		String actualErrorMessage = Verifydashboardtitle.getText();

		// Verify the dashboard page title

		if (actualErrorMessage.contains("Welcome"))

		{
			System.out.println("User login to the application dashboard succesfully " + "**********");

		} else {

			System.out.println("User not able login to the application dashboard " + "**********");
		}

	}

	public void clicksOnProfileSectionPage(String cardName) throws InterruptedException {

		Thread.sleep(2000);
		driverSupport.locateByXpath("//div[@data-testid='sub-card-nav']").click();

		driverSupport.locateByXpath("//img[contains(@class,'CreditCardDetails_caret')]").click();
		Thread.sleep(2000);
		driverSupport.locateByXpath("//img[contains(@alt,'Navigation Caret for add payment method page')]").click();

		driverSupport.locateByXpath("//input[@id='cardName']").sendKeys(cardName);

		driverSupport.locateByXpath("//input[@data-testid='primary-card-checkbox']").click();

	}

	public void clicksOnAddCreditCard() throws InterruptedException {

		Thread.sleep(2000);
		driverSupport.locateByXpath("(//i[contains(@class,'chevron-right')])[1]").click();

		// Scroll to the element using JavaScriptExecutor
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element = driverSupport
				.locateByXpath("//img[contains(@alt,'Navigation caret for payment-information page')]");
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(2000);
		element.click();

		driverSupport.locateByXpath("//p[text()='Add Credit Card']").click();

	}

	public void clicksOnAddCreditCard(String cardName) throws InterruptedException {

		driverSupport.locateByXpath("//input[@id='cardName']").sendKeys(cardName);

		driverSupport.locateByXpath("//input[@data-testid='primary-card-checkbox']").click();

	}

	public void enterCardDetails(String entercardno, String expdate, String cvc, String zipcode)
			throws InterruptedException {

		driver.switchTo().frame(driver.findElement(By.xpath("(//iframe[contains(@name,'__privateStripeFrame')])[1]")));
		driverSupport.locateByXpath("(//input[@aria-label='Credit or debit card number'])").click();
		Thread.sleep(3000);
		WebElement element = driverSupport.locateByXpath("(//input[@aria-label='Credit or debit card number'])");
		element.sendKeys(entercardno);

		driverSupport.locateByCSS("input[aria-label='Credit or debit card expiration date']").click();
		driverSupport.locateByCSS("input[aria-label='Credit or debit card expiration date']").sendKeys(expdate);

		driverSupport.locateByXpath("(//input[@aria-label='Credit or debit card CVC/CVV'])").click();
		driverSupport.locateByCSS("input[aria-label='Credit or debit card CVC/CVV']").sendKeys(cvc);

		driverSupport.locateByXpath("(//input[@placeholder='ZIP'])").click();
		driverSupport.locateByCSS("input[placeholder='ZIP']").sendKeys(zipcode);
		driver.switchTo().defaultContent();

		Thread.sleep(2000);

		driverSupport.locateByXpath("//button[text()='Add Payment Method']").click();

		/*
		 * JavascriptExecutor jse = (JavascriptExecutor) driver;
		 * jse.executeScript("arguments[0].value='4111 1111 1111 1111';", element);
		 * Thread.sleep(2000);
		 */

		// driver.switchTo().defaultContent();
		// driver.switchTo().frame(driver.findElement(By.xpath("(//iframe[contains(@name,'__privateStripeFrame')])[1]")));
		// driverSupport.locateByCSS("input[aria-label='Credit or debit card expiration
		// date']").click();
		// act.moveToElement(driverSupport.locateByCSS("input[aria-label='Credit or
		// debit card expiration date']")).sendKeys(expdate).build().perform();

		// driverSupport.locateByXpath("(//input[@aria-label='Credit or debit card
		// expiration date'])").click();
		// driverSupport.locateByXpath("(//input[@aria-label='Credit or debit card
		// expiration date'])").sendKeys(expdate);
		// driver.switchTo().defaultContent();
		// driver.switchTo().frame(driver.findElement(By.xpath("(//iframe[contains(@name,'__privateStripeFrame')])[3]")));

		/*
		 * Actions act = new Actions(driver); act.moveToElement(driverSupport.
		 * locateByXpath("(//input[@aria-label='Credit or debit card number'])")).
		 * sendKeys(entercardno)
		 * 
		 * .moveToElement(driverSupport.
		 * locateByCSS("input[aria-label='Credit or debit card expiration date']")).
		 * sendKeys(expdate) .moveToElement(driverSupport.
		 * locateByCSS("input[aria-label='Credit or debit card CVC/CVV']")).sendKeys(
		 * expdate)
		 * .moveToElement(driverSupport.locateByCSS("input[placeholder='ZIP']")).
		 * sendKeys(expdate) .build().perform();
		 * 
		 */
	}

	public void validateNickNameSuccessMessage() throws InterruptedException {

		Thread.sleep(5000);

		WebElement Verifynick_addedsuccessfully = driverSupport
				.locateByXpath("//p[text()='Your card was added successfully!']");

		String actualErrorMessage = Verifynick_addedsuccessfully.getText();

		// Verify the Nickname is added ot the payment method successfully!

		if (actualErrorMessage.contains("Your card was added successfully!"))

		{
			System.out.println("User add nick name in the profile section page succesfully " + "**********");

		} else {

			System.out.println(
					"User not able add nick name through the payment method " + "**********");
			Assert.fail();
		}

		driverSupport.locateByXpath("//button[text()='Head Back Home']").click();
	}
	
	

	public void validateSucessMessage() throws InterruptedException {

		Thread.sleep(5000);
		try {
			WebElement Verifycard_addedsuccessfully = driverSupport.locateByXpath("/html/body/div[1]/div[2]/p ");

			System.out.println("User added the card details in the profile section page succesfully " + "**********");

		} catch (Exception e) {
			Assert.fail();

		}

		driverSupport.locateByXpath("//button[text()='Head Back Home']").click();

		/*
		 * String actualErrorMessage = Verifycard_addedsuccessfully.getText();
		 * System.out.println(actualErrorMessage);
		 */
		/*
		 * String ErrorMessage =
		 * driverSupport.locateByXpath("//p[@class='error'] ").getText();
		 * System.out.println(ErrorMessage);
		 * 
		 * 
		 * 
		 * 
		 * String expectedMessage = "Your card was added successfully!"; //String
		 * errorMessage = "Your card has been declined.";
		 */

		// Verify the card was added in tye profile page sucessfully
		/*
		 * if (actualErrorMessage.equals(expectedMessage))
		 * 
		 * { System.out.
		 * println("User added the card details in the profile section page succesfully "
		 * + "**********");
		 * 
		 * } else {
		 * 
		 * System.out.
		 * println("User was not able to add the card details in the profile section page succesfully"
		 * + "**********");
		 * 
		 * }
		 */

	}

	public void removePaymentMethod() throws InterruptedException {

		Thread.sleep(2000);
		driverSupport.locateByXpath("//div[@data-testid='sub-card-nav']").click();

		driverSupport.locateByXpath("//img[contains(@class,'CreditCardDetails_caret')]").click();
		Thread.sleep(2000);
		driverSupport.locateByXpath("(//img[@alt='Navigation caret for edit payment page'])[1]").click();

		driverSupport.locateByXpath("//button[text()='Remove Payment Method']").click();

		WebElement Verifycard_addedsuccessfully = driverSupport
				.locateByXpath("//p[text()='Your card was removed successfully!']");

		String actualErrorMessage = Verifycard_addedsuccessfully.getText();

		// Verify the card was added in tye profile page sucessfully

		if (actualErrorMessage.contains("Your card was removed successfully!"))

		{
			System.out.println("User remove the card details in the profile section page succesfully " + "**********");

		} else {

			System.out.println(
					"User not able to remove the card details in the profile section page succesfully " + "**********");
		}

		driverSupport.locateByXpath("//button[text()='Head Back Home']").click();

	}

	// vaildate DeclinedCreditcard error message

	public void verifyDeclinedCreditcard() throws InterruptedException {

		Thread.sleep(2000);

		WebElement DeclinedCreditcardmsg = driverSupport.locateByXpath("//p[text()='Your card has been declined.']");

		String actualErrorMessage = DeclinedCreditcardmsg.getText();
		System.out.println(
				"Error msg displaying on the creditcard page after clicking submit button   :" + actualErrorMessage);

		// Validate error message for DeclinedCreditcard

		if (actualErrorMessage.contains("Your card has been declined"))

		{
			System.out.println("DeclinedCreditcard validations error messages displayed succesfully   " + "**********");

		} else {

			System.out.println("User enter the vaild credit card number" + "**********");
		}

	}

	public void verifyIncorrectCreditCardNumber() throws InterruptedException {

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

	public void verifyexpiredCreditCard() throws InterruptedException {

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

}
