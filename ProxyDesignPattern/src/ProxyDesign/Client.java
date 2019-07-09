package ProxyDesign;
import java.util.Scanner;

public class Client{ 	
	public static void main (String[] args){ 
		Scanner scanner=new Scanner(System.in);
		Internet internet = new ProxyInternet(); 
	    try{ 
	    	do {
	    		System.out.println("Enter Web Site");
	    		String site=scanner.nextLine();
		    	internet.connectTo(site);
	    	}while(true);
	    } 
	    catch (Exception e){ 
	    	System.out.println(e.getMessage()); 
	    }
	    scanner.close();
	}
} 
