package genericlibs;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

/**
 * A Class to develop some common Logics
 * @author Nethaji D
 *
 */
public class FUtil
{
	/**
	 * 
	 * @param driver- WebDriver
	 * @param testCaseName- test case @Test annotated method name
	 * @return the path of the File or Snapshot
	 */
	public static String getSnapShot(WebDriver driver, String testCaseName)
	{
		String timeStamp=LocalDateTime.now().toString().replace(':', '-');
		TakesScreenshot ts=(TakesScreenshot)driver;
		File tempFile = ts.getScreenshotAs(OutputType.FILE);
		File destFile=new File(IAutoConstants.SCREEN_SHOT+testCaseName+timeStamp+".png");		
		try {
			FileUtils.copyFile(tempFile, destFile);
			return destFile.getAbsolutePath();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * Converts the seconds into Milliseconds
	 * @param seconds
	 */
	public static void sleepInSeconds(long seconds) 
	{
		try {
			Thread.sleep(seconds*1000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}
}
