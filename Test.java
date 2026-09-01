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
        if (args.length == 2)
        {
            Eights game = new Eights(args[0], args[1]);
            game.playGame();
        }
        else
        {
            System.out.println("Use: java Test \"p1Name\" \"p2Name\"");
        }
    }
}