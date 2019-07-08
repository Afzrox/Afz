package AddressBook;
import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;

public class AddressBookFacade {
	private AddressBook.OpenBook OpenBook;
	private AddressBook.AddPerson AddPerson;
	private AddressBook.CloseBook CloseBook;
	private AddressBook.SaveBook SaveBook;
	
	public AddressBookFacade() throws JsonParseException, JsonMappingException, IOException{
		this.OpenBook = new OpenBook();
		this.CloseBook = new CloseBook();
		this.SaveBook = new SaveBook();
		this.AddPerson=new AddPerson();
	}
	public void Start(String Option) throws JsonParseException, JsonMappingException, IOException{		
		if(Option.equalsIgnoreCase("add")) {
			AddPerson.Add();	
		}
		else if(Option.equalsIgnoreCase("save")) {
			CloseBook.Close();	
		} 
		else if(Option.equalsIgnoreCase("edit")) {
			SaveBook.Save();
		}
	}
}
