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

public class WriteDataBackToExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
		FileInputStream fsi=new FileInputStream("./src/test/resources/Multi.xlsx");
		Workbook wb=WorkbookFactory.create(fsi);
		Sheet st=wb.getSheet("Test");
		
			Row row=st.getRow(1);
			Cell  cl=row.createCell(4);
			cl.setCellType(CellType.STRING);
			cl.setCellValue("fail");
			//opening file in write mode
			FileOutputStream fos=new FileOutputStream("./src/test/resources/Multi.xlsx");
			wb.write(fos);
			wb.close();
			System.out.println("----executed---");
			
			
		
			
		
		

		

	}

}
