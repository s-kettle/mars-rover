import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InputParserTest {

    InputParser ip = new InputParser();

    @Test
    @DisplayName("PlateauSize created from input string correctly")
    void parsePlateauCoordinatesTest() {

        PlateauSize expectedPlateau = new PlateauSize(5, 5);

        PlateauSize testPlateau = ip.parsePlateauCoordinates("5 5");

        assertEquals(expectedPlateau.getX(), testPlateau.getX());
        assertEquals(expectedPlateau.getY(), testPlateau.getY());
    }
}