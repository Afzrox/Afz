import java.util.*;
public class FlipCoin{
	public static void main(String args[]){
		int num,i;
		int t=0;
		int h=0;
		double percent;
		Scanner sc=new Scanner(System.in);
		System.out.println("The number of times to Flip Coin: ");
		num=sc.nextInt();
		for(i=0;i<num;i++){
			if(Math.random()<0.5){
				t++;
			}
			else{
				h++;
			}
		}
		System.out.println("head "+h);
		System.out.println("tail "+t);
		percent = (h*100)/num;
		System.out.println("head percentage "+percent+"%");
		percent = (t*100)/num;
		System.out.println("tail percentage "+percent+"%");
		sc.close();
	}
}