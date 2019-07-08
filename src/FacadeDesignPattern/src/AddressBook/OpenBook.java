package AddressBook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import AddressBook.Utility;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

public class OpenBook {
	List<ReadBook> ReadBooks;
	TypeReference<List<ReadBook>> typeRefrence;
	public OpenBook() throws JsonParseException, JsonMappingException, IOException{
		
		
		ObjectMapper map= Utility.getMapper();
		File File=new File("/home/user/Afz/com/BridgeLabs/FacadeDesignPattern/src/AddressBook/AddressBook.json"); 
		InputStream Input=new FileInputStream(File);
		typeRefrence=new TypeReference<List<ReadBook>>() {};
		ReadBooks = map.readValue(Input,typeRefrence);
		
		
//		for(ReadBook RB:ReadBooks) {
//			System.out.println(RB.getFirstName()+" "+RB.getLastName()+" "+RB.getContact()+" "+RB.getCity()+" "+RB.getZip());
//		}
//		ReadBook book = new ReadBook();
//		book.setFirstName("Afzal");
//		book.setLastName("Sadar");
//		book.setCity("Pune");
//		book.setContact("8888888888");
//		book.setZip("123123");
//		ReadBooks.add(book);
//		map.writeValue(new File("/home/user/Afz/com/BridgeLabs/FacadeDesignPattern/src/AddressBook/AddressBook.json"),ReadBooks);
	}
	List<ReadBook> getReadBook(){
		return ReadBooks;
	}
	TypeReference<List<ReadBook>> getTypeRefrence(){
		return typeRefrence;
	}
	
}
