import java.util.Scanner;
import java.lang.Math;
public class Distance{
    static double r;
    static double calculateEuclidean(Double x1,double y1,double x2,double y2){
        x1 -= x2;
        x1 = Math.pow(x1, 2);
        y1 -= y2;
        y1  = Math.pow(y1,2);
        r   = Math.sqrt(x1+y1);
        return r;
    }

    public static void main(String args[]){
        int x2=0;
        int y2=0;
        double r;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter two value X and Y : ");
        double x1 = sc.nextInt();
        double y1 = sc.nextInt();
        r = calculateEuclidean(x1,y1,x2,y2);
        System.out.println("Euclidean Distance for "+x1+ " and " +y1+ " from origine (0,0) is "+r+" .");
        sc.close();
    }
}