package org;


import java.util.Arrays;
import java.util.Random;

public class Player {
	public static final int CARDS_IN_HAND=13;
	private String name;
	private int overallPoints;
	private int handPoints;
	private int seed;
	private int next;
	private Card hand[];


	Player(String name,int seed){
		this.name=name;
		this.seed=seed;
		hand=new Card[CARDS_IN_HAND];
		overallPoints = 0;
		handPoints = 0;
		next = 0;
	}
	public void addCard(Card card){
		hand[next] = card;
		next++;
	}

	public int getHandPoints(){
            return handPoints;
	}
	public void addToHandPoints(int points){
            handPoints=points+handPoints;
            overallPoints += points;
        }
	public void resetHandPoints(){
            handPoints=0;
        }
	public int getOverallPoints(){return overallPoints;
        }
	public String getName(){
		return name;
        }
	public String toString(){
            return name+": "+handPoints;
        }
	public void dumpCards(){
		this.next=0;
	}
	public Card getCard(int index){
		return hand[index];
	}
	public boolean hasActiveCardOfSuit(char suit){
		for(int i =0; i<CARDS_IN_HAND;i++){
			if((hand[i].getSuit()==suit)&&(!hand[i].hasBeenPlayed())){
				return true;
			}
		}
		return false;
	}
	public boolean onlyHasHearts(){
		for (int i=0;i<CARDS_IN_HAND;i++){
			if((!hand[i].hasBeenPlayed())&&(!hand[i].isHeart())){
				return false;
			}
		}
		return true;
	}
	public String[] getCardNames(){
		String[] cardNames = new String[CARDS_IN_HAND];
		for(int i=0;i<CARDS_IN_HAND;i++){
			cardNames[i] = hand[i].toString();
		}

		return cardNames;
	}
	/**
	 * This method returns the card that a computer player will use in the
	 * current round which is determined based on the starting card, whether or
	 * not it is the first round of a hand, and if hearts have been started in
	 * the hand.
	 * 
	 * @param startingCard
	 *            The card that started the round
	 * @param isFirstRound
	 *            Whether or not this is the first round of a hand
	 * @param heartsStarted
	 *            Whether or not hearts are in play at this point of the hand
	 * @return The card that will be played
	 */
	public Card getMove(Card startingCard, boolean isFirstRound,
			boolean heartsStarted) {
		// System.out.println("---\n" + startingCard + "\nFR: " + isFirstRound +
		// "\nHS: " + heartsStarted);
		Random rand = null;
		if (seed != -1) {
			rand = new Random(seed);
		} else {
			rand = new Random();
		}
		if (isFirstRound && startingCard == null
				&& hand[0].getSuit() == Card.CLUBS && hand[0].getValue() == 2) {
			// if this is the opening hand and you have the 2 of Clubs, you must
			// play it
			hand[0].setPlayed(true);
			return hand[0];
		} else if (startingCard != null) {
			// we must follow the suit of the initial card, if one was played at
			// this point
			int currentSuit = startingCard.getSuit();
			for (int i = 0; i < CARDS_IN_HAND; i++) {
				if (!hand[i].hasBeenPlayed()
						&& hand[i].getSuit() == currentSuit) {
					hand[i].setPlayed(true);
					return hand[i];
				}
			}
			// if we didn't have any cards in that suit, we will just choose one
			// at random
		}
		// if we have the queen of spades, we want to play it right away.
		if (startingCard != null && !isFirstRound) {
			for (int i = 0; i < CARDS_IN_HAND; i++) {
				if (hand[i].getSuit() == Card.SPADES
					&& hand[i].getValue() == Card.QUEEN_VALUE && !hand[i].hasBeenPlayed()) {
					hand[i].setPlayed(true);
					return hand[i];
				}
			}
			for (int i = CARDS_IN_HAND - 1; i >= 0; i--) {
				if (hand[i].getSuit() == Card.HEARTS
						&& !hand[i].hasBeenPlayed()) {
					hand[i].setPlayed(true);
					return hand[i];
				}
			}
		}
		// just play a random card from the hand
		boolean invalid = true;
		int index = 0;
		while (invalid) {
			index = rand.nextInt(CARDS_IN_HAND);
			invalid = hand[index].hasBeenPlayed();
			if (!invalid) {
				if (isFirstRound
						&& ((hand[index].getSuit() == Card.HEARTS) || (hand[index]
								.getSuit() == Card.SPADES && hand[index]
								.getValue() == Card.QUEEN_VALUE))) {
					invalid = true;
				} else if (!onlyHasHearts()
						&& hand[index].getSuit() == Card.HEARTS
						&& !heartsStarted) {
					invalid = true;
				}
			}
		}

		hand[index].setPlayed(invalid);
		return hand[index];
	}
	/**
	 * This method sorts the player's hand so that it is in the correct order to
	 * start out
	 */
	public void sortHand(){
            Arrays.sort(hand);
	}
        
}
