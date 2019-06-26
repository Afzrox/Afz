/////////////////////////////////////////////////////////
///////////////////////////////////////////////////////
////   Programme :  Prime.java                                               
////   Author    :  Afzal Sadar
////   Date      :  13JUNE2019
////   Input     :  10 20
////   Output    :  10 is not Prime
////                11 is Prime
////                12 is not Prime
////                13 is Prime
////                14 is not Prime
////                15 is not Prime
////                16 is not Prime
////                17 is Prime
////                18 is not Prime
////                19 is Prime
////                20 is not Prime 
//////////////////////////////////////////////////////
/////////////////////////////////////////////////////////



import java.util.Scanner;
import MyPackage.Util;

public class Prime{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the range");
        int firstNum = scan.nextInt();
        int lastNum = scan.nextInt();
        Util.checkPrime(firstNum, lastNum);
        scan.close();
    }
}