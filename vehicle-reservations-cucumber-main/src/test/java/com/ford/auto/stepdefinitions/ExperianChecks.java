package com.ford.auto.stepdefinitions;

import com.ford.auto.waitlist.SSNPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.ford.auto.browser.Browser;
import com.ford.auto.logging.Logger;
import com.ford.auto.support.WDSupport;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ExperianChecks extends Browser {
	public WebDriver driver = getDriver();
	WDSupport driverSupport = new WDSupport(driver);

	// Verify the experian checks page

	@When("User enter invalid experian details")
	public void user_enter_invalid_experian_details() {
		// User enter invalid experience details
		Logger.LogEnterMethod("Check not doing anything yet.");
	}

	@Then("delinquent Checkout error message should be displayed successfully")
	public void delinquent_checkout_error_message_should_be_displayed_successfully() throws InterruptedException {

		WebElement Verifydashboardtitle = driverSupport
				.locateByXpath("//h5[text()='We’re unable to approve your application.']");

		String actualErrorMessage = Verifydashboardtitle.getText();

		Logger.LogInfo ("experian checks error msg displaying after clicking submit button   :" + actualErrorMessage);

		String expectedErrorMessage = "We’re unable to approve your application.";
		Assert.assertEquals(actualErrorMessage, expectedErrorMessage);

	}

	// Verify the SCORE,INQUIRIES checks page

	@Then("INQUIRIES Checkout error message should be displayed successfully")
	public void inquiries_checkout_error_message_should_be_displayed_successfully() throws InterruptedException {

		WebElement Verifydashboardtitle = driverSupport
				.locateByXpath("//h5[text()='We’re unable to approve your application.']");

		String actualErrorMessage = Verifydashboardtitle.getText();

		Logger.LogInfo ("experian checks error msg displaying after clicking submit button   :" + actualErrorMessage);

		String expectedErrorMessage = "We’re unable to approve your application.";
		Assert.assertEquals(actualErrorMessage, expectedErrorMessage);

	}

	// Verify the Auto loan history checks page

	@Then("Auto loan history Checkout error message should be displayed successfully")
	public void auto_loan_history_checkout_error_message_should_be_displayed_successfully() throws InterruptedException {

		WebElement Verifydashboardtitle = driverSupport
				.locateByXpath("//h5[text()='We’re unable to approve your application.']");

		String actualErrorMessage = Verifydashboardtitle.getText();

		Logger.LogInfo ("experian checks error msg displaying after clicking submit button   :" + actualErrorMessage);

		String expectedErrorMessage = "We’re unable to approve your application.";
		Assert.assertEquals(actualErrorMessage, expectedErrorMessage);

	}

	// Verify the BANKRUPTCIES checks page

	@Then("BANKRUPTCIES Checkout error message should be displayed successfully")
	public void bankruptcies_checkout_error_message_should_be_displayed_successfully() throws InterruptedException {
		WebElement Verifydashboardtitle = driverSupport
				.locateByXpath("//h5[text()='We’re unable to approve your application.']");

		String actualErrorMessage = Verifydashboardtitle.getText();

		Logger.LogInfo ("experian checks error msg displaying after clicking submit button   :" + actualErrorMessage);

		String expectedErrorMessage = "We’re unable to approve your application.";
		Assert.assertEquals(actualErrorMessage, expectedErrorMessage);

	}

	// Verify the Credit Score low checks page

	@Then("Credit Score low Checkout error message should be displayed successfully")
	public void credit_score_low_checkout_error_message_should_be_displayed_successfully() throws InterruptedException {
		WebElement Verifydashboardtitle = driverSupport
				.locateByXpath("//h5[text()='We’re unable to approve your application.']");

		String actualErrorMessage = Verifydashboardtitle.getText();

		Logger.LogInfo ("experian checks error msg displaying after clicking submit button   :" + actualErrorMessage);

		String expectedErrorMessage = "We’re unable to approve your application.";
		Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
	}

	// Verify the FRAUD ALERT checks page

	@Then("FRAUD ALERT 16 Checkout error message should be displayed successfully")
	public void fraud_alert_16_checkout_error_message_should_be_displayed_successfully() throws InterruptedException {
		WebElement Verifydashboardtitle = driverSupport
				.locateByXpath("//h5[text()='We’re unable to approve your application.']");

		String actualErrorMessage = Verifydashboardtitle.getText();

		Logger.LogInfo ("experian checks error msg displaying after clicking submit button   :" + actualErrorMessage);

		String expectedErrorMessage = "We’re unable to approve your application.";
		Assert.assertEquals(actualErrorMessage, expectedErrorMessage);

	}

	// Verify the Repossesion checks page

	@Then("Repossesion, Auto Loan history Checkout error message should be displayed successfully")
	public void repossesion_auto_loan_history_checkout_error_message_should_be_displayed_successfully() throws InterruptedException {
		WebElement Verifydashboardtitle = driverSupport
				.locateByXpath("//h5[text()='We’re unable to approve your application.']");

		String actualErrorMessage = Verifydashboardtitle.getText();

		Logger.LogInfo ("experian checks error msg displaying after clicking submit button   :" + actualErrorMessage);

		String expectedErrorMessage = "We’re unable to approve your application.";
		Assert.assertEquals(actualErrorMessage, expectedErrorMessage);

	}

	// Verify the OFAC checks page

	@Then("OFAC Checkout error message should be displayed successfully")
	public void ofac_checkout_error_message_should_be_displayed_successfully() throws InterruptedException {

		WebElement Verifydashboardtitle = driverSupport
				.locateByXpath("//h5[text()='We’re unable to approve your application.']");

		String actualErrorMessage = Verifydashboardtitle.getText();

		Logger.LogInfo ("experian checks error msg displaying after clicking submit button   :" + actualErrorMessage);

		String expectedErrorMessage = "We’re unable to approve your application.";
		Assert.assertEquals(actualErrorMessage, expectedErrorMessage);

	}
	
	// Verify the scoreusers_9000 checks page
	
	@Then("score users Checkout error message should be displayed successfully")
	public void score_users_checkout_error_message_should_be_displayed_successfully() throws InterruptedException {
		WebElement Verifydashboardtitle = driverSupport
				.locateByXpath("//h5[text()='We’re unable to approve your application.']");

		String actualErrorMessage = Verifydashboardtitle.getText();
		Logger.LogInfo ("experian checks error msg displaying after clicking submit button   :" + actualErrorMessage);

		String expectedErrorMessage = "We’re unable to approve your application.";
		Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
	    
	}
	
	// Verify the score users600to619 checks page
	
	@Then("score users600to619 Checkout error message should be displayed successfully")
	public void score_users600to619_checkout_error_message_should_be_displayed_successfully() throws InterruptedException {
		Thread.sleep(2000);
		WebElement VerifyWebElement;
		VerifyWebElement = driverSupport.locateByXpath("/html/body/div[3]/div/div[2]/div/div/button");

		String successmessage = VerifyWebElement.getText();
		//Thread.sleep(2000);
		Logger.LogInfo ("experian checks Congrats popup after clicking submit button   :" + successmessage);

		String expectedSuccessMsg = "Let's Go!";
		Assert.assertEquals(successmessage, expectedSuccessMsg);
	}
		@Then("driver gets rejected when their credit profile is Frozen")
	public void driver_gets_rejected_when_their_credit_profile_is_Frozen() throws InterruptedException {
		WebElement Verifydashboardtitle = driverSupport
				.locateByXpath("//h5[text()='Your credit report is frozen.']");

		String actualErrorMessage = Verifydashboardtitle.getText();
		Logger.LogInfo ("experian checks error msg displaying after clicking submit button   :" + actualErrorMessage);

		String expectedErrorMessage = "Your credit report is frozen.";
		Assert.assertEquals(actualErrorMessage, expectedErrorMessage);

	}

	@Then("FRAUD ALERT 23 Checkout error message should be displayed successfully")
	public void fraud_alert_23_checkout_error_message_should_be_displayed_successfully() throws InterruptedException {
		WebElement Verifydashboardtitle = driverSupport
				.locateByXpath("//h5[text()='We’re unable to approve your application.']");

		String actualErrorMessage = Verifydashboardtitle.getText();

		Logger.LogInfo ("experian checks error msg displaying after clicking submit button   :" + actualErrorMessage);

		String expectedErrorMessage = "We’re unable to approve your application.";
		Assert.assertEquals(actualErrorMessage, expectedErrorMessage);

	}

	@Then("FRAUD ALERT 33 Checkout error message should be displayed successfully")
	public void fraud_alert_33_checkout_error_message_should_be_displayed_successfully() throws InterruptedException {
		WebElement Verifydashboardtitle = driverSupport
				.locateByXpath("//h5[text()='We’re unable to approve your application.']");

		String actualErrorMessage = Verifydashboardtitle.getText();

		Logger.LogInfo ("experian checks error msg displaying after clicking submit button   :" + actualErrorMessage);

		String expectedErrorMessage = "We’re unable to approve your application.";
		Assert.assertEquals(actualErrorMessage, expectedErrorMessage);

	}
	@Then("Congrats displayed successfully")
	public void Congrats_displayed_successfully() throws InterruptedException {
		Thread.sleep(2000);
		WDSupport.checkIfPageUrlContainsExcerptOrThrow(driver, 10, "approved");
		WebElement VerifyWebElement;
        VerifyWebElement = driverSupport.locateByXpath("/html/body/div[3]/div/div[2]/div/div/button");

        String successmessage = VerifyWebElement.getText();
		//Thread.sleep(2000);
		Logger.LogInfo ("experian checks Congrats popup after clicking submit button   :" + successmessage);

		String expectedSuccessMsg = "Let's Go!";
		Assert.assertEquals(successmessage, expectedSuccessMsg);

	}
	@When("User enter valid experian details")
	public void userEnterValidExperianDetails() {
		Logger.LogEnterMethod("Check does not do anything yet.");
	}

}
