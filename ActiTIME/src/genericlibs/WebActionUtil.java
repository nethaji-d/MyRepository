package genericlibs;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebActionUtil
{
	WebDriverWait wait;
	WebDriver driver;
	JavascriptExecutor jse;
	Actions actions;
	Select select;
	Alert alert;
	public WebActionUtil  webActionUtil;
	protected WebActionUtil(WebDriver driver, long ETO, WebElement target)
	{
		wait=new WebDriverWait(driver, ETO);
		this.driver=driver;
		jse=(JavascriptExecutor) driver;
		actions=new Actions(driver);
		select=new Select(target);
		alert=driver.switchTo().alert();
	}

	public void enterData(WebElement target, String text)
	{
		wait.until(ExpectedConditions.visibilityOf(target));
		target.clear();
		target.sendKeys(text);
	}

	public  void click(WebElement target)
	{
		try 
		{
			wait.until(ExpectedConditions.visibilityOf(target));
			wait.until(ExpectedConditions.elementToBeClickable(target));
			target.click();
		}catch(Exception e) 
		{
			target.sendKeys(Keys.ENTER);
		}
	}
	public void jsClick(WebElement target)
	{
		wait.until(ExpectedConditions.visibilityOf(target));
		wait.until(ExpectedConditions.elementToBeClickable(target));
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click();", target);
	}

	public void scroll(int xPixels, int yPixels)
	{
		jse.executeScript("scrollBy(arguments[0], arguments[1];", xPixels, yPixels);
	}

	public void scrollToTop()
	{
		jse.executeScript("scrollTo(0, -document.body.scrollHeight");
	}

	public void scrollToBottom()
	{
		jse.executeScript("scrollTo(0,document.body.scrollHeight");
	}

	public void dragAndDrop(WebElement source, WebElement dest)
	{
		actions.dragAndDrop(source, dest).perform();
	}

	public void moveToElement(WebElement target)
	{
		actions.moveToElement(target).perform();
	}

	public void doubleClick(WebElement target)
	{
		actions.doubleClick(target).perform();
	}

	public void contextClick(WebElement target)
	{
		actions.contextClick(target).perform();
	}

	public void selectByVisibleText(WebElement target, String text)
	{
		Select select=new Select(target);
		select.selectByVisibleText(text);
	}

	public void selectByValue(WebElement target, String text)
	{
		Select select=new Select(target);
		select.selectByValue(text);
	}

	public void selectByIndex(WebElement target, int text)
	{
		Select select=new Select(target);
		select.selectByIndex(text);
	}

	public String getSelectedOption(WebElement target)
	{

		return select.getFirstSelectedOption().getText();
	}

	public void closeAllChildBrowserWindows()
	{
		String parentWindowId = driver.getWindowHandle();
		Set<String> allWindowIds = driver.getWindowHandles();
		allWindowIds.remove(parentWindowId);
		for(String wid : allWindowIds)
		{
			driver.switchTo().window(wid);
			driver.close();
		}
		driver.switchTo().window(parentWindowId);
	}

	public void switchToParentWindow()
	{
		List<String> allWindowIdsList=new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(allWindowIdsList.get(0));
	}
	public void switchToWindow(String title)
	{
		Set<String> allWindowIds = driver.getWindowHandles();
		for(String wid : allWindowIds)
		{
			driver.switchTo().window(wid);
			if(driver.getTitle().contains(title))
			{
				break;
			}
		}
	}

	public void switchToFrame(String indexIdorName)
	{
		try
		{
			int index=Integer.parseInt(indexIdorName);
			driver.switchTo().frame(index);
		}catch(NumberFormatException e)
		{
			driver.switchTo().frame(indexIdorName);
		}

	}
	public void acceptAlert(String alertText)
	{
		wait.until(ExpectedConditions.alertIsPresent());
		if(alert.getText().contains(alertText))
		{
			alert.accept();
		}
	}

	public void cancelAlert(String alertText)
	{
		wait.until(ExpectedConditions.alertIsPresent());
		if(alert.getText().contains(alertText))
		{
			alert.dismiss();
		}
	}

	public void verifyPage(String expectedTitle, String expectedUrl)
	{
		wait.until(ExpectedConditions.titleContains(expectedTitle));
		wait.until(ExpectedConditions.urlContains(expectedUrl));
	}
}
