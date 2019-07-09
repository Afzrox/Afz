package AddressBook;
import java.util.Scanner;
import org.codehaus.jackson.map.ObjectMapper;

public class Utility {
	static Scanner scan=new Scanner(System.in);
	public static String getString() {
		return scan.nextLine();
	}
	public static int getInt() {
		return scan.nextInt();
	}
	
	public static ObjectMapper getMapper() {
		 return new ObjectMapper();
		 
	}
}
