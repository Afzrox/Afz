import java.util.*;

public class Factor{
	public int a;
	Factor(int ino){
		a=ino;
	}
	
	void PrimeFact(){
		int icnt=0;
		for(int i=2;i<=a/2;i++){
			if(a%i == 0){
				for(int j=2;j<i;j++){
					if(i%j==0){
						icnt++;					
					}
				}
				if(icnt==0){
					System.out.println(i);
					
				}
				icnt=0;
			}
		}
	}

	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Number : ");
		int a = sc.nextInt();
		Factor Fobj = new Factor(a);
		Fobj.PrimeFact();
		sc.close();
	}
}