/////////////////////////////////////////////////////////
///////////////////////////////////////////////////////
////    Programme   :   InsertionString.java                                               
////    Author      :   Afzal Sadar
////    Date        :   17JUNE2019
////    Input       :   Enter the string
////                    word
////    Output      :   Sorted String is
////                    dorw
//////////////////////////////////////////////////////
/////////////////////////////////////////////////////////

import  MyPackage.Util;
import java.util.Scanner;

class InsertionString{
    public static void main(String[] args) {
        String Result;
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the string");
        String string=scan.nextLine(); 
        Result=Util.insertionSort(string);
        System.out.println("Sorted String: "+Result);

        scan.close();
    }
}

