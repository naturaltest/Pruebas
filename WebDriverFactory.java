
package src.test.java;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class WebDriverFactory {

	private static WebDriver instance;
	
	public static WebDriver getCurrentDriver() {
		if (instance == null) {
			instance = createChromeDriver();
		}
		
		return instance;
	}
	
	public static WebDriver createFirefoxDriver() {
		System.setProperty("webdriver.gecko.driver","drivers/geckodriver.exe");
	    DesiredCapabilities capabilities = DesiredCapabilities.firefox();
	    capabilities.setCapability("marionette", true);
	    WebDriver driver = new FirefoxDriver(capabilities);
	    instance = driver;
	    driver.manage().window().maximize();
	    
		return driver;
	}
	
	public static WebDriver createChromeDriver() {
		System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito","--start-maximized");
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		
		WebDriver driver = new ChromeDriver(options);
		instance = driver;
	    driver.manage().window().maximize();
		
		return driver;
	}
}
