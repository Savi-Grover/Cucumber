package com.ford.auto.config;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
	
	private Properties prop;
	
	private final String propertyFilePath = (System.getProperty("user.dir")).replace('\\', '/')+ "/src/main/java/com/ford" 
			+ "/auto/config/config.properties";
	public ConfigFileReader() 
	{
		//BufferedReader reader;
		try
		{
			
			//FileInputStream  reader = new FileInputStream(propertyFilePath);
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "/src/test/java/com/ford"
					+ "/auto/config/config.properties");
			try
			{
			prop = new Properties();
			prop.load(ip);
			} catch ( IOException e)
			{
				e.printStackTrace();
			}	
		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		//throw new RuntimeException("Configuration properties file not found at: " + propertyFilePath );
	}
	
	public String getApplicationUrl()
	{
		String url = prop.getProperty("url");
		if(url!=null) return url;
		else throw new RuntimeException("Url not specified in the configuration properties file");
	}
	
	public String getBrowser()
	{
		String browser = prop.getProperty("browser");
		if(browser!=null) return browser;
		else throw new RuntimeException("browser not specified in the configuration properties file");
	}
	
	public String getImplicitWait()
	{
		String implicitWait = prop.getProperty("IMPLICIT_WAIT");
		if(implicitWait!=null) return implicitWait;
		else throw new RuntimeException("implicitWait not specified in the configuration properties file");
	}
	
	public String getPageTimeOut()
	{
		String pageTimeOut = prop.getProperty("PAGE_LOAD_TIMEOUT");
		if(pageTimeOut!=null) return pageTimeOut;
		else throw new RuntimeException("pageTimeOut not specified in the configuration properties file");
	}
	
	public String getGrid()
	{
		String grid = prop.getProperty("grid");
		if(grid!=null) return grid;
		else throw new RuntimeException("grid not specified in the configuration properties file");
	}
	
	public String getGridHost()
	{
		String gridHost = prop.getProperty("GridHostUrl");
		if(gridHost!=null) return gridHost;
		else throw new RuntimeException("gridHost not specified in the configuration properties file");
	}
	public String getExplicittWait()
	{
		String explicitWait = prop.getProperty("EXPLICIT_WAIT");
		if(explicitWait!=null) return explicitWait;
		else throw new RuntimeException("explicitWait not specified in the configuration properties file");
	}
	
	public String getDataSheet()
	{
		String dataSheet = prop.getProperty("DataSheet");
		if(dataSheet!=null) return dataSheet;
		else throw new RuntimeException("dataSheet not specified in the configuration properties file");
	}
	
	public String getScreenshotAfterEachStep() {
		String isScreenshot=prop.getProperty("isScreenshotAfterEachStep");
		if(isScreenshot!= null) return isScreenshot;
		else throw new RuntimeException("Screenshot AfterEach Step is not specified in the Configuration.properties file for the Key:isScreenshotAfterEachStep");
	}
	
	public String getproxyServer() {
		String isProxyServer=prop.getProperty("proxyServer");
		if(isProxyServer!= null) {
			return isProxyServer;
		}else {
			throw new RuntimeException("Proxy Server is not specified in the Configuration.properties file for the Key:proxyServer"); 
		}
	}
	
	public String[] getProxyBypassList() {
		String isProxyBypassList=prop.getProperty("proxyBypassList");
		String[] proxyByPassList=null;
		if(isProxyBypassList!= null) {
			proxyByPassList = isProxyBypassList.split(",");
		}
		else {
			throw new RuntimeException("proxyBypassList is not specified in the Configuration.properties file for the Key:proxyBypassList");			
		}
		return proxyByPassList;
	}
	
	public String getOpenReport()
	{
		String url = prop.getProperty("openreport");
		if(url!=null) return url;
		else throw new RuntimeException("Url not specified in the configuration properties file");
	}
	
	
}

