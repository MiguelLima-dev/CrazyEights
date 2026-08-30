/**
 * Deck class for a standart 52 cards
 * 
 * @author Miguel Lima
 * @version 30.08.2026
 */
public class Deck
{
    private Card[] cards;

    public Deck(int n)
    {
        this.cards = new Card[n];
    }
    public Deck()
    {
        this.cards = new Card[52];

        int index = 0;
        for (int suit = 0; suit < 4; suit++)
        {
            for (int rank = 1; rank <= 13; rank++)
            {
                cards[index] = new Card(rank, suit);
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

    public Deck subdeck(int low, int high)
    {
        Deck sub = new Deck(high - low + 1);
        for (int i = 0; i < sub.cards.length; i++)
        {
            sub.cards[i] = this.cards[low + i];
        }
        return sub;
    }

    public static Deck merge(Deck d1, Deck d2)
    {
        Deck result = new Deck(d1.cards.length + d2.cards.length);

        int i = 0; // pointer into d1.cards
        int j = 0; // pointer into d2 cards
        int k = 0; // pointer into result.cards

        while (i < d1.cards.length && j < d2.cards.length)
        {
            if (d1.cards[i].compareTo(d2.cards[j]) <= 0)
            {
                result.cards[k] = d1.cards[i];
                i++;
            }
            else
            {
                result.cards[k] =  d2.cards[j];
                j++;
            }
            k++;
        }

        // Insert the remaining cards of d1
        while (i < d1.cards.length)
        {
            result.cards[k] = d1.cards[i];
            i++;
            k++;
        }

        // Insert the remaining cards of d2
        while (j < d2.cards.length)
        {
            result.cards[k] = d2.cards[j];
            j++;
            k++;
        }

        return result;
    }

    public void mergeSort()
    {
        if (cards.length <= 1)
        {
            return;
        }

        int mid = cards.length / 2;

        Deck left = subdeck(0, mid - 1);
        Deck right = subdeck(mid, cards.length - 1);

        left.mergeSort();
        right.mergeSort();

        Deck merged = merge(left, right);

        for (int i = 0; i < cards.length; i++)
        {
            this.cards[i] = merged.cards[i];
        }
    }
}