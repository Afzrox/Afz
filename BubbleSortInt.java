import java.util.Scanner;
import MyPackage.Util;

class BubbleSortInt{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Number of element of Array");
        int length=sc.nextInt();
        int[] Array=new int[length];
        for(int i=0;i<length;i++){
            Array[i]=sc.nextInt();
        }
        System.out.println("Sorted Array are");
        Array=Util.bubbleSort(Array);
        for(int i=0;i<length;i++){
           System.out.println(Array[i]);
        }
    }
}