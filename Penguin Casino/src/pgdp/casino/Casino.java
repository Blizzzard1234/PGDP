package pgdp.casino;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Casino {

	public static void penguBlackJack() {
		int token = 1000;
		System.out.println("Welcome to Pengu-BlackJack!");
		boolean play = true;
		// Here is a card deck for your games :)
		// Remember for testing you can use seeds:
		// CardDeck deck = CardDeck.getDeck(420);
		CardDeck deck = CardDeck.getDeck(); //CHANGE BEFORE HANDING IN!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		while(play){
			if(token<1){
				System.out.println("Sorry, you are broke. Better Luck next time.");
				break;
			}
			System.out.println("(1) Start a game or (2) exit");
			int input = readInt();
			if(input==1){
				int cardnumber = 1;
				int cardsum = 0;
				int bet = -1;
				while(bet <1||bet>token){
				System.out.println("Your current balance: " + token);
				System.out.println("How much do you want to bet?");
				bet = readInt();}
				token -= bet;
				System.out.println("Player cards:");
				//first card
				int card = deck.drawCard();
				System.out.println(cardnumber + " : " + card);
				cardsum += card;
				cardnumber++;
				//sec card
				card = deck.drawCard();
				System.out.println(cardnumber + " : " + card);
				cardsum += card;
				cardnumber++;
				System.out.println("Current standing: " + cardsum);
				//more cards
				boolean continu = true;
				while(continu){
					System.out.println("(1) draw another card or (2) stay");
					input = readInt();
					if(input == 2){
						System.out.println("Dealer cards:");
						int dealercardnumb = 1;
						int dealercardsum = 0;
						while(dealercardsum<21&&dealercardsum<cardsum){
							int dealercard = deck.drawCard();
							System.out.println(dealercardnumb + " : " + dealercard);
							dealercardnumb ++;
							dealercardsum += dealercard;
						}
						System.out.println("Dealer: " + dealercardsum);
						if(dealercardsum>21){
							System.out.println("You won " + bet +" tokens.");
							token += bet*2;
						}else if(dealercardsum<21&&dealercardsum>cardsum){
							System.out.println("Dealer wins. You lost " + bet + " tokens.");
						}else{
							System.err.println("Something went wrong in the dealer playing!!!");
						}
						continu = false;
						break;
					} else if (input == 1) {
						card = deck.drawCard();
						System.out.println(cardnumber + " : " + card);
						cardsum += card;
						cardnumber++;
						System.out.println("Current standing: " + cardsum);
						//test if game over
						if(cardsum==21){
							System.out.println("Blackjack! You won "+ (bet*2) + " tokens.");
							token += (bet*3);
							continu = false;
							break;
						}else if(cardsum>21){
							System.out.println("You lost "+ bet +" tokens.");
							continu = false;
							break;
						}
					}else{
						System.out.println("What?!");
					}
				}
			}else if(input == 2){
				break;
			}else{
				System.out.println("What?!");

			}
		}

		System.out.println("Your final balance: " + token);
		if(token>1000){
			System.out.println("Wohooo! Ez profit! :D");
		}else{
			System.out.println("That's very very sad :(");
		}
		System.out.println("Thank you for playing. See you next time.");
	}


	public static String readString() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			return br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static int readInt() {
		while (true) {
			String input = readString();
			try {
				return Integer.parseInt(input);
			} catch (Exception e) {
				System.out.println("This was not a valid number, please try again.");
			}
		}
	}

	public static void main(String[] args) {
		penguBlackJack();
	}

}
