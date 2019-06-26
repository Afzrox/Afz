import java.util.LinkedList;
import java.util.Scanner;
import java.io.InputStreamReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;

public class UnOrderedList{
    public static UnOrderedList Ulist = new UnOrderedList();
    Node head;
    static class Node{
        String data;
        Node next;
        Node(String d){
            data=d;
            next=null;
        }
    }
    
    public static void search(String searchElement){
        Node newNode=new Node(searchElement.trim());
        Node currentNode=Ulist.head,prevNode=null;
        newNode.next=null;
        if(Ulist.head==null){
            Ulist.head=newNode;
            System.out.println("data added to empty list");
            return;
        }
        if(currentNode.data.equals(searchElement)){
            Ulist.head=currentNode.next;
            System.out.println("Found At top and Deleted");
            return;
        }
        while((currentNode.next!=null) && (currentNode.data!=searchElement)){
            prevNode=currentNode;
            currentNode=currentNode.next;
        }
        if(currentNode.next!=null){        
            prevNode.next=currentNode.next;
            System.out.println("Found At mid and Deleted");
            return;
        }
        if((currentNode.next==null) && searchElement.equals(currentNode.data)){        
            prevNode.next=currentNode.next;
            System.out.println("Found At last and Deleted");
            return;
        }
        if((currentNode.next==null) && (currentNode.data != searchElement)){
            currentNode.next=newNode;
            System.out.println("Not Found and added");
            return;
        }
    }

    public static void printUlist(){
        Node curNode =Ulist.head;
        if(curNode.next==null){
            System.out.println("Data is empty");
        }
        while(curNode.next!=null){
            System.out.println("Data is "+curNode.data);
            curNode=curNode.next;
        }
        System.out.println("Data is "+curNode.data);
    }
    
    public static void main(String[] args) throws Exception {

        try{
        
            BufferedReader FileObj=new BufferedReader(new FileReader("test.txt"));            
            BufferedReader InputObj=new BufferedReader(new InputStreamReader(System.in));                
            Scanner scan=new Scanner(System.in);
            int Line=0;
            char choice;
            String Searchelement;
            String[] word=new String[5];
            while((word[Line]=FileObj.readLine())!=null){
                word[Line]=word[Line].trim();
                search(word[Line]);
                Line++;
            }
            do{
            System.out.println("Enter Searching String");
            Searchelement=InputObj.readLine();
            Searchelement=Searchelement.trim();
            search(Searchelement);
            printUlist();
            System.out.println("Enter Y for continue :");
            choice=scan.next().charAt(0);
            }while(choice=='Y');
            FileObj.close();
            scan.close();
            InputObj.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}