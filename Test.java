/**
 * Class test for the game
 *
 * @author Miguel Lima
 * @version 01.09.2026
 */

public class Test
{
    public static void main(String[] args)
    {
        Eights game = new Eights();
        game.playGame();
        
        /** 
        Deck deck = new Deck("Deck");
        deck.shuffle();

        Hand hand = new Hand("Hand");
        deck.deal(hand, 5);
        hand.display();

        Hand drawPile = new Hand("Draw Pile");
        deck.dealAll(drawPile);
        System.out.printf("Draw pile has %d cards.\n", drawPile.size());
        */
    }
}