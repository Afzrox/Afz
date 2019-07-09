package ObserverDesignPattern;

import java.util.ArrayList;
public class Subject {
	private ArrayList<Observer> Observers=new ArrayList<Observer>(); 
	private int state;	
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state=state;
		notifyAllObserver();
	}
	private void notifyAllObserver() {
		for(Observer O:Observers) {
			O.update();
		}
	}
	public void Subscribe(Observer observer) {
		Observers.add(observer);
	}
	public void UnSubscribe(Observer observer) {
		Observers.remove(observer);
	}
}
