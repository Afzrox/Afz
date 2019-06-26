/////////////////////////////////////////////////////////
///////////////////////////////////////////////////////
////    Programme   : InsertionSort.java                                               
////    Author      : Afzal Sadar
////    Date        :  17JUNE2019
////    Input       :   5 4 3 2 2
////    Output      :   Arr[1] =2
////                    Arr[2] =2
////                    Arr[3] =3
////                    Arr[4] =4
////                    Arr[5] =5
//////////////////////////////////////////////////////
/////////////////////////////////////////////////////////

import  MyPackage.Util;
import java.util.Scanner;

class InsertionInt{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter No.of Element of Array");
        int NumOfElement=scan.nextInt(); 
        int InsertionSort[]=new int[NumOfElement];
        System.out.println("Enter"+NumOfElement+" Element of Array");
        for(int loop=0;loop<NumOfElement;loop++){
            InsertionSort[loop]=scan.nextInt(); 
        }
        Util.insertionSort(InsertionSort);
        scan.close();
    }
}