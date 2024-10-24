package com.ford.auto.stepdefinitions;

import org.openqa.selenium.WebDriver;

import com.ford.auto.browser.Browser;
import com.ford.auto.creditcardpages.CCvalidateInProfilePage;
import com.ford.auto.support.WDSupport;
import com.ford.auto.waitlist.LoginWithUberPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddNickname extends Browser {

	CCvalidateInProfilePage signinwithlink;

	public WebDriver driver = getDriver();
	WDSupport driverSupport = new WDSupport(driver);

	@Given("user login with exsisting account to signin {string} and {string}")
	public void user_login_with_exsisting_account_to_signin_and(String email, String password)
			throws InterruptedException {

		signinwithlink = new CCvalidateInProfilePage(driver);

		signinwithlink.loginWithSignupLink(email, password);
	}

	@Given("click on Profile section in the dashboard")
	public void click_on_profile_section_in_the_dashboard() throws InterruptedException {

		signinwithlink.clicksOnAddCreditCard();

	}
	
	@Given("click on Credit section")
	public void click_on_credit_section() {
		//click on Credit section
	}
	
	

	@Given("click on Add Credit card {string}")
	public void click_on_add_credit_card(String cardName) throws InterruptedException {
		
		signinwithlink.clicksOnAddCreditCard(cardName);
		
	}

	@Given("add Nickname in Text box and Select Primary Payment method checkbox")
	public void add_nickname_in_text_box_and_select_primary_payment_method_checkbox() {
		//add Nickname in Text box and Select Primary Payment method checkbox
		
	}

	@Given("user enters Credit Card information {string},{string},{string},{string}")
	public void user_enters_credit_card_information(String entercardno, String expdate, String cvc, String zipcode) throws InterruptedException {
		
		signinwithlink.enterCardDetails(entercardno, expdate, cvc, zipcode);
	}
	

	@When("user click on Add Payment Method")
	public void user_click_on_add_payment_method() {
		//user click on Add Payment Method 
	}

	@Then("the validation message should be displayed indicating the card added to the payment method sucessfully")
	public void the_validation_message_should_be_displayed_indicating_the_card_added_to_the_payment_method_sucessfully() throws InterruptedException {
		
		signinwithlink.validateNickNameSuccessMessage();
	}

}
