package app.logic;

import app.datatypes.PlateauSize;
import app.sampletype.Titanium;

import java.util.Random;

public class Plateau {

    private final PlateauSize size;
    private int[][] plateauGrid;

    public Plateau(PlateauSize size) {
        this.size = size;
        generateGrid(size);
        populateSamples();
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

    public void populateSamples(){
        for (int i = 0; i < plateauGrid[0].length; i++) {
            for (int j = 0; j < plateauGrid[1].length; j++) {
                Random r = new Random();
                plateauGrid[i][j] = r.nextInt(1, 6);
            }
        }
    }

}
