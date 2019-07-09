package SingleTon;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class BillPughSingleton implements Serializable {
	   
		private BillPughSingleton(){
			System.out.println("Craeting SingleTon using BillPugh");
		}
	    private static class SingletonHelper{
	        private static final BillPughSingleton INSTANCE = new BillPughSingleton();
	    }
	    public static BillPughSingleton getInstance(){
	        return SingletonHelper.INSTANCE;
	    }
}
class TestBill{
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		BillPughSingleton BillObject1=BillPughSingleton.getInstance();
		BillPughSingleton BillObject2=BillPughSingleton.getInstance();
		System.out.println(BillObject1.hashCode());
		System.out.println(BillObject2.hashCode());
///		Using Serializable
///		ObjectOutputStream OOS =new ObjectOutputStream(new FileOutputStream("S2.ser"));
///		OOS.writeObject(BillObject2);
///		ObjectInputStream OIS=new ObjectInputStream(new FileInputStream("S2.ser"));
///		BillPughSingleton SBI3Object=(BillPughSingleton) OIS.readObject();
///		System.out.println(SBI3Object.hashCode());
///		OOS.close();
///		OIS.close();
	}
}