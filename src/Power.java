public class Power{
	public static void main(String[] args){
		int a=Integer.parseInt(args[0]);
		System.out.println("2^"+a+" is : "+(int)Math.pow(2,a));
		if(a>0 &&a<30){
			for(int i=1;i<=a;i++){
				System.out.println("2^"+i+" : "+(int)Math.pow(2,i));
			}
		}
	}
}
