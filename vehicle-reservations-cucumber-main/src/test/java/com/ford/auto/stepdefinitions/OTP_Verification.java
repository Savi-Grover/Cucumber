package com.ford.auto.stepdefinitions;

import org.openqa.selenium.WebDriver;

import com.ford.auto.OTPverificationTest.OTPverificationPage;
import com.ford.auto.browser.Browser;
import com.ford.auto.support.WDSupport;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OTP_Verification extends Browser {

	OTPverificationPage Invaild_OTP;

	public WebDriver driver = getDriver();
	WDSupport driverSupport = new WDSupport(driver);

	@Given("the new driver is on the OTP verification page")
	public void the_new_driver_is_on_the_otp_verification_page() {
		// the new driver is on the OTP verification page

	}

	@When("the new driver enters a wrong OTP code")
	public void the_new_driver_enters_a_wrong_otp_code() {

		Invaild_OTP = new OTPverificationPage(driver);

		Invaild_OTP.OtpVerification();

	}

	@Then("an error message should be displayed indicating the OTP is incorrect")
	public void an_error_message_should_be_displayed_indicating_the_otp_is_incorrect() throws InterruptedException {

		Invaild_OTP = new OTPverificationPage(driver);

		Invaild_OTP.verifyOtpVerification();

	}

	@Then("the new driver should not be able to complete the verification process")
	public void the_new_driver_should_not_be_able_to_complete_the_verification_process() {
		// the new driver should not be able to complete the verification proces
	}

	// driver cannot complete OTP verification if entered OTP is less than 6 digits

	@When("the new driver enters an OTP code with less than six digits")
	public void the_new_driver_enters_an_otp_code_with_less_than_six_digits() throws InterruptedException {
		Invaild_OTP = new OTPverificationPage(driver);

		Invaild_OTP.enterOtpLessthan_6digits();

	}

	@Then("an error message should be displayed indicating the OTP is invalid")
	public void an_error_message_should_be_displayed_indicating_the_otp_is_invalid() throws InterruptedException {

		Invaild_OTP = new OTPverificationPage(driver);

		Invaild_OTP.verifyOtpLessthan_6digits();

	}
	
	
	// Verify new driver can see reset timer after clicking RESEND
	
	
	@When("user clicks on Resend button")
	public void user_clicks_on_resend_button() {
		
		Invaild_OTP = new OTPverificationPage(driver);
		
		Invaild_OTP.clickson_resendbutton();
		
	    
	}
	@Then("user can see timer reset Successfully")
	public void user_can_see_timer_reset_successfully() throws InterruptedException {
		
		Invaild_OTP = new OTPverificationPage(driver);
		
		Invaild_OTP.verifytimerreset();
	}


}
