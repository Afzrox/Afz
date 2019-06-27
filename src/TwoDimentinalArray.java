///Pending


import java.io.PrintWriter;
import java.util.Scanner;
@SuppressWarnings("unused")
public class TwoDimentinalArray
{
	public static <T> void  printArray(T[][] Array,int row,int cols){
		 
		PrintWriter outPut=new PrintWriter(System.out);
		//OutputStreamWriter OSWriter=new OutputStreamWriter(new PrintWriter(System.out));
		System.out.println("The Arr Elements Are: ");
		for(int i=0;i<row;i++){
			for(int j=0;j<cols;j++) {
				outPut.print(Array[i][j]);
			}
			System.out.println();
		}
		System.out.println(">>>>>>>>>>>>>>>>>>");
	}
	public static void main(String[] args)
	{
		int row,cols;
		Scanner scan=new Scanner(System.in);
		PrintWriter writeOutPut=new PrintWriter(System.out);
		System.out.println("Enter Row: ");
		row=scan.nextInt();		
		System.out.println("Enter Cols: ");
		cols = scan.nextInt();
		Object[][] Array=new Object[row][cols];
		System.out.println("Enter Elements into Array: ");
		int i,j;
		for(i=0;i<row;i++)
		{
			for(j=0;j<cols;j++)
			{
				Array[i][j]=scan.next(); 
			}
		}
		printArray(Array,row,cols);
		scan.close();
		writeOutPut.close();
	}
}
