package com.ford.auto.stepdefinitions;

import org.openqa.selenium.WebDriver;

import com.ford.auto.applicationapprovalpages.Approvalpage;
import com.ford.auto.applicationapprovalpages.DateOfBirth;
import com.ford.auto.applicationapprovalpages.HomeAddress;
import com.ford.auto.applicationapprovalpages.ValidateCheckBoxPage;
import com.ford.auto.browser.Browser;
import com.ford.auto.support.WDSupport;
import com.ford.auto.waitlist.ApplicationPage;
import com.ford.auto.waitlist.Otppage;
import com.ford.auto.waitlist.AccountPackageSelection;
import com.ford.auto.waitlist.RegisterPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ApplicationApprovalPage extends Browser {

	ValidateCheckBoxPage checkbox;

	public WebDriver driver = getDriver();
	WDSupport driverSupport = new WDSupport(driver);

	@Given("Sign up should be done in ford drive with this info {string},{string},{string},{string},{string}")
	public void sign_up_should_be_done_in_ford_drive_with_this_info(String firstname, String lastname, String email,
			String phoneno, String zipcode) throws InterruptedException {
		RegisterPage signup = new RegisterPage(driver);

		String uberEmail = signup.getRandomEmailId();

		System.out.println("UberEmail;" + uberEmail);

		signup.registerPage(firstname, lastname, uberEmail, phoneno, zipcode);

	}

	@Given("has been verified with an otp functionality successfully")
	public void has_been_verified_with_an_otp_functionality_successfully() throws InterruptedException {
		Otppage otp = new Otppage(driver);

		otp.OtpPage();

	}

	@Given("Lease package {string} should be selected by user")
	public void lease_package_should_be_selected_by_user(String packagename) throws InterruptedException {
		AccountPackageSelection pkg = new AccountPackageSelection(driver);

		pkg.NewPackageName(packagename);
	}

	@Given("user is on the Application approval page provides info {string},{string},{string},{string},{string},{string},{string},{string}")
	public void user_is_on_the_application_approval_page_provides_info(String DLnumber, String month, String day,
			String year, String address, String city, String state, String zipCode) throws InterruptedException {
		ApplicationPage ap = new ApplicationPage(driver);

        try {
            ap.ApplicationPage(DLnumber, month, day, year, address, city, state, zipCode);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

	@When("user enters an invalid license number in the license field")
	public void user_enters_an_invalid_license_number_in_the_license_field() {

		// user enters an invalid license number in the license field

	}

	@Then("an error message should be displayed")
	public void an_error_message_should_be_displayed() throws InterruptedException {

		Approvalpage licensefield = new Approvalpage(driver);

		licensefield.Validateinvalidlicensenumber();

	}

	@When("user enters an invalid date of birth")
	public void user_enters_an_invalid_date_of_birth() {

		// user enters an invalid date of birth

	}

	@Then("an error message should be displayed successfully")
	public void an_error_message_should_be_displayed_successfully() throws InterruptedException {
		DateOfBirth dob = new DateOfBirth(driver);

		dob.validateDateOfBirth();

	}

	@When("user enters an invalid  special characters in the home address")
	public void user_enters_an_invalid_special_characters_in_the_home_address() {
		// user enters an invalid special characters in the home address

	}

	@Then("An error message should be displayed")
	public void An_error_message_should_be_displayed() throws InterruptedException {

		HomeAddress address = new HomeAddress(driver);

		address.validateHomeAddress();

	}

	// Verify that the checkbox is required to proceed to the next step

	@Given("user is on the Application approval page provides info in  {string},{string},{string},{string},{string},{string},{string},{string}")
	public void user_is_on_the_application_approval_page_provides_info_in(String DLnumber, String month, String day,
			String year, String address, String city, String state, String zipCode) {

		checkbox = new ValidateCheckBoxPage(driver);
		checkbox.ApplicationPage(DLnumber, month, day, year, address, city, state, zipCode);

	}

	@When("the user tries to proceed without selecting the checkbox")
	public void the_user_tries_to_proceed_without_selecting_the_checkbox() throws InterruptedException {

		checkbox = new ValidateCheckBoxPage(driver);

		checkbox.userclicksConsentCheckbox();
	}

	@Then("the user should not be able to proceed to the next step")
	public void the_user_should_not_be_able_to_proceed_to_the_next_step() {
		// the user should not be able to proceed to the next step
	}

}
