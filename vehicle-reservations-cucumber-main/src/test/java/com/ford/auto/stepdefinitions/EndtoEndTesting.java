package com.ford.auto.stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
import com.ford.auto.waitlist.ApplicationPage;
import com.ford.auto.waitlist.ConfrimPage;
import com.ford.auto.waitlist.Creditcardpage;
import com.ford.auto.waitlist.LoginWithUberPage;
import com.ford.auto.waitlist.Otppage;
import com.ford.auto.waitlist.AccountPackageSelection;
import com.ford.auto.waitlist.PackageSelection;
import com.ford.auto.waitlist.ProfilePage;
import com.ford.auto.waitlist.RegisterPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EndtoEndTesting extends Browser {

	LoginWithUberPage uberpage;
	Creditcardpage creditcardpage;
	RegisterPage partialsignup;
	AccountPackageSelection plan;
	PackageSelection plan2;
	ConfrimPage alert;
	LoginWithUberPage loginUber;
	LogintoRidecell login;
	Assignvin Assvinno;
    SelectcountryfromDropdown ddvalue;
	OpenLifecycle lifecyclepage;
	PendingReturn ppstatus;
    ActivateAccount activateaccount;
    String uberEmail =" ";

	public WebDriver driver = getDriver();
	WDSupport driverSupport = new WDSupport(driver);

	// Updated end to end testing stepdefinition 
	@Given("The new user has registered into the Forddrive.com application successfully with details such as {string},{string},{string},{string},{string}")
	public void the_new_user_has_registered_into_the_forddrive_com_application_successfully_with_details_such_as(String firstname, String lastname, String Email, String phoneno, String zipcode) throws InterruptedException {
	   
		
		/*
		 * // login into the uber market place uberpage = new LoginWithUberPage(driver);
		 * uberpage.loginWithUber();
		 * uberpage.signInwithUber(" andrew.brown+test+lettilbirch@uber.com",
		 * "Ford123!"); uberpage.selectfordDriveImage();
		 */
		
       //login to the partialsignup page
		partialsignup = new RegisterPage(driver);
        uberEmail = RegisterPage.getRandomEmailId();
        System.out.println("Register emailId of the new Driver   :" + uberEmail);
        partialsignup.registerPage(firstname, lastname, uberEmail, phoneno, zipcode);
        
        //otp verification 
        Otppage otp = new Otppage(driver);
		otp.OtpPage();
        
      }
	
	@Given("the new user changes the new package plan successfully {string} ,{string}")
	public void the_new_user_changes_the_new_package_plan_successfully(String packagename, String leasepackage) throws Exception {
		
		     //select the package selection page
				plan = new AccountPackageSelection(driver);
		        plan.PackageNamePage(packagename);
		        
		        // enter the application approval page details
		        ApplicationPage apppage = new ApplicationPage(driver);
		        apppage.applicationApprovalPage();
		        
		        // fill the credit card details 
		        creditcardpage = new Creditcardpage(driver);
				creditcardpage.entercreditcardpage();
				creditcardpage.Passwordpage();
				
				//verify new driver sgnup to the application
				
				Thread.sleep(3000);
				WebElement dashboardstatus = driver.findElement(By.xpath("//h4[@class='PickupInfoV2_heading__knKDp']"));

				String verifystatus = dashboardstatus.getText();

				if (verifystatus.contains("Pickup Pending")) {

					System.out.println("New driver signIn  to the FordDrive application Successfully" + "**********");

				} else {

					System.out.println("New driver has not signIn  to the FordDrive application Successfully" + "**********");
					Assert.fail();

				}
				
				
				//Driver clicks on the Lease Package section
				ProfilePage leasepck = new ProfilePage(driver);
                leasepck.clickonleasepackage();
                
                //driver change the required package
                plan2 = new PackageSelection(driver);
        		plan2.NewPackageName(leasepackage);
        		plan2.clicknext();
        		
        		
        		//Driver Confirms the package name"
        		
                  alert = new ConfrimPage(driver);
        	      alert.clickonconfirm();
        	      
                  String expected = alert.verifygetleasepackage();
        			
        			System.out.println("Success Message :-" + expected + "****");

        			if (expected.contains("$259.00/wk"))

        			{
        				System.out.println("New Driver switched to the new packages succesfully ********");
        			} else {
        				
        				System.out.println("New Driveris not switched to the new packages succesfully ********");
        				Assert.fail();
        			}

			}
	
	
	@Given("In Ride Cell operators verify the customer details and assign Vin no to the customer {string} , {string}")
	public void in_ride_cell_operators_verify_the_customer_details_and_assign_vin_no_to_the_customer(String Countryname, String vinno) throws Exception {
	    
		
		//login to the RideCell
		login = new LogintoRidecell(driver);
		
		login.loginWithRidecell();
		
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
		
		//select from the dropdown
		
		SelectcountryfromDropdown ddvalue = new SelectcountryfromDropdown(driver);
        ddvalue.selectCountryName(Countryname);
        
        // search with the email 
        
        SearchwithMail email = new SearchwithMail(driver);
        email.searchWithEmailID(uberEmail);
        
        
        // assign vinNo to the reservation 
        Assvinno = new Assignvin(driver);
        Assvinno.assignVinNo(vinno);
        
        String expectedresult = Assvinno.verifyUpcomingStatus();

		//System.out.println("Success Message :-" + expected + "****");

		if (expectedresult.contains("Upcoming"))

		{
			System.out.println("VinNo  assigned Successfully");
		} else {
			Assert.fail();
		}
		
		//User open Lifecycle from Activity section and select the desired location
		driver.switchTo().newWindow(WindowType.TAB);

		driver.navigate().to("https://oval2-uat.ridecell.com/platform-one/platform/san-diego/automation/lifecycle");

		ddvalue.selectCountryName(Countryname);
		
		// search with vinno 
		lifecyclepage = new OpenLifecycle(driver);

		lifecyclepage.searchWithVinNo(vinno); 
		
		lifecyclepage = new OpenLifecycle(driver);

		String expectedstatus = lifecyclepage.verifyPendingPickupStatus();

		System.out.println("Success Message :-" + expectedstatus + "****");

		if (expectedstatus.contains("Pending Pickup"))

		{
			System.out.println("pending pickup completed Successfully");
		} else {
			Assert.fail();
		}
		
		
}
	
	
	@Given("the new customer picked up the vehicle and the status has changed to Active from pickup scheduled")
	public void the_new_customer_picked_up_the_vehicle_and_the_status_has_changed_to_active_from_pickup_scheduled() throws Exception {
		
//		actived the vino 
			activateaccount = new ActivateAccount(driver);

			activateaccount.activateAccount();
			
			String expectedactive = activateaccount.verifyActivateAccountStatus();

			System.out.println("Success Message :-" + expectedactive + "****");

			if (expectedactive.contains("5 | Active Subscription"))

			{
				System.out.println("Account activation is successfull");
			} else {
				System.out.println("Account activation is not successfull");
				Assert.fail();
			}
	    
	    
	}



       @Given("after utilizing the car the customer informed the company and returned the car and the status changed to the pending return")
	public void after_utilizing_the_car_the_customer_informed_the_company_and_returned_the_car_and_the_status_changed_to_the_pending_return() throws Exception {

		// make the account pending return
		ppstatus = new PendingReturn(driver);

		ppstatus.verifyPendingreturn();

		String expectedPendingReturn = ppstatus.PendingReturnStatus();

		System.out.println("Success Message :-" + expectedPendingReturn + "****");

		if (expectedPendingReturn.contains("6 | Pending Return"))

		{
			System.out.println("Account changed to Pending return successfull");
		} else {
			System.out.println("Account not changed to Pending return");
			Assert.fail();
		}
	}
	@When("the inspection of the returned car is completed")
	public void the_inspection_of_the_returned_car_is_completed() throws InterruptedException {
		
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
	@Then("the reservation status is set to close and the customer can view the status as closed in the dashboard")
	public void the_reservation_status_is_set_to_close_and_the_customer_can_view_the_status_as_closed_in_the_dashboard() throws InterruptedException {
		driver.switchTo().newWindow(WindowType.TAB);

		driver.navigate()
				.to("https://stage.rideshare.forddrive.com/sign-up?referrer=https%3A%2F%2Fbonjour.uber.com%2F");

		LoginToDashboard activestatus = new LoginToDashboard(driver);

		activestatus.LogintoDashboard(uberEmail);

		String expected = activestatus.closedStatus();

		System.out.println("Success Message :-" + expected + "****");

		if (expected.contains("Your lease has been successfully canceled. We hope you’ll drive with us again soon."))

		{
			System.out.println("Your lease has been successfully Closed in the dashboard");
		} else {
			System.out.println("Your lease has been not successfully Closed in the dashboard");
			Assert.fail();
		}
	}



}
