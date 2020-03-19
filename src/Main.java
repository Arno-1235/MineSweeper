import model.MyLocation;

import static org.junit.Assert.fail;

public class Main {
    public static void main(String[] args){
        try {
            MyMinesweeper b = new MyMinesweeper(30, 16, 99);
            b.checkLocation(new MyLocation(3,4));
            b.printBoard();
        } catch (InvalidRangeException e) {
            System.out.println(e);
        }
    }
}
