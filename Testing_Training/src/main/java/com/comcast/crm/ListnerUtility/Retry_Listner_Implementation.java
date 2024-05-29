package com.comcast.crm.ListnerUtility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry_Listner_Implementation implements IRetryAnalyzer
{
	
	int count=0;
	int limiCount=5;
	public boolean retry(ITestResult result) {
		
		if(count<limiCount) {
			count++;
			return true;
		}
		return false;
	}
	

}
