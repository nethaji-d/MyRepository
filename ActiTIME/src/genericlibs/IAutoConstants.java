package genericlibs;
/**
 * * This interface is used to store configuration information
 * Where in if there are any changes it should reflect everywhere
 * @author Nethaji D
 */
public interface IAutoConstants
{
	String CHROME_KEY="wedriver.chrome.driver";
	String CHROME_PATH="./drivers/chromedriver.exe";

	String ITO="20";
	String ETO="20";

	String XL_FILE_PATH="./resources/TestData.xlsx";
	String SCREEN_SHOT="./errorshots/";

	String DEFAULT_BROWSER="chrome";
	String DEFAULT_USER="admin";
	String DEFAULT_PASSWORD="manager";
	String DEFAULT_URL="https://demo.actitime.com";
}
