package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import Source.BasePage;

public class UserListPage extends BasePage{

	public UserListPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	public boolean verifyUserEmployeeCreated(String firstname, String lastName, String id,String leader) throws InterruptedException {
		waitForPageLoaded();
		String firstNameLocator = driver.findElement(By.xpath("//td[contains(.,'" + firstname + "')]")).getText();
		String lastNameLocator = driver.findElement(By.xpath("//td[contains(.,'" + lastName + "')]")).getText();;
		String idLocator = driver.findElement(By.xpath("//td[contains(.,'" + id + "')]")).getText();
		String leadorlocator = driver.findElement(By.xpath("//td[contains(.,'" + leader + "')]")).getText();
		if(firstNameLocator.equals(firstname) && lastNameLocator.equals(lastName) && idLocator.equals(id) && leadorlocator.equals(leader))
			return true;
		else 
			System.out.println("Elements are not displayed");
			return false;			
	} 
}
