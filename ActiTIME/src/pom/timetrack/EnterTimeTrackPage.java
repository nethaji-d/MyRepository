package pom.timetrack;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import genericlibs.WebActionUtil;
import pom.BasePage;

public class EnterTimeTrackPage extends BasePage 
{

	@FindBy(xpath="//span[text()='New']")
	private WebElement newButton;

	@FindBy(xpath="//div[contains(@class, 'customerSelector')]//div[@class='dropdownButton']")
	private WebElement customerSelectionDropdownButton;

	@FindBy(xpath="//div[contains(@class, 'customerSelector')]//div[contains(@class, 'itemRow ')]")
	private List<WebElement> customerSelectionDropdownOptionList;

	@FindBy(xpath="//input[@placeholder='Enter Customer Name']")
	private WebElement customerNameTextField;

	@FindBy(xpath="//input[@placeholder='Enter Project Name']")
	private WebElement projectNameTextField;

	@FindBy(xpath="(//input[@placeholder='Enter task name'])[1]")
	private WebElement enterTaskNameField;

	@FindBy(xpath="(//input[@placeholder='not needed'])[1]")
	private WebElement estimateHoursTextField;

	@FindBy(xpath="(//button[text()='set deadline'])[1]")
	private WebElement setDeadlineButton;

	@FindBy(xpath="//div[text()='Create Tasks']")
	private WebElement createTaskButton;

	@FindBy(xpath="//div[@class='task']")
	private List<WebElement> tasksList;

	@FindBy(xpath="//span[text()='27']")
	private WebElement date;

	public WebElement getCustomerSelectionDropdownButton() {
		return customerSelectionDropdownButton;
	}

	public List<WebElement> getCustomerSelectionDropdownOption() {
		return customerSelectionDropdownOptionList;
	}

	public WebElement getCustomerNameTextField() {
		return customerNameTextField;
	}

	public WebElement getProjectNameTextField() {
		return projectNameTextField;
	}

	public WebElement getEnterTaskNameField() {
		return enterTaskNameField;
	}

	public WebElement getEstimateHoursTextField() {
		return estimateHoursTextField;
	}

	public WebElement getSetDeadlineButton() {
		return setDeadlineButton;
	}

	public WebElement getCreateTaskButton() {
		return createTaskButton;
	}

	public List<WebElement> getTasksList() {
		return tasksList;
	}

	public WebElement getNewButton() 
	{
		return newButton;
	}

	public EnterTimeTrackPage(WebDriver driver, WebActionUtil webActionUtil) 
	{
		super(driver, webActionUtil);
		webActionUtil.verifyPage("actiTIME -  Enter Time-Track", "https://demo.actitime.com/user/submit_tt.do");

	}

	public void selectOption(String optionName)
	{
		for(WebElement ele:customerSelectionDropdownOptionList)
		{
			if(ele.getText().contains(optionName))
			{
				webActionUtil.click(ele);
				break;
			}
		}
	}

	public void createTask(String optionName, String custName, String prjName, String taskName, String estimateHours)
	{
		webActionUtil.click(newButton);
		webActionUtil.click(customerSelectionDropdownButton);
		selectOption(optionName);
		webActionUtil.enterData(customerNameTextField, custName);
		webActionUtil.enterData(projectNameTextField, prjName);
		webActionUtil.enterData(enterTaskNameField, taskName);
		webActionUtil.enterData(estimateHoursTextField, estimateHours);
		webActionUtil.click(setDeadlineButton);
		webActionUtil.click(getDate());
		webActionUtil.click(createTaskButton);
	}

	public boolean verifyTask(String taskName)
	{
		for(WebElement ele:tasksList)
		{
			if(ele.getText().equalsIgnoreCase(taskName))
			{
				return true;
			}
		}
		return false;
	}

	public List<WebElement> getCustomerSelectionDropdownOptionList() {
		return customerSelectionDropdownOptionList;
	}

	public WebElement getDate() {
		return date;
	}

	public void deleteTask()
	{

	}

}
