package com.ford.auto.stepdefinitions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ford.auto.browser.Browser;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;

public class SearchSoftware extends Browser {
	
	protected WebDriver driver;
	protected WebDriverWait wait;
	
	@Given("I launch the EAMS website")
	public void i_launch_the_EAMS_website() throws InterruptedException {		
		driver = getDriver();
		driver.navigate().to("https://www.eams.ford.com");
		driver.findElement(By.xpath("//img[@alt='Active Directory']")).click();
		Thread.sleep(5000);	
		
	}
	

	@When("I click Technology Management button")
	public void i_click_Technology_Management_button() throws InterruptedException {
	   driver.findElement(By.id("homeForm:requestNewTechnology")).click();
	   Thread.sleep(2000);
	}
	
	@And("I click Search technology in hopex")
	public void i_click_Search_technology_in_hopex() throws InterruptedException {
		driver.findElement(By.id("homeForm:searchTechnology")).click();
		 Thread.sleep(2000);	   
		 
		 
	}
	

	@And("I search for {string} with {string} and click Search button")
	public void i_search_for_and_click_Search_button(String strSoftware, String strDescription) throws InterruptedException {
	   
	   driver.findElement(By.id("searchTechnologyForm:nameAndVersionAutocomplete")).sendKeys(strSoftware);
	   driver.findElement(By.name("searchTechnologyForm:descriptionAutocomplete")).sendKeys(strDescription);
	   driver.findElement(By.id("searchTechnologyForm:searchCriteriaButton")).click();
	   Thread.sleep(20000);
	}

	
	
	
	@Then("I should get the search results")
	public void i_should_get_the_search_results() { 
			    String actualresults =driver.findElement(By.xpath("//div[@id='searchResultsForm:listSearchResults_paginator_top']//span[@class='ui-paginator-current']")).getText();
			   //Assert.assert(actualresults,results);
			    System.out.println(actualresults);
	   
	}
	

}
