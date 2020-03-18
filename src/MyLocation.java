import gameinterface.Location;

public class MyLocation implements Location {

    private int i;
    private int j;

    public MyLocation(int i, int j) {
        this.i = i;
        this.j = j;
    }

    @Override
    public int getRow() {
        return i;
    }

    @Override
    public int getColumn() {
        return j;
    }
}
