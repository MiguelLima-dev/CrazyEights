/**
 * Card Hand class
 * 
 * @author Miguel Lima
 * @version 30.08.2026
 */

public class Hand extends CardCollection
{
    public Hand(String label)
    {
        super(label);
    }

    /**
     * Prints the card in hand
     */
    public void display()
    {
        System.out.println(getLabel() + ": ");
        for (int i = 0; i < size(); i++)
        {
            System.out.println(getCard(i));
        }
        System.out.println();
    }

}