package Test;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;



import org.openqa.selenium.WebDriver;

import Pages.HomePage;
import Pages.LoginPage;
import Source.BaseTest;

public class LoginTest extends BaseTest {

		private WebDriver driver;
	    private LoginPage loginPage;
	    private HomePage homePage;
	    SoftAssert softAssert = new SoftAssert();
	    //Variables
	    private final String user = "gap-automation-test@mailinator.com";
	    private final String pass = "12345678";
	    
		@BeforeMethod
		public void beforeClass() throws Exception {
			System.out.println("Executing class: " + getClass().getName());
			System.out.println("Creating Driver");
			String browserType = "chrome";
		    driver = createLocalDriver(browserType);
		    loginPage = new LoginPage(driver);
		}

		@Test
		public void verifyLoginUser() throws Exception {
			String succesBannerMessage = "Signed in successfully.";
			String succesInfMessage = "Welcome GAP, Logout";
			homePage = loginPage.logIn(user, pass);
			softAssert.assertTrue(homePage.verifySuccessMsg(succesBannerMessage));
			softAssert.assertTrue(homePage.logoIsDisplayed());
			softAssert.assertTrue(homePage.verifyinformationMessage(succesInfMessage));
			softAssert.assertAll();	
		}
		
		@AfterMethod
		public void afterMethod() {
				driver.close();
		}
		
}