package com.ford.auto.stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.ford.auto.RidecellPageobjects.LoginToDashboard;
import com.ford.auto.browser.Browser;
import com.ford.auto.support.WDSupport;
import com.ford.auto.waitlist.ApplicationPage;
import com.ford.auto.waitlist.Creditcardpage;
import com.ford.auto.waitlist.AccountPackageSelection;
import com.ford.auto.waitlist.RestartMembershipPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RestartMembership extends Browser {

	public WebDriver driver = getDriver();
	WDSupport driverSupport = new WDSupport(driver);

	@Given("user login with closed account to signin {string}")
	public void user_login_with_closed_account_to_signin(String EmailId) throws InterruptedException {

		LoginToDashboard logintoforddriver = new LoginToDashboard(driver);

		logintoforddriver.LogintoDashboard(EmailId);
		
		Thread.sleep(2000);

		String expected = logintoforddriver.closedStatus();

		System.out.println("Success Message :-" + expected + "****");

		if (expected.contains("Your lease has been successfully canceled. We hope you’ll drive with us again soon."))

		{
			System.out.println("Your lease has been successfully canceled in the dashboard");
		} else {
			System.out.println("Your lease has been successfully canceled in the dashboard");
			Assert.fail();
		}

	}

	@Given("click on restart membership on dashboard")
	public void click_on_restart_membership_on_dashboard() throws InterruptedException {

		RestartMembershipPage clickonrestart_button = new RestartMembershipPage(driver);

		clickonrestart_button.clickonRestartbutton();
		
		Thread.sleep(2000);

		String actual_pageheader = clickonrestart_button.verifyPackageSelectionpage();

		System.out.println("Success Message :-" + actual_pageheader + "****");

		if (actual_pageheader.contains("Package Selection"))

		{
			System.out.println("Navigate to the Package Selection page Successfully");
		} else {

			System.out.println("User not switch to the Package Selection page Successfully");
			Assert.fail();
		}

	}

	@Given("select the packages from the package selection page {string}")
	public void select_the_packages_from_the_package_selection_page(String newpackages) throws InterruptedException {

		AccountPackageSelection select_package = new AccountPackageSelection(driver);

		select_package.NewPackageName(newpackages);

	}

	@Given("user complete the application approval page {string},{string},{string},{string},{string},{string},{string},{string}")
	public void user_complete_the_application_approval_page(String DLnumber, String month, String day, String year,
			String address, String city, String state, String zipCode) throws InterruptedException {

		ApplicationPage approvalPage = new ApplicationPage(driver);

		approvalPage.ApplicationPage(DLnumber, month, day, year, address, city, state, zipCode);

	}

	@When("user enter credit card details and the password information {string},{string},{string},{string}")
	public void user_enter_credit_card_details_and_the_password_information(String entercardno, String expdate,
			String cvc, String zipcode) throws InterruptedException {

		Creditcardpage entercard_details = new Creditcardpage(driver);

		entercard_details.fillcreditcardpage(entercardno, expdate, cvc, zipcode);

		entercard_details.Passwordpage();

	}

	@Then("Reservation will be created sucessfully.")
	public void reservation_will_be_created_sucessfully() throws InterruptedException {
		Thread.sleep(3000);
		WebElement newreservationstatus = driver.findElement(By.xpath("//h4[@class='PickupInfoV2_heading__knKDp']"));

		String verifystatus = newreservationstatus.getText();

		if (verifystatus.contains("Pickup Pending")) {

			System.out.println("New driver signIn  to the FordDrive application Successfully" + "**********");

		} else {

			System.out.println("New driver has not signIn  to the FordDrive application Successfully" + "**********");
			Assert.fail();

		}
	}

}
