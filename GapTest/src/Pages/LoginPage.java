package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Source.BasePage;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    //Login Elements
    	@FindBy(id = "user_email")
    	WebElement userEmailField;
        @FindBy(id = "user_password")
        WebElement userPasswordField;
        @FindBy(name = "commit")
        WebElement commitBtn;
        
    public HomePage logIn(String userEmail,String userPassword)    
     {
    	typeOnElement(userEmailField, userEmail);
    	typeOnElement(userPasswordField, userPassword);
		clickOnElement(commitBtn);
		return new HomePage(driver);    
     }
}
