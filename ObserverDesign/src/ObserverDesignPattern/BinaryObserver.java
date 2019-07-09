package ObserverDesignPattern;

public class BinaryObserver extends Observer {
	public BinaryObserver(Subject subject) {
		this.subject=subject;
		this.subject.Subscribe(this);
	}

	@Override
	public void update() {
		System.out.println("Binary String"+Integer.toBinaryString(subject.getState() ) );
	}
}