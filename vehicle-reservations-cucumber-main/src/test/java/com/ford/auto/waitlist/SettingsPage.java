package com.ford.auto.waitlist;

import com.ford.auto.logging.Logger;
import com.ford.auto.support.PageBaseClass;
import io.cucumber.java.sl.In;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SettingsPage extends PageBaseClass {

    public static final String CLASS_CARD_LEASE_WIDGET = "//*[@class='card--lease-widget']";

    public SettingsPage(WebDriver driver) throws InterruptedException {
        super(driver, "/settings", 25);
    }

    public void waitForPackageName(String packageName) throws InterruptedException{
        Logger.LogEnterMethod("packageName=" + packageName);
        waitForElementToContainText(packageName, CLASS_CARD_LEASE_WIDGET, 10);
    }

    public void waitForElementToContainText(String containsText, String elementLocator, int maxRetries) throws InterruptedException {
        int retries = 0;
        WebElement leasePackageName = null;
        leasePackageName = this.driverSupport.locateByXpath(elementLocator);
        String currentElementText = leasePackageName.getText();
        while (!currentElementText.contains(containsText) && retries < maxRetries){
            Thread.sleep(1000);
            retries++;
            leasePackageName = this.driverSupport.locateByXpath(elementLocator);
            currentElementText = leasePackageName.getText();
        }
        if(!currentElementText.contains(containsText))
        {
            Assert.fail("CurrentElementValue does not contain package name after "+ retries + " retries. CurrentElementValue=" + currentElementText +", containsText=" + containsText);
        }
        Logger.LogEnterMethod("currentElementValue =" + currentElementText);
    }

}
