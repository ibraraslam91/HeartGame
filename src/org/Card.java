package org;

public class Card implements Comparable {
        public static final char CLUBS='c';
        public static final char DIAMONDS='d';
        public static final char SPADES='s';
        public static final char HEARTS='h';
        public static final int LOWEST_VALUE=2;
        public static final int HIGHEST_VALUE=14;
        public static final int QUEEN_VALUE=12;
        private int value;
        private char suit;
        private boolean played;

        public Card(int value,char suit){
            if(value>=LOWEST_VALUE && value<=HIGHEST_VALUE){
                this.value=value;
            }
            else{
                throw new IllegalArgumentException("Please enter the an integer for value");
            }
            if(suit==CLUBS||suit==DIAMONDS||suit==SPADES||suit==HEARTS){
                this.suit=suit;
            }
            else{
                throw new IllegalArgumentException("The value should be c,s,h,d");
            }
            this.played = false;
        }
        public boolean hasBeenPlayed(){
                return played;
        }
        public void setPlayed(boolean played){
        this.played=played;
        }
        public char getSuit(){
            return suit;
        }
        public int getValue(){
            return value;
        }
        public boolean isHeart(){
            if(this.suit == HEARTS){
                return true;
            }else {
                return false;
            }
        }
        public boolean isQueenOfSpades(){
            if((this.suit==SPADES)&&(this.value==QUEEN_VALUE)){
                return true;
            }else {
                return false;
            }
        }
        public boolean isHigherThan(Card other){
            if((this.suit == other.suit)&&(this.value>other.value)){
                return  true;
            }else {
                return false;
            }
        }

    public String toString(){
         return ""+suit+value;
    }

    public int compareTo(Object o) {
        if(o instanceof Card) {
            Card other = (Card)o;

            if (getSuit() == other.getSuit()) {
                if (getValue() < other.getValue()) {
                    return -1;
                } else {
                    return 1;
                }
            } else {
                switch(getSuit()) {
                    case HEARTS:
                        return 1;
                    case SPADES:
                        if (other.getSuit() == HEARTS) {
                            return -1;
                        } else {
                            return 1;
                        }
                    case DIAMONDS:
                        if (other.getSuit() == HEARTS || other.getSuit() == SPADES) {
                            return -1;
                        } else {
                            return 1;
                        }
                    case CLUBS:
                        return -1;
                }
            }
        }
        return 1;
    }
}