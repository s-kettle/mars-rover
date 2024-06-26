package app;

import app.datatypes.Direction;
import app.datatypes.Instruction;
import app.datatypes.PlateauSize;
import app.datatypes.Position;
import app.parsers.InputParser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InputParserTest {

    InputParser ip = new InputParser();

    @Test
    @DisplayName("app.datatypes.PlateauSize created from input string correctly")
    void parsePlateauCoordinatesTest() {

        PlateauSize expectedPlateau  = new PlateauSize(5, 5);
        PlateauSize expectedPlateau2 = new PlateauSize(3, 3);

        PlateauSize testPlateau  = ip.parsePlateauCoordinates("5 5");
        PlateauSize testPlateau2 = ip.parsePlateauCoordinates("3 3");

        assertEquals(expectedPlateau.getX(), testPlateau.getX());
        assertEquals(expectedPlateau2.getY(), testPlateau2.getY());
    }

    @Test
    @DisplayName("Invalid negative coordinates throws IllegalArgumentException")
    void parsePlateauCoordinatesTest2() {
        assertThrows(IllegalArgumentException.class, () -> ip.parsePlateauCoordinates("-1 0"));
        assertThrows(IllegalArgumentException.class, () -> ip.parsePlateauCoordinates("-1 -2"));
        assertThrows(IllegalArgumentException.class, () -> ip.parsePlateauCoordinates("3 -1"));
    }

    @Test
    @DisplayName("Invalid coordinates over 5 throw IllegalArgumentException")
    void parsePlateauCoordinatesException1() {
        assertThrows(IllegalArgumentException.class, () -> ip.parsePlateauCoordinates("6 0"));
        assertThrows(IllegalArgumentException.class, () -> ip.parsePlateauCoordinates("0 6"));
        assertThrows(IllegalArgumentException.class, () -> ip.parsePlateauCoordinates("7 -1"));
    }

    @Test
    @DisplayName("Too few arguments throws IllegalArgumentException")
    void parsePlateauCoordinatesException2() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> ip.parsePlateauCoordinates(""));
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> ip.parsePlateauCoordinates("0"));
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> ip.parsePlateauCoordinates("-1"));
    }

    @Test
    @DisplayName("Too many arguments throws IllegalArgumentException")
    void parsePlateauCoordinatesException3() {
        assertThrows(IllegalArgumentException.class, () -> ip.parsePlateauCoordinates("1 2 3"));
        assertThrows(IllegalArgumentException.class, () -> ip.parsePlateauCoordinates("-1 -3 -6"));
        assertThrows(IllegalArgumentException.class, () -> ip.parsePlateauCoordinates("0 0 0"));
    }

    @Test
    @DisplayName("app.datatypes.Position created from input string correctly")
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

    @Test
    @DisplayName("parseInstruction returns correct list from string")
    void parseInstruction() {

        List<Instruction> expectedList  = new ArrayList<>(List.of(
                Instruction.L,
                Instruction.L,
                Instruction.M,
                Instruction.R
        ));

        List<Instruction> expectedList2 = new ArrayList<>(List.of(
                Instruction.M,
                Instruction.M,
                Instruction.M,
                Instruction.L
        ));

        List<Instruction> testList  = ip.parseInstruction("LLMR");
        List<Instruction> testList2 = ip.parseInstruction("MMML");

        assertEquals(expectedList, testList);
        assertEquals(expectedList2, testList2);
    }

    @Test
    @DisplayName("parseInstruction invalid instructions throw exception")
    void parseInstructionException() {
        assertThrows(IllegalArgumentException.class, () -> ip.parseInstruction("DSS"));
        assertThrows(IllegalArgumentException.class, () -> ip.parseInstruction("!!!"));
        assertThrows(IllegalArgumentException.class, () -> ip.parseInstruction("123"));
        assertThrows(IllegalArgumentException.class, () -> ip.parseInstruction("LMR RM"));
    }
}