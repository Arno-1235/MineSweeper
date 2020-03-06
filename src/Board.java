import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Board
{
    ArrayList<ArrayList<Tile>> board;
    private int aantal;
    private int x;
    private int y;

    public Board(int x, int y, int mines) {
        board = new ArrayList<ArrayList<Tile>>();
        aantal = mines;
        this.x = x;
        this.y = y;
    }
    public void initialiseBoard(int A , int B)
    {
        for( int i = 0 ; i < y ; i++)
        {
            board.add(new ArrayList<Tile>());
            for( int j = 0 ; j < x; j++)
            {
                board.get(i).add(new Tile(0));
            }
        }

        ArrayList<Integer> coo = new ArrayList<>();
        for (int i = 0 ; i < x*y ; i++)
        {
            coo.add(i);
        }
        coo.remove(x*B+A);
        Random rand = new Random();
        for (int i = 0; i < aantal; i++)
        {
                int random = rand.nextInt(coo.size());
                int randomX = random%x;
                int randomY = random/x;


                board.get(randomY).get(randomX).setValue(-1);
                coo.remove(random);
                addNumbers(randomX,randomY);
            }
        }



    public void addNumbers(int bomX, int bomY){
        for (int i = -1; i < 2; i++){
            for (int j = -1; j < 2; j++){
                if (bomX + i >= 0 && bomX + i < x && bomY + j >= 0 && bomY + j < y){
                    board.get(bomY + j).get(bomX + i).valuePlusOne();
                }
            }
        }
        board.get(bomY).get(bomX).setValue(-1);
    }

    public void printBoard(){
        for( int i = 0 ; i < y ; i++) {
            String printValue = "";
            for (int j = 0; j < x; j++) {
                if (board.get(i).get(j).getValue() == -1) {
                    printValue += " " + board.get(i).get(j).getValue();
                } else {
                    printValue += "  " + board.get(i).get(j).getValue();
                }
            }
            System.out.println(printValue);
        }
    }
}
