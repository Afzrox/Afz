import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ClinicManagement {
    public Scanner scanner=new Scanner(System.in);
    public static void main(String[] args) {
        ClinicManagement Clinic=new ClinicManagement();
        Clinic.askUser();
    }

/** Asks user to choose between doctor and patient **/
	void askUser() {
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
	void askDoctorInput() {
		System.out.println("Search doctor by:");
		System.out.println("1. Name");
		System.out.println("2. ID");
		System.out.println("3. Specialization");
		System.out.println("4. Availability");
		int choice = scanner.nextInt();
		doctorChoice(choice);
	}

/** Gets user's input according to his choice **/
void doctorChoice(int choice) {
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
void readDoctorData(String key, String value) {
    JSONParser parser = new JSONParser(); // parser to read from json file
    JSONObject EachDocter=new JSONObject();
    try {
        // adds JOSN data to JSON array
        JSONObject getData = (JSONObject) parser.parse(new FileReader("Docter.json"));
        JSONArray Docter=(JSONArray)getData.get("Docters");
        for(int i=0;i<Docter.size();i++) {
        	EachDocter=(JSONObject)Docter.get(i);
        	if (value.equalsIgnoreCase((String)EachDocter.get(key))) {
        		System.out.println("\nDoctor Information:");
        		System.out.println("ID\t:" + EachDocter.get("Id") + "\t");
        		System.out.println("Name\t:" + EachDocter.get("Name") + "\t");
        		System.out.println("Specialization\t:" + EachDocter.get("Specialization") + "\t");
        		System.out.println("Availability\t:" + EachDocter.get("Availability") + "\t");
        		JSONArray Patient=(JSONArray)EachDocter.get("PatientList");
        		for(int j=0;j<Patient.size();j++) {
        		JSONObject EachPatient=(JSONObject)Patient.get(i);
        		System.out.println("Patients\t:" + EachPatient.get("Name") + "\n");
        		}
        	}
        }
        // asks user if want to take an appointment
        System.out.println("Do you want to take an appointment?[y/n]");
        char response = scanner.next().charAt(0);
        if (response=='y') {
            makeAppointment(EachDocter);
        }
    } catch (IOException | ParseException e) {
        e.printStackTrace();
    }
}

/** If doctor is not busy then makes an appointment**/
void makeAppointment(JSONObject doctorJsonObject) {
    JSONArray NumberOfPatient=(JSONArray)doctorJsonObject.get("PatientList");
    if(NumberOfPatient.size()>=5) {
        System.out.println("Sorry!!! Doctor is busy today. Make an appointment tomorrow.");
    }
    else { // doctor is not busy. Increases number of patients and updates json file
        String id = getRandomId(); //generates random id
        updatePatientData(id); // updates patient json file
        System.out.println("You have got an appointment. Your Patient ID is " + id + "\n");
        askUser();	
    }
}

/** Gets user's input to search for a patient **/
void askPatientInput() {
    System.out.println("Search patient by:");
    System.out.println("1. Name");
    System.out.println("2. ID");
    System.out.println("3. Mobile Number");
    int choice = scanner.nextInt();
    patientChoice(choice);
}

/** Gets user's input according to his choice **/
void patientChoice(int choice) {
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
void readPatientData(String key, String value) {
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
        		System.out.println("Mobile Number\t\t:" + EachPatient.get("Mobile Number"));
        	}
        }
    }
    catch (IOException | ParseException e) {
        e.printStackTrace();
    }
}
/** Updates patient's data **/
	@SuppressWarnings("unchecked")
	void updatePatientData(String id){
		System.out.println("Enter your name, mobile number");
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("Id",id);
		jsonObject.put("Name", scanner.next());
		jsonObject.put("Mobile Number", scanner.next());
		JSONParser parser = new JSONParser(); //parser to read the file
		try {
			JSONArray jsonArray = (JSONArray) parser.parse(new FileReader("Docter.json"));
			jsonArray.add(jsonObject);
			PrintWriter printWriter = null; // print writer to write to the file
			File file = new File("Docter.json");
			try {
			printWriter = new PrintWriter(file);
			} catch (IOException e) {
				e.printStackTrace();
			}
			printWriter.write(jsonArray.toJSONString()); //writes data to the file
			printWriter.close();
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}
	}
/** Updates doctor's data **/
	void updateDoctorData(JSONObject doctorJsonObject) {
		JSONParser parser = new JSONParser();
		JSONArray jsonArray;
		try {
			jsonArray = (JSONArray) parser.parse(new FileReader("/home/user/Desktop/Docter.txt"));
			JSONArray updatedArray = new JSONArray(); // new array with updated elements	
			Iterator<?> iterator = jsonArray.iterator();
            //iterates over array
			while (iterator.hasNext()) {
				JSONObject object = (JSONObject) iterator.next();
				if (object.get("id").equals(doctorJsonObject.get("id"))) {
					updatedArray.add(doctorJsonObject);
				} else {
					updatedArray.add(object);
				}
			}	
			PrintWriter printWriter = null;
			File file = new File("/home/user/Desktop/Docter.txt");
			try {
				printWriter = new PrintWriter(file);
			} catch (IOException e) {
				e.printStackTrace();
			}
			printWriter.write(updatedArray.toJSONString());
			printWriter.close();
		} catch (IOException | ParseException e1) {
			e1.printStackTrace();
		}
	}	

/** Generates a random ID for patient **/
	String getRandomId() {
		Random random = new Random();
		return String.valueOf(random.nextInt(1000)+ 1);
	}
}