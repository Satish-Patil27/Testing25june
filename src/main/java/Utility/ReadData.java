package Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadData {

	public static String readPropertyFile(String value) throws Exception
	{
		Properties prop = new Properties();
		FileInputStream file = new FileInputStream("C:\\Users\\Atish\\eclipse-workspace\\SauceLabFrameWork\\TestData\\config.property");
		prop.load(file);
		return prop.getProperty(value);
		
	}
	
	public static String readExcelFile(int rowNum,int colNum) throws Exception
	{
		FileInputStream f = new FileInputStream("C:\\Users\\Atish\\eclipse-workspace\\SauceLabFrameWork\\TestData\\sauce lab.xlsx");
		Sheet excel = WorkbookFactory.create(f).getSheet("Sheet5");
		String value1 = excel.getRow(rowNum).getCell(colNum).getStringCellValue();
		return value1;
	}
	
}
