import java.util.*;
public class Gambler{
	public static void main(String args[]){
		int loss=0,win=0;
		float per;
		Scanner sc = new Scanner(System.in);
		System.out.println("The number of times to play: ");
		int numOfTime = sc.nextInt();
		System.out.println("The intake: ");
		int intake = sc.nextInt();
		System.out.println("Enter Goal: ");
		int goal = sc.nextInt();
		win=0;
		loss=0;
		int cash=intake;
		for(int round=0;round<numOfTime;round++) {
			if(cash>0 && win<goal-intake ) {
				if(Math.random()<0.5){
					cash--;
					loss++;
				}
				else{
					cash++;
					win++;
				}
			}	
		}
		

		System.out.println("win "+(win+intake));
		System.out.println("loss "+(intake-loss));
		per = (win*100)/numOfTime;
		System.out.println("win percentage "+per);
		per = (loss*100)/numOfTime;
		System.out.println("loss percentage "+per);
		sc.close();
	}
}