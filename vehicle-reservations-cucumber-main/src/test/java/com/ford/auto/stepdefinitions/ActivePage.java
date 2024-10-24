package com.ford.auto.stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.ford.auto.activepage.SignInWithVaildaddress;
import com.ford.auto.activepage.leasepackagepage;
import com.ford.auto.browser.Browser;
import com.ford.auto.support.WDSupport;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ActivePage extends Browser {

	SignInWithVaildaddress activepage;

	public WebDriver driver = getDriver();
	WDSupport driverSupport = new WDSupport(driver);

	// Pricing Tiers - Verify the selected pricing tier appears in Active page.

	@Given("I have signed up with a valid address {string} and {string}")
	public void i_have_signed_up_with_a_valid_address_and(String EmailId, String Password) throws InterruptedException {

		activepage = new SignInWithVaildaddress(driver);

		activepage.signInwithVaildaddress(EmailId, Password);

	}

	@Given("I am on the Active page")
	public void i_am_on_the_active_page() throws InterruptedException {

		activepage.verifyactivehomepage();
	}
	
	@When("I select a pricing tier {string}")
	public void i_select_a_pricing_tier(String string) {
		//I select a pricing tier
	}
	

	@Then("I should see the selected tier tile under the Lease package section")
	public void i_should_see_the_selected_tier_tile_under_the_lease_package_section() {
		//I should see the selected tier tile under the Lease package section 
	}

	@Then("the lease package should show the latest selected pricing tier {string}")
	public void the_lease_package_should_show_the_latest_selected_pricing_tier(String packagepage) throws InterruptedException {
		
		leasepackagepage leasepackage = new leasepackagepage(driver);
		
		
		Thread.sleep(5000);
		String expected = leasepackage.verifyleasepackage(packagepage);

		System.out.println("Success Message :-" + expected + "****");

		if (expected.contains("packagepage"))

		{
			System.out.println("New package name is displaying Successfully in the Active dashboard page");
		} else {
			Assert.fail();
		}

	}

}
