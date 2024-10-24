package com.ford.auto.support;

import com.ford.auto.browser.Browser;
import org.openqa.selenium.WebDriver;

public class PageBaseClass extends Browser {
    public WebDriver driver;
    public WDSupport driverSupport;
    public PageBaseClass(WebDriver driver, String urlExcerpt, int secondsToWaitForURLExcerpt) throws InterruptedException {
        this.driver = driver;
        this.driverSupport = new WDSupport(driver);
        WDSupport.checkIfPageUrlContainsExcerptOrThrow(driver, secondsToWaitForURLExcerpt, urlExcerpt);
    }
}
