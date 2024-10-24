package com.ford.auto.footerlinks;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.ford.auto.browser.Browser;
import com.ford.auto.support.WDSupport;

public class FooterLinksPages extends Browser {

	WebDriver driver;
	WDSupport driverSupport;

	public FooterLinksPages(WebDriver driver) {
		this.driver = driver;
		this.driverSupport = new WDSupport(driver);

	}

	public void verifyFooterLinks() {

		WebElement footerlink = driverSupport.locateByXpath("//div[contains(@class,'Footer_footer_links__D3gkE')]");

		List<WebElement> links = footerlink
				.findElements(By.xpath("//div[contains(@class,'Footer_footer_links__D3gkE')]//a"));

		int count = links.size();
		System.out.println("Total no of footer links on the partial profile page  : " + count);
	}
	
	

}
