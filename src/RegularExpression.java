import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.FileReader;
import java.util.Iterator;
import java.util.Scanner;

public class RegularExpression {
	public void getExpression(JSONObject Name) {
		String FullName="";
		String PhoneNumber="";
		Iterator<?> iterator = Name.iterator();
		while (iterator.hasNext()) {
			JSONObject obj = (JSONObject) iterator.next();
			FullName = (String) obj.get("FullName");
			PhoneNumber = (String) obj.get("Phone");
		}
		System.out.println("Hello, We have your full\n" + "name as " + FullName+
				" in our system. your contact number is "+PhoneNumber+".\n"
				+ "Please,let us know in case of any clarification Thank you BridgeLabz 01/01/2016.");
	}
	
	public static void main(String[] args) {
		RegularExpression regularExp = new RegularExpression();
		Scanner scan = new Scanner(System.in);
		JSONParser Parser = new JSONParser();
		JSONObject Name = new JSONObject();
		try {
			Name = (JSONObject) Parser.parse(new FileReader("RegularExpression.json"));
			System.out.println("Enter name");
			String InputName = scan.nextLine();
			String getName = (String) Name.get(InputName);
			if (getName != InputName) {
				System.out.println("No Data Found");
			} else {
				regularExp.getExpression(Name.get(InputName));
			}
		} catch (Exception e) {
			System.out.println(e);
		}

	}
}
