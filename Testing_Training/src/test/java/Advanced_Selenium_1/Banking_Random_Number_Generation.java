package Advanced_Selenium_1;

public class Banking_Random_Number_Generation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=20;
		String alphaNumeric="ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvwxyz";
		StringBuilder sb=new StringBuilder(n);
		for(int i=0;i<n;i++)
		{
			int index=(int)(alphaNumeric.length()*Math.random());
			sb.append(alphaNumeric.charAt(index));
		}
		System.out.println(sb);


	}

}

