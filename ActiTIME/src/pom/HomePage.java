package pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import genericlibs.WebActionUtil;
import pom.timetrack.EnterTimeTrackPage;

public class HomePage extends BasePage
{
	public HomePage(WebDriver driver, WebActionUtil webActionUtil)
	{
		super(driver, webActionUtil);
		webActionUtil.verifyPage("actiTIME -  Enter Time-Track", "https://demo.actitime.com/user/submit_tt.do");
	}

	@FindBy(linkText="Time-Track")
	private WebElement timeTrackLink;

	@FindBy(id="logoutLink")
	private WebElement logoutLink;

	@FindBy(xpath="//a/div[contains(@id,'container')]")
	private List<WebElement> menuLinksList;

	public WebElement getLogoutLink() 
	{
		return logoutLink;
	}

	public WebElement getTimeTrackLink() 
	{
		return timeTrackLink;
	}

	public BasePage clickOnMenuLinks(String menuName)
	{
		for(WebElement ele:menuLinksList)
		{
			if(ele.getText().equalsIgnoreCase(menuName))
			{
				webActionUtil.click(ele);
				break;
			}
		}
		menuName=menuName.toLowerCase();
		switch(menuName)
		{
		case "time-track" : return new EnterTimeTrackPage(driver, webActionUtil);
		case "users" : return new UsersPage(driver, webActionUtil);
		case "reports" : return new ReportsPage(driver, webActionUtil);
		case "tasks" : return new TasksPage(driver, webActionUtil);
		default : return null;
		}
	}

}
