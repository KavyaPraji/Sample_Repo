package Advanced_Selenium_1;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Java_Basics_With_Date {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date dateObj=new Date();
		
		SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
		String CURRENTDATE=sim.format(dateObj);
		System.out.println(CURRENTDATE);
		
		//fetch day after 30 days
		
		Calendar calObj=sim.getCalendar();
		calObj.add(Calendar .DAY_OF_MONTH,30);
		String LASTDATE=sim.format(calObj.getTime());
		System.out.println(LASTDATE);

	}

}
