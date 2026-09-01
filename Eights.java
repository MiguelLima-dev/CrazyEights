/**
 * Eights class
 * 
 * @author Miguel Lima
 * @author 30.08.2026
 */

import java.util.Scanner;

public class Eights
{
    private Player one;
    private Player two;
    private Hand drawPile;
    private Hand discardPile;
    private Scanner in;

    public Eights()
    {
        Deck deck = new Deck("Deck");
        deck.shuffle();

        int handSize = 5;
        one = new Player("Allen");
        deck.deal(one.getHand(), handSize);
        
        two = new Player("Chris");
        deck.deal(two.getHand(), handSize);

        discardPile = new Hand("Discards");
        deck.deal(discardPile, 1);

        drawPile = new Hand("Draw pile");
        deck.dealAll(drawPile);

        in = new Scanner(System.in);
    }

    /**
     * Is the game finished
     */
    public boolean isDone()
    {
        return one.getHand().empty() || two.getHand().empty();
    }

    /**
     * When there is no cards left in the draw pile, saves the top card on 
     * the discard pile ant put all the others in the draw pile
     */
    public void reshuffle()
    {
        Card prev = discardPile.popCard();
        discardPile.dealAll(drawPile);
        discardPile.addCard(prev);
        drawPile.shuffle();
    }

    /**
     * Draw a card from the draw pile
     */
    public Card draw()
    {
        if (drawPile.empty())
        {
            reshuffle();
        }
        return drawPile.popCard();
    }

    /**
     * Switch one player to the next
     */
    public Player nextPlayer(Player current)
    {
        if (current == one)
        {
            return two;
        }
        else 
        {
            return one;
        }
    }

    /**
     * Display the state of the match
     */
    public void displayState()
    {
        one.display();
        two.display();
        discardPile.display();
        System.out.println("Draw pile:");
        System.out.println(drawPile.size() + " card");
    }

    /**
     * Takes the next line of input
     */
    public void waitForUser()
    {
        in.nextLine();
    }

    /**
     * Executes a player's turn
     */
    public void takeTurn(Player player)
    {
        Card prev = discardPile.lastCard();
        Card next = player.play(this, prev);
        discardPile.addCard(next);

        System.out.println(player.getName() + " plays " + next);
        System.out.println();
    }

    /**
     * Execute the game
     */
    public void playGame()
    {
        Player player = one;

        // Keep playing until there's a winner
        while (!isDone())
        {
            displayState();
            waitForUser();
            takeTurn(player);
            player = nextPlayer(player);
        }

        // Display the final score
        one.displayScore();
        two.displayScore();
    }
}