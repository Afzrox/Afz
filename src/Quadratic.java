import java.util.Scanner;
class Quadratic{
    static int a;
    static int b;
    static int c;

    public static void Find(int a1,int b1,int c1){
        //System.out.println(a1);
        //System.out.println(b1);
        //System.out.println(c1);
        double x;
        double y;
        double delta;
        delta = (b1*b1)-(4*a1*c1);    
        //System.out.println("Delta : "+delta);
        x =((-b1)+((Math.sqrt(delta)/2*a1)));
        y =((-b1)-((Math.sqrt(delta)/2*a1)));;
        if(delta > 0){
        System.out.println(x);
        System.out.println(y);
        }
        else if(delta == 0){ 
            x = y = -b/(2*a);
            System.out.println(x);
            System.out.println(y);
        }
        else{
            double realTerm =-b/(2*a);
            double imaginaryTerm = Math.sqrt(-delta) / (2 * a);
            System.out.format("root1 = %.2f+%.2fi and root2 = %.2f-%.2fi", realTerm, imaginaryTerm, realTerm, imaginaryTerm);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter A B and C");
        a=sc.nextInt();
        b=sc.nextInt();
        c=sc.nextInt();
        Find(a,b,c);
        sc.close();
    }
}