package ObserverDesignPattern;

public class HexObserver extends Observer {
	public HexObserver(Subject subject) {
		this.subject=subject;
		this.subject.Subscribe(this);
	}

	@Override
	public void update() {
		System.out.println("Hexa String"+Integer.toHexString(subject.getState() ).toUpperCase() );
	}
}
