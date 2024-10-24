package com.ford.auto.waitlist;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.ford.auto.browser.Browser;
import com.ford.auto.support.WDSupport;

public class ProfilePage extends Browser{
	WebDriver driver;
	WDSupport driverSupport;
	
	
	
	public ProfilePage(WebDriver driver) {
		this.driver=driver;
		this.driverSupport= new WDSupport(driver);
		
}



	public void clickonleasepackage() throws InterruptedException {
		
		Thread.sleep(2000);
		
		  driverSupport.locateByXpath("//i[@class='pi pi-chevron-right']").click();
		  
		  JavascriptExecutor js = (JavascriptExecutor) driver;
	       js.executeScript("window.scrollBy(0,-350)", "//img[contains(@alt,'lease payment page')]");
	       
	       driverSupport.locateByXpath("//img[contains(@alt,'lease payment page')]").click();
	       
	     }
	
	

}
