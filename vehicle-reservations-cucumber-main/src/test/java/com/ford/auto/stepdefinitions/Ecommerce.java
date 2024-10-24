package com.ford.auto.stepdefinitions;

import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.ford.auto.browser.Browser;
import com.ford.auto.support.LocatorType;
import com.ford.auto.support.WDSupport;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Ecommerce extends Browser {

	protected WebDriver driver = getDriver();
	WDSupport driverSupport = new WDSupport(driver);

	@Given("an user is in the contact us section of the website")
	public void an_user_is_in_the_contact_us_section_of_the_website() {
		driver.get("https://www.advantageonlineshopping.com/#/");

//		driver.findElement(By.xpath("//a[contains(text(),'CONTACT US')]")).click();
		boolean speakerText = driverSupport.locator("//span[@id='speakersTxt']", LocatorType.XPATH).isDisplayed();
		if (speakerText) {
			driverSupport.locator("//a[contains(text(),'CONTACT US')]", LocatorType.XPATH).click();
		}

	}

	@Given("provides the {string}, {string}, {string} and {string}")
	public void provides_the_and(String string, String string2, String string3, String string4) {

		WebElement selectCategory = driverSupport.locator("//select[@name='categoryListboxContactUs']",
				LocatorType.XPATH);
		Select selectOption = new Select(selectCategory);
		selectOption.selectByVisibleText(string);

		WebElement selectProduct = driverSupport.locator("//select[@name='productListboxContactUs']",
				LocatorType.XPATH);
		Select selectOptionProduct = new Select(selectProduct);
		selectOptionProduct.selectByVisibleText(string2);

		driverSupport.locator("emailContactUs", LocatorType.NAME).sendKeys(string3);
		driverSupport.locator("subjectTextareaContactUs", LocatorType.NAME).sendKeys(string4);

	}

	@When("the user clicks on the send button")
	public void the_user_clicks_on_the_send_button() {

		driverSupport.locator("//button[contains(text(),'SEND')]").click();

	}

	@Then("a message should be displayed with the below text")
	public void a_message_should_be_displayed_with_the_below_text(io.cucumber.datatable.DataTable dataTable) {
		// Write code here that turns the phrase above into concrete actions
		// For automatic transformation, change DataTable to one of
		// E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
		// Map<K, List<V>>. E,K,V must be a String, Integer, Float,
		// Double, Byte, Short, Long, BigInteger or BigDecimal.
		//
		// For other transformations you can register a DataTableType.
		List<List<String>> ls = dataTable.asLists();

		String xpathValidation = "//p[contains(text(),'" + ls.get(0).get(0) + "')]";

		// boolean valueDisplayed =
		// driver.findElement(By.xpath(xpathValidation)).isDisplayed();

		boolean valueDisplayed = driverSupport.locator(xpathValidation, LocatorType.XPATH).isDisplayed();

		Assert.assertTrue(valueDisplayed);

	}

	@Given("that an user goes to the contact us section of the website")
	public void that_an_user_goes_to_the_contact_us_section_of_the_website() {

		driver.get("https://www.advantageonlineshopping.com/#/");

//		driver.findElement(By.xpath("//a[contains(text(),'CONTACT US')]")).click();
		boolean speakerText = driverSupport.locator("//span[@id='speakersTxt']", LocatorType.XPATH).isDisplayed();
		if (speakerText) {
			driverSupport.locator("//a[contains(text(),'CONTACT US')]", LocatorType.XPATH).click();
		}

	}

	@When("the user clicks on the live chat button")
	public void the_user_clicks_on_the_live_chat_button() {

		driverSupport.locator("chatLogo",LocatorType.ID).click();
	//	driverSupport.locator("//label[@translate='CHAT_WITH_US']", LocatorType.XPATH).click();

	}

	@Then("a chat window is displayed for the user to chat with a live agent")
	public void a_chat_window_is_displayed_and_user_is_able_to_chat_with_an_live_agent() {
		// Write code here that turns the phrase above into concrete actions

		Set<String> setOfHandles = driver.getWindowHandles();
		String getChatWindow = null;

		for (String x : setOfHandles) {
			getChatWindow = x;

		}

		driver.switchTo().window(getChatWindow);
//		try {
//			Thread.sleep(3000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
	boolean chatServer=	driverSupport.locator("//p[contains(text(),'Server connect')]").isDisplayed();
		driverSupport.locator("textMessage", LocatorType.ID).sendKeys("Hi chat support");
		driverSupport.locator("textMessage", LocatorType.ID).sendKeys(Keys.ENTER);

//		boolean isDisp = driverSupport
//				.locator("//*[contains(text(),'Hello')]", LocatorType.XPATH)
//				.isDisplayed();

		Assert.assertTrue(chatServer);

	}

}
