package Source;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



public class BaseTest {
	private String url = "https://vacations-management.herokuapp.com/users/sign_in";
	private WebDriver drive = null;

	public WebDriver createLocalDriver(String browserType) throws Exception {

		if (browserType.toLowerCase().equals("firefox")){
			System.setProperty("webdriver.gecko.driver","C:\\Selenium\\geckodriver.exe");
			drive = new FirefoxDriver();
			drive.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		}
		else if(browserType.toLowerCase().equals("chrome")){
			System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver.exe");
			drive = new ChromeDriver();
			drive.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		}
		drive.get(url);
		return drive;

	}


}

