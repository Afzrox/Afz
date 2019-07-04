package AdapterDesignProblem;
import NormalSocket.Socket;
public class ChargePhone {
	public static void main(String[] args) {
		//NormalSocket Socket=new NormalSocket();
		Charger Charge=new ChargerAdapter();
		Charging Charging=new Charging();
		Charging.setCharge(Charge);
		Charging.chargPhone("Charging...");
	}
}
