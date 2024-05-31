package app.logic;

import app.datatypes.Direction;
import app.datatypes.PlateauSize;
import app.datatypes.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class PlateauTest {

    @Test
    @DisplayName("generateGrid creates 2D Array from PlateauSize")
    void generateGrid() {

        PlateauSize ps = new PlateauSize(5, 5);
        PlateauSize ps1 = new PlateauSize(3, 3);

        int[][] expectedArray = new int[5][5];
        int[][] expectedArray1 = new int[3][3];

        Plateau plateau = new Plateau(ps);
        Plateau plateau1 = new Plateau(ps1);

        assertArrayEquals(expectedArray, plateau.getPlateauGrid());
        assertArrayEquals(expectedArray1, plateau1.getPlateauGrid());

    }

    @Test
    @DisplayName("locationIsEmpty returns true when empty, false when full")
    void locationIsEmptyTest() {

        PlateauSize ps = new PlateauSize(5, 5);
        Plateau plateau = new Plateau(ps);
        MissionControl ms = new MissionControl(plateau);
        Rover rover = new Rover(new Position(3, 3, Direction.N));
        ms.addRover(rover, 3, 3);

        assertTrue(plateau.locationIsEmpty(1, 2));
        assertTrue(plateau.locationIsEmpty(3, 4));
        assertTrue(plateau.locationIsEmpty(5, 5));
        assertTrue(plateau.locationIsEmpty(0, 0));

        assertFalse(plateau.locationIsEmpty(3, 3));

    }

    @Test
    @DisplayName("populateSamples fills array randomly")
    void populateSamplesTest() {
        Plateau p = new Plateau(new PlateauSize(5, 5));
        for (int i = 0; i < p.getPlateauGrid().length ; i++) {
            System.out.println(Arrays.toString(p.getPlateauGrid()[i]));
        }
    }
}