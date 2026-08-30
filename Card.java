/**
 * Card class for a standart 52 cards
 * 
 * @author Miguel Lima
 * @version 29.08.2006
 */
public class Card
{
    private int rank;
    private int suit;

    // Constants for the ranks and suits of a card
    public static final String[] RANKS = {
       null, "Ace", "2", "3", "4", "5", "6", "7", 
       "8","9", "10", "Jack", "Queen", "King"};
    
    // Constants for the ranks and suits of a card
    public static final String[] SUITS = {
        "Clubs", "Diamonds", "Hearts", "Spades"};

    public Card(int rank, int suit)
    {
        this.rank = rank;
        this.suit = suit;
    }

    /**
     * Return the rank of the card
     */
    public int getRank()
    {
        return this.rank;
    }

    /**
     * Return the suit of the card
     */
    public int getSuit()
    {
        return this.suit;
    }
    /**
     * Converts the atributtes of an object
     * into a string with inteligible info
     */
    public String toString()
    {
        return RANKS[this.rank] + " of " + SUITS[this.suit];
    }

    /**
     * Compares two cards and returns true if they are equal
     */
    public boolean equals(Card other)
    {
        return this.rank == other.rank && this.suit == other.suit;
    }

    public int compareTo(Card other)
    {  
        if (this.suit < other.suit) return -1;
        if (this.suit > other.suit) return 1;
        if (this.rank < other.rank) return -1;
        if (this.rank > other.rank) return 1;
        
        return 0;
    }
}