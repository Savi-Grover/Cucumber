package com.ford.auto.browser;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.CapabilityType;
import javax.imageio.ImageIO;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.Proxy.ProxyType;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.apache.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
//import org.openqa.grid.selenium.GridLauncherV3;

import com.ford.auto.managers.FileReaderManager;

public class Browser {

	// public static WebDriver driver;

	private static Browser instance = new Browser();
	public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<RemoteWebDriver>();
	public static Properties prop;
	public String browserName, gridFeature, gridHost, appURL;
	protected static float devicePixelRatio;

	public static Browser getInstance() {
		return instance;
	}

	public void setConfigCred() {

		gridFeature = FileReaderManager.getInstance().getConfigReader().getGrid();
		gridHost = FileReaderManager.getInstance().getConfigReader().getGridHost();
		// System.out.println("gridHost:" + gridHost);
		// appURL =
		// FileReaderManager.getInstance().getConfigReader().getApplicationUrl();
		// appURL = System.getProperty("url");
		// browserName = System.getProperty("browser");
		// System.out.println(appURL);
		// System.out.println(browserName);

		if (System.getProperty("url") == null) {

			appURL = FileReaderManager.getInstance().getConfigReader().getApplicationUrl();
			System.out.println("appURL " + appURL);
		} else {
			appURL = System.getProperty("url");

		}
		if (System.getProperty("browser") == null) {

			browserName = FileReaderManager.getInstance().getConfigReader().getBrowser();

			System.out.println("browsername " + browserName);

		} else {
			browserName = System.getProperty("browser");

		}

	}

