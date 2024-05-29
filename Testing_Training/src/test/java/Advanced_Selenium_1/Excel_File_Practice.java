package Advanced_Selenium_1;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_File_Practice {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// get java representation of physical file
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\Test.xlsx");
		//pen excel file in read mode
		Workbook wb=WorkbookFactory.create(fis);
		//get the control of sheet method
		Sheet sh=wb.getSheet("Sheet1");
		//get the control of first row
		Row row=sh.getRow(1);
		//get control of second cell and read data
		Cell cel=row.getCell(2);
		String value=cel.getStringCellValue();
		System.out.println(value);
		
		wb.close();
		
		

	}

}
