package model;

import gameinterface.Location;

public class MyLocation implements Location {
    public MyLocation(int i, int j) {
    }

    @Override
    public int getRow() {
        return 0;
    }

    @Override
    public int getColumn() {
        return 0;
    }
}
