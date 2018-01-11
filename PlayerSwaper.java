public class PlayerSwaper {
	public static void swap() {
		double temp = Blackjack.winCounterOne;
		Blackjack.winCounterOne = Blackjack.winCounterTwo;
		Blackjack.winCounterTwo = temp;
		String str = Blackjack.PlayerOneName;
		Blackjack.PlayerOneName = Blackjack.PlayerTwoName;
		Blackjack.PlayerTwoName = str;
	}
}
