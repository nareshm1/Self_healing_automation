package one.last.time.healing;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.session.ChromeFilter;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.epam.healenium.SelfHealingDriver;
import com.qa.util.java.WebEventListener;
import com.typesafe.config.ConfigFactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.Config;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;

public class Base {
	public static SelfHealingDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	public static WebDriver delegate;
	private String browserType;
	// public static String inputbrowser;
	public static URL url;
	public static DesiredCapabilities capabilities;

	public Base() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "//src//main//java//Config//config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/// Intialization...
	public static void intialization() {
		String browserName = prop.getProperty("browser");
		if (browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions(); // declare delegate
			delegate = new ChromeDriver();
			com.typesafe.config.Config config = (com.typesafe.config.Config) ConfigFactory.load("healenium.properties");
			// create self-healing driver
			driver = SelfHealingDriver.create(delegate, config);
			driver.get(" http://192.168.56.1:8080/bootstrap1.html#");
			driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			// EventFireCopy();

		} else if (browserName.equals("FF")) {
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions options = new FirefoxOptions();
			// declare delegate
			WebDriver delegate = (WebDriver) new FirefoxOptions(options);
			// create self-healing driver
			driver = SelfHealingDriver.create(delegate);
			driver.get(" http://192.168.56.1:8080/bootstrap1.html#");
			driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
			driver.manage().window().setSize(new Dimension(1200, 800));

			EventFire();
		}

	}

	public static void EventFire() {
		// Initializing EventFiringWebDriver using Firefox WebDriver instance
		e_driver = new EventFiringWebDriver(driver);

		// Now create object of EventListerHandler to register it with
		// EventFiringWebDriver
		WebEventListener eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = (SelfHealingDriver) e_driver;
	}

}
