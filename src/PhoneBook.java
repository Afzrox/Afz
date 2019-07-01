import org.json.simple.*;
import org.json.simple.parser.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class PhoneBook {

	static Scanner scan=new Scanner(System.in);
	static BufferedReader BR=new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws Exception{
		int Choice=0;
		char Exit=' ';
		do {
			System.out.println("1.Show Data");
			System.out.println("2.Add a Person");
			System.out.println("3.Edit a Person");
			System.out.println("4.Delete a Person");
			System.out.println("5.Search a Person");
			System.out.println("6.Exit");
			Choice=scan.nextInt();
			switch(Choice) {
			case 1:
				ShowContact();
				break;
			case 2:
				SaveContact();
				break;
			case 3:
				EditContact();
				break;
			case 4:
				DeleteContact();
				break;
			case 5:
				SearchContact();
				break;
			case 6:
				System.out.println("Enter Y/n for Exit");
				Exit=BR.readLine().charAt(0);
				break;
			default :
				System.out.println("Ener proper choice");
			}
		}while(Exit!='Y' || Exit!= 'y');
	}
	
	private static void SearchContact() throws IOException, ParseException {
		// TODO Auto-generated method stub
		boolean delete=true;
		JSONArray ContactList=getData();
		System.out.println("Enter Name Search");
		String Name=BR.readLine();
		for(int i=0;i<ContactList.size();i++) {
			JSONObject EachContact=(JSONObject)ContactList.get(i);
			if(Name.equals((String)EachContact.get("FirstName"))){
				System.out.println("Data Found");
				System.out.println("FirstName\t:"+EachContact.get("FirstName"));
				System.out.println("LastName\t:"+EachContact.get("LastName"));
				System.out.println("Contact\t\t:"+EachContact.get("Contact"));
				System.out.println("City\t\t:"+EachContact.get("City"));
				System.out.println("Zip\t\t:"+EachContact.get("Zip"));
				delete=false;
			}
		}
		if(delete) {
			System.out.println("No data Found");
		}
	}

	@SuppressWarnings("unchecked")
	private static void DeleteContact() throws IOException, ParseException {
		boolean delete=true;
		// TODO Auto-generated method stub
		JSONArray ContactList=getData();
		JSONObject NewList=new JSONObject();
		System.out.println("Enter Name to delete");
		String Name=BR.readLine();
		for(int i=0;i<ContactList.size();i++) {
			JSONObject eachContact=(JSONObject)ContactList.get(i);
			if(Name.equals((String)eachContact.get("FirstName"))){
				ContactList.remove(i);
				System.out.println("Data Deleted");
				NewList.put("Data",ContactList);
				writeData(NewList);
				delete=false;
			}
		}
		if(delete) {
			System.out.println("No Data Found");
		}
	}
	
	public static void writeData(JSONObject ContactList) throws IOException {
		FileWriter file = new FileWriter("Contact.json");
		file.write(ContactList.toJSONString());
        file.flush();
        file.close();	
	}

	@SuppressWarnings("unchecked")
	private static void EditContact() throws IOException, ParseException {
		// TODO Auto-generated method stub
		JSONArray Contact=getData();
		JSONObject NewList=new JSONObject();
		System.out.println("Enter Field to edit");
		String Field=BR.readLine();
		System.out.println("Enter Name to edit");
		String OldName=BR.readLine();
		for(int i=0;i<Contact.size();i++) {
			JSONObject eachContact=(JSONObject)Contact.get(i);
			if(OldName.equals((String)eachContact.get("FirstName"))){
				System.out.println("Enter Data to edit");
				String NewName=BR.readLine();
				eachContact.put(Field,NewName);
				NewList.put("Data",Contact);
				writeData(NewList);
				System.out.println("Data Edited");
			}
		}
	}

	@SuppressWarnings("unchecked")
	private static void SaveContact() throws ParseException {
		// TODO Auto-generated method stub
		JSONObject NewContact=new JSONObject();
		
		try {
			System.out.println("Enter First Name");
			NewContact.put("FirstName",BR.readLine());
			System.out.println("Enter Last Name");
			NewContact.put("LastName",BR.readLine());
			System.out.println("Enter Contact Number");
			NewContact.put("Contact",BR.readLine());
			System.out.println("Enter City");
			NewContact.put("City",BR.readLine());
			System.out.println("Enter Zip");
			NewContact.put("Zip",BR.readLine());
			System.out.println("Enter Y/n to Save");
			char save=scan.next().charAt(0);
			if(save=='Y' || save=='y') {
				JSONArray ContactList=getData();
				ContactList.add((JSONObject)NewContact);
				JSONObject NewList = new JSONObject();
				NewList.put("Data",ContactList);
				writeData(NewList);
				System.out.println("Data Saved");
			}
			else {
				System.out.println("Data Not Saved");
			}
        }catch(IOException e) {
            e.printStackTrace();
        }
	}
	
	private static void ShowContact() throws IOException, ParseException {
		JSONArray ContactList=getData();
		for(int i=0;i<ContactList.size();i++) {
			JSONObject eachContact=(JSONObject)ContactList.get(i);
			System.out.print(eachContact.get("FirstName")+"\t\t"+eachContact.get("LastName")+"\t\t"+eachContact.get("Contact")+"\t"+eachContact.get("City")+"\t"+eachContact.get("Zip"));
			System.out.println();
		}
	}
	public static JSONArray getData() throws IOException, ParseException {
		JSONArray ContactList=null;
		JSONParser Parser=new JSONParser();
		try {
			FileReader ReadFile=new FileReader("Contact.json");
			JSONObject Contact=(JSONObject)Parser.parse(ReadFile);
			ContactList =(JSONArray)Contact.get("Data");
			
		}
		catch(NullPointerException e) {
			System.out.println("No Data Found");
		}
		return ContactList;
	}
}
