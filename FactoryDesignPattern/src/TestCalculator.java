import java.util.Scanner;

public class TestCalculator {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		CalculatorFactory cf=new CalculatorFactory();
		
		System.out.println("Enter First Value");
		int a=sc.nextInt();
		System.out.println("Enter First Value");
		int b=sc.nextInt();
		System.out.println("1.Add");
		System.out.println("2.Multiply");
		System.out.println("3.Subtract");
		System.out.println("Enter Operation");
		int option=sc.nextInt();
		Calculator c=cf.getInstance(option);
		c.calculate(a,b);
		sc.close();
	}
}
