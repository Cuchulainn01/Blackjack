import java.util.*;
public class Blackjack {
	static double winCounterOne = 0.0;
	static double winCounterTwo = 0.0;
	static String PlayerOneName = "";
	static String PlayerTwoName = "";
	public static void main(String args[]) {
		System.out.println("Welcome to Blackjack!");
		Scanner scanny = new Scanner(System.in);
		boolean done = false;
		System.out.print("Please enter the name of player 1: ");
		PlayerOneName += scanny.next();
		System.out.print("Please enter the name of player 2: ");
		PlayerTwoName += scanny.next();
	
		round();
		while (done == false) {
			System.out.print("Play again (y/n)? ");
			if (scanny.next().equals("y")) {
				PlayerSwaper.swap();
				round();
			}
			else {
				done = true;

			}
		}
	}     
	public static void round() {
		System.out.println("==============");
		Scanner scanny = new Scanner(System.in);
		Deck.newGame();
		Dealer.getCard(1);//player 1 picks 2 cards
		Dealer.getCard(1);
		Dealer.getCard(2);//player 2 picks 2 cards
		Dealer.getCard(2);
		System.out.println(PlayerOneName + " shows: " + Hand.getHandOneArray().get(0));
		System.out.println(PlayerTwoName + " shows: " + Hand.getHandTwoArray().get(0));
		System.out.print("\n");
		System.out.println(PlayerOneName + ", it is your turn.");
		
	
		String HitOrStand;
		boolean done = false;
		while (done == false) { 
			System.out.println(PlayerOneName + ", you have " + Hand.getHandOneArray()+ " (" + Hand.sum(1) + ")"); // tells the person they have and the some of the values
			System.out.println("Do you want to [h]it or [s]tand?");
			HitOrStand = scanny.next();
			if (HitOrStand.equals("h")) {
				Dealer.getCard(1);// pick another card
				System.out.println("You drew " + Hand.getHandOneArray().get(Hand.getHandOneArray().size() -1)); // returns the most recent card drawn and returns it
				if(Hand.sum(1) > 21) {
					System.out.print("Bust! \n" );
					done = true;
					// 
				}
			}
			else {
				done = true;
			}
		}
		System.out.println("==============");
		System.out.println(PlayerOneName + " shows: " + Hand.getHandOneArray().get(0));
		System.out.println(PlayerTwoName + " shows: " + Hand.getHandTwoArray().get(0));
		System.out.println("\n" + PlayerTwoName + ", it is your turn.");
		


		done = false;
		while (done == false) {
			System.out.println(PlayerTwoName + ", you have " + Hand.getHandTwoArray()+ " (" + Hand.sum(2) + ")" ); //they can simply do that by just printing out the arrayList 
			System.out.println("Do you want to [h]it or [s]tand?");
			HitOrStand = scanny.next();
			if (HitOrStand.equals("h")) {
				Dealer.getCard(2);
				System.out.println("You drew " + Hand.getHandTwoArray().get(Hand.getHandTwoArray().size() -1)); // returns the most recent card drawn and returns it
				if(Hand.sum(2) > 21) {
					System.out.println("Bust!");
					done = true;
				}
			}
			else {
				done = true;
			}
		}

		if(Hand.sum(1) > 21) {
			if(Hand.sum(2) >21) {
				System.out.println("No one wins.\n");
			}
			else {
				System.out.println(PlayerTwoName + " wins!\n");
				winCounterTwo++;
			}
		}
		else {
			if(Hand.sum(2) > 21) {
				System.out.println(PlayerOneName + " wins!\n");
				winCounterOne++;

			}
			else {
				if ((Hand.sum(1) > Hand.sum(2)) ) {
					System.out.println(PlayerOneName + " wins!\n");
					winCounterOne++;
				}
				if ((Hand.sum(1) < Hand.sum(2)) ) {
					System.out.println(PlayerTwoName + " wins!\n");
					winCounterTwo++;
				}
				if ((Hand.sum(1) == Hand.sum(2)) ) {
					System.out.println("The game was a tie.");
					winCounterOne += .5;
					winCounterTwo += .5;
				}
			}
		}
		stats();
	}
	public static void stats() {
		System.out.println(PlayerOneName + " has " + winCounterOne + " wins.");
		System.out.println(PlayerTwoName + " has " + winCounterTwo + " wins.");
	}
}