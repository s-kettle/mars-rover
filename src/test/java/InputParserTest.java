import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InputParserTest {

    InputParser ip = new InputParser();

    @Test
    @DisplayName("PlateauSize created from input string correctly")
    void parsePlateauCoordinatesTest() {

        PlateauSize expectedPlateau  = new PlateauSize(5, 5);
        PlateauSize expectedPlateau2 = new PlateauSize(10, 5);

        PlateauSize testPlateau  = ip.parsePlateauCoordinates("5 5");
        PlateauSize testPlateau2 = ip.parsePlateauCoordinates("10 5");

        assertEquals(expectedPlateau.getX(), testPlateau.getX());
        assertEquals(expectedPlateau2.getY(), testPlateau2.getY());
    }

    @Test
    @DisplayName("Invalid coordinates throws IllegalArgumentException")
    void parsePlateauCoordinatesTest2() {
        assertThrows(IllegalArgumentException.class, () -> ip.parsePlateauCoordinates("-1 0"));
        assertThrows(IllegalArgumentException.class, () -> ip.parsePlateauCoordinates("-1 -2"));
        assertThrows(IllegalArgumentException.class, () -> ip.parsePlateauCoordinates("3 -1"));
    }

    @Test
    @DisplayName("Position created from input string correctly")
    void parsePositionTest() {

        Position expectedPosition  = new Position(1, 5, Direction.N);
        Position expectedPosition2 = new Position(3, 2, Direction.W);

        Position testPosition  = ip.parsePosition("1 5 N");
        Position testPosition2 = ip.parsePosition("3 2 W");

        assertEquals(expectedPosition.getX(), testPosition.getX());
        assertEquals(expectedPosition.getY(), testPosition.getY());
        assertEquals(expectedPosition.getFacing(), testPosition.getFacing());

        assertEquals(expectedPosition2.getX(), testPosition2.getX());
        assertEquals(expectedPosition2.getY(), testPosition2.getY());
        assertEquals(expectedPosition2.getFacing(), testPosition2.getFacing());
    }
}