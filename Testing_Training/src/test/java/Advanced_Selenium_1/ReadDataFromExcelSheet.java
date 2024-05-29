package Advanced_Selenium_1;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcelSheet {

	public static void main(String[] args) throws Throwable {
		FileInputStream fsi=new FileInputStream("./src/test/resources/Test.xlsx");
		Workbook wb=WorkbookFactory.create(fsi);
		Sheet st=wb.getSheet("Test");
		Row row=st.getRow(1);
		Cell c=row.getCell(2);
		String data=c.getStringCellValue();
		System.out.println(data);
		wb.close();
		
		
		
		
		
	}

}
