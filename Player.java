/**
 * Player class
 * 
 * @author Miguel Lima
 * @version 30.08.2026
 */

public class Player
{
    private String name;
    private Hand hand;

    public Player(String name)
    {
        this.name = name;
        this.hand = new Hand(name);
    }

    /**
     * Gets the player's name
     */
    public String getName()
    {
        return name;
    }

    /**
     * Gets the player's hand
     */
    public Hand getHand()
    {
        return hand;
    }

    /**
     * Which card will be discarded
     */
    public Card play(Eights eights, Card prev)
    {
        Card card = searchForMatch(prev);
        if (card == null)
        {
            card = drawForMatch(eights, prev);
        }
        return card;
    }

    /**
     * Searches for a card that matches
     */
    public Card searchForMatch(Card prev)
    {
        for (int i = 0; i < hand.size(); i++)
        {
            Card card = hand.getCard(i);
            if (cardMatches(card, prev))
            {
                return hand.popCard(i);
            }
        }
        
        return null;
    }

    /**
     * Draws cards from the pile until finds a card that matches
     */
    public Card drawForMatch(Eights eights, Card prev)
    {
        while (true)
        {
            Card card = eights.draw();
            System.out.println(name + " draws " + card);
            if (cardMatches(card, prev))
            {
                return card;
            }
            hand.addCard(card);
        }
    }

    /**
     * Returns if two cards match (card1 can be played after card2 or not)
     */
    public static boolean cardMatches(Card card1, Card card2)
    {
        if (card1.getSuit() == card2.getSuit())
        {
            return true;
        }
        if (card1.getRank() == card2.getRank())
        {
            return true;
        }
        if (card1.getRank() == 8)
        {
            return true;
        }
        return false;
    }
    
    /**
     * Score of the hand (for the last player with cards)
     * 
     * eights = 20 points
     * 10 or greater = 10 points
     * other = nRank points
     * */
    public int score()
    {
        int sum = 0;
        for (int i = 0; i < hand.size(); i++)
        {
            Card card = hand.getCard(i);
            int rank = card.getRank();
            if (rank == 8)
            {
                sum -= 20;
            }
            else if (rank > 10)
            {
                sum -= 10;
            }
            else
            {
                sum -= rank;
            }
        }
        return sum;
    }

    /**
     * Displays the player's hand
     */
    public void display()
    {
        hand.display();
    }

    /**
     * Displays the player's name and score
     */    
    public void displayScore()
    {
        System.out.println(name + " has " + score() + " points");
    }
}