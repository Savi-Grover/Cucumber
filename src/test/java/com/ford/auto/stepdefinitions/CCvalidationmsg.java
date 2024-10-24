package com.ford.auto.stepdefinitions;

import org.openqa.selenium.WebDriver;

import com.ford.auto.browser.Browser;
import com.ford.auto.creditcardpages.CCvalidateInProfilePage;
import com.ford.auto.support.WDSupport;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CCvalidationmsg extends Browser {

	CCvalidateInProfilePage loginwithforddrive;

	public WebDriver driver = getDriver();
	WDSupport driverSupport = new WDSupport(driver);

	@Given("user Login to the Drivers Ford drive portal with vaild {string} and {string}")
	public void user_login_to_the_drivers_ford_drive_portal_with_vaild_and(String emailid, String password)
			throws InterruptedException {

		loginwithforddrive = new CCvalidateInProfilePage(driver);

		loginwithforddrive.loginWithSignupLink(emailid, password);

	}

	@Given("User navigate to Edit profile page {string}")
	public void user_navigate_to_edit_profile_page(String cardName) throws InterruptedException {

		loginwithforddrive.clicksOnProfileSectionPage(cardName);

	}

	@Given("Open the credit card page and click on add payment button")
	public void open_the_credit_card_page_and_click_on_add_payment_button() {
		// Open the credit card page and click on add payment butto
	}

	@Given("the user is on the Credit Card page provides the credit card information {string},{string},{string},{string}")
	public void the_user_is_on_the_credit_card_page_provides_the_credit_card_information(String entercardno,
			String expdate, String cvc, String zipcode) throws InterruptedException {
		loginwithforddrive.enterCardDetails(entercardno, expdate, cvc, zipcode);
	}

	@When("the user enters a vaild creditcard number number")
	public void the_user_enters_a_vaild_creditcard_number_number() {
		// the user enters a vaild creditcard number number
	}

	@Then("the validation message should be displayed indicating the card added sucessfully")
	public void the_validation_message_should_be_displayed_indicating_the_card_added_sucessfully() throws InterruptedException {
		loginwithforddrive.validateSucessMessage();

	}

	// remove the credit card in the profile section page

	@Given("User navigate to Edit profile page")
	public void user_navigate_to_edit_profile_page() {
		// User navigate to Edit profile page

	}

	@Given("Open the credit card page and select the credit card")
	public void open_the_credit_card_page_and_select_the_credit_card() {
		// Open the credit card page and select the credit card"
	}

	@When("User clicks on remove payment method in edit payment page")
	public void user_clicks_on_remove_payment_method_in_edit_payment_page() {
		// User clicks on remove payment method in edit payment page
	}

	@Then("credit card should be removed succesfully")
	public void credit_card_should_be_removed_succesfully() throws InterruptedException {
		loginwithforddrive.removePaymentMethod();

	}

	// verify Declined credit card number

	@Given("the user in the Credit card page provides the credit card information {string},{string},{string},{string}")
	public void the_user_in_the_credit_card_page_provides_the_credit_card_information(String entercardno,
			String expdate, String cvc, String zipcode) throws InterruptedException {

		loginwithforddrive.enterCardDetails(entercardno, expdate, cvc, zipcode);
	}

	@When("the user enters a Declined credit card number")
	public void the_user_enters_a_declined_credit_card_number() {
		// the user enters a Declined credit card number
	}

	@Then("a validation message should be displayed indicating the card is Declined")
	public void a_validation_message_should_be_displayed_indicating_the_card_is_declined() throws InterruptedException {

		loginwithforddrive.verifyDeclinedCreditcard();
	}

	//// verify incorrect credit card number

	@When("the user enters a Incorrect credit card number")
	public void the_user_enters_a_incorrect_credit_card_number() {
		// the user enters a Incorrect credit card number
	}

	@Then("a validation message should be displayed indicating the card is Incorrect")
	public void a_validation_message_should_be_displayed_indicating_the_card_is_incorrect()
			throws InterruptedException {

		loginwithforddrive.verifyIncorrectCreditCardNumber();
	}

	// verify expired credit card number

	@When("the user enters a expired creditcard number")
	public void the_user_enters_a_expired_creditcard_number() {
		// the user enters a expired creditcard number
	}

	@Then("a validation message should be displayed indicating the card is expired creditcard")
	public void a_validation_message_should_be_displayed_indicating_the_card_is_expired_creditcard()
			throws InterruptedException {

		loginwithforddrive.verifyexpiredCreditCard();
	}
	
	
	

}
