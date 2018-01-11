import java.util.*;

public class Dealer {
	public static String getCard(int playerNum) { 
		int cardIndexValue = (int)(Math.random() *  Deck.deck.size());
		// get rid of it from the storage so we don't accidentally use it again
		String val = Deck.deck.get(cardIndexValue);
		if(playerNum == 1) {
			Hand.storeCardsPlayer1(val);
		}
		else {
			Hand.storeCardsPlayer2(val);
		}
		Deck.deck.remove(cardIndexValue); // removes so cant be picked again


		return val;
	}
}