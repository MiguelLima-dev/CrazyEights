/**
 * Cards collection class
 * 
 * @author Miguel Lima
 * @version 30.08.2026
 */

import java.util.ArrayList;
import java.util.Random; 

public class CardCollection
{
    private String label;
    private ArrayList<Card> cards;

    /**
     * Constructs a card colletion with a label
     */
    public CardCollection(String label)
    {
        this.label = label;
        cards = new ArrayList<Card>();
    }

    /**
     * Add e new card into cards
     */
    public void addCard(Card card)
    {
        cards.add(card);
    }

    /**
     * Pops a card at the location i and returns it
     */
    public Card popCard(int i)
    {
        return cards.remove(i);
    }

    /**
     * Returns the size of the collection
     */
    public int size()
    {
        return cards.size();
    }

    /**
     * Pops the card on the top of the collection and returns it
     */
    public Card popCard()
    {
        int i = size() - 1;
        return popCard(i);
    }

    /**
     * Returns if the collection is empty
     */
    public boolean empty()
    {
        return size() == 0;
    }

    /**
     * Add n cards from the top of this collection to
     * another collection
     */
    public void deal(CardCollection that, int n)
    {
        for (int i = 0; i < n; i++)
        {
            Card card = popCard();
            that.addCard(card);
        }
    }

    /**
     * Deal all cards
     */
    public void dealAll(CardCollection that)
    {
        int i = size();
        deal(that, i);
    }
    
    /**
     * Returns the label
     */
    public String getLabel()
    {
        return label;
    }

    /**
     * Gets the card in the index i
     */
    public Card getCard(int i)
    {
        return cards.get(i);
    }

    /**
     * Gets the card in the last index
     */
    public Card lastCard()
    {
        int i = size() - 1;
        return cards.get(i);
    }

    /**
     * Swaps two cards in the indexes i and j
     */
    public void swapCards(int i, int j)
    {
        Card aux = cards.get(i);
        cards.set(i, cards.get(j));
        cards.set(j, aux);
    }

    /**
     * Shuffles the cards
     */
    public void shuffle()
    {
        Random random = new Random();
        for (int i = 1; i < size(); i++)
        {
            int j = random.nextInt(i);
            swapCards(i, j);
        }
    }
}