import java.util.*;
public class ReplaceString{
	public static void main(String args[]){
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter Username");
		String userName = scan.nextLine();
		if(userName.length()>=3){
			System.out.println("Hello "+userName+", How are you?");
		}
		else{
			System.out.println("UserName should have minimum 3 Character");		
		}
		scan.close();
	}
}
