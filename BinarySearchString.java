/////////////////////////////////////////////////////////
///////////////////////////////////////////////////////
////    Programme :     BinarySearchString.java                                               
////    Author    :     Afzal Sadar
////    Date      :     17JUNE2019
////    Input     :     Enter the string
////                    afzal
////                    Sorted String before Search :aaflz
////                    Enter the searching character :
////                    a
////    Output    :     a fount at posistion 1
//////////////////////////////////////////////////////
/////////////////////////////////////////////////////////


import java.util.Scanner;
import MyPackage.Util;
class BinarySearchString{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the string");
        String string=scan.nextLine(); 
        String Result=Util.insertionSort(string);
        System.out.println("Sorted String before Search :"+Result);
        System.out.println("Enter the searching character :");
        char SearchChar=scan.next().charAt(0);
        Util.binarySearch(Result,0,Result.length(),SearchChar);
        scan.close();
    }
}