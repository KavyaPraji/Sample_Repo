package Advanced_Selenium_1;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class MultipleData_On_Expectedcondition_Practice {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
		String expectedTestId="tc-02";
		String data1="";
		String data2="";
		String data3="";
		boolean flag=false;
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\Multi.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet("Sheet1");
		int rowCount=sh.getLastRowNum();
	
		for(int i=0;i<=rowCount;i++)
		{
			String data="";
			try {
				  data=sh.getRow(i).getCell(0).toString();//test case column data
				   if(data.equals(expectedTestId))
				{
					   flag=true;
					data1=sh.getRow(i).getCell(1).toString();
					data2=sh.getRow(i).getCell(2).toString();
					data3=sh.getRow(i).getCell(3).toString();
					
				}
			}catch(Exception e)
			{
				
			}
		}
		if(flag=true)
		{
			
		System.out.println(data1);
		System.out.println(data2);
		System.out.println(data3);
			
		}
		
		

	}

}
