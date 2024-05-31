package app.logic;

import app.datatypes.PlateauSize;
import app.datatypes.Position;

import java.util.Random;

public class Plateau {

    private final PlateauSize size;
    private int[][] plateauGrid;
    private Rover[][] roverLocations;

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

    public void addRoverLocation(Rover rover, int x, int y) {
        this.roverLocations[x][y] = rover;
    }

    public void updateRoverLocation(Rover rover, Position oldPosition, int x, int y) {
        this.roverLocations[oldPosition.getX()][oldPosition.getY()] = null;
        this.roverLocations[x][y] = rover;
    }

    public void generateGrid(PlateauSize plateauSize) {
        this.plateauGrid = new int[plateauSize.getX() + 1][plateauSize.getY() + 1];
        this.roverLocations = new Rover[plateauSize.getX() + 1][plateauSize.getY() + 1];
    }

    public boolean locationIsEmpty(int x, int y) {
        return roverLocations[x][y] == null;
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
