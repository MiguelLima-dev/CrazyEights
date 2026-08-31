/**
 * Deck of cards class
 * 
 * @author Miguel Lima
 * @author 30.08.2026
 */

public class Deck extends CardCollection
{
    public Deck(String label)
    {
        super(label); // Executes the superclass constructor

        for (int suit = 0; suit <= 3; suit++)
        {
            for (int rank = 1; rank <= 13; rank++)
            {
                addCard(new Card(rank, suit));
            }
        }
    }
}