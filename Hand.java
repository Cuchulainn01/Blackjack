import java.util.*;
public class Hand {
	private int player1Sum;
	private int player2Sum;
	private static ArrayList<String> handOneArray = new ArrayList<String>();
	private static ArrayList<String> handTwoArray =new ArrayList<String>();  

	public static void storeCardsPlayer1(String str) {
		getHandOneArray().add(str);
	}
	public static void storeCardsPlayer2(String str) {
		handTwoArray.add(str);
	}
	public static int faceToRank(String str) {

		str = str.substring(0,str.indexOf(" "));
		int val;

		try {
			val = Integer.parseInt(str);
		}

		catch(NumberFormatException e){
			if(str.equals("Ace")){
				val = 1;
			}
			else{
				val = 10;
			}
		}

		return val;
	}
	public static int sum(int playerNum) { // gets the sum of the array

		if(playerNum == 1) {
			return addingTheValuesUp(getHandOneArray());
		}
		else {
			return addingTheValuesUp(getHandTwoArray());
		}

	}
	public static int addingTheValuesUp(ArrayList<String> arr) {
		int sum = 0;
		for(int i = 0; i < arr.size(); i++) {
			sum += faceToRank(arr.get(i));
		}
		return sum;
	}
	//----------------------------
	public static ArrayList<String> getHandOneArray() {
		return handOneArray;
	}
	public static void setHandOneArray(ArrayList<String> handOneArray) {
		Hand.handOneArray = handOneArray;
	}
	//----------------------------
	public static ArrayList<String> getHandTwoArray() {
		return handTwoArray;
	}
	public static void setHandTwoArray(ArrayList<String> handTwoArray) {
		Hand.handTwoArray = handTwoArray;
	}
}