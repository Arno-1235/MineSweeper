public class Tile
{
    private int value;
    

    public Tile(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void valuePlusOne(){
        if (value != -1) {
            this.value++;
        }
    }
}
