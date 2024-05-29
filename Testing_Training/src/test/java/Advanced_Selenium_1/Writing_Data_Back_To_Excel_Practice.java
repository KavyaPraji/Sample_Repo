package Advanced_Selenium_1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Writing_Data_Back_To_Excel_Practice {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		//opening file in read mode
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\Test.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet("sheet1");
		Row row=sh.getRow(1);
		Cell cell=row.createCell(4);
		cell.setCellType(CellType.STRING);
		cell.setCellValue("PASS");
		
		///opening file in write mode
		FileOutputStream fos=new FileOutputStream(".\\\\src\\\\test\\\\resources\\\\Test.xlsx");
		wb.write(fos);
		wb.close();
		System.out.println("===executed====");
		
		
		
		
		
		

	}

}
