package Pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Source.BasePage;

public class UserCreateEmployeesPage extends BasePage {

	public UserCreateEmployeesPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	    @FindBy(xpath = "//a[contains(.,'Create a new employee')]")
	  	WebElement createNewUserEmployeedLocatorLink;
	    @FindBy(id="employee_first_name")
	  	WebElement employeeFirstNameLocator;
	    @FindBy(id="employee_last_name")
	  	WebElement employeeLastNameLocator;
	    @FindBy(id="employee_email")
	  	WebElement employeeEmailLocator;
	    @FindBy(id="employee_identification")
	  	WebElement employeeIdLocator;
	    @FindBy(id="employee_leader_name")
	  	WebElement employeeLeaderNameLocator; 
	    @FindBy(id="employee_start_working_on_1i")
	    WebElement yearSelectLocator;
	    @FindBy(id="employee_start_working_on_2i")
	    WebElement daySelectLocator;
	    @FindBy(id="employee_start_working_on_3i")
	    WebElement monthSelectLocator;
	    @FindBy(css="input[name='commit']")
	  	WebElement createEmployeeButton; 
	    @FindBy(id="notice")
	    WebElement noticesSuccesLocator;
	    @FindBy(xpath = "//a[contains(.,'Back')]")
	  	WebElement backLinkLocator;
	    
	    public UserCreateEmployeesPage clickOnCreateUserBtn(){
	    	waitForElementVisible(createNewUserEmployeedLocatorLink);
			clickOnElement(createNewUserEmployeedLocatorLink);
			return new UserCreateEmployeesPage(driver);
		}

	    public UserCreateEmployeesPage createNewUser(String firstName, String lastName, String userEmail, String id, String leader, String year, String day, String month){
	    	
	    	typeOnElement(employeeFirstNameLocator, firstName);
	    	typeOnElement(employeeLastNameLocator, lastName);
	    	typeOnElement(employeeEmailLocator, userEmail);
	    	typeOnElement(employeeIdLocator, id);
	    	typeOnElement(employeeLeaderNameLocator, leader);
	    	new Select(yearSelectLocator).selectByValue(year);
	    	new Select(monthSelectLocator).selectByValue(day);
	    	new Select(daySelectLocator).selectByValue(month);
			clickOnElement(createEmployeeButton);
			return this;
		}
	    
	    public boolean verifyMsgCreateEmp(String userCreateMessage){
			waitForPageLoaded();
			waitForElementVisible(noticesSuccesLocator);
			System.out.println(noticesSuccesLocator.getText());
			return waitForText(noticesSuccesLocator, userCreateMessage);
		}
	    
	    public UserListPage clickOnBackLink(){
	    	waitForElementVisible(backLinkLocator);
			clickOnElement(backLinkLocator);
			waitForPageLoaded();
			return new UserListPage(driver);
		}
	   
		
	
}

