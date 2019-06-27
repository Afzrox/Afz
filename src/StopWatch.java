import java.util.Scanner;
class StopWatch{

    long startWatch(){
        long startTime;
        startTime = System.currentTimeMillis();
        return startTime;
    }

    long endWatch(){
        long endTime;
        endTime = System.currentTimeMillis();
        return endTime;
    }
    public static void main(String[] args) {
        double startT;
        double stopT;
        StopWatch StopWatchObj=new StopWatch();
        Scanner sc=new Scanner(System.in);
        System.out.println("Start StopWatch press any KEY : ");
        sc.next().charAt(0);
        startT = StopWatchObj.startWatch();

        System.out.println("Stop StopWatch press any KEY: ");
        sc.next().charAt(0);
        stopT = StopWatchObj.endWatch();
        startT = stopT-startT;
        System.out.println("Time Elepsed :"+(startT/1000)+" second");
        sc.close();
    }
}
