package SingleTon;
//import java.lang.reflect.Constructor;

public class EagerInitialization {
	private static EagerInitialization EagerObject=new EagerInitialization();
	private EagerInitialization() {
		System.out.println("Creating..");
	}
	public static EagerInitialization getEagerObject() {
		return EagerObject;
	}
}
class TestEager{
	public static void main(String[] args) throws Exception{
		EagerInitialization E1Object =EagerInitialization.getEagerObject();
		EagerInitialization E2Object =EagerInitialization.getEagerObject();
		System.out.println(E1Object.hashCode());
		System.out.println(E2Object.hashCode());
//		
//		@SuppressWarnings("rawtypes")
//		Class c=Class.forName("SingleTon.EagerInitialization");
//		
//		@SuppressWarnings("unchecked")
//		Constructor<EagerInitialization> constructor=c.getDeclaredConstructor();
//		constructor.setAccessible(true);
//		EagerInitialization E3Object=constructor.newInstance();
//		System.out.println(E3Object.hashCode());
	}
}