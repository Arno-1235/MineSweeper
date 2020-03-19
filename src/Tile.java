public class Tile
{
    private int value;
    private boolean flag;

    public Tile(int value) {
        this.value = value;
        flag = false;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public boolean isFlag() {
        return flag;
    }

    public boolean setFlag() {
        this.flag = !this.flag;
        return this.flag;
    }

    public void valuePlusOne(){
        if (value != -1) {
            this.value++;
        }
    }
}
