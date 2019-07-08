package AddressBook;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import AddressBook.OpenBook;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
public class AddPerson {
	void Add() throws IOException{
		OpenBook OpenAddressBook=new OpenBook(); 
		File File= new File("/home/user/Afz/com/BridgeLabs/FacadeDesignPattern/src/AddressBook/AddressBook.json");
		ObjectMapper mapper = Utility.getMapper();
		
		System.out.println("Enter First Name");
		String FirstName=Utility.getString();
		System.out.println("Enter Last Name");
		String LastName=Utility.getString();
		System.out.println("Enter City");
		String City=Utility.getString();
		System.out.println("Enter Contact");
		String Contact=Utility.getString();
		System.out.println("Enter Zip");
		String Zip=Utility.getString();
		
		InputStream Input=new FileInputStream(File);
		TypeReference<List<ReadBook>> typeRefrence=OpenAddressBook.getTypeRefrence();
		List<ReadBook> ReadBooks = OpenAddressBook.getReadBook();
		ReadBook book = new ReadBook();
		book.setFirstName(FirstName);
		book.setLastName(LastName);
		book.setCity(City);
		book.setContact(Contact);
		book.setZip(Zip);
		ReadBooks.add(book);
		mapper.writeValue(File,ReadBooks);
		
	}


}
