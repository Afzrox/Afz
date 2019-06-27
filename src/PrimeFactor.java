import java.io.BufferedReader;
import java.io.InputStreamReader;

class PrimeFactor{
    public static void getPrimeFactor(int Num){
        int outerLoop,primeCount=0,innerLoop=0;
        System.out.println("Primr Factor are");
        for(outerLoop=2;outerLoop<Num;outerLoop++){
            if(Num%outerLoop==0){
                for(innerLoop=2;innerLoop<=outerLoop/2;innerLoop++){
                    if(outerLoop%innerLoop==0){
                        primeCount++;
                        break;
                    }
                }
                if(primeCount==0){
                    System.out.println(outerLoop);
                }
                primeCount=0;
            }
        }
    }
    public static void main(String[] args) {
        try{
        BufferedReader BRObj=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter Number");
        int Num=Integer.parseInt(BRObj.readLine());
        getPrimeFactor(Num);
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}