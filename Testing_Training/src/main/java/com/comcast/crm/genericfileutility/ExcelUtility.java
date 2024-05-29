
package com.comcast.crm.genericfileutility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	public String getDataFromExcel(String sheetname,int rowNum,int celNum) throws Throwable, IOException
	{
		
		FileInputStream fis=new FileInputStream("./TestScriptData/Test.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		String data=wb.getSheet(sheetname).getRow(rowNum).getCell(celNum).getStringCellValue();
		return data;
	}
	public int getRowCount(String sheetname) throws Throwable 
	{
		FileInputStream fis=new FileInputStream("./TestScriptData/Test.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		int rowCount =wb.getSheet(sheetname).getLastRowNum();
		return rowCount;
		
		
	}
	
	public void writeDataBacktoExcel(String sheetname,int rowNum,int celNum,String data) throws Throwable, IOException
	{
			FileInputStream fsi=new FileInputStream("./TestScriptData/Test.xlsx");
			Workbook wb=WorkbookFactory.create(fsi);
			wb.getSheet(sheetname).getRow(rowNum).createCell(celNum);
			
			FileOutputStream fos=new FileOutputStream("./TestScriptData/Test.xlsx");
			wb.write(fos);
			wb.close();
			
			
			
	}
	
	

}
