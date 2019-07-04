package AdapterDesignProblem;
import NormalSocket.Socket;

public class ChargerAdapter implements Charger {
	Socket socket=new Socket();

	@Override
	public void Charge(String str) {
		// TODO Auto-generated method stub
		socket.charge(str);
	}
}
