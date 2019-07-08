package UserInterface;
import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;

import AddressBook.AddressBookFacade;
import AddressBook.Utility;
public class UserInterface {
	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		AddressBookFacade ABF=new AddressBookFacade();
		System.out.println("Enter your Option");
		String Input=Utility.getString();
		ABF.Start(Input);
	}
}
