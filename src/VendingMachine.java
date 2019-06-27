import java.util.Scanner;

class VendingMachine{
    static int i=0;
    static int countNotes=0;        
    public static void Vending(int Rs,int[] Notes){
        
        if(Rs/Notes[i]!=0) {
            countNotes=countNotes+Rs/Notes[i];
            System.out.println(Notes[i]+"\t X "+Rs/Notes[i]);
            Rs=Rs%Notes[i];
        }
        i++;
        if(Rs==0) {
            System.out.println("Total    : "+countNotes);
            return;
        }
        Vending(Rs,Notes);        
    }
        public static void main(String[] args) {
        int[] Notes={1000,500,100,50,20,10,5,2,1};
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter rupees for change");
        int rupees=scan.nextInt();
        Vending(rupees,Notes);
        scan.close();
    }
}