package Source;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	public WebDriver driver;
	public WebDriverWait wait;
	protected int timeOut = 15;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, timeOut);
	}

	public boolean clickOnElement(WebElement webElement) {

		try {
			wait.until(ExpectedConditions.elementToBeClickable(webElement));
			webElement.click();
			return true;
		} catch (Exception e) {
			getMessages(e);
			return false;
		}
	}
	
	public boolean waitForPageLoaded(){
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			return wait.until(new ExpectedCondition<Boolean>()

			{
				public Boolean apply(WebDriver arg0)
				{
					return js.executeScript("return document.readyState").equals(
							"complete");
				}
			});
		} catch (Exception e) {
			getMessages(e);
			return false;
		}
	}

	public boolean typeOnElement(WebElement element, String text) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(element));
			element.clear();
			element.sendKeys(text);
			return true;
		} catch (Exception e) {
			getMessages(e);
			return false;
		}
	}

	public boolean isElementPresent(By by) {
		try {
			return driver.findElement(by) != null;
		} catch (NoSuchElementException e) {
			getMessages(e);
			return false;
		}
	}

	public WebElement findElement(By by){
		try {
			return wait.until(ExpectedConditions.presenceOfElementLocated(by));
		} catch (Exception e) {
			getMessages(e);
			return null;
			// TODO: handle exception
		}	 		
	}

	public Boolean waitForText(WebElement element, String text){
		try {
			return wait.until(new ExpectedCondition<Boolean>()
			{
				public Boolean apply(WebDriver arg0)
				{
					return element.getText().trim().contains(text);
				}
			});
		} catch (Exception e) {
			getMessages(e);
			return false;
		} 		
	}
	
	public boolean waitForElementVisible(WebElement element)  {
		
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			Thread.sleep(2000);
			return true;
		} catch (Exception e) {
			getMessages(e);
			return false;
		}finally {
			System.out.print("");
		}
	}

	public void getMessages(Exception e){
		System.out.print(e.getMessage());
		System.out.print(e.getStackTrace());
	}

	public boolean waitForElementInvisible(WebElement element){
		try {
			return wait.until(ExpectedConditions.invisibilityOf(element));

		} catch (Exception e) {
			getMessages(e);
			return false;
		}
	}
	
}