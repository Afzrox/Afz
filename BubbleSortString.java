import java.util.Scanner;
import MyPackage.Util;

class BubbleSortString{
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter String");
        String string=scan.nextLine();
        int[] stringIntArray=new int[string.length()];
        for(int i=0;i<string.length();i++){
            stringIntArray[i]=string.charAt(i);
        }
        stringIntArray=Util.bubbleSort(stringIntArray);
        for(int i=0;i<string.length();i++){
            System.out.print((char)stringIntArray[i]);
        }
        System.out.println();
        scan.close();
    }
}