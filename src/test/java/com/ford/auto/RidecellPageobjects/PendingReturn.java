package com.ford.auto.RidecellPageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.ford.auto.browser.Browser;
import com.ford.auto.support.WDSupport;

public class PendingReturn extends Browser {
	
	WebDriver driver;
	WDSupport driverSupport;

	public PendingReturn(WebDriver driver) {
		this.driver = driver;
		this.driverSupport = new WDSupport(driver);

	}
	
	public void verifyPendingreturn() throws Exception {
		Thread.sleep(2000);
		
		WebElement clickprogress = driverSupport
				.locateByXpath("(//select[contains(@data-test-id,'DataTable__TableRow__DataTable__TableRow')])[1]");
		
        Select dropdown = new Select(clickprogress);
		dropdown.selectByVisibleText("Completed");
        WebElement clickYes = driverSupport.locateByXpath("//button[text()='Yes']");
        clickYes.click();
        
        Thread.sleep(3000);
        WebElement clickQueue = driverSupport.locateByXpath("(//select[contains(@data-test-id,'DataTable__TableRow__DataTable__TableRow')])");
		Select dropdown2 = new Select(clickQueue);
        dropdown2.selectByVisibleText("Completed");
        WebElement clickYesbtn = driverSupport.locateByXpath("//button[text()='Yes']");
        clickYesbtn.click();
        Thread.sleep(5000);
	}
	
	public String PendingReturnStatus() throws InterruptedException {
		

		String verifyPPstatus = driverSupport.locateByXpath("//div[text()='6 | Pending Return']").getText();

		System.out.println(verifyPPstatus);

		return verifyPPstatus;
	}
	
	

}
