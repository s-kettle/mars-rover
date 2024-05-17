package app.logic;

import app.datatypes.PlateauSize;

import java.util.ArrayList;
import java.util.List;

public class Plateau {

    private final PlateauSize size;
    private int[][] plateauGrid;

    public Plateau(PlateauSize size) {
        this.size = size;
        generateGrid(size);
    }

    public PlateauSize getSize() {
        return size;
    }

    public int[][] getPlateauGrid() {
        return plateauGrid;
    }

    public void generateGrid(PlateauSize plateauSize) {
        this.plateauGrid = new int[plateauSize.getX()][plateauSize.getY()];
    }

}
