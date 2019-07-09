package MediatorDesign;

public class User {
	private String Name;

	public User(String name) {
		this.Name=name;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public void sendMsg(String Msg) {
		ChatRoom.ShowMsg(this,Msg);
	}
}
