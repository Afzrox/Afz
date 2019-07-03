public class DeckOfCard {
	public static void main(String[] args) {
		DeckOfCard DeckCard=new  DeckOfCard();
		//HashSet<String> list=newHashSet<String>();
		String[][]  Distribute=new String[4][9];
		for(int i=0;i<4;i++){
			for(int j=0;j<9;j++){
				Distribute[i][j]=DeckCard.getRank()+" "+DeckCard.getSuit();
				System.out.println ("User :"+(i+1)+" Card is :"+Distribute[i][j]+"\t");
			}
			System.out.println();
		}
	}
	String getRank(){
		int RandomRank = (int)((Math.random() * (14 - 1)));
		String RankArray[]={"Ace","2","3","4","5","6","7","8","9","10","Jack","Queen","King"};
		return RankArray[RandomRank];
	}
	String getSuit(){
		String Suit=new String();
		int suit = (int)(Math.random() * 4);
		switch (suit) // Get suit
		{
			case 0: Suit="Clubs";
			break;
			case 1: Suit="Diamonds";
			break;
			case 2: Suit="Hearts";
			break;
			case 3: Suit="Spades"; 
			break;
		}
		return Suit;
	}
}