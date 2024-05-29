
package com.comcast.crm.genericfileutility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility
{
	public String getDataFromProperties(String key) throws IOException
	{
		FileInputStream fis=new FileInputStream("./configurationAppData/commondata.properties");
		Properties ps=new Properties();
		ps.load(fis);
		
		String data=ps.getProperty(key);
	
		
		return data;
	}

}
