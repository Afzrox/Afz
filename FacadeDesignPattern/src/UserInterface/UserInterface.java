package UserInterface;
import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;

import AddressBook.AddressBookFacade;
import AddressBook.Utility;
public class UserInterface {
	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		AddressBookFacade ABF=new AddressBookFacade();
		do {
			System.out.println("1.Add Person");
			System.out.println("2.Remove Person");
			System.out.println("3.Edit Book");
			System.out.println("4.Show Book");
			System.out.println("Enter your Option");

			String Input=Utility.getString();
			ABF.Start(Input);
			
		}while(true);
	}
}
