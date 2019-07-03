import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ClinicManagement {
    public Scanner scanner=new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        ClinicManagement Clinic=new ClinicManagement();
        Clinic.askUser();
    }

	/** Asks user to choose between doctor and patient **/
		void askUser() throws Exception{
		System.out.println("Whom do you want to search?");
		System.out.println("1. Doctor");
		System.out.println("2. Patient");
		int choice = scanner.nextInt();
		//calls method depending upon user's input
			switch (choice) {
			case 1:
				askDoctorInput();
				break;
			default:
				askPatientInput();
				break;
			}
		}

	/** Gets user's input to search for a doctor **/
	void askDoctorInput() throws Exception{
		System.out.println("Search doctor by:");
		System.out.println("1. Name");
		System.out.println("2. ID");
		System.out.println("3. Specialization");
		System.out.println("4. Availability");
		int choice = scanner.nextInt();
		doctorChoice(choice);
	}

	/** Gets user's input according to his choice **/
	void doctorChoice(int choice) throws Exception  {
		switch (choice) {
		case 1:
			scanner.nextLine();
			System.out.print("Enter name:");
			readDoctorData("Name", scanner.nextLine());
			break;
		case 2:
			System.out.print("Enter ID:");
				readDoctorData("Id", scanner.next());
			break;
		case 3:
			System.out.print("Enter speacialization:");
				readDoctorData("Specialization", scanner.next());
			break;
		case 4:
			System.out.print("Enter availability::");
			readDoctorData("Availability", scanner.next());
			break;
		}
	}

	/** Reads doctor's data from JSON file **/
	void readDoctorData(String key, String value) throws Exception {
	    JSONParser parser = new JSONParser(); // parser to read from json file
	    JSONObject EachDocter=new JSONObject();
	    try {
	        // adds JOSN data to JSON array
	        JSONObject getData = (JSONObject) parser.parse(new FileReader("../Docter.json"));
	        JSONArray DocterList=(JSONArray)getData.get("Docter");
	        for(int i=0;i<DocterList.size();i++) {
	        	EachDocter=(JSONObject)DocterList.get(i);
	        	if (value.equalsIgnoreCase((String)EachDocter.get(key))) {
	        		System.out.println("\nDoctor Information:");
	        		System.out.println("ID\t:" + EachDocter.get("Id") + "\t");
	        		System.out.println("Name\t:" + EachDocter.get("Name") + "\t");
	        		System.out.println("Specialization\t:" + EachDocter.get("Specialization") + "\t");
					System.out.println("Availability\t:" + EachDocter.get("Availability") + "\t");
					JSONArray Patient=(JSONArray)EachDocter.get("PatientList");
	        		for(int j=0;j<Patient.size();j++) {
		        		JSONObject EachPatient=(JSONObject)Patient.get(j);
		        		System.out.print("Patients\t:" + EachPatient.get("Id") + "\n");
	        		}
	        	}
	        }
	        // asks user if want to take an appointment
	        System.out.println("Do you want to take an appointment?[y/n]");
	        char response = scanner.next().charAt(0);
	        if (response=='y') {
	            makeAppointment((String)EachDocter.get("Id"),DocterList);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

	/** If doctor is not busy then makes an appointment**/
	@SuppressWarnings("unchecked")
	void makeAppointment(String Id,JSONArray DocterList) throws Exception {
	JSONObject NewData=new JSONObject();
	JSONObject NewId=new JSONObject();
	for(int i=0;i<DocterList.size();i++){
		JSONObject EachDocter=(JSONObject)DocterList.get(i);
		JSONArray PatientList=(JSONArray)EachDocter.get("PatientList");
			if(Id.equals(EachDocter.get("Id"))) {
				if(PatientList.size()>=5){
					//Docter Busy
					System.out.println("Sorry!!! Doctor is busy today. Make an appointment tomorrow.");
				}
				else{
					String id = getRandomId(); //generates random id
					updatePatientData(id); // updates Patient json file
					NewId.put("Id",id);
					PatientList.add(NewId);
					EachDocter.put("PatientList",PatientList);
					DocterList.add(EachDocter);
					NewData.put("Docter",DocterList);
					updateDoctorData(NewData);
					System.out.println("You have got an appointment. Your Patient ID is " + id + "\n");
					askUser();
				}
			}
		}
	}
	

	/** Gets user's input to search for a patient **/
	void askPatientInput() throws Exception{
	    System.out.println("Search patient by:");
	    System.out.println("1. Name");
	    System.out.println("2. ID");
	    System.out.println("3. Mobile Number");
	    int choice = scanner.nextInt();
	    patientChoice(choice);
	}
	
	/** Gets user's input according to his choice **/
	void patientChoice(int choice) throws Exception{
		switch (choice) {
			case 1:
				scanner.nextLine();
				System.out.print("Enter name:");
				readPatientData("Name", scanner.nextLine());
				break;
			case 2:
				System.out.print("Enter ID:");
				readPatientData("Id", scanner.next());
				break;
			case 3:
				System.out.print("Enter mobile number:");
				readPatientData("Mobile Number", scanner.next());
				break;
			}
	}

	/** Reads patient data from json file **/
	void readPatientData(String key, String value) throws Exception {
    	JSONParser parser = new JSONParser(); //parser to read json file
   	try {
        	JSONObject Data = (JSONObject) parser.parse(new FileReader("Patient.json"));
        	JSONArray Patient=(JSONArray)Data.get("Patient");
        	for(int i=0;i<Patient.size();i++) {
        		JSONObject EachPatient=(JSONObject)Patient.get(i);
        		if (value.equalsIgnoreCase((String)EachPatient.get(key))){
        			System.out.println("\nPatient Information:");
        			System.out.println("ID\t\t:" + EachPatient.get("Id"));
        			System.out.println("Age\t\t:" + EachPatient.get("Age"));
        			System.out.println("Name\t\t:" + EachPatient.get("Name"));
        			System.out.println("Phone\t:" + EachPatient.get("Phone"));
        		}
        	}
    	}
    	catch (IOException | ParseException e) {
        	e.printStackTrace();
    	}
	}
	/** Updates patient's data **/
	@SuppressWarnings("unchecked")
	void updatePatientData(String id) throws Exception {
		
		JSONArray PatientList= new JSONArray();
		JSONObject NewPatient = new JSONObject();
		System.out.println("Enter your Name, Mobile Number ,Age");
		NewPatient.put("Id",id);
		NewPatient.put("Name", scanner.next());
		NewPatient.put("Phone", scanner.next());
		NewPatient.put("Age", scanner.next());
		JSONParser Parser = new JSONParser(); //parser to read the file
		try {
			JSONObject NewData=new JSONObject();
			JSONObject Data = (JSONObject) Parser.parse(new FileReader("Patient.json"));
			PatientList=(JSONArray)Data.get("Patient");
			PatientList.add(NewPatient);
			NewData.put("Patient",PatientList);
			PrintWriter printWriter = null; // print writer to write to the file
			File file = new File("Patient.json");
			printWriter = new PrintWriter(file);
			printWriter.write(NewData.toJSONString()); //writes data to the file
			printWriter.close();
		} 
		catch (IOException | ParseException e) {
			e.printStackTrace();
		}
	}
	/** Updates doctor's data **/
	void updateDoctorData(JSONObject Data) throws Exception {	
		PrintWriter printWriter = null;
		try {
			File file = new File("Docter.json");
			printWriter = new PrintWriter(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		printWriter.write(Data.toJSONString());
		printWriter.close();
	}	
	/** Generates a random ID for patient **/
	String getRandomId() {
		Random random = new Random();
		return String.valueOf(random.nextInt(100)+ 1);
	}
}