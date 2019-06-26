/////////////////////////////////////////////////////////
///////////////////////////////////////////////////////
////   Programme :  Prime.java                                               
////   Author    :  Afzal Sadar
////   Date      :  15JUNE2019
////   Input     :  10 20
////   Output    :  .......PRIME CHECKING.......
////                101 is Prime Number
////                103 is Prime Number
////                107 is Prime Number
////                109 is Prime Number
////                .......PALINDROM CHECKING.......
////                101 is Palindrome
////                103 is Not Palindrome
////                107 is Not Palindrome
////                109 is Not Palindrome
////                .......ANAGARAM CHECKING.......
////                101 And 101 is Anagram
////                101 And 103 is not Anagram
////                101 And 107 is not Anagram
////                101 And 109 is not Anagram
////                103 And 101 is not Anagram
////                103 And 103 is Anagram
////                103 And 107 is not Anagram
////                103 And 109 is not Anagram
////                107 And 101 is not Anagram
////                107 And 103 is not Anagram
////                107 And 107 is Anagram
////                107 And 109 is not Anagram
////                109 And 101 is not Anagram
////                109 And 103 is not Anagram
////                109 And 107 is not Anagram
////                109 And 109 is Anagram
//////////////////////////////////////////////////////
/////////////////////////////////////////////////////////



import java.util.Scanner;
import MyPackage.Util;

public class PrimeExtend{
    public static void main(String[] args) {
        try{
        int i,j;
        Scanner scan = new Scanner(System.in);
        System.out.println(" Enter Range between 0-1000 :");
        int FirstNum = scan.nextInt();
        int SecondNum = scan.nextInt();
        System.out.println(".......PRIME CHECKING.......");
        Util.checkPrime(FirstNum,SecondNum);
        int length = Util.Position;
        int AnagaramArr[] =  new int[length];
        for(i=0;i<length;i++){
        AnagaramArr[i]=Util.ArrNum[i];
        }
        System.out.println(".......PALINDROM CHECKING.......");
        for(i=0;i<length;i++){
                Util.checkPalindrome(AnagaramArr[i]);
        }
        System.out.println(".......ANAGARAM CHECKING.......");
        for(i=0;i<length;i++){
            for(j=0;j<length;j++){
                Util.checkAnagaram(AnagaramArr[i],AnagaramArr[j]);
            }
        }
        scan.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}