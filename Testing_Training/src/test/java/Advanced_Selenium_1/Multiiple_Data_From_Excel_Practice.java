package Advanced_Selenium_1;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class Multiiple_Data_From_Excel_Practice {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\Multi.xlsx");
		
		Workbook wb=WorkbookFactory.create(fis);
		  Sheet sh=wb.getSheet("Sheet1");
		  int rowCount=sh.getLastRowNum();
		  for(int i=0;i<=rowCount;i++)
		  {
			  Row row=sh.getRow(i);
			 
			  String column1data=row.getCell(0).toString();
			  String column2data=row.getCell(1).toString();
			  
			  System.out.println(column1data+"\t"+column2data);
			  
		  }
		  
		  wb.close();
		  
		  
		  
		

	}

}
