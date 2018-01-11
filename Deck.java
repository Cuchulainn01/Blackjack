import java.util.*;
public class Deck {
	static // shuffle
	// store the data
	ArrayList<String> deck = new ArrayList<String>();
	static int length = 52;
	public static void newGame() { //new game 

		String[]  faces = {"Ace", "Jack", "Queen", "King", "2", "3", "4", "5", "6", "7", "8", "9", "10" };
		// Clears the deck for new game
		deck.clear();
		Hand.getHandOneArray().clear();
		Hand.getHandTwoArray().clear();
		for(int i = 0; i < faces.length; i++) {
			deck.add("" + faces[i] + " of Spades");
			deck.add("" + faces[i] + " of Clubs");        
			deck.add("" + faces[i] + " of Hearts");
			deck.add("" + faces[i] + " of Diamonds");        
		}
	}
}