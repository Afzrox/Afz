import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)//
@Retention(RetentionPolicy.RUNTIME)//
@interface SmartPhone{
	String os() default "Symbian";
	int version() default 1;
}

@SmartPhone(os="Android",version=6)
class Nokia{
	String Model;
	int ScreenSize;
	public Nokia(String model, int screenSize) {
		super();
		Model = model;
		ScreenSize = screenSize;
	}
}
//bulidin Annotation for unused object
class UserDefineAnnotation{
	public static void main(String[] args) {
		
		Nokia nokia=new Nokia("Fire",5);
		@SuppressWarnings("rawtypes")
		Class c=nokia.getClass();
		@SuppressWarnings("unchecked")
		Annotation annotation=c.getAnnotation(SmartPhone.class);
		SmartPhone smartphone=(SmartPhone)annotation;
		System.out.println("Annotation Value os "+smartphone.os());
		System.out.println("Annotation Value version "+smartphone.version());
	}
}