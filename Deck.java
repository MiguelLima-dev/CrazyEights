/**
 * Deck class for a standart 52 cards
 * 
 * @author Miguel Lima
 * @version 30.08.2026
 */
public class Deck
{
    private Card[] cards;

    public Deck()
    {
        this.cards = New Card[52];

        int index = 0;
        for (int suit = 0; suit < 4; suit++)
        {
            for (int rank = 1; rank <= 13; rank++)
            {
                cards[index] = New Card(rank, suit);
                index++;
            }
        }
    }

    /**
     * Prints each card of the deck.
     */
    public void printDeck()
    {
        for (int i = 0; i < cards.length; i++) 
        {
            System.out.println(cards[i]);
        }
    }

    /**
     * Searchs for a target sequentially
     */
    public int search(Card target)
    {
        for (int i = 0; i < cards.length; i++)
        {
            if (cards[i].equals(target))
            {
                return i;
            }
        }

        return -1;
    }

    /**
     * Searches for a target through binary search
     */
    public int binarySearch(Card target)
    {
        int low = 0;
        int high = cards.length - 1;
        while (low <= high)
        {
            int mid = (low + high) / 2;
            int comp = cards[mid].compareTo(target);

            if (comp == 0) return mid;
            else if (comp < 0) low = mid + 1;
            else high = mid - 1;
        }

        return -1;
    }

    /**
     * Partition used int Quick Sort algorithm
     */
    private int partition(int low, int high)
    {
        int i = low + 1;
        int j = high;
        Card pivot = cards[low];

        while (i <= j)
        {
            if (pivot.compareTo(cards[i]) > 0) i++;
            else if (pivot.compareTo(cards[j]) < 0) j--;
            else 
            {
                Card aux = cards[j];
                cards[j] = cards[i];
                cards[i] = aux;
                i++;
                j--;
            }
        }
        cards[low] = cards[j];
        cards[j] = pivot;

        return j;
    }

    /**
     * Sort using the Quick Sort algorithm
     */
    public void quickSort(int low, int high)
    {
        if (low < high)
        {
            int pivotPosition = partition(low, high);
            quickSort(low, pivotPosition - 1);
            quickSort(pivotPosition + 1, high);
        }
    }
}