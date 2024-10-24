package com.ford.auto.stepdefinitions;

import org.openqa.selenium.WebDriver;

import com.ford.auto.browser.Browser;
import com.ford.auto.creditcardpages.ValidateCreditCardPage;
import com.ford.auto.support.WDSupport;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreditCardpage extends Browser {

	ValidateCreditCardPage dc;

	public WebDriver driver = getDriver();
	WDSupport driverSupport = new WDSupport(driver);

	@Given("the user is on the Credit card page provides the credit card information {string},{string},{string},{string}")
	public void the_user_is_on_the_credit_card_page_provides_the_credit_card_information(String entercardno,
			String expdate, String cvc, String zipcode) {
		dc = new ValidateCreditCardPage(driver);

		dc.entercreditcardpagedetails(entercardno, expdate, cvc, zipcode);
	}

	@When("the user enters a declined credit card number")
	public void the_user_enters_a_declined_credit_card_number() {

		// the user enters a declined credit card numbe

	}

	@Then("a validation message should be displayed indicating the card is declined")
	public void a_validation_message_should_be_displayed_indicating_the_card_is_declined() throws InterruptedException {

		dc = new ValidateCreditCardPage(driver);

		dc.verifyDeclinedCreditcard();

	}

	// Verify validation message for an incorrect credit card number

	@When("the user enters an incorrect credit card number")
	public void the_user_enters_an_incorrect_credit_card_number() {
		// the user enters an incorrect credit card number
	}

	@Then("a validation message should be displayed indicating the card is incorrect")
	public void a_validation_message_should_be_displayed_indicating_the_card_is_incorrect()
			throws InterruptedException {

		dc = new ValidateCreditCardPage(driver);
		dc.verifyIncorrectCreditcardNumber();

	}

//Verify validation message for an incorrect CVC number

	@When("the user enters an incorrect CVC number")
	public void the_user_enters_an_incorrect_cvc_number() {
		//the user enters an incorrect CVC number 
	}

	@Then("a validation message should be displayed indicating the card has incorrect CVC number")
	public void a_validation_message_should_be_displayed_indicating_the_card_has_incorrect_cvc_number() throws InterruptedException {
		dc = new ValidateCreditCardPage(driver);
		dc.verifyIncorrectCVCNumber();
	}
	
	
	//Verify validation message for an expired credit card
	
	@When("the user enters an expired credit card")
	public void the_user_enters_an_expired_credit_card() {
	    //the user enters an expired credit card 
	}
	@Then("a validation message should be displayed indicating the card is expired credit card")
	public void a_validation_message_should_be_displayed_indicating_the_card_is_expired_credit_card() throws InterruptedException {
		
		dc = new ValidateCreditCardPage(driver);
		dc.verifyExpiredCreditCard();
	    
	}
	
	//Verify validation message for a debit card
	
	@When("the user enters the debit card number")
	public void the_user_enters_the_debit_card_number() {
	    //the user enters the debit card number 
	}
	@Then("a validation message should be displayed indicating the card is debit card number")
	public void a_validation_message_should_be_displayed_indicating_the_card_is_debit_card_number() throws InterruptedException {
		dc = new ValidateCreditCardPage(driver);
		dc.verifyDebitCard();
	}

	
//Verify validation message for a card with insufficient funds
	
	
	@When("the user enters the insufficient funds card number")
	public void the_user_enters_the_insufficient_funds_card_number() {
	    //the user enters the insufficient funds card number 
	}
	@Then("a validation message should be displayed indicating the card is insufficient funds card number")
	public void a_validation_message_should_be_displayed_indicating_the_card_is_insufficient_funds_card_number() throws InterruptedException {
		dc = new ValidateCreditCardPage(driver);
		dc.verifyInsufficientFunds();
	    
	}
	
	//Verify validation message for a card with Incorrect number decline
	
	
	@When("the user enters the Incorrectnumber card number")
	public void the_user_enters_the_incorrectnumber_card_number() {
	    //the user enters the Incorrectnumber card number
		}
	
	@Then("a validation message should be displayed indicating the card is Incorrect number decline card number")
	public void a_validation_message_should_be_displayed_indicating_the_card_is_incorrect_number_decline_card_number() throws InterruptedException {
		
		dc = new ValidateCreditCardPage(driver);
		
		dc.verifyIncorrectnumberdecline();
	}






}
