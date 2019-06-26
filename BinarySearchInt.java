/////////////////////////////////////////////////////////
///////////////////////////////////////////////////////
////    Programme   :   BinarySearchInt.java                                               
////    Author      :   Afzal Sadar
////    Date        :   17JUNE2019
////    Input       :   Enter Number of Element
////                    5
////                :   Enter 5 Element
////                    6 5 4 3 2
////                    2 3 4 5 6
////                :   Enter the Searching Element
////    Output      :   5 found at Position 4
//////////////////////////////////////////////////////
/////////////////////////////////////////////////////////
import java.util.Scanner;
import MyPackage.Util;
public class BinarySearchInt{
    public static void main(String args[]){
        try{
            Scanner scanner=new Scanner(System.in);
            int temp, i, j;
            System.out.println("Enter Number of Element");
            int NumOfElement=scanner.nextInt();
            int[] BinaryArr = new int[NumOfElement]; 
            System.out.println("Enter the "+NumOfElement+" Element");
            for(int loop=0;loop<NumOfElement;loop++){
                BinaryArr[loop]=scanner.nextInt();
            }
            for(i=0;i<NumOfElement;i++){
                for(j=0;j<NumOfElement-i-1;j++){
                    if(BinaryArr[j]>BinaryArr[j+1]){
                        temp=BinaryArr[j];
                        BinaryArr[j]=BinaryArr[j+1];
                        BinaryArr[j+1]=temp;
                    }
                }
            }
            System.out.println("Sorted Element are");
            for(i=0;i<NumOfElement;i++){
                System.out.println(BinaryArr[i]);
            }
            System.out.println("Enter the Searching Element :");
            int Element=scanner.nextInt();
            Util.binarySearch(BinaryArr,0,NumOfElement-1,Element);
            scanner.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
