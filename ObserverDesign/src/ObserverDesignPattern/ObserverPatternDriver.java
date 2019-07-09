package ObserverDesignPattern;

public class ObserverPatternDriver {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Subject subject=new Subject();
		Observer hexObserver=new HexObserver(subject);
		Observer OctalObserver=new OctalObserver(subject);
		Observer BinaryObserver=new BinaryObserver(subject);
		
		System.out.println("\nFirst State change");
		subject.setState(10);
		
		subject.UnSubscribe(hexObserver);
		System.out.println("\nSecond State change");
		subject.setState(20);

		
		
	}
}
