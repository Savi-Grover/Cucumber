package com.ford.auto.stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.ford.auto.PackageselectionPage.BundleInsurance;
import com.ford.auto.browser.Browser;
import com.ford.auto.support.WDSupport;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PackageSelection extends Browser {
	BundleInsurance packagepage;

	public WebDriver driver = getDriver();
	WDSupport driverSupport = new WDSupport(driver);

	@Given("user is on the Package Selection screen {string},{string},{string},{string},{string}")
	public void user_is_on_the_package_selection_screen(String firstname, String lastname, String email, String phoneno,
			String zipcode) throws InterruptedException {

		packagepage = new BundleInsurance(driver);

		String uberEmail = BundleInsurance.getRandomEmailId();

		System.out.println("UberEmail : " + uberEmail);

		packagepage.registerPage(firstname, lastname, uberEmail, phoneno, zipcode);

		packagepage.otpPage();

	}

	@When("user navigates to the Bundle Insurance section")
	public void user_navigates_to_the_bundle_insurance_section() throws Exception {

		Thread.sleep(1000);
		String expected = packagepage.verifypackageselectionpage();

		System.out.println("Success Message :-" + expected + "****");

		if (expected.contains("Package Selection"))

		{
			System.out.println("Switch to the Package Selection page Successfully");
		} else {
			Assert.fail();
		}

		driverSupport.locateByXpath("//a[text()='Bundled Insurance']").click();

		Thread.sleep(1000);

	}

	@Then("Bundle Insurance hyperlink is displayed")
	public void bundle_insurance_hyperlink_is_displayed() {

		WebElement packagename = driverSupport.locateByXpath("//span[@class='p-dialog-header-close-icon pi pi-times']");

		boolean actualHeading = packagename.isDisplayed();

		// Checking the alert is displayed while click on the Bundle Insurance hyperlink

		if (actualHeading) {
			System.out.println("Bundle Insurance hyperlink is displayed on the page");

		} else {
			System.out.println("Bundle Insurance hyperlink is not displayed on the page");
		}

	}

}
