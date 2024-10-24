package com.ford.auto.testRunners;

import java.io.File;
import java.net.MalformedURLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.DataProvider;
import com.ford.auto.managers.FileReaderManager;
import io.cucumber.testng.CucumberOptions;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import net.masterthought.cucumber.Reportable;
import net.masterthought.cucumber.json.support.Status;
import net.masterthought.cucumber.presentation.PresentationMode;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(glue = "com.ford.auto.stepDefinitions", plugin = { "pretty",
		"json:target/json-cucumber-reports/cukejson.json", "junit:target/junit-cucumber-reports/cukejunit.xml",
		"html:target/cucumber.html" }, monochrome = true, tags="@new_waitlistflow_SanDiego", features = { "/CucumberFramework/src/test/resources" })

public class TestNGRunner extends AbstractTestNGCucumberTests {
	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		return super.scenarios();
	}

	public static File file;
	

	  @AfterSuite 
	  public static void cucumberSandwichReportGeneration() {
		  
		  
		//  if(System.getProperty("os.name").contains("Windows")) {
			  
			  DateFormat obj = new SimpleDateFormat("ddMMMyyyy-HH-mm-ss");   
			  Date d = new Date(System.currentTimeMillis());
	  File reportOutputDirectory = new File(System.getProperty("user.dir")+
			  "/reports/SandwichReports"+obj.format(d)); 
	  List<String> jsonFiles = new ArrayList<>();
	  jsonFiles.add("target/json-cucumber-reports/cukejson.json");
		  String buildNumber = "1"; String projectName = "cucumberProject";
	  Configuration configuration = new Configuration(reportOutputDirectory, projectName);
	  configuration.setNotFailingStatuses(Collections.singleton(Status.SKIPPED));
	  configuration.setBuildNumber(buildNumber); 
	  configuration.addClassifications("Platform", System.getProperty("os.name"));
	  String browserName = "Chrome";
		if (System.getProperty("browser") == null) {

			browserName = FileReaderManager.getInstance().getConfigReader().getBrowser();

			System.out.println("browsername " + browserName);

		} else {
			browserName = System.getProperty("browser");
			
		}
	  configuration.addClassifications("Browser", browserName);
	  configuration.addClassifications("Environment", "QA");
	   // optionally add metadata presented on main page via properties file
	  List<String> classificationFiles = new ArrayList<>();
	  configuration.addClassificationFiles(classificationFiles);
	   // optionally specify qualifiers for each of the report json files
	  configuration.addPresentationModes(PresentationMode.EXPAND_ALL_STEPS);
	  ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
	  Reportable result = reportBuilder.generateReports(); 
	  file = configuration.getReportDirectory();
	  WebDriver driver;
	  String openReport = FileReaderManager.getInstance().getConfigReader().getOpenReport();

	 if(openReport.equalsIgnoreCase("yes")) {
	  System.setProperty("webdriver.chrome.driver", "Utilities/chromedriver.exe");
	  driver = new ChromeDriver();
	  
	  driver.get(file.toString()+"/cucumber-html-reports/overview-features.html");
	  
		  }
		// }
	  }
	 
}
//@BeforeSuite
