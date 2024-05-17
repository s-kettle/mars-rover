package app.logic;

import app.datatypes.PlateauSize;
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
    @DisplayName("populateSamples fills array randomly")
    void populateSamplesTest() {
        Plateau p = new Plateau(new PlateauSize(5, 5));
        for (int i = 0; i < p.getPlateauGrid().length ; i++) {
            System.out.println(Arrays.toString(p.getPlateauGrid()[i]));
        }
    }
}