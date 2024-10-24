package com.ford.auto.waitlist;

import com.ford.auto.logging.Logger;
import com.ford.auto.support.PageBaseClass;
import com.ford.auto.support.WDSupport;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PackageSelection extends PageBaseClass {

	public final static String PACKAGESELECTION_PAGEURLEXCERPT = "/package-selection";
	public static final String MILEAGEAMOUNTLOCATOR = "//*[@class='mileage-package__amount']//*[contains(text(),'";

	public PackageSelection(WebDriver driver) throws InterruptedException {
		super(driver, PACKAGESELECTION_PAGEURLEXCERPT, 25);
	}

	public void PackageNamePage(String packagename) throws InterruptedException {
		Logger.LogEnterMethod("packagename=" + packagename);
        driverSupport.locateByXpath(buildPackageSelector(packagename)).click();
	}

	private static String buildPackageSelector(String packagename) {
		String packageLocator = MILEAGEAMOUNTLOCATOR + packagename + "')]";
		return packageLocator;
	}

	public void clicknext() throws InterruptedException {
		Logger.LogEnterMethod("");
		Thread.sleep(3000);
		driverSupport.locateByXpath("//button[text()='Next']").click();
	}

	public void NewPackageName(String packagename) throws InterruptedException {
		Logger.LogEnterMethod("packagename="+packagename);
		// Scroll to the element using JavaScriptExecutor
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element = driverSupport
				.locateByXpath(buildPackageSelector(packagename));
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(2000);
		element.click();
	}

}
