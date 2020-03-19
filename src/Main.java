import static org.junit.Assert.fail;

public class Main {
    public static void main(String[] args){
        try {
            MyMinesweeper b = new MyMinesweeper(30, 16, 99);
            b.initialiseBoard(1, 2);
            b.printBoard();
        } catch (InvalidRangeException e) {
            System.out.println(e);
        }
    }
}
