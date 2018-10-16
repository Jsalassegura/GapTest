package Test;

import java.security.SecureRandom;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.UserCreateEmployeesPage;
import Pages.UserListPage;
import Source.BaseTest;

public class CreateUserTest extends BaseTest{
	private WebDriver driver;
    private LoginPage loginPage;
    private HomePage homePage;
    private UserListPage userListPage;
    private UserCreateEmployeesPage userCreateEmployeesPage;
    SoftAssert softAssert = new SoftAssert();
    
    //Variables
    private static final String ALPHABET = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-_";
    private static final SecureRandom RANDOM = new SecureRandom();
    private final String user = "gap-automation-test@mailinator.com";
    private final String pass = "12345678";
    private String firstName = "James";
    private String lastName = "Smith";
    private String email =  "justin."+generateRandom(6)+"@gmail.com";
    private String leader = "Genaro"+generateRandom(3)+"";
    private String id = "12345678";
    private String year = "2014";
    private String day = "21";
    private String month = "1";
    private String msgSuccesCreate = "Employee was successfully created.";

	@BeforeMethod
	public void beforeClass() throws Exception {
		System.out.println("Executing class: " + getClass().getName());
		System.out.println("Creating Driver");
		String browserType = "chrome";
	    driver = createLocalDriver(browserType);
	    loginPage = new LoginPage(driver);
	}

	@Test
	public void testCreateUserEmployees() throws Exception {
	
		homePage = loginPage.logIn(user, pass);
		userCreateEmployeesPage = homePage.clickOnLoginBtnPage().clickOnCreateUserBtn();
		userCreateEmployeesPage.createNewUser(firstName, lastName, email,id,leader, year, day, month);
		Assert.assertTrue(userCreateEmployeesPage.verifyMsgCreateEmp(msgSuccesCreate),"It's not the same");
	}
	
	@Test
	public void testVerifyCreateUserEmployees() throws Exception {
	
		homePage = loginPage.logIn(user, pass);
		userCreateEmployeesPage = homePage.clickOnLoginBtnPage().clickOnCreateUserBtn();
		userCreateEmployeesPage.createNewUser(firstName, lastName, email, id, leader, year, day, month);
		userListPage = userCreateEmployeesPage.clickOnBackLink();
		Assert.assertTrue(userListPage.verifyUserEmployeeCreated(firstName, lastName, id, leader),"Are not the same");	
	}

	@AfterMethod
	public void afterMethod() {
			driver.quit();
	}
	public static String generateRandom(int count) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; ++i) {
            sb.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));
        }
        return sb.toString();
    }
}
