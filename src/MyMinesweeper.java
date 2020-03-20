import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import model.MyLocation;

public class MyMinesweeper {
    ArrayList<ArrayList<Tile>> MyMinesweeper;
    private int aantal;
    private int x;
    private int y;
    private int counter;
    private boolean lost;

    public MyMinesweeper(int x, int y, int mines) throws InvalidRangeException {
        if (x <= 0 || y <= 0 )
        {
            throw new InvalidRangeException("veld klopt nie lul");
        }
        MyMinesweeper = new ArrayList<ArrayList<Tile>>();
        aantal = mines;
        this.x = x;
        this.y = y;
        counter = 0;
        lost = false;
        if (x * y < aantal) {
            throw new InvalidRangeException("teveel mijnen meegegeven lul");
        }
        emptyBoard();
    }

    public MyMinesweeper(int x, int y) throws InvalidRangeException {
        if (x <= 0 || y <= 0 )
        {
            throw new InvalidRangeException("veld klopt nie lul");
        }
        MyMinesweeper = new ArrayList<ArrayList<Tile>>();
        aantal = 0;
        this.x = x;
        this.y = y;
        counter = 0;
        lost = false;
        emptyBoard();
    }

    public void emptyBoard(){
        for (int i = 0; i < y; i++) {
            MyMinesweeper.add(new ArrayList<Tile>());
            for (int j = 0; j < x; j++) {
                MyMinesweeper.get(i).add(new Tile(0));
            }
        }
    }

    public void initialiseBoard(int A, int B) {
        //emptyBoard();

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
        return y;
    }

    public int getHeight()
    {
        return x;
    }

    public Object getValueAt(MyLocation locatie)
    {
        if (locatie.getColumn()<0 || locatie.getRow()<0 || locatie.getColumn()>y-1 || locatie.getRow()>x-1)
        {
            return null;
        }
        System.out.println(MyMinesweeper.size());
        if (MyMinesweeper.get(locatie.getColumn()).get(locatie.getRow()).isFlag()) {
            return "F";
        }
        return "O";
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
        if (locatie.getColumn()<0 || locatie.getRow()<0 || locatie.getColumn()>y-1 || locatie.getRow()>x-1){
            return false;
        }
        if (counter == 0){
            initialiseBoard(locatie.getRow(),locatie.getColumn());
        }
        counter++;
        if (MyMinesweeper.get(locatie.getColumn()).get(locatie.getRow()).getValue() == -1)
        {
            lost = true;
            return true;
        }
        return false;
    }

    public void flagLocation(MyLocation locatie)
    {
        if (locatie.getColumn()<0 || locatie.getRow()<0 || locatie.getColumn()>y-1 || locatie.getRow()>x-1){

        } else {
            //counter++;
            boolean flag = MyMinesweeper.get(locatie.getColumn()).get(locatie.getRow()).setFlag();
            if (flag && MyMinesweeper.get(locatie.getColumn()).get(locatie.getRow()).getValue() == -1) {
                aantal--;
            } else if (!flag && MyMinesweeper.get(locatie.getColumn()).get(locatie.getRow()).getValue() == -1) {
                aantal++;
            }
        }
    }

    public int getNrOfMinesLeft()
    {
        return aantal;
    }

    public int getNrOfActions()
    {
        return counter;
    }

    public boolean getLost()
    {
        return lost;
    }
}
