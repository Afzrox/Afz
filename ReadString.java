import java.io.BufferedReader;
import java.io.StringReader;
import java.io.FileReader;
import java.io.InputStreamReader;
class ReadString{  
    public static void searchString(String Line,String Search){
        boolean found=false;
        String Word[] = Line.split(" ");
        // for(String eachWord : Word){
        //     System.out.println(eachWord);
        // }
        for(int i=0;i<Word.length;i++){
            Word[i]=Word[i].trim();
            if(Search.equals(Word[i])){
                System.out.println("Found At position "+(i+1));
                found=true;
                return;
            }
        }
        if(!found){
            System.out.println("Not Found");
        }
    }
    public static void main(String[] args) {
        try{
            String Line=null;
            BufferedReader FileObj=new BufferedReader(new FileReader("test.txt"));            
            BufferedReader InputObj=new BufferedReader(new InputStreamReader(System.in));            
            System.out.println("Enter Searching String");
            String Search=InputObj.readLine();
            Search=Search.trim();
            Line=FileObj.readLine();
            while(FileObj.readLine()!=null){
                System.out.println(Line);
            }
            searchString(Line,Search);
            FileObj.close();
            InputObj.close();

        }
        catch(Exception e){
            System.out.println(e);
        }
    }   
}