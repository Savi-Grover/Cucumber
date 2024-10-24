package com.ford.auto.stepdefinitions;

import com.ford.auto.logging.Logger;
import com.ford.auto.waitlist.*;
import com.ford.auto.waitlist.PackageSelection;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;

import com.ford.auto.browser.Browser;
import com.ford.auto.support.WDSupport;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class WaitlistFlow extends Browser {

	Creditcardpage ccpage;
	ConfrimPage alert;
	LoginWithUberPage loginUber;
	SignInPage signinpage;

	public WebDriver driver = getDriver();
	WDSupport driverSupport = new WDSupport(driver);

	// login with uber market place

	@Given("User clicks on login with Uber")
	public void user_clicks_on_login_with_uber() throws InterruptedException {

		loginUber = new LoginWithUberPage(driver);
		loginUber.loginWithUber();

	}

	@Given("Signin with vaild uber account and password {string},{string}")
	public void signin_with_vaild_uber_account_and_password(String Uberemail, String UberPassword)
			throws InterruptedException {

		loginUber = new LoginWithUberPage(driver);

		loginUber.signInwithUber(Uberemail, UberPassword);

	}

	@Given("select Ford drive image")
	public void select_ford_drive_image() throws InterruptedException {

		loginUber = new LoginWithUberPage(driver);

		loginUber.selectfordDriveImage();

	}

	@When("User clicks on get started")
	public void user_clicks_on_get_started() {
		// User clicks on get started

	}

	@Then("ford drive launch partial profile")
	public void ford_drive_launch_partial_profile() throws InterruptedException {
		Thread.sleep(3000);
		driver.switchTo().newWindow(WindowType.TAB);

		driver.navigate().to(
				"https://stage.rideshare.forddrive.com/sign-up?referrer=bonjour.uber.com&flow=UBER");
		         //https://stage.rideshare.forddrive.com/sign-up?referrer=https%3A%2F%2Fbonjour.uber.com%2F&flow=UBER

	}
	

	@Given("that a new driver has registered with his info {string},{string},{string},{string},{string}")
	public void that_a_new_driver_has_registered_with_his_info(String firstname, String lastname, String email,
			String phoneno, String zipcode) throws InterruptedException {

		RegisterPage rp = new RegisterPage(driver);

		String uberEmail = RegisterPage.getRandomEmailId();

		System.out.println("UberEmail;" + uberEmail);

		rp.registerPage(firstname, lastname, uberEmail, phoneno, zipcode);

	}

	@Given("has been verified with otp functionality successfully")
	public void has_been_verified_with_otp_functionality_successfully() throws InterruptedException {

		Otppage otp = new Otppage(driver);

		otp.OtpPage();

	}

	@Given("the new driver selects the {string}")
	public void the_new_driver_selects_the(String packagename) throws InterruptedException {

		AccountPackageSelection pkg = new AccountPackageSelection(driver);

		pkg.PackageNamePage(packagename);

	}

	@Given("provides info {string},{string},{string},{string},{string},{string},{string},{string}")
	public void provides_info(String DLnumber, String month, String day, String year, String address, String city,
			String state, String zipCode) throws InterruptedException {

		ApplicationPage ap = new ApplicationPage(driver);

		ap.ApplicationPage(DLnumber, month, day, year, address, city, state, zipCode);

	}

	// dashboard page
	@Given("provides the credit card information {string},{string},{string},{string}")
	public void provides_the_credit_card_information(String entercardno, String expdate, String cvc, String zipcode)
			throws InterruptedException {

		ccpage = new Creditcardpage(driver);

		ccpage.fillcreditcardpage(entercardno, expdate, cvc, zipcode);

	}
	// SSN page credit card page

	@Then("driver provides the credit card information {string},{string},{string},{string}")
	public void driver_provides_the_credit_card_information(String entercardno, String expdate, String cvc,
			String zipcode) throws InterruptedException {
		ccpage = new Creditcardpage(driver);

		ccpage.fillcreditcardpage(entercardno, expdate, cvc, zipcode);

	}

	@When("new driver sets the password and submit it")
	public void new_driver_sets_the_password_and_submit_it() throws InterruptedException {

		ccpage.Passwordpage();

	}

	@Then("new driver lands on the dashboard page")
	public void new_driver_lands_on_the_dashboard_page() throws InterruptedException {
		Thread.sleep(3000);
		WebElement dashboardstatus = driver.findElement(By.xpath("//h4[@class='PickupInfoV2_heading__knKDp']"));

		String verifystatus = dashboardstatus.getText();

		if (verifystatus.contains("Pickup Pending")) {

			System.out.println("New driver signIn  to the FordDrive application Successfully" + "**********");

		} else {

			System.out.println("New driver has not signIn  to the FordDrive application Successfully" + "**********");
			Assert.fail();

		}

	}

	@When("the name or address does not match with experian SSN verification is required {string}")
	public void the_name_or_address_does_not_match_with_experian_ssn_verification_is_required(String SSNno) {

		SSNPage ssn = new SSNPage(driver);

		ssn.enterSSNPage(SSNno);

	}

	// switching tiers

	@Then("driver clicks the Lease Package section in the Profile section.")
	public void driver_clicks_the_lease_package_section_in_the_profile_section() throws InterruptedException {

		ProfilePage leasepck = new ProfilePage(driver);

		leasepck.clickonleasepackage();

	}

	@Then("change the required {string}")
	public void change_the_required(String PackageName) throws InterruptedException {

		PackageSelection pkg = new PackageSelection(driver);

		pkg.NewPackageName(PackageName);

		pkg.clicknext();

	}

	@Then("the package is changed successfull {string}")
	public void the_package_is_changed_successfully (String packageName) throws InterruptedException{
		Logger.LogEnterMethod("The settings page should display with the appropriate package. packageName=" + packageName);
		SettingsPage settingsPage = new SettingsPage(driver);
		settingsPage.waitForPackageName(packageName);
	}

	@When("driver Confirms the package name")
	public void driver_click_on_confirm_button_in_modal_popup() throws InterruptedException {
		alert = new ConfrimPage(driver);
		alert.clickonconfirm();

	}
	
	
	
	
//Driver able to return using JOIN NOW-SIGNIN button - With Password
	
	
	
	@Then("Partial signup page will get displayed")
	public void partial_signup_page_will_get_displayed() throws InterruptedException {
		
		Thread.sleep(3000);
		driver.switchTo().newWindow(WindowType.TAB);

		driver.navigate().to(
				"https://stage.rideshare.forddrive.com/sign-up?referrer=https%3A%2F%2Fbonjour.uber.com%2F&flow=UBER");

}
	
	
	@Then("click on Signin link below the Partial profile page")
	public void click_on_signin_link_below_the_partial_profile_page() throws InterruptedException {
	    
		signinpage = new SignInPage(driver);
		
		signinpage.clickOnSignInLink();
		
		
	}
	
	@Then("user lands on signin homepage")
	public void user_lands_on_signin_homepage() throws InterruptedException {
		
		signinpage.verifysignInpagetitle();
	}
	
	
	@When("user enter email and password {string} , {string}")
	public void user_enter_email_and_password(String emailid, String password) throws InterruptedException {
		
		signinpage.LogintoOTPpage(emailid, password);
	    
	}
	
	
	@Then("user login into the dashboard succesfully")
	public void user_login_into_the_dashboard_succesfully() throws InterruptedException {
		
		signinpage.newdriverlandsonthe_dashboardpage();
	    
	}
	
	// Driver able to return using JOIN NOW button without passwd 

	@Then("do not set password and submit it")
	public void do_not_set_password_and_submit_it() {
	    // do not set password and submit it
	}
	
	
	
// Driver able to return using JOIN NOW-SIGNIN button -Without Password
	

@Then("user login into the OTP verification page successfully")
public void user_login_into_the_otp_verification_page_successfully() throws InterruptedException {
	
	signinpage.VerifyOTPpage();
}


/*
 * @When("the name or address does not match with experian SSN verification is required {string}"
 * ) public void
 * theNameOrAddressDoesNotMatchWithExperianSSNVerificationIsRequired(String
 * arg0) { }
 */
}
