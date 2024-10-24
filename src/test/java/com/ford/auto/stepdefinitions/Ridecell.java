package com.ford.auto.stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;

import com.ford.auto.RidecellPageobjects.ActivateAccount;
import com.ford.auto.RidecellPageobjects.Assignvin;
import com.ford.auto.RidecellPageobjects.LoginToDashboard;
import com.ford.auto.RidecellPageobjects.LogintoRidecell;
import com.ford.auto.RidecellPageobjects.OpenLifecycle;
import com.ford.auto.RidecellPageobjects.PendingReturn;
import com.ford.auto.RidecellPageobjects.ReturnProcess;
import com.ford.auto.RidecellPageobjects.SearchwithMail;
import com.ford.auto.RidecellPageobjects.SelectcountryfromDropdown;
import com.ford.auto.browser.Browser;

import com.ford.auto.support.WDSupport;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Ridecell extends Browser {

	Assignvin Assvinno;
	SelectcountryfromDropdown ddvalue;
	OpenLifecycle lifecyclepage;
	LogintoRidecell login;
	PendingReturn ppstatus;
    ActivateAccount activateaccount;

	public WebDriver driver = getDriver();
	WDSupport driverSupport = new WDSupport(driver);

	@Given("User enter {string} and {string} in the ridecell login page")
	public void user_enter_and_in_the_ridecell_login_page(String Email, String Password) throws Exception {
		
		

		login = new LogintoRidecell(driver);

		login.loginpageRidecell(Email, Password);

		/*
		 * String expected = login.verifyScheduledRentals();
		 * 
		 * System.out.println("Success Message :-" + expected + "****");
		 * 
		 * if (expected.contains("Scheduled Rentals"))
		 * 
		 * { System.out.println("Login to the Home page Successfully"); } else {
		 * Assert.fail(); }
		 */

	}

	@Given("select the desired location from the dropdown {string}")
	public void select_the_desired_location_from_the_dropdown(String Countryname) throws InterruptedException {

		ddvalue = new SelectcountryfromDropdown(driver);

		ddvalue.selectCountryName(Countryname);

	}

	@Given("user search customer details with {string} in Scheduled Rentals")
	public void user_search_customer_details_with_in_scheduled_rentals(String Email) throws InterruptedException {

		SearchwithMail email = new SearchwithMail(driver);

		email.searchWithEmailID(Email);

	}

	@Given("User should see the record and assign vin to the reservations {string}")
	public void user_should_see_the_record_and_assign_vin_to_the_reservations(String vinno)
			throws InterruptedException {
		Assvinno = new Assignvin(driver);

		Assvinno.assignVinNo(vinno);

	}

	@Given("VIN assigned successfully to the selected reservations")
	public void vin_assigned_successfully_to_the_selected_reservations() throws Exception {

		String expected = Assvinno.verifyUpcomingStatus();

		System.out.println("Success Message :-" + expected + "****");

		if (expected.contains("Upcoming"))

		{
			System.out.println("VinNo  assigned Successfully");
		} else {
			Assert.fail();
		}

	}

	@Given("User open Lifecycle from Activity section and selects the desired location {string}")
	public void user_open_lifecycle_from_activity_section_and_selects_the_desired_location(String Countryname)
			throws InterruptedException {

		driver.switchTo().newWindow(WindowType.TAB);

		driver.navigate().to("https://oval2-uat.ridecell.com/platform-one/platform/san-diego/automation/lifecycle");

		ddvalue.selectCountryName(Countryname);

	}

	@Given("User enter {string} in the search and pull reservations details")
	public void user_enter_in_the_search_and_pull_reservations_details(String VinNo) throws InterruptedException {

		lifecyclepage = new OpenLifecycle(driver);

		lifecyclepage.searchWithVinNo(VinNo);

	}

	@And("Expand reservations using v icon in Actions column")
	public void expand_reservations_using_v_icon_in_actions_column() throws Exception {

		lifecyclepage = new OpenLifecycle(driver);

		String expected = lifecyclepage.verifyPendingPickupStatus();

		System.out.println("Success Message :-" + expected + "****");

		if (expected.contains("Pending Pickup"))

		{
			System.out.println("pending pickup completed Successfully");
		} else {
			Assert.fail();
		}

	}

	@When("all the Lifecycle steps status are changed to Completed for pending pickup and pickup schedule")
	public void all_the_lifecycle_steps_status_are_changed_to_completed_for_pending_pickup_and_pickup_schedule()
			throws Exception {

		activateaccount = new ActivateAccount(driver);

		activateaccount.activateAccount();

	}

	@Then("Reservation will get activated successfully in ridecell")
	public void reservation_will_get_activated_successfully_in_ridecell() throws Exception {

		String expected = activateaccount.verifyActivateAccountStatus();

		System.out.println("Success Message :-" + expected + "****");

		if (expected.contains("5 | Active Subscription"))

		{
			System.out.println("Account activation is successfull");
		} else {
			System.out.println("Account activation is not successfull");
			Assert.fail();
		}

	}

	@And("Driver able to see the reservations status as active in the dashboard")
	public void driver_able_to_see_the_reservations_status_as_active_in_the_dashboard(String uberEmail) throws InterruptedException {

		driver.switchTo().newWindow(WindowType.TAB);

		driver.navigate()
				.to("https://stage.rideshare.forddrive.com/sign-up?referrer=bonjour.uber.com&flow=UBER");

		LoginToDashboard activestatus = new LoginToDashboard(driver);
		
		

		activestatus.LogintoDashboard(uberEmail);

		String expected = activestatus.activateStatus();

		System.out.println("Success Message :-" + expected + "****");

		if (expected.contains("MILEAGE SNAPSHOT"))

		{
			System.out.println("Account in active status in the dashboard");
		} else {
			System.out.println("Account is not active status");
			Assert.fail();
		}

	}

	@When("all the Lifecycle steps status are changed to Completed for pending pickup and active")
	public void all_the_lifecycle_steps_status_are_changed_to_completed_for_pending_pickup_and_active()
			throws Exception {

		activateaccount = new ActivateAccount(driver);

		activateaccount.activateAccount();

		String expected = activateaccount.verifyActivateAccountStatus();

		System.out.println("Success Message :-" + expected + "****");

		if (expected.contains("5 | Active Subscription"))

		{
			System.out.println("Account activation is successfull");
		} else {
			System.out.println("Account activation is not successfull");
			Assert.fail();
		}

	}

	@Then("Reservation status changed to pending return successfully")
	public void reservation_status_changed_to_pending_return_successfully() throws Exception {

		ppstatus = new PendingReturn(driver);

		ppstatus.verifyPendingreturn();

		String expected = ppstatus.PendingReturnStatus();

		System.out.println("Success Message :-" + expected + "****");

		if (expected.contains("6 | Pending Return"))

		{
			System.out.println("Account changed to Pending return successfull");
		} else {
			System.out.println("Account not changed to Pending return");
			Assert.fail();
		}

	}

	@Then("Driver able to see the reservations status as pending return in the dashboard")
	public void driver_able_to_see_the_reservations_status_as_pending_return_in_the_dashboard(String uberEmail)
			throws InterruptedException {
		driver.switchTo().newWindow(WindowType.TAB);

		driver.navigate()
				.to("https://stage.rideshare.forddrive.com/sign-up?referrer=bonjour.uber.com&flow=UBER");

		LoginToDashboard activestatus = new LoginToDashboard(driver);

		activestatus.LogintoDashboard(uberEmail);

		String expected = activestatus.activatePPStatus();

		System.out.println("Success Message :-" + expected + "****");

		if (expected.contains("Return Details:"))

		{
			System.out.println("Account in PendingReturn status in the dashboard");
		} else {
			System.out.println("Account is not PendingReturn status");
			Assert.fail();
		}
	}

	@When("all the Lifecycle steps status are changed to Completed for pending pickup,active and pending return")
	public void all_the_lifecycle_steps_status_are_changed_to_completed_for_pending_pickup_active_and_pending_return()
			throws Exception {
		
// changed lifecycle steps for active and pending return
		
		activateaccount = new ActivateAccount(driver);

		activateaccount.activateAccount();

		String expected = activateaccount.verifyActivateAccountStatus();

		System.out.println("Success Message :-" + expected + "****");

		if (expected.contains("5 | Active Subscription"))

		{
			System.out.println("Account activation is successfull");
		} else {
			System.out.println("Account activation is not successfull");
			Assert.fail();
		}
		
		ppstatus = new PendingReturn(driver);

		ppstatus.verifyPendingreturn();

		/*
		 * String expected2 = ppstatus.PendingReturnStatus();
		 * 
		 * System.out.println("Success Message :-" + expected2 + "****");
		 * 
		 * if (expected.contains("6 | Pending Return"))
		 * 
		 * { System.out.println("Account changed to Pending return successfull"); } else
		 * { System.out.println("Account not changed to Pending return"); Assert.fail();
		 * }
		 */


		

	}

	@Then("Reservation status changed to ended successfully")
	public void reservation_status_changed_to_ended_successfully() throws InterruptedException {
		// Reservation status changed to ended successfully
		ReturnProcess close = new ReturnProcess(driver);
		close.closetheAccount();

		String expected = close.verifyReturnProcess();

		System.out.println("Success Message :-" + expected + "****");

		if (expected.contains("1 | Vehicle Intake"))

		{
			System.out.println("Account has been successfully canceled.");
		} else {
			System.out.println("Account has not canceled successfully.");
			Assert.fail();
		}

	}
	

	@Then("Driver able to see the reservations status as closed in the dashboard")
	public void driver_able_to_see_the_reservations_status_as_closed_in_the_dashboard(String uberEmail) throws InterruptedException {
		
		driver.switchTo().newWindow(WindowType.TAB);

		driver.navigate()
				.to("https://stage.rideshare.forddrive.com/sign-up?referrer=bonjour.uber.com&flow=UBER");

		LoginToDashboard activestatus = new LoginToDashboard(driver);

		activestatus.LogintoDashboard(uberEmail);

		String expected = activestatus.closedStatus();

		System.out.println("Success Message :-" + expected + "****");

		if (expected.contains("Your lease has been successfully canceled. We hope you’ll drive with us again soon."))

		{
			System.out.println("Your lease has been successfully canceled in the dashboard");
		} else {
			System.out.println("Your lease has been successfully canceled in the dashboard");
			Assert.fail();
		}
		
	}

}
