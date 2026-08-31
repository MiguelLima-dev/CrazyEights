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
}