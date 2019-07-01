import java.io.FileReader;

import org.json.simple.*;
import org.json.simple.parser.*;

public class test {	
	public static void main(String[] args) throws Exception{
		try {
			JSONParser Parser=new JSONParser();
			JSONObject Contact=(JSONObject)Parser.parse(new FileReader("Contact.json"));
			JSONArray Data=(JSONArray)Contact.get("Data");

			for(int i=0;i<Data.size();i++) {
				JSONObject eachContact=(JSONObject)Data.get(i);
				System.out.print(eachContact.get("FirstName")+"\t"+eachContact.get("LastName")+"\t"+eachContact.get("Contact")+"\t"+eachContact.get("City")+"\t"+eachContact.get("Zip"));
				System.out.println();
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
}
		
