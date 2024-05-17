package app.logic;

import app.datatypes.PlateauSize;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlateauTest {

    @Test
    @DisplayName("generateGrid creates 2D Array from PlateauSize")
    void generateGrid() {

        PlateauSize ps = new PlateauSize(5, 5);
        int[][] expectedArray = new int[5][5];

        Plateau plateau = new Plateau(ps);

        assertArrayEquals(expectedArray, plateau.getPlateauGrid());

    }
}