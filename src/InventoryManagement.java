import java.io.FileReader;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import java.util.Iterator;
public class InventoryManagement {
	public void calculate(JSONArray Item) {
		Iterator<?> iterator =Item.iterator();
		long value=0;
		while(iterator.hasNext()) {
			JSONObject obj= (JSONObject)iterator.next();
			long weight =(long)obj.get("Weight");
			long price =(long)obj.get("Price");
			value=weight*price;
		}
		System.out.println("Total Price is"+ value);
	}
	public static void main(String[] args) throws Exception {
		InventoryManagement Inventory =new InventoryManagement();
		JSONParser Parser = new JSONParser();
		JSONArray Item=new JSONArray();
		JSONObject InventoryObject=new JSONObject();
		try {
		InventoryObject = (JSONObject)Parser.parse(new FileReader("Inventory.json"));
		Item=(JSONArray)InventoryObject.get("Rice");
		System.out.println("Rice :"+Item);
		Inventory.calculate(Item);
		//System.out.println(Item.getVAlue("Price"));
		Item=(JSONArray)InventoryObject.get("Pulses");
		System.out.println("Rice :"+Item);
		Inventory.calculate(Item);
		Item=(JSONArray)InventoryObject.get("Wheat");
		System.out.println("Rice :"+Item);
		Inventory.calculate(Item);
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
}