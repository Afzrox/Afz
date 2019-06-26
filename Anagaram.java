/////////////////////////////////////////////////////////
///////////////////////////////////////////////////////
////   Programme : Anagram.java                                               
////   Author    : Afzal Sadar
////   Date      : 13JUNE2019
////   Input     : Madam || Damam
////   Output    : String Anagram
//////////////////////////////////////////////////////
/////////////////////////////////////////////////////////



import java.io.BufferedReader;
import java.io.InputStreamReader;
import MyPackage.Util;
public class Anagaram{
    public static void main(String[] args) {
        try{
        //Boolean Result=false;
        //Util utilObj = new Util();
        InputStreamReader input=new InputStreamReader(System.in);
        BufferedReader bufferedReaderObj =new BufferedReader(input);
        String FirstString=new String();
        String SecondString=new String();
        System.out.println("Enter first String");
        FirstString = bufferedReaderObj.readLine();
        
        System.out.println("Enter Second String");
        SecondString = bufferedReaderObj.readLine();
        System.out.println(FirstString+" String "+SecondString);
        Util.checkAnagaram(FirstString,SecondString);
        //System.out.println("String Anagaram :"+Result);
        }
        catch(Exception e){
        System.out.println(" Error "+e);
        }
    }
}