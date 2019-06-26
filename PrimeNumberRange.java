import java.util.Scanner;

public class PrimeNumberRange{
    static int Array[][]=new int[26][26];
    static void checkPalindrome(int firstNumber,int secondNumber){
        boolean flag=true;
        for(int i=firstNumber;i<=secondNumber;i++){
            if(i<=1){
                System.out.println("Enter Proper value");
                return;
            }
            for(int j=2;j<i/2;j++){
                if(i%j==0){
                    flag=false;
                    break;
                }
            }
            if(flag){
                int pos=(int)i/100;
                insertValue(pos,i);
            }
            flag=true;
        }
    }
    static void insertValue(int pos,int value){
        int row=0;
        for(row=0;row<26;row++){
            if((Array[row][pos]==0) && row<10){                                      
                Array[row][pos]=value;
                return;
            }
        }
    }

    static void printArray(){
        int col=0;
        for(int row=0;row<26;row++){
            while(col<26 && Array[row][col]!=0){
                System.out.print("\t"+Array[row][col]);
                col++;
            }
            System.out.println();                
            col=0;
            }
    }
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter Range Number :");
        int firstNumber=scan.nextInt();
        int secondNumber=scan.nextInt();
        checkPalindrome(firstNumber,secondNumber);
        printArray();
        scan.close();
    }
}
