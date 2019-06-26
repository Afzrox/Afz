import MyPackage.Util;
class CallUtilityWithTimeElepsed{
    static long startT;
    static long stopT;
    static double seconds;
    public static void startTime(){
        startT=System.currentTimeMillis();
        startT=startT-startT;
    }
    public static void stopTime(){
        stopT=System.currentTimeMillis();
        seconds=(double)(stopT-startT)/1000.0;
    }
    public static void main(String[] args) {
    int[] Array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};        
    String string="ABCDEFGHIJ";
    
    startTime();
    Util.insertionSort(string);
    stopTime();
    System.out.println("Elepsed Time for insertion sort string is: "+seconds);
    
    startTime();
    Array= Util.insertionSort(Array);
    stopTime();
    System.out.println("Elepsed Time for insertion sort integer is: "+seconds);
    startTime();
    Util.bubbleSort(string);
    stopTime();
    System.out.println("Elepsed Time for bubble sort string is: "+seconds);
    
    startTime();
    Util.bubbleSort(Array);
    stopTime();
    System.out.println("Elepsed Time for bubble sort integer is: "+seconds);
    
    startTime();
    Util.binarySearch(Array, 0, Array.length-1, 8);
    stopTime();
    System.out.println("Elepsed Time for binarySearch integer is: "+seconds);
    
    startTime();
    Util.binarySearch(string, 0, string.length()-1, 'I');
    stopTime();
    System.out.println("Elepsed Time for binarySearch string is: "+seconds);
    }
}