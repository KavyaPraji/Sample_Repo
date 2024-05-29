package Advanced_Selenium_1;

public class AlphaNumericRandomData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=20;
		
		//choose a character random from this string
		String AlphaNumericString ="ABCDEFGHIJKLMNOOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvwxyz";
		
		//create String buffer size of AlphaNumericString
		
		StringBuffer sb=new StringBuffer(n);
		
		for(int i=0;i<n;i++)
		{
			//generate random number between 0 to AlphaNumericString variable length
			int index =(int)(AlphaNumericString.length()*Math.random());
			
			//add character one by one in end of sb
			sb.append(AlphaNumericString.charAt(index));
		}
			System.out.println(sb);
	}

}
