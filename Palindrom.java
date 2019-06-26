/////////////////////////////////////////////////////////
///////////////////////////////////////////////////////
////   Programme : Anagram.java                                               
////   Author    : Afzal Sadar
////   Date      : 13JUNE2019
////   Input     : Madam
////   Output    : String Palindrome
//////////////////////////////////////////////////////
/////////////////////////////////////////////////////////


import java.io.BufferedReader;
import java.io.InputStreamReader;
import MyPackage.Util;
public class Palindrom{
    public static void main(String[] args) {
        try{
        InputStreamReader input=new InputStreamReader(System.in);
        BufferedReader bufferedReaderObj =new BufferedReader(input);
        String FirstString=new String();
        System.out.println("Enter String");
        FirstString = bufferedReaderObj.readLine();
        Util.checkPalindrome(FirstString);
        }
        catch(Exception e){
        System.out.println(" Error "+e);
        }
    }
}