package com.ford.auto.OTPverificationTest;

import static org.testng.Assert.fail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.ford.auto.browser.Browser;
import com.ford.auto.support.WDSupport;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OTPverificationPage extends Browser {
	WebDriver driver;
	WDSupport driverSupport;

	public OTPverificationPage(WebDriver driver) {
		this.driver = driver;
		this.driverSupport = new WDSupport(driver);

	}

	// Verify new driver cannot complete OTP verification if wrong OTP entered

	public void OtpVerification() {

		// enter invaild OTP
		driverSupport.locateByXpath("//div[@id='otp']/input[@id='first']").sendKeys("123111");
		driverSupport.locateByXpath("//button[text()='Verify and Continue']").click();

	}

	public void verifyOtpVerification() throws InterruptedException {

		Thread.sleep(2000);

		WebElement errorMessage = driverSupport.locateByXpath("//div[@id='verifyEmailUsingOTP_error_message']");

		// Verify the error message for incorrect OTP
		if (errorMessage.isDisplayed()) {
			System.out.println("Error message displayed: " + errorMessage.getText());
		} else {
			System.out.println("Error message not displayed for incorrect OTP");
		}

	}

	// Verify new driver cannot complete OTP verification if entered OTP is less than 6 digits

	public void enterOtpLessthan_6digits() throws InterruptedException {
		// enter OTP less than 6 digits
		driverSupport.locateByXpath("//div[@id='otp']/input[@id='first']").sendKeys("123");
		//driverSupport.locateByXpath("//button[text()='Verify and Continue']").click();

	}
	public void  verifyOtpLessthan_6digits() throws InterruptedException {
		
		Thread.sleep(2000);
		
		WebElement buttonElement =driver.findElement(By.xpath("//button[text()='Verify and Continue']"));
		
		 boolean actualvalue = buttonElement.isEnabled();

		// Check if the button is disabled
		if(actualvalue){
		    System.out.println("Driver enter the vaild OTP in the OTP verification page ");
		    
		    }else{
		    System.out.println("Driver cannot complete OTP verification if entered OTP is less than 6 digits");
		}
	}
	
	
	public void clickson_resendbutton() {
		
		driver.findElement(By.xpath("//a[@id='resendNewCodeLink']")).click();
		
	    
	}
	
	
	
	public void verifytimerreset() throws InterruptedException {
		
        Thread.sleep(2000);
		
		WebElement Resendbutton =driver.findElement(By.xpath("//div[@id='OTPTimer']"));
		
		 boolean actualvalue = Resendbutton.isDisplayed();

		// Check if the button is disabled
		if(actualvalue){
		    System.out.println("User can see timer reset in the OTP verification page ");
		    
		    }else{
		    System.out.println("Driver cannot see timer reset after clicking on the resend button");
		    Assert.fail();
		}
	    
	}



	
	

}
