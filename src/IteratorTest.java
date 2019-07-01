import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
public class IteratorTest {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
		JSONParser Parser=new JSONParser();
		JSONObject obj=(JSONObject)Parser.parse(new FileReader("IteratorTest.json"));
		obj.keySet().forEach(keyStr ->
		{
	        Object keyvalue = obj.get(keyStr);
	        System.out.println("key: \t"+ keyStr + "\t value:" + keyvalue);

	        //for nested objects iteration if required
//	        if (keyvalue instanceof JSONObject)
//	            printJsonObject((JSONObject)keyvalue);
	    });
		}
			
}
