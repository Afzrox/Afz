import java.util.Scanner;
import java.util.HashSet;
public class StringPermutation{
    static int countOfString=1;
    static int length;
    static HashSet<String> distincString = new HashSet<String>(); 
    
    
    public static void main(String arg[]){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter String");
        String newString=scanner.nextLine();
        length=newString.length();
        System.out.println("length of string is : "+length);
        StringPermutation stringPermutationObject = new StringPermutation();
        stringPermutationObject.permutation(newString,0,length-1);
        System.out.println("total permutation is: "+(countOfString-1));
        System.out.println("total distinc permutation is: "+distincString.size()); 
        System.out.println(distincString);
        scanner.close();
    }
    public void permutation(String getString,int start,int end){
        if(start == end){
            System.out.println(getString+" "+countOfString);
            distincString.add(getString);
            countOfString++;
        }
        else{
            for(int loop=start;loop<=end;loop++){
                getString=swap(getString,start,loop);
                permutation(getString,start+1,end); 
                getString=swap(getString,start,loop);
            }
        }
    }
    /// swap method to swap the char of string for each call of method 
    public String swap(String getString,int start,int end){
        char temp;
        char[] stringArray = getString.toCharArray();
        temp= stringArray[start];
        stringArray[start]=stringArray[end];
        stringArray[end]=temp;
        return String.valueOf(stringArray);
    }
}