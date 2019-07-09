package AddressBook;

import AddressBook.Utility;
import java.io.File;
import java.io.IOException;
import java.util.List;
import AddressBook.OpenBook;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class DeletePerson {

	public void Delete() throws JsonParseException, JsonMappingException, IOException {
		OpenBook OpenAddressBook=new OpenBook();
		int count=-1;
		File File=OpenAddressBook.getFile();
		ObjectMapper mapper = Utility.getMapper();
		List<ReadBook> ReadBooks = OpenAddressBook.getReadBook();
		System.out.println("Enter Name");
		String Name=Utility.getString();
		for(ReadBook RB:ReadBooks) {
			count++;
			if(Name.equals(RB.getFirstName())){
				System.out.println(RB.getFirstName()+" "+RB.getLastName()+" "+RB.getContact()+" "+RB.getCity()+" "+RB.getZip());
				break;
			}
		}
		if(count>ReadBooks.size()) {
		System.out.println("Not Found");	
		}else {
			ReadBooks.remove(count);
			mapper.writeValue(File,ReadBooks);
		}
	}
}
