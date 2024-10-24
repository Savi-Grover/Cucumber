package com.ford.auto.RidecellPageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.ford.auto.browser.Browser;
import com.ford.auto.support.WDSupport;

public class ActivateAccount extends Browser {

	WebDriver driver;
	WDSupport driverSupport;

	public ActivateAccount(WebDriver driver) {
		this.driver = driver;
		this.driverSupport = new WDSupport(driver);

	}

	public void activateAccount() throws Exception {
		
		Thread.sleep(10000);

		WebElement table = driverSupport.locateByXpath("(//table[@class='webElements-DataTable-table'])[2]");

		List<WebElement> selectdropdown = table
				.findElements(By.xpath("//select[contains(@data-test-id,'DataTable__TableRow__DataTable__TableRow')]"));
		
		
		System.out.println("table" + selectdropdown.size());

		for (WebElement x : selectdropdown) {

			System.out.println("i......" + x);
			
			Select dropdown2 = new Select(x);

			dropdown2.selectByVisibleText("Completed");
			driverSupport.locateByXpath("//button[text()='Yes']").click();
			Thread.sleep(8000);

		}
	}

	public String verifyActivateAccountStatus() {

		String  verifyactivestatus = driverSupport.locateByXpath("//div[text()='5 | Active Subscription']").getText();

		System.out.println( verifyactivestatus);

		return  verifyactivestatus;
	}
	
	

}
