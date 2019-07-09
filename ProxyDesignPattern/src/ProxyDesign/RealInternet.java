package ProxyDesign;

public class RealInternet implements Internet {

	@Override
	public void connectTo(String serverhost) throws Exception {
		System.out.println("Connecting..."+ serverhost);
	}
}
