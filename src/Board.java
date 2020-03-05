import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Board
{
    ArrayList<ArrayList<Tile>> board;
    //private ArrayList<Tile>[][] board;
    private int aantal;
    private int x;
    private int y;

    public Board(int x, int y, int mines) {
        board = new ArrayList<ArrayList<Tile>>();
        //board = new ArrayList[x][y];
        aantal = mines;
        this.x = x;
        this.y = y;
    }
    public void initialiseBoard()
    {
        for( int i = 0 ; i<x ; i++)
        {
            board.add(new ArrayList<Tile>());
            for( int j = 0 ; j<y ; j++)
            {
                board.get(i).add(new Tile(0));
            }
        }

        Random rand = new Random();
        for (int i = 0; i < aantal; i++)
        {
            while(true) {
                int randomX = rand.nextInt(x);
                int randomY = rand.nextInt(y);
                if (board.get(randomX).get(randomY).getValue() == 0){
                    board.get(randomX).get(randomY).setValue(-1);
                    addNumbers(randomX,randomY);
                    break;
                }
            }
        }

    }

    public void addNumbers(int bomX, int bomY){
        for (int i = -1; i < 2; i++){
            for (int j = -1; j < 2; j++){
                if (bomX + i >= 0 && bomX + i < x && bomY + j >= 0 && bomY + j < y){
                    board.get(bomX + i).get(bomY + j).valuePlusOne();
                }
            }
        }
        board.get(bomX).get(bomY).setValue(-1);
    }

    public void printBoard(){
        for( int i = 0 ; i<x ; i++) {
            String printValue = "";
            for (int j = 0; j < y; j++) {
                if (board.get(i).get(j).getValue() == -1) {
                    printValue += board.get(i).get(j).getValue() + " ";
                } else {
                    printValue += board.get(i).get(j).getValue() + "  ";
                }
            }
            System.out.println((printValue));
        }
    }
}
