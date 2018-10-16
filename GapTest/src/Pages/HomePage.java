package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Source.BasePage;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
    @FindBy(css = "div#content p.flash_notice")
	WebElement bannerSuccessfullyMsgLocator;
    @FindBy(css = "#logo")
  	WebElement logoLocator;
    @FindBy(css = "#user_information")
  	WebElement elementUserLogLocator;
    @FindBy(xpath = "//a[contains(.,'Employees Information')]")
  	WebElement EmployeesTabLocator;
  
    public boolean verifySuccessMsg(String successMsg){
    	waitForPageLoaded();
    	waitForElementVisible(bannerSuccessfullyMsgLocator);
    	System.out.println(bannerSuccessfullyMsgLocator.getText());
		return waitForText(bannerSuccessfullyMsgLocator, successMsg);
	}
    
    public boolean logoIsDisplayed() {
		return waitForElementVisible(logoLocator);
	}
    
    public boolean verifyinformationMessage(String userLogMessage){
		waitForPageLoaded();
		waitForElementVisible(elementUserLogLocator);
		System.out.println(elementUserLogLocator.getText());
		return waitForText(elementUserLogLocator, userLogMessage);
	}
    
    public UserCreateEmployeesPage clickOnLoginBtnPage(){
		clickOnElement(EmployeesTabLocator);
		return new UserCreateEmployeesPage(driver);
	}
	
    


}