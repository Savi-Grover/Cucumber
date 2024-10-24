package com.ford.auto.PartialSignup;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.ford.auto.browser.Browser;
import com.ford.auto.support.WDSupport;

public class ParitalSignuppage extends Browser {

	WebDriver driver;
	WDSupport driverSupport;

	public ParitalSignuppage(WebDriver driver) {
		this.driver = driver;
		this.driverSupport = new WDSupport(driver);

	}
	
	public void verifyPartialprofilepage() throws InterruptedException {
		
        Thread.sleep(1000);

		WebElement verifypartialprofile = driverSupport.locateByXpath("//img[@class='SignUp_join_now_img__7Bx+l']");
		String actualMessage = verifypartialprofile.getText();
		String expectedMessage = "Join Now";

		Assert.assertEquals(actualMessage, expectedMessage);

		System.out.println("login to the Partialprofile page succesfully");

	}

	public void paritalSignupagevalidation(String firstname, String lastname, String email, String phoneno,
			String zipcode) throws InterruptedException {

		driverSupport.locateByXpath("//input[@id='firstName']").sendKeys(firstname);

		driverSupport.locateByXpath("//input[@id='lastName']").sendKeys(lastname);

		driverSupport.locateByXpath("//input[@id='email']").sendKeys(email);
		driverSupport.locateByXpath("//input[@id='phoneNo']").sendKeys(phoneno);

		driverSupport.locateByXpath("//input[@id='homeZipCode']").sendKeys(zipcode);
		
		driverSupport.locateByXpath("//input[@data-testid='consents'][@type='checkbox']").click();
		
		
	}
	
	public void userclicksGetstartedbtn() throws InterruptedException {
		Thread.sleep(3000);
       driverSupport.locateByXpath("//button[text()='Get Started']").click();
       Thread.sleep(3000);
	}
	
	// Validate the partial page with invalid data
	public void Validateerrormsg() {
		
	WebElement	FirstNameErrMsg = driverSupport.locateByXpath("//p[text()='Enter a valid First Name']");
        String 	actualErrorMessage = FirstNameErrMsg.getText();
        String  expectedErrorMessage ="Enter a valid First Name";
        
     // Validate error message
        Assert.assertEquals(actualErrorMessage,expectedErrorMessage);
        System.out.println("Firstname verified");
        
        WebElement	LastNameErrMsg = driverSupport.locateByXpath("//p[text()='Enter a valid Last Name']");
        String actualErrorMessage1 = LastNameErrMsg.getText();
        String  expectedErrorMessage1 ="Enter a valid Last Name";
        
     // Validate error message
        Assert.assertEquals(actualErrorMessage1,expectedErrorMessage1);
        System.out.println("LastName verified");
        
        
        WebElement	EmailErrMsg = driverSupport.locateByXpath("//p[text()='Please enter an email address in the correct format']");
        String actualErrorMessage2 = EmailErrMsg.getText();
        String  expectedErrorMessage2 ="Please enter an email address in the correct format";
        
     // Validate error message
        Assert.assertEquals(actualErrorMessage2,expectedErrorMessage2);
        System.out.println("Email verified");
        
        
        WebElement	PhoneNoErrMsg = driverSupport.locateByXpath("//p[text()='Please enter a phone number in the correct format']");
        String actualErrorMessage3 = PhoneNoErrMsg.getText();
        String  expectedErrorMessage3 ="Please enter a phone number in the correct format";
        
     // Validate error message
        Assert.assertEquals(actualErrorMessage3,expectedErrorMessage3);
        System.out.println("PhoneNo verified");
        
        
        
        WebElement	ZipcodeErrMsg = driverSupport.locateByXpath("//p[text()='Provided Zip Code must be 5 digits']");
        String actualErrorMessage4 = ZipcodeErrMsg.getText();
        String  expectedErrorMessage4 ="Provided Zip Code must be 5 digits";
        
     // Validate error message
        Assert.assertEquals(actualErrorMessage4,expectedErrorMessage4);
        System.out.println("Zipcode verified");
        
		
		
	}
	
	
	public void VerifyGetStartedButtonState() throws InterruptedException {
		
		Thread.sleep(2000);
		WebElement buttonElement =driver.findElement(By.xpath("//button[text()='Get Started']"));
		
		 boolean actualvalue = buttonElement.isEnabled();

		// Check if the button is disabled
		if(actualvalue){
		    System.out.println("Get Started Button is enabled");
		}else{
		    System.out.println("Get Started Button is disabled");
		}
		
	}
	
	

	}


