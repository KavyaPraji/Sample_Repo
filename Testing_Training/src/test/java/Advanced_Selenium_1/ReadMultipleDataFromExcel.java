package Advanced_Selenium_1;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadMultipleDataFromExcel {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		FileInputStream fsi=new FileInputStream("./src/test/resources/Multi.xlsx");
		Workbook wb=WorkbookFactory.create(fsi);
		Sheet st=wb.getSheet("Test");
		
		int rowCount=st.getLastRowNum();
		
		for(int i=0;i<=rowCount;i++)
		{ 
			Row row=st.getRow(i);
			
			String column1data=row.getCell(0).toString();
			String column2data=row.getCell(1).toString();
			
			System.out.println(column1data+"\t"+column2data);
		}
		
		wb.close();
		

	}

}
