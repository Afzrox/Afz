
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class HarmonicNumber{
	public static void main(String[] args){
		try{
		BufferedReader brObj = new BufferedReader(new InputStreamReader(System.in));
		double sum=0;
		int Num;
		System.out.println("Enter the Nth term");
		Num=Integer.parseInt(brObj.readLine());

		while(Num>0){
			sum = sum + (double) 1/Num;
			Num--;
		}
		System.out.println("harmonic term is "+sum);
		}catch(Exception e){
			System.out.print(e);

		}
	}
}

