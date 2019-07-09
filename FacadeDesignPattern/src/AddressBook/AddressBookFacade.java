package AddressBook;
import java.io.IOException;

import AddressBook.AddPerson;
import AddressBook.DeletePerson;
import AddressBook.EditPerson;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;

public class AddressBookFacade {
	private AddressBook.AddPerson AddPerson;
	private AddressBook.DeletePerson DeletePerson;
	private AddressBook.EditPerson EditPerson;
	private AddressBook.ShowBook ShowBook;
	
	public AddressBookFacade() throws JsonParseException, JsonMappingException, IOException{
		this.AddPerson=new AddPerson();
		this.DeletePerson = new DeletePerson();
		this.EditPerson = new EditPerson();
		this.ShowBook=new ShowBook();
		
	}
	public void Start(String Option) throws JsonParseException, JsonMappingException, IOException{		
		if(Option.equalsIgnoreCase("add") || Option.equalsIgnoreCase("1")) {
			AddPerson.Add();	
		}
		else if(Option.equalsIgnoreCase("remove") || Option.equalsIgnoreCase("2")){
			DeletePerson.Delete();	
		} 
		else if(Option.equalsIgnoreCase("edit") || Option.equalsIgnoreCase("3")){
			EditPerson.Edit();
		}
		else if(Option.equalsIgnoreCase("Show") || Option.equalsIgnoreCase("4")){
			ShowBook.Show();
		}
	}
}
