import java.io.FileReader;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class RegularExpression {
	static String message = "Hello <<name>>, We have your full " + 
			"name as <<full name>> in our system. \nYour "
			+ "contact number is 91-xxxxxxxxxx." + 
			" \nPlease,let us know in case of any" + 
			" clarification. \nThank you BridgeLabz 29/06/2019.";
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);	//	scanner to get user input
		System.out.print("Enter your name: ");
		String Name = scanner.nextLine();
		getDetails(Name);
		System.out.println(message);	//	print updated message
		scanner.close();
	}
	
	private static void getDetails(String Name) {
		// TODO Auto-generated method stub
		RegularExpression Regex=new RegularExpression();
		try {
			JSONParser Parser=new JSONParser();
			JSONObject Data=(JSONObject)Parser.parse(new FileReader("RegularExpression.json"));
			System.out.println(Data.get(1));
//			if(Name.equalsIgnoreCase((String)Data.get(Name))) {
//				JSONObject person=(JSONObject)Data.get(Name);
//				String FirstName=(String)person.get("Name");
//				String FullName=(String)person.get("FullName");
//				String Contact=(String)person.get("Phone");
//				String Date=(String)person.get("Date");
//				Regex.replace("<<name>>", FirstName);	//	replace first name
//				Regex.replace("<<full name>>", FullName);	//	replace last name
//				Regex.replace("xxxxxxxxxx", Contact);	// replace contact number
//				Regex.replace("01/01/2016", Date);	//	replace date
//			}
//			else {
//				System.out.println("Not found");
//			}
//			
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
	}

	void replace(String stringToBeReplaced , String replacement) {
		Pattern patrn = Pattern.compile(stringToBeReplaced);	//	pattern
		Matcher matc= patrn.matcher(message);	//	matcher
		message = matc.replaceFirst(replacement);
	}
}

	
	
	
