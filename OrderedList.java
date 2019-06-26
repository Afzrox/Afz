import java.io.*;
import java.util.Scanner;
import java.util.LinkedList;

class OrderedList{
    public static OrderedList list = new OrderedList(); 
    Node head;

    static class Node{
        int data;
        Node next;
        Node(int n){
            data=n;
            next=null;    
        }
    }

    public static WriteList(){
            
    }
    public static void insert(int data){
        Node newNode=new Node(data);
        newNode.next=null;
        ///if linked list is empty then make new node as head
        if(list.head==null){
            list.head=newNode;  
        }else{
            Node last=list.head;
            while(last.next!=null){
                last=last.next;
            }
            ///Assign new node to last node
            last.next=newNode;
        }
    }

    public static void search(int search){
        Node Search=new Node(search);
        Node curNode=list.head,PrevNode=null;
        if(curNode.data==search){
            list.head=curNode.next;
            return;
        }
        if(curNode.data>search){
            list.head=Search;
            Search.next=curNode;
            return;
        }
        while(curNode.next!=null && curNode.data<=search){
            PrevNode=curNode;
            curNode=curNode.next;
        }
        if(curNode.data==search){
            PrevNode.next=curNode.next;
        }
        if(curNode.data>search){
            PrevNode.next=Search;
            Search.next=curNode;
            return;
        }
        if(curNode.next==null){
            curNode.next=Search;
            return;
        }
        


            // //System.out.println("Not Found in list");
            // Node tempCurNode,tempPrevNode=null;
            // tempCurNode=list.head;
            // if(tempCurNode.data>search){
            //     list.head=Search;
            //     Search.next=tempCurNode;
            //     return;
            // }
            // while(curNode.data<search && curNode.next!=null){
            //     tempPrevNode=tempCurNode;
            //     tempCurNode=tempCurNode.next;
            // }
            // if(tempCurNode.data>search){
            //     tempPrevNode.next=Search;
            //     Search.next=tempCurNode;
            //     System.out.println("Node entered in list");
            //     return;
            // }
            // if(tempCurNode.next==null){
            //     tempCurNode.next=Search;
            //     return;
            // }
        }
    
    public static void printList(){
        ///create node obj to point list i.e:currentNode
        Node currentNode=list.head;
        System.out.println("NumberList :");
        if(currentNode.next==null){
            System.out.println("Empty data");
        }
        while(currentNode.next!=null){
            ///Print data
            System.out.println("Data "+currentNode.data);
            ///Go to next node
            currentNode=currentNode.next;
        }
    }

    public static void main(String[] args) {
        try{
            BufferedReader bufferReaderObj=new BufferedReader(new InputStreamReader(System.in));
            BufferedReader FileReaderObj=new BufferedReader(new FileReader("test_int.txt"));
            Scanner scanner=new Scanner(System.in);
            char a;
            int line;
            while((line=Integer.parseInt(FileReaderObj.readLine())) !=0 ){
                insert(line);
            }
            line=Integer.parseInt(FileReaderObj.readLine());
            insert(line);
            printList();
            do{
            System.out.println("Enter data to search");
            int search=scanner.nextInt();
            search(search);
            printList();
            System.out.println("type (Y/N) to continue");
            a = scanner.next().charAt(0);
            
            }while(a == 'Y');
            bufferReaderObj.close();
            FileReaderObj.close();
            scanner.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}