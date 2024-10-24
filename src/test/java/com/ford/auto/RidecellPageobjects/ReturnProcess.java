package com.ford.auto.RidecellPageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.ford.auto.browser.Browser;
import com.ford.auto.support.WDSupport;

public class ReturnProcess extends Browser {

	WebDriver driver;
	WDSupport driverSupport;

	public ReturnProcess(WebDriver driver) {
		this.driver = driver;
		this.driverSupport = new WDSupport(driver);

	}

	public void closetheAccount() throws InterruptedException {

		Thread.sleep(10000);

		WebElement table = driverSupport.locateByXpath("(//table[@class='webElements-DataTable-table'])[2]");

		List<WebElement> selectdropdown = table
				.findElements(By.xpath("//select[contains(@data-test-id,'DataTable__TableRow__DataTable__TableRow')]"));

		for (WebElement webElement : selectdropdown) {

			System.out.println("i......" + webElement);

			Select dropdownlist = new Select(webElement);

			dropdownlist.selectByVisibleText("Completed");
			driverSupport.locateByXpath("//button[text()='Yes']").click();
			Thread.sleep(8000);

		}

	}

	public String verifyReturnProcess() {

		String verifyclosedtatus = driverSupport.locateByXpath("//div[text()='1 | Vehicle Intake']").getText();

		System.out.println(verifyclosedtatus);

		return verifyclosedtatus;
	}

}
