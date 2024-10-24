	package com.ford.auto.stepdefinitions;
import java.io.File;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//import org.junit.After;
//import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.ford.auto.browser.Browser;
import com.ford.auto.managers.FileReaderManager;
import com.ford.auto.logging.Logger;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import net.masterthought.cucumber.Reportable;
import net.masterthought.cucumber.presentation.PresentationMode;
//import io.cucumber.plugin.event.Node.Scenario;
//import io.cucumber.messages.Messages.GherkinDocument.Feature.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
 
public class Hooks extends Browser{
	
	
	@BeforeAll
	public  static void before_all()
	{	
		Logger.LogEnterMethod ("This Method is called once before executing all the test cases ");
			}
	
	
	@Before
    public void beforeScenario() throws MalformedURLException{
		Logger.LogEnterMethod ("This will run before the Scenario");
     createLocalOrRemoteDriver();
    }
    
	
	@After
    public void afterScenario(Scenario scenario){
		Logger.LogEnterMethod ("This will run after the Scenario");
        
         //Scenario scenario
        if (scenario.isFailed()) {
            scenario.log("Scenario failed so capturing a screenshot");
            TakesScreenshot screenshot = (TakesScreenshot) Browser.getDriver();
           
            try {scenario.attach(screenshot.getScreenshotAs(OutputType.BYTES), "image/png", "Screenshot attached");
            }catch(Exception e)
            {
            	e.printStackTrace();
            }
        }
        Browser.getDriver().close();
        Browser.getDriver().quit();
        //generateSandwichReport();
    }
	
	//Attach screenshot and log message after each step
		@AfterStep
		    public void afterStep(Scenario scenario) {
				String isScreenshot=null;
				
				isScreenshot = FileReaderManager.getInstance().getConfigReader().getScreenshotAfterEachStep();
				if(isScreenshot.equalsIgnoreCase("true")) {			   
				    scenario.attach("Step completed", "text/plain", "Step information");	       
				    TakesScreenshot screenshot = (TakesScreenshot) Browser.getDriver();
			        scenario.attach(screenshot.getScreenshotAs(OutputType.BYTES), "image/png", "Screenshot attached");
				}    
		}
		
	public void generateSandwichReport() {
		File reportOutputDirectory = new File("target/html-reports-cucumber");
		List<String> jsonFiles = new ArrayList<>();
		jsonFiles.add("target/json-cucumber-reports/cukejson.json");
			

		String buildNumber = "1";
		String projectName = "FrameWork";

		Configuration configuration = new Configuration(reportOutputDirectory, projectName);
		
		configuration.setNotFailingStatuses(Collections.singleton(net.masterthought.cucumber.json.support.Status.SKIPPED));
		configuration.setBuildNumber(buildNumber);
		// addidtional metadata presented on main page
		configuration.addClassifications("Platform", "Windows");
		configuration.addClassifications("Browser", "Chrome");
		configuration.addClassifications("Branch", "release/1.0");
		// optionally specify qualifiers for each of the report json files
		configuration.addPresentationModes(PresentationMode.EXPAND_ALL_STEPS);
		configuration.setQualifier("cucumber-report-1", "First report");
		configuration.setQualifier("cucumber-report-2", "Second report");

		ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
		Reportable result = reportBuilder.generateReports();
	}
	
	@AfterAll
	public static void after_all()
	{

		Logger.LogEnterMethod ("This Method is called once AFTER  executing all the test cases ");
		
		
		
	}
	
	
	

}