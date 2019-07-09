package MediatorDesign;
import java.util.Date;
public class ChatRoom {
	public static void ShowMsg(User user ,String Msg) {
		System.out.println(new Date().toString()+ "["+user.getName()+"]"+Msg);
	}
}
