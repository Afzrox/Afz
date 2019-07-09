package SingleTon;

public class EnumSingleton {
	public static void main(String[] args) {
		EnumTest testEnum=EnumTest.INSTANCE;
		testEnum.i=5;
		testEnum.show();
		testEnum.i=6;
		testEnum.show();
		System.out.println(testEnum.hashCode());
	}
}
enum EnumTest{
	INSTANCE;
	int i;
	public void show() {
		System.out.println(i);
	}
}