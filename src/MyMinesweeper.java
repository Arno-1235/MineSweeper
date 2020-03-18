import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MyMinesweeper {
    ArrayList<ArrayList<Tile>> MyMinesweeper;
    private int aantal;
    private int x;
    private int y;
    private int counter;

    public MyMinesweeper(int x, int y, int mines) throws InvalidRangeException {
        MyMinesweeper = new ArrayList<ArrayList<Tile>>();
        aantal = mines;
        this.x = x;
        this.y = y;
        counter = 0;
        if (x * y < aantal) {
            throw new InvalidRangeException("teveel mijnen meegegeven lul");
        }
    }

    public MyMinesweeper(int x, int y) throws InvalidRangeException {
        throw new InvalidRangeException("geen mijnen meegegeven lul");

    }

    public void initialiseBoard(int A, int B) {
        for (int i = 0; i < y; i++) {
            MyMinesweeper.add(new ArrayList<Tile>());
            for (int j = 0; j < x; j++) {
                MyMinesweeper.get(i).add(new Tile(0));
            }
        }

        ArrayList<Integer> coo = new ArrayList<>();
        for (int i = 0; i < x * y; i++) {
            coo.add(i);
        }
        coo.remove(x * B + A);
        Random rand = new Random();
        for (int i = 0; i < aantal; i++) {
            int random = rand.nextInt(coo.size());
            int randomCoo = coo.get(random);
            int randomX = randomCoo % x;
            int randomY = randomCoo / x;


            MyMinesweeper.get(randomY).get(randomX).setValue(-1);
            coo.remove(random);
            addNumbers(randomX, randomY);
        }
    }

    public int getWidth()
    {
        return x;
    }

    public int getHeight()
    {
        return y;
    }

    public char getValueAt(MyLocation locatie)
    {
        if (MyMinesweeper.get(locatie.getColumn()).get(locatie.getRow()).isFlag()){
            return 'F';
        }
        return 'O';
    }

    public void addNumbers(int bomX, int bomY){
        for (int i = -1; i < 2; i++){
            for (int j = -1; j < 2; j++){
                if (bomX + i >= 0 && bomX + i < x && bomY + j >= 0 && bomY + j < y){
                    MyMinesweeper.get(bomY + j).get(bomX + i).valuePlusOne();
                }
            }
        }
        //board.get(bomY).get(bomX).setValue(-1);
    }

    public void printBoard(){
        for( int i = 0 ; i < y ; i++) {
            String printValue = "";
            for (int j = 0; j < x; j++) {
                if (MyMinesweeper.get(i).get(j).getValue() == -1) {
                    //printValue += " " + board.get(i).get(j).getValue();
                    printValue += "  B";
                } else {
                    printValue += "  " + MyMinesweeper.get(i).get(j).getValue();
                }
            }
            System.out.println(printValue);
        }
    }

    public boolean checkLocation( MyLocation locatie)
    {
        counter++;
        if (MyMinesweeper.get(locatie.getColumn()).get(locatie.getRow()).getValue() == -1)
        {
            return true;
        }
        return false;

    }

    public void flagLocation(MyLocation locatie)
    {
        counter++;
        MyMinesweeper.get(locatie.getColumn()).get(locatie.getRow()).setFlag();
        if (checkLocation(locatie))
        {
            aantal--;
        }
    }

    public int getNrOfActions()
    {
        return counter;
    }
}
