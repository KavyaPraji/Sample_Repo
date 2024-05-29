
package com.comcast.crm.generic.webdriverutility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	public int getRandomNum()
	{
		Random  random=new Random();
		int randomNumber=random.nextInt(5000);
		return randomNumber;
		
	}
	public String getSystemDateInFormat()
	{
		Date dateObj=new Date();
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String date=sdf.format(dateObj);
		return date;
		
	}
	
	public String getRequiredDateInFormat(int days)
	{
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Calendar calObj=sdf.getCalendar();
		calObj.add(Calendar .DAY_OF_MONTH,days);
		String requiredDate=sdf.format(calObj.getTime());
		return requiredDate;
	}
	
	

}
