package org;

import java.util.Random;

public class Deck{
    public static final int CARDS_IN_DECK =52;
	public static final int SHUFFLE_SWAPS=500;
	private Card card[];
    private int position;
    private int seed;

	Deck(int seed){
        this.seed = seed;
        this.position = 0;
        card = new Card[CARDS_IN_DECK];
        int count =0;
        for(int i=0;i<4;i++){
            for(int j = Card.LOWEST_VALUE;j<=Card.HIGHEST_VALUE;j++){
                switch (i){
                    case 0:
                        Card newCarCLUBS = new Card(j,Card.CLUBS);
                        card[count] = newCarCLUBS;
                        break;
                    case 1:
                        Card newCarHEARTS = new Card(j,Card.HEARTS);
                        card[count] = newCarHEARTS;
                        break;
                    case 2:
                        Card newCarSPADES = new Card(j,Card.SPADES);
                        card[count] = newCarSPADES;
                        break;
                    case 3:
                        Card newCarDIAMONDS = new Card(j,Card.DIAMONDS);
                        card[count] = newCarDIAMONDS;
                        break;
                }
                count ++;
            }
        }
    }
	public void shuffle(){
	    Random r;
	    if(seed >0){
	        r = new Random(seed);
        }else {
	        r = new Random();
        }

        for(int i =0; i< card.length;i++){
	        card[i].setPlayed(false);
        }

        for(int i=0;i<SHUFFLE_SWAPS;i++){
            Card temp;
            int index1 = r.nextInt(CARDS_IN_DECK);
            int index2 = r.nextInt(CARDS_IN_DECK);
            temp = card[index1];
            card[index1] = card[index2];
            card[index2] = temp;
        }
        this.position = 0;
    }
    public Card nextCard(){
	    if(position>=CARDS_IN_DECK){
	        position=0;
        }
	    Card nextCard = card[position];
	    position++;
	    return nextCard;
    }
    public String toString(){
        String deck="";
        for(int i=0;i<CARDS_IN_DECK;i++){
            deck += card[i].toString()+"\n";
        }
        return deck;
    }
}
