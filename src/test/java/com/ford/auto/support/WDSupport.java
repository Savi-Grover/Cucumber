package com.ford.auto.support;

import java.text.MessageFormat;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ford.auto.browser.Browser;
import com.ford.auto.managers.FileReaderManager;
import com.ford.auto.logging.Logger;
import com.ford.auto.support.LocatorType;

public class WDSupport {
	public WebDriver driver;
	public String explicitWaitTime ;
	public WDSupport(WebDriver driver) {
		this.driver = driver;

	}

	/**
	 * Waits until the specified element is no longer in the DOM
	 * @param webDriver
	 * @param seconds - how long to wait for element to disappear
	 * @param webElement
	 */
	public static void waitUntilElementIsGoneFromDOM(WebDriver webDriver, int seconds, WebElement webElement) {
		Logger.LogEnterMethod("seconds=" + seconds);
		WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(seconds));
		wait.until(ExpectedConditions.stalenessOf(webElement));
	}

	/**
	 * Waits until the specified element is no longer in the DOM
	 * @param webDriver
	 * @param seconds - how long to wait for element to disappear
	 * @param webElement
	 */
	public static void waitUntilElementToBeSelected(WebDriver webDriver, int seconds, WebElement webElement) {
		Logger.LogEnterMethod("element=" + webElement.getTagName() + ", seconds=" + seconds);
		WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(seconds));
		wait.until(ExpectedConditions.elementSelectionStateToBe(webElement,true));
	}

	public static void checkIfPageUrlContainsExcerptOrThrow(WebDriver webDriver, int seconds, String urlContainsExcerpt) throws PageWithUrlContainsNotFoundException {
		try {
			Logger.LogEnterMethod("urlContainsExcerpt=" + urlContainsExcerpt + ", seconds=" + seconds); ;
			WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(seconds));
			wait.until(ExpectedConditions.urlContains(urlContainsExcerpt));
		} catch (TimeoutException e) {
			String actualPageUrl = webDriver.getCurrentUrl();
			throw new PageWithUrlContainsNotFoundException(urlContainsExcerpt, actualPageUrl, MessageFormat.format("Page URL was not found in {0} seconds or less.", seconds));
		}
	}

	/**
	 * Method to perform actionability checks like presence of element and
	 * visibility/clickability of elements
	 * @selector - the xpath of the element
	 * @return - web element
	 */
	public WebElement locator(String selector) {
		explicitWaitTime = FileReaderManager.getInstance().getConfigReader().getExplicittWait();
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(explicitWaitTime)));
		WebElement element = w.until(ExpectedConditions.presenceOfElementLocated(By.xpath(selector)));
		WebElement clickableElement = w.until(ExpectedConditions.elementToBeClickable(element));
		

		return clickableElement;

	}

	/**
	 * Overloaded method to perform actionability checks like presence of element
	 * and visibility/click ability of elements
	 * 
	 * @param selector - the string used to identify the element based on the locator type
	 * @param locatorType - The type of locator passed as enum from LocatorType
	 * 
	 * @return - web element
	 */
	public WebElement locator(String selector,  LocatorType locatorType) {
		explicitWaitTime = FileReaderManager.getInstance().getConfigReader().getExplicittWait();
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(explicitWaitTime)));
		WebElement element, clickableElement = null;

		
	//	driver.findElement(By.id(selector))
		switch (locatorType) {
		case CLASSNAME:

			element = w.until(ExpectedConditions.presenceOfElementLocated(By.className(selector)));
			clickableElement = w.until(ExpectedConditions.elementToBeClickable(element));
			break;
		case CSSSELECTOR:

			element = w.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(selector)));
			clickableElement = w.until(ExpectedConditions.elementToBeClickable(element));
			break;
		case ID :
		
			element = w.until(ExpectedConditions.presenceOfElementLocated(By.id(selector)));
			clickableElement = w.until(ExpectedConditions.elementToBeClickable(element));
			break;
		case LINKTEXT:

			element = w.until(ExpectedConditions.presenceOfElementLocated(By.linkText(selector)));
			clickableElement = w.until(ExpectedConditions.elementToBeClickable(element));
			break;
		case NAME:

			element = w.until(ExpectedConditions.presenceOfElementLocated(By.name(selector)));
			clickableElement = w.until(ExpectedConditions.elementToBeClickable(element));
			break;

		case PARTIALLINKTEXT:

			element = w.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText(selector)));
			clickableElement = w.until(ExpectedConditions.elementToBeClickable(element));
			break;
		case TAGNAME:

			element = w.until(ExpectedConditions.presenceOfElementLocated(By.tagName(selector)));
			clickableElement = w.until(ExpectedConditions.elementToBeClickable(element));
			break;
		case XPATH:

			element = w.until(ExpectedConditions.presenceOfElementLocated(By.xpath(selector)));
			clickableElement = w.until(ExpectedConditions.elementToBeClickable(element));
			break;
		default:
			System.out.println("Please provide a valid input for Selector type ");
		};
		

		return clickableElement;

	}

	
	
	/***
	 * Convenient method to locate an element by xpath  
	 * @param selector - a XPATH to identify the element
	 * @return web element
	 */
	public WebElement locateByXpath(String selector) {
		explicitWaitTime = FileReaderManager.getInstance().getConfigReader().getExplicittWait();
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(explicitWaitTime)));
		//WebElement element, clickableElement = null;
		WebElement	element = w.until(ExpectedConditions.presenceOfElementLocated(By.xpath(selector)));
		WebElement clickableElement = w.until(ExpectedConditions.elementToBeClickable(element));
		return clickableElement;

	}

	/***
	 * Convenient method to locate an element by CSS Selector 
	 * @param selector - a CSS Selector to identify the element
	 * @return web element
	 */	
	public WebElement locateByCSS(String selector) {
		explicitWaitTime = FileReaderManager.getInstance().getConfigReader().getExplicittWait();
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(explicitWaitTime)));
		//WebElement element, clickableElement = null;
		WebElement	element = w.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(selector)));
		WebElement clickableElement = w.until(ExpectedConditions.elementToBeClickable(element));
		return clickableElement;

	}
	/***
	 * Convenient method to locate an element by Class Name 
	 * @param selector - ClassName attribute of the element/tag
	 * @return web element
	 */		
	public WebElement locateByClassName(String selector) {
		explicitWaitTime = FileReaderManager.getInstance().getConfigReader().getExplicittWait();
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(explicitWaitTime)));
		//WebElement element, clickableElement = null;
		WebElement	element = w.until(ExpectedConditions.presenceOfElementLocated(By.className(selector)));
		WebElement clickableElement = w.until(ExpectedConditions.elementToBeClickable(element));
		return clickableElement;

	}

	/***
	 * Convenient method to locate an element by ID
	 * @param selector -  ID attribute of the element  
	 * @return web element
	 */		
	public WebElement locateById(String selector) {
		explicitWaitTime = FileReaderManager.getInstance().getConfigReader().getExplicittWait();
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(explicitWaitTime)));
		//WebElement element, clickableElement = null;
		WebElement	element = w.until(ExpectedConditions.presenceOfElementLocated(By.id(selector)));
		WebElement clickableElement = w.until(ExpectedConditions.elementToBeClickable(element));
		return clickableElement;

	}
	/***
	 * Convenient method to locate an element by LinkText
	 * @param selector - The LinkText of the element
	 * @return web element
	 */		

	public WebElement locateByLinkText(String selector) {
		explicitWaitTime = FileReaderManager.getInstance().getConfigReader().getExplicittWait();
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(explicitWaitTime)));
		//WebElement element, clickableElement = null;
		WebElement	element = w.until(ExpectedConditions.presenceOfElementLocated(By.linkText(selector)));
		WebElement clickableElement = w.until(ExpectedConditions.elementToBeClickable(element));
		return clickableElement;

	}
	
	/***
	 * Convenient method to locate an element by Name
	 * @param selector - The Name attribute of the element 
	 * @return WebElement
	 */		
	public WebElement locateByName(String selector) {
		explicitWaitTime = FileReaderManager.getInstance().getConfigReader().getExplicittWait();
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(explicitWaitTime)));
		//WebElement element, clickableElement = null;
		WebElement	element = w.until(ExpectedConditions.presenceOfElementLocated(By.name(selector)));
		WebElement clickableElement = w.until(ExpectedConditions.elementToBeClickable(element));
		return clickableElement;

	}
	
	/***
	 * Convenient method to locate an element by PartialLinkText
	 * @param selector - The PartialLinkText of the element 
	 * @return WebElement
	 */		
	
	public WebElement locateByPartialLinkText(String selector) {
		explicitWaitTime = FileReaderManager.getInstance().getConfigReader().getExplicittWait();
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(explicitWaitTime)));
		//WebElement element, clickableElement = null;
		WebElement	element = w.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText(selector)));
		WebElement clickableElement = w.until(ExpectedConditions.elementToBeClickable(element));
		return clickableElement;

	}
	
	/***
	 * Convenient method to locate an element by Tagname
	 * @param selector - The Tagname of the element 
	 * @return WebElement
	 */		
	public WebElement locateByTagName(String selector) {
		explicitWaitTime = FileReaderManager.getInstance().getConfigReader().getExplicittWait();
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(explicitWaitTime)));
		//WebElement element, clickableElement = null;
		WebElement	element = w.until(ExpectedConditions.presenceOfElementLocated(By.tagName(selector)));
		WebElement clickableElement = w.until(ExpectedConditions.elementToBeClickable(element));
		return clickableElement;

	}
	
	
	
	
	
	
	
}
