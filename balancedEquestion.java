import java.util.Scanner;

class stack{
    static char[] stack= new char[10];
    static int top;
    static{
        top=-1;
    }
    static boolean checkEmpty(){
        System.out.println("top is"+top);
        return (top<=0);
    }
    static void push(char character){
        if(top>=10-1){
            System.out.println("Stack over flow");
        }
        else{
            top++;
            stack[top]=character;
            System.out.println(top+" Pushed to Stack : "+stack[top]);
        }
    }
     
    static char pop(){
        char x=' ';
        if(top<0){
            System.out.println("Stack Underflow");
        }
        else{
            x=stack[top];
            System.out.println(top+" pop to Stack : "+x);
            top--;
        }
        return x;
    }
}
class balancedEquestion extends stack{
    public static boolean checkBalanced(String equation){
        char data;
        boolean result=false;
        char character;
        for(int i=0;i<equation.length();i++){
            if((character=equation.charAt(i))=='('){
                push(character);
            }
            if((character=equation.charAt(i))==')'){
                data=pop();
                System.out.println(data);
            }
        }
        result=checkEmpty();   
        return result;
    }
    
    public static void main(String[] args) {
        boolean result=false;
        Scanner scanInput= new Scanner(System.in);
        System.out.println("Enter Equation :");
        String equastion=scanInput.nextLine();
        stack=new char[equastion.length()];
        result=checkBalanced(equastion);
        System.out.println(result);
        scanInput.close(); 
    }
}