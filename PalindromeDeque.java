import java.util.Scanner;
class Queue{
    static int front,rear;
    static char[] queue;
    static{
        front =-1;
        rear=0;
    }

    static void push(char character){
        if(front==-1){
            front=0;
        }
        queue[rear]=character;
        rear++;
    }

    static char popFront(){
        char x;
        x=queue[front];
        front++;
        return x;
    }
    static char popRear(){
        char x;
        rear--;
        x=queue[rear];
        return x;
    }
    static void queuepush(String str){
        int i;
        for(i=0;i<queue.length;i++){
            push(str.charAt(i));
        }
    }
    static boolean checkPalindrom(){
        char first,last;
        boolean result=false;
        for(int i=0;i<(queue.length/2);i++){
            first=popFront();
            last=popRear();
            if(first!=last){
                result = false;
                return false;
            }
            else{
                result = true;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        boolean result=false;
        Scanner scanInput= new Scanner(System.in);
        System.out.println("Enter String :");
        String Word=scanInput.nextLine();
        queue=new char[Word.length()];
        queuepush(Word);
        result=checkPalindrom();
        System.out.println(result);
        scanInput.close();
    }
}