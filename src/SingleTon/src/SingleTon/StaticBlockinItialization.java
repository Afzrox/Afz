package SingleTon;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

@SuppressWarnings("serial")
public class StaticBlockinItialization implements Serializable {
	    private static StaticBlockinItialization SBIObject;
	    
	    private StaticBlockinItialization(){
	    	System.out.println("Static Block Initialization Creating...");
	    }
	    //static block initialization for exception handling
	    static{
	        try{
	            SBIObject = new StaticBlockinItialization();
	        }catch(Exception e){
	            throw new RuntimeException("Exception occured in creating singleton instance");
	        }
	    }
	    
	    public static StaticBlockinItialization getInstance(){
	        return SBIObject;
	    }
}
class TestStaticBlockInitialization{
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		StaticBlockinItialization SBI1Object=StaticBlockinItialization.getInstance();
		StaticBlockinItialization SBI2Object=StaticBlockinItialization.getInstance();
		System.out.println(SBI1Object.hashCode());
		System.out.println(SBI2Object.hashCode());
		///using Serialization and Deserialization
		ObjectOutputStream OOS =new ObjectOutputStream(new FileOutputStream("S2.ser"));
		OOS.writeObject(SBI2Object);
		ObjectInputStream OIS=new ObjectInputStream(new FileInputStream("S2.ser"));
		StaticBlockinItialization SBI3Object=(StaticBlockinItialization) OIS.readObject();
		System.out.println(SBI3Object.hashCode());
		OOS.close();
		OIS.close();
	}
}