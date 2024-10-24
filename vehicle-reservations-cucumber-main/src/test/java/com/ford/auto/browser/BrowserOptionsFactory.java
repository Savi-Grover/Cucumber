package com.ford.auto.browser;

import java.io.File;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.Proxy.ProxyType;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariOptions;

import com.ford.auto.managers.FileReaderManager;

public class BrowserOptionsFactory {

	 public void setGeneralDriverBehaviors(WebDriver webDriver) {
	   webDriver.manage().deleteAllCookies();
	   webDriver.manage().window().maximize();
	   Long pageTimeout = Long.parseLong(FileReaderManager.getInstance().getConfigReader().getPageTimeOut());
	   Long implicitWait = Long.parseLong(FileReaderManager.getInstance().getConfigReader().getImplicitWait());	   
	   webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(pageTimeout));
	   webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWait));	   
}
	 
public ChromeOptions createChromeOptions() {	 
	ChromeOptions chromeOptions = new ChromeOptions();
	 Map<String, Object> prefs = new HashMap<String, Object>();
     prefs.put("profile.default_content_setting_values.notifications", 2);
     chromeOptions.setExperimentalOption("prefs", prefs);
     chromeOptions.addArguments("disable-popup-blocking");
     chromeOptions.addArguments("--disable-extensions");
     chromeOptions.addArguments("--disable-infobars");
     
     return chromeOptions;
}

public InternetExplorerOptions createIEOptions() {	 
	InternetExplorerOptions options = new InternetExplorerOptions();
	
	options.setCapability("ignoreZoomSetting", true);				
	//options.setCapability(InternetExplorerDriver.NATIVE_EVENTS,false);
	options.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, false);
	options.setCapability(InternetExplorerDriver.UNEXPECTED_ALERT_BEHAVIOR, UnexpectedAlertBehaviour.IGNORE);
	options.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS,true);     
     return options;
}



public ChromeOptions headlessChrome()
{
	ChromeOptions options = new ChromeOptions();
	String proxyServer = FileReaderManager.getInstance().getConfigReader().getproxyServer();
	
	if(System.getProperty("os.name").contains("Linux")) {		
		options = new ChromeOptions();
		options.addArguments("window-size=1920,1080");
		options.addArguments("headless");
		//options.setExperimentalOption("useAutomationExtension", false);
		options.addArguments("--no-sandbox");
		options.addArguments("--disable-dev-shm-usage");
	    options.addArguments("--proxy-server=http://internet.ford.com:83");
	   // options.setHeadless(true);
	    options.setAcceptInsecureCerts(true);			
		//options.setCapability("chrome.ensureCleanSession", true);
	}
	else {	
	options.addArguments("window-size=1920,1080");
	options.addArguments("headless");	
    options.addArguments("--proxy-server="+proxyServer);
	}	
	//Proxy settings-common for Linux and Windows
    try {  
          String[] proxyByPassURLs = FileReaderManager.getInstance().getConfigReader().getProxyBypassList();
          if(proxyByPassURLs!=null) {	            
	            for(String url:proxyByPassURLs) {
	            	options.addArguments("--proxy-bypass-list="+url);
	            	System.out.println("Proxy bypass list added: "+url);
	            }
	        }        
    	}catch(Exception e)
    	{
    		e.printStackTrace();
    	}	
	
	return options;
}
public FirefoxOptions firefox() {
	FirefoxOptions options = new FirefoxOptions();
	FirefoxBinary firefoxBinary = new FirefoxBinary();
	options.addPreference("network.proxy.type", ProxyType.AUTODETECT.ordinal());
	options.setBinary(firefoxBinary);
	return options;

}
public FirefoxOptions headlessfirefox() {
	 FirefoxOptions firefoxOptions;
		
		if(System.getProperty("os.name").contains("Linux")) {
			String firefoxpath = System.getenv("FIREFOX_HOME");
			File pathBinary = new File (firefoxpath+"/firefox-esr");
			 FirefoxBinary firefoxBinary = new FirefoxBinary(pathBinary);
			 firefoxOptions = new FirefoxOptions();
			 firefoxBinary.addCommandLineOptions("--headless");
			 firefoxOptions.addArguments("--window-size=1920,1080");
			 firefoxOptions.addPreference("network.proxy.type", 1);
			 firefoxOptions.addPreference("network.proxy.socks", "internet.ford.com");
			 firefoxOptions.addPreference("network.proxy.socks_port", 83);
			 firefoxOptions.setBinary(firefoxBinary);			   
		}
		else { 
			FirefoxBinary firefoxBinary = new FirefoxBinary();
			firefoxOptions = new FirefoxOptions();
			firefoxBinary.addCommandLineOptions("--headless");
			firefoxOptions.addArguments("--window-size=1920,1080");
			firefoxOptions.addPreference("network.proxy.type", ProxyType.AUTODETECT.ordinal());	 
			firefoxOptions.setBinary(firefoxBinary);		  	    
		    firefoxOptions.setBinary(firefoxBinary);
		}
		return firefoxOptions;	
	}
	public EdgeOptions createEdgeOptions() {	 
		EdgeOptions edgeOptions = new EdgeOptions();
		 Map<String, Object> prefs = new HashMap<String, Object>();
	     prefs.put("profile.default_content_setting_values.notifications", 2);
	     edgeOptions.setExperimentalOption("prefs", prefs);
	     edgeOptions.addArguments("disable-popup-blocking");
	     edgeOptions.addArguments("--disable-extensions");
	     edgeOptions.addArguments("--disable-infobars");
	     return edgeOptions;
	}
	
	public EdgeOptions createHeadlessEdgeOptions()
	{
		EdgeOptions edgeOptions = new EdgeOptions();			
			edgeOptions = new EdgeOptions();
			edgeOptions.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
			edgeOptions.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);			
			edgeOptions.addArguments("window-size=1920,1080");
			//edgeOptions.addArguments("headless");
			edgeOptions.addArguments("disable-gpu");			
			edgeOptions.addArguments("--no-sandbox");
			edgeOptions.addArguments("--disable-dev-shm-usage");			
			edgeOptions.setHeadless(true);
		    edgeOptions.setAcceptInsecureCerts(true);	
		    edgeOptions.setCapability(EdgeOptions.CAPABILITY,edgeOptions);
		    
		    return edgeOptions;
	}
	
	public SafariOptions createSafariOptions() {
		SafariOptions safariOptions = new SafariOptions();
		return safariOptions;
	}

}
