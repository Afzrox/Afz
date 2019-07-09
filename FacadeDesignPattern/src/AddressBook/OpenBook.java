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
	File File;
	public OpenBook() throws JsonParseException, JsonMappingException, IOException{
		
		File=new File("/home/admin1/Desktop/Afz/com/BridgeLabs/FacadeDesignPattern/src/AddressBook/AddressBook.json");
		ObjectMapper map= Utility.getMapper(); 
		InputStream Input=new FileInputStream(File);
		typeRefrence=new TypeReference<List<ReadBook>>() {};
		ReadBooks = map.readValue(Input,typeRefrence);
	}
	
	List<ReadBook> getReadBook(){
		return ReadBooks;
	}
	TypeReference<List<ReadBook>> getTypeRefrence(){
		return typeRefrence;
	}
	File getFile(){
		return File;
		
	}
}