	public void createLocalOrRemoteDriver() throws MalformedURLException {
		ChromeOptions options;
		// InternetExplorerOptions ieOptions;
		//FirefoxOptions ffoptions;
		//FirefoxOptions ffoptions_headless;
		BrowserOptionsFactory factory = new BrowserOptionsFactory();
		options = factory.createChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		// ieOptions = factory.createIEOptions();
		// ffoptions=factory.firefox();
		// ffoptions_headless=factory.headlessfirefox();
		ChromeOptions options_headless = factory.headlessChrome();
		EdgeOptions edgeoptions = factory.createEdgeOptions();
		//FirefoxOptions ffoptions_headless=factory.headlessfirefox();
		EdgeOptions edgeoptions_headless = factory.createHeadlessEdgeOptions();
		SafariOptions safariOptions = factory.createSafariOptions();

		setConfigCred();
		// String url = "http://" + gridHost + "/wd/hub";
		System.out.println("hostURL......" + gridHost);

		if (gridFeature.equalsIgnoreCase("Yes")) {
			// System.out.println("Grid Enabled:: GRID URL"+url +"Browser Specified to run
			// ::"+browserName);
			switch (browserName) {
			case "chrome":
				driver.set(new RemoteWebDriver(new URL(gridHost), options));
				break;
//			case "ie":
//				driver.set(new RemoteWebDriver(new URL(gridHost), ieOptions));
//				break;
			case "firefox":
				FirefoxOptions ffoptions;
				ffoptions = factory.firefox();
				driver.set(new RemoteWebDriver(new URL(gridHost), ffoptions));
				break;
			case "HeadlessChrome":
				driver.set(new RemoteWebDriver(new URL(gridHost), options_headless));
				break;
			case "Headlessfirefox":
				FirefoxOptions ffoptions_headless=factory.headlessfirefox();
				ffoptions_headless = factory.headlessfirefox();
				driver.set(new RemoteWebDriver(new URL(gridHost), ffoptions_headless));
				break;
			case "edge":
				driver.set(new RemoteWebDriver(new URL(gridHost), edgeoptions));
				break;
			case "HeadlessEdge":
				driver.set(new RemoteWebDriver(new URL(gridHost), edgeoptions_headless));
				break;
			case "safari":
				driver.set(new RemoteWebDriver(new URL(gridHost), safariOptions));
				break;
			default:
				System.err.println(
						"By default , it will run in Chrome Browser, Specify a value for browser in com.ford.auto.config/config.properties file should be :: ##chrome || ie ||firefox ||HeadlessChrome || Headlessfirefox");
				driver.set(new RemoteWebDriver(new URL(gridHost), options));
				break;

			}

		} else if (System.getProperty("os.name").contains("Linux")) {
			switch (browserName) {
			case "HeadlessChrome":
				System.out.println("LinuxTesting");
				ChromepathLinux();
				driver.set(new ChromeDriver(options_headless));
				break;

			}

		}

		else if (gridFeature.equalsIgnoreCase("No"))

		{
			System.out.println("Grid Not Enabled ::Browser Specified to run ::" + browserName);
			switch (browserName) {
			case "chrome":
				try {
					options.addArguments("--remote-allow-origins=*");
					driver.set(new ChromeDriver(options));
				} catch (Exception e) {

					Proxy proxy = new Proxy();
					proxy.setProxyType(ProxyType.MANUAL);
					proxy.setHttpProxy("internet.ford.com:83");
					proxy.setSslProxy("internet.ford.com:83");
					options.setProxy(proxy);
					options.addArguments("--remote-allow-origins=*");
					driver.set(new ChromeDriver(options));
				}
				break;

			case "firefox":
				
				try {
					FirefoxOptions ffoptions;
					
					ffoptions = factory.firefox();
					driver.set(new FirefoxDriver(ffoptions));
				} catch (Exception e) {
					FirefoxOptions ffoptions;
					
					ffoptions = factory.firefox();
					Proxy proxy = new Proxy();
					proxy.setProxyType(ProxyType.MANUAL);
					proxy.setHttpProxy("internet.ford.com:83");
					proxy.setSslProxy("internet.ford.com:83");
					ffoptions.setProxy(proxy);
					driver.set(new FirefoxDriver(ffoptions));
				}
				break;
			case "HeadlessChrome":
				if (!System.getProperty("os.name").contains("Linux")) {
					try {
					
						options_headless.addArguments("--remote-allow-origins=*");
						driver.set(new ChromeDriver(options_headless));
						
					} catch (Exception e) {

						options_headless.addArguments("--remote-allow-origins=*");
						Proxy proxy = new Proxy();
						proxy.setProxyType(ProxyType.MANUAL);
						proxy.setHttpProxy("internet.ford.com:83");
						proxy.setSslProxy("internet.ford.com:83");
						options_headless.setProxy(proxy);
						driver.set(new ChromeDriver(options_headless));
				}
			}
				break;
			case "Headlessfirefox":
				FirefoxOptions ffoptions_headless=factory.headlessfirefox();
				if (!System.getProperty("os.name").contains("Linux")) {
				
					try {
				
						ffoptions_headless = factory.firefox();
						driver.set(new FirefoxDriver(ffoptions_headless));
					} catch (Exception e) {
						System.out.println("catch area");
						FirefoxOptions firefoxOptions;
						FirefoxBinary firefoxBinary = new FirefoxBinary();
						firefoxOptions = new FirefoxOptions();
						firefoxBinary.addCommandLineOptions("--headless");
						firefoxOptions.addArguments("--window-size=1920,1080");
						firefoxOptions.addPreference("network.proxy.type", ProxyType.AUTODETECT.ordinal());	 
						firefoxOptions.setBinary(firefoxBinary);		  	    
					    firefoxOptions.setBinary(firefoxBinary);
						//ffoptions_headless = factory.firefox();
						Proxy proxy = new Proxy();
						proxy.setProxyType(ProxyType.MANUAL);
						proxy.setHttpProxy("internet.ford.com:83");
						proxy.setSslProxy("internet.ford.com:83");
						firefoxOptions.setProxy(proxy);
						driver.set(new FirefoxDriver(firefoxOptions));
					}

				} 
				
				break;
			case "edge":
				try {
					System.out.println("Try Block");
					edgeoptions.addArguments("--remote-allow-origins=*");
					driver.set(new EdgeDriver(edgeoptions));
				} catch (Exception e) {
					System.out.println("Catch Block");
					edgeoptions.addArguments("--remote-allow-origins=*");
					Proxy proxy = new Proxy();
					proxy.setProxyType(ProxyType.MANUAL);
					proxy.setHttpProxy("internet.ford.com:83");
					proxy.setSslProxy("internet.ford.com:83");
					edgeoptions.setProxy(proxy);
					driver.set(new EdgeDriver(edgeoptions));
			}

				break;
			case "HeadlessEdge":
				try {
					System.out.println("Try Block");
					edgeoptions_headless.addArguments("--remote-allow-origins=*");
					driver.set(new EdgeDriver(edgeoptions_headless));
				} catch (Exception e) {
					System.out.println("Catch Block");
					edgeoptions_headless.addArguments("--remote-allow-origins=*");
					Proxy proxy = new Proxy();
					proxy.setProxyType(ProxyType.MANUAL);
					proxy.setHttpProxy("internet.ford.com:83");
					proxy.setSslProxy("internet.ford.com:83");
					edgeoptions_headless.setProxy(proxy);
					driver.set(new EdgeDriver(edgeoptions_headless));
			}
				break;
			case "safari":
				driver.set(new SafariDriver(safariOptions));
				break;

			default:
				System.err.println(
						"By default , it will run in Chrome Browser, Specify a value for browser in com.ford.auto.config/config.properties file should be :: ##chrome || ie ||firefox ||HeadlessChrome || Headlessfirefox");
				System.setProperty("webdriver.chrome.driver", "Utilities/chromedriver.exe");
				options.addArguments("--remote-allow-origins=*");
				driver.set(new ChromeDriver(options));
				break;

			}

		}
		getDriver().get(appURL);
		factory.setGeneralDriverBehaviors(getDriver());
		setDevicePixelRatio();

	}

