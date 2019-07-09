package AddressBook;

import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;

public class ShowBook {
	public void Show() throws JsonParseException, JsonMappingException, IOException {
		OpenBook OpenAddressBook=new OpenBook();
		List<ReadBook> ReadBooks = OpenAddressBook.getReadBook();
		for(ReadBook RB:ReadBooks) {
			System.out.println(RB.getFirstName()+"\t\t"+RB.getLastName()+"\t"+RB.getContact()+"\t"+RB.getCity()+"\t"+RB.getZip());
		}
	}
}