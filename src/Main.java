public class Main {
    public static void main(String[] args)
    {
        MyMinesweeper b = new MyMinesweeper(30,16,99);
        b.initialiseBoard(1,2);
        b.printBoard();
    }
}
