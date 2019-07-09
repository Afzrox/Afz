package MediatorDesign;

public class MediatorTest {
	public static void main(String[] args) {
		User Afzal=new User("Afzal");
		User Akshay=new User("Akshay");
		Afzal.sendMsg("Hi...");
		Akshay.sendMsg("Hello.");
	}
}