	public static WebDriver getDriver() {
		// Get driver from ThreadLocalMap
		return driver.get();
	}

	private void setDevicePixelRatio() {
		Object obj = ((JavascriptExecutor) driver.get()).executeScript("return window.devicePixelRatio;");
		if (obj instanceof Double) {
			Double value = (Double) obj;
			devicePixelRatio = value.floatValue();

		}
		if (obj instanceof Float) {
			Float value = (Float) obj;
			devicePixelRatio = value.floatValue();

		}

		if (obj instanceof Long) {
			Long value = (Long) obj;
			devicePixelRatio = value.floatValue();

		}
	}

	public static byte[] getScreenShotAsByteArray(BufferedImage bufferedImage) {
		ByteArrayOutputStream byteArrayOutputStream = null;
		try {
			byteArrayOutputStream = new ByteArrayOutputStream();
			ImageIO.write(bufferedImage, "png", byteArrayOutputStream);
			byteArrayOutputStream.flush();
			byte[] image = byteArrayOutputStream.toByteArray();
			return image;
		} catch (IOException ex) {
			ex.printStackTrace();
			return null;
		} finally {
			try {
				if (byteArrayOutputStream != null)
					byteArrayOutputStream.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

	public static void ChromepathLinux() {
		String[] cmd = { "/bin/sh", "-c", "cat /etc/*-release" };
		try {
			Process p = Runtime.getRuntime().exec(cmd);
			BufferedReader bri = new BufferedReader(new InputStreamReader(p.getInputStream()));

			String oSName = "";
			while ((oSName = bri.readLine()) != null) {
				// System.out.println("line........................." + oSName);
				if (oSName.contains("Debian GNU/Linux")) {
					String chromePath = System.getenv("CHROME_HOME");
					System.setProperty("webdriver.chrome.driver", chromePath + "/chromedriver");
					System.out.println("linebreak............." + oSName);
					break;
				}

				else if (oSName.contains("Red Hat Enterprise Linux")) {
					System.setProperty("webdriver.chrome.driver", "./Utilities/chromedriver");
					// System.out.println("line........................." + oSName);
					break;
				} else {
					System.setProperty("webdriver.chrome.driver", "./Utilities/chromedriver");

				}

			}
		} catch (IOException e) {

			e.printStackTrace();
		}

	}
}
