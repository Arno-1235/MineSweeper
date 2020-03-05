import java.util.ArrayList;
import java.util.List;


public class Board
{
    private ArrayList<Tile>[][] board;
    private int aantal;
    private int x;
    private int y;

    public Board(int x, int y, int mines) {
        board = new ArrayList[x][y];
        aantal = mines;
        this.x = x;
        this.y = y;
    }
    public void initialiseBoard()
    {
        for( int i = 0 ; i<x ; i++)
        {
            for( int j = 0 ; j<y ; j++)
            {
                board[i][j].add(new Tile(3));
            }
        }
    }
}
