package SingleTon;


public class EagerSingletonTest {
	public static void main(String args[]) {
		EagerSingleton a=EagerSingleton.getInstance();
		EagerSingleton b=EagerSingleton.getInstance();
		System.out.println(a.hashCode());
		System.out.println(b.hashCode());
	}
}
