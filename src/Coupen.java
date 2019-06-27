import java.util.*;


class Coupen{
	private static final String coupenString = "ABCDEFGJIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
	public static String randomCoupen(int length) {
		StringBuilder coupen =new StringBuilder();
		while(length--!=0) {
			int position=(int)(Math.random()*coupenString.length());
			coupen.append(coupenString.charAt(position));
		}
		return coupen.toString();	
	}
	
	public static void main(String args[]) {
		Scanner scan =new Scanner(System.in);
		System.out.println("Enter Number of Coupen ");
		int NumOfCoupen=scan.nextInt();
		String[] coupen=new String[NumOfCoupen];
		System.out.println("Enter length of Coupen ");
		int length=scan.nextInt();
		while(NumOfCoupen!=0) {
		coupen[NumOfCoupen-1]=randomCoupen(length);
		NumOfCoupen--;
		}
		for(String a:coupen) {
			System.out.println(a);
		}
		scan.close();
	}
} 