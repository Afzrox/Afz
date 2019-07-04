package AdapterDesignProblem;

public class Charging {
	private Charger charge;
	
	public Charger getCharge() {
		return charge;
	}

	public void setCharge(Charger charge) {
		this.charge = charge;
	}

	public void chargPhone(String str) {
		charge.Charge(str);
	}
}
