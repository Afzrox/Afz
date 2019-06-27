import java.util.Random;

import java.util.Scanner;
///hello
class TicToc{
	///	static dynamic ARRAY win so it can be change by check_methode and check by main method
	///	initialize variable for  horizontal count of x : horizontalCountOfX
	/// initialize variable for  vertical count of x : verticalCountOfX
	/// initiilize char ARRAY of Value so it can take 'X' OR 'O'
	/// object of random function used for getting random location by positioByComputer
	static int[] Win={0,0};
	static int CountOfX=0;
	static int countPosition=0;
	static boolean flagX=true;
	static boolean flagO=true;
		
	//static int verticalCountOfX=0;
	static char[][] Value = new char[][]{ {'1','2','3'}, {'4','5','6'}, {'7','8','9'}};
	static Random random = new Random();
	static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		try{
			///display the blank TictocBoard for user interaction
			///with positions in board
			display();
			do{
				user();
				///	if we filled upto 4 value then 
				///	call check for win or loss
				if(countPosition>3){
					checkWin();
				}
				display();
				if(Win[0]!=1 || countPosition<8 ){
					Computer();	
				}
				display();
			///	iterate while loop until position filled upto 8th location
			///	in TicTocBoard or anyone win's
			}while ( ((Win[0] !=1) && (Win[1] !=1))  && countPosition<9);
			///	check if win is true or false
			if(Win[0] != 1 && Win[1] != 1 ){
				System.out.println("Match Draw");
			}
			/// close the scanner object for resource management
			scanner.close();
		}
		catch(Exception e){
			System.out.println("Error Occured");
		}
}
	///Display method for display the TicTocToe matrix 
	///initally the matrix have filled with positions i.e:1 2 3... 
	///as it get position it will replace by respective character 
	static void display(){
		int i,j;
		System.out.println("");
		for(i=0;i<3;i++){
			for(j=0;j<=2;j++){
				System.out.print(" | "+Value[i][j]);
			}
			System.out.print(" |");
			System.out.println("");
		}
		System.out.println("");
	}
		
	// getting position from user 
	//and calling positionByUser method to add value in TicTocToe matrix 
	static void user(){
		char ch = 'X';
		int positionByUser;
		positionByUser = scanner.nextInt();
		addTicToc(positionByUser,ch);

	}
	
	static void Computer(){
		int positionByComputer;
		char ch='O';
		positionByComputer = random.nextInt(8);
		positionByComputer +=1;
		addTicToc(positionByComputer,ch);  
	}

	static	void addTicToc(int positionByComputer,char ch){
		switch(positionByComputer){
			case 1:
			checkAndReplaceTicToc(0,0,ch);
				break;
				
			case 2:
			checkAndReplaceTicToc(0,1,ch);
				break;
			
			case 3:
			checkAndReplaceTicToc(0,2,ch);
				break;
			case 4:
			checkAndReplaceTicToc(1,0,ch);
				break;
			case 5:
			checkAndReplaceTicToc(1,1,ch);
				break;
			case 6:
			checkAndReplaceTicToc(1,2,ch);
				break;
			case 7:
			checkAndReplaceTicToc(2,0,ch);
				break;
			case 8:
			checkAndReplaceTicToc(2,1,ch);
				break;
			case 9:
			checkAndReplaceTicToc(2,2,ch);
				break;
			default:
				if(ch =='O'){
				Computer();
				}
				else{
					user();
				}
			break;
		}
	}
	
	/// this method is for checking wether the position is already
	/// filled or empty
	static void checkAndReplaceTicToc(int row,int column,char ch){
		if(Value[row][column] == 'O' || Value[row][column] == 'X'){
			if(ch =='O'){
				Computer();
			}else{
				user();
			}
		}
		else{
			Value[row][column] = ch;
			countPosition++;
		}
	}

	///it will check for win or loss
	public static void checkWin(){
		int checkRow=0;
		for(checkRow=0;checkRow<3;checkRow++){
			checkHorizontal(checkRow);
			checkVertical(checkRow);
			checkLeftToRightDigonal();
			checkRightToLeftDigonal();
		}
		if( Win[0] == 1 ){
			System.out.println("User Win's");
			return;
		}
		if( Win[1] == 1 ){
			System.out.println("Computer Win's");
			return;
		}
	}

	static void checkHorizontal(int eachRow){ 
		int i 	=	eachRow;	
		int j	=	0;
		for(j=0;j<3;j++){							
			flagX = flagX && (Value[i][j]=='X');
			flagO = flagO && (Value[i][j]=='O');
		}
		if(flagX){
			System.out.println("At row :"+(i+1));
			Win[0]=1;
			return;
		}
		flagX=true;
		if(flagO){
			Win[1]=1;
			return;
		}
		flagO=true;
	}

	static void checkVertical(int eachColumn){			
		int i = 0;
		int j = eachColumn;
		for(i=0;i<3;i++){
			flagX = (flagX && (Value[i][j]=='X'));
			flagO = (flagO && (Value[i][j]=='O'));
		}
		if(flagX){
			System.out.println("At column :"+(j+1));
			Win[0]=1;
			return;
		}
		flagX=true;
		if(flagO){
			Win[1]=1;
			return;
		}
	 	flagO=true;
	}

	static void checkRightToLeftDigonal(){			
		int i=0;
		for(i=0;i<3;i++){
				flagX = flagX && (Value[i][i]=='X');
				flagO = flagO && (Value[i][i]=='O');
		}
		if(flagX){
			System.out.println("At left top right bottom ");
			Win[0]=1;
			return;
		}
		flagX=true;
		if(flagO){
			Win[1]=1;
			return;
		}
		flagO=true;
	}

	static void checkLeftToRightDigonal(){		
		int i,j=0;
		for(i=2;i>=0;i--){
			flagX = flagX && (Value[i][j] == 'X' );
			flagO = flagO && (Value[i][j] == 'O' );
			j++;
		}		
		if(flagX){
			System.out.println("At right top left bottom ");
			Win[0]=1;
			return;
		}
		flagX=true;
		if(flagO){
			Win[1]=1;
			return;
		}
		flagO=true;
	}
}