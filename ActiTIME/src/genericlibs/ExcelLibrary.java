package genericlibs;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * To initialize the single copy of workbook type object
 * @author Nethaji D
 *
 */
public class ExcelLibrary 
{
	private static Workbook workbook;
	static
	{
		try 
		{
			workbook = WorkbookFactory.create(new FileInputStream(IAutoConstants.XL_FILE_PATH));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}	
	}

	/**
	 * Method to read the String data
	 * @param sheetName- name of the excel sheet from which we need to read the data
	 * @param rowNumber- the row number from which we need to read the data
	 * @param cellNumber- the cell number from which we need to read the data
	 * @return String
	 */
	public static String getStringData(String sheetName, int rowNumber, int cellNumber) 
	{
		return workbook.getSheet(sheetName).getRow(rowNumber).getCell(cellNumber).getStringCellValue();

	}

	/**
	 * Method to read Numeric data in double form
	 * @param sheetName
	 * @param rowNumber
	 * @param cellNumber
	 * @return Double
	 */
	public static Double getNumericDoubleData(String sheetName, int rowNumber, int cellNumber) 
	{
		return workbook.getSheet(sheetName).getRow(rowNumber).getCell(cellNumber).getNumericCellValue();	
	}

	/**
	 * Method to read Numeric data in integer form
	 * @param sheetName
	 * @param rowNumber
	 * @param cellNumber
	 * @return int
	 */
	public static int getNumericIntData(String sheetName, int rowNumber, int cellNumber) 
	{
		return (int) workbook.getSheet(sheetName).getRow(rowNumber).getCell(cellNumber).getNumericCellValue();	
	}

	/**
	 * Method to read Boolean data
	 * @param sheetName
	 * @param rowNumber
	 * @param cellNumber
	 * @return boolean
	 * @throws Exception 
	 */
	public static Boolean getBooleanData(String sheetName, int rowNumber, int cellNumber) throws Exception 
	{
	
		 
		 
		 
		return workbook.getSheet(sheetName).getRow(rowNumber).getCell(cellNumber).getBooleanCellValue();

	}
	/**
	 * Method to read Date in LocalDateTime Form
	 * @param sheetName
	 * @param rowNumber
	 * @param cellNumber
	 * @return LocalDateTime
	 */
	public static LocalDateTime getLocalDateTimeData(String sheetName, int rowNumber, int cellNumber) 
	{

		return workbook.getSheet(sheetName).getRow(rowNumber).getCell(cellNumber).getLocalDateTimeCellValue();

	}

	/**
	 * Method to return all the data in the String 2D array
	 * @param sheetName
	 * @return
	 */
	public static String[][] getMultipleData(String sheetName)
	{
		Sheet sheet = workbook.getSheet(sheetName);

		int rowCount=sheet.getPhysicalNumberOfRows();
		int cellCount=sheet.getRow(0).getPhysicalNumberOfCells();

		String[][] sarr=new String[rowCount][cellCount];
		for(int i=0; i<=rowCount-1; i++)
		{
			for(int j=0; j<=cellCount-1; j++)
			{
				sarr[i][j]=sheet.getRow(i).getCell(j).toString();
			}
		}
		return sarr;
	}
}

