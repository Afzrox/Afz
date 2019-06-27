import java.util.Scanner;

public class LeapYear {

    public static void main(String[] args) {
        Scanner scannerObj=new Scanner(System.in);
        System.out.println("Enter Year : ");
        int year = scannerObj.nextInt();
        boolean checkYear = false;
        if(year % 4 == 0){
            if( year % 100 == 0){
                checkYear=false;
            }else{
                checkYear = true;
            }
        }else{
            checkYear = false;
        }
        if(checkYear){
            System.out.println(year + " is a leap year.");
        }else{
            System.out.println(year + " is not a leap year.");
        }
        scannerObj.close();
    }
}