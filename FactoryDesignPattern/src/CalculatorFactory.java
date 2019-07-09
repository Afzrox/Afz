
public class CalculatorFactory {
	public Calculator getInstance(int option) {
		if(option==1) {
			return new Add();	
		}
		else if(option==2) {
			return new Multiply();
		}
		else
			return new Subtract();
	}
}