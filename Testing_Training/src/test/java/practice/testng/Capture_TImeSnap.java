package practice.testng;

import java.util.Date;

public class Capture_TImeSnap {

	public static void main(String[] args) {
		
	String time=	new  Date().toString().replace(" ", "_").replace(":","_");
	System.out.println(time);
	}

}
