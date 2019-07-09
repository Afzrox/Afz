package AddressBook;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class EditPerson {

	public void Edit() throws JsonParseException, JsonMappingException, IOException {
			OpenBook OpenAddressBook=new OpenBook();
			File File=OpenAddressBook.getFile();
			List<ReadBook> ReadBooks = OpenAddressBook.getReadBook();
			ObjectMapper mapper = Utility.getMapper();
			int count=-1;
			
			System.out.println("Enter First Name to Edit");
			String Name=Utility.getString();
			
			for(ReadBook RB:ReadBooks) {
				count++;
				if(Name.equals(RB.getFirstName())){
					System.out.println(RB.getFirstName()+" "+RB.getLastName()+" "+RB.getContact()+" "+RB.getCity()+" "+RB.getZip());
					break;
				}
			}
			
			ReadBook rB=new ReadBook();
			System.out.println("Enter First Name");
			rB.setFirstName(Utility.getString());
			System.out.println("Enter Last Name");
			rB.setLastName(Utility.getString());
			System.out.println("Enter Contact");
			rB.setContact(Utility.getString());
			System.out.println("Enter City");
			rB.setCity(Utility.getString());
			System.out.println("Enter Zip");
			rB.setZip(Utility.getString());
			
			ReadBooks.set(count,rB);
			mapper.writeValue(File,ReadBooks);
	}
}

