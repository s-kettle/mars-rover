package app;

import app.datatypes.Direction;
import app.datatypes.Instruction;
import app.datatypes.Position;
import app.logic.Rover;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoverTest {

    @Test
    @DisplayName("app.logic.Rover position updates on move()")
    void moveTest() {

        Position positionNorth = new Position(2, 2, Direction.N);
        Position positionEast = new Position(2, 2, Direction.E);
        Position positionSouth = new Position(2, 2, Direction.S);
        Position positionWest = new Position(2, 2, Direction.W);

        Rover roverNorth = new Rover(positionNorth);
        Rover roverEast = new Rover(positionEast);
        Rover roverSouth = new Rover(positionSouth);
        Rover roverWest = new Rover(positionWest);

        roverNorth.move();
        roverSouth.move();
        roverEast.move();
        roverWest.move();

        assertEquals(3, roverNorth.getPosition().getY());
        assertEquals(3, roverEast.getPosition().getX());
        assertEquals(1, roverSouth.getPosition().getY());
        assertEquals(1, roverWest.getPosition().getX());
    }

    @Test
    @DisplayName("North facing rover direction updates on rotate(L)")
    void rotateTestNorthL() {
        Position position = new Position(Direction.N);
        Rover rover = new Rover(position);

        rover.rotate(Instruction.L);
        assertEquals(Direction.W, rover.getPosition().getFacing());

    }

    @Test
    @DisplayName("North facing rover direction updates on rotate(R)")
    void rotateTestNorthR() {
        Position position = new Position(Direction.N);
        Rover rover = new Rover(position);

        rover.rotate(Instruction.R);
        assertEquals(Direction.E, rover.getPosition().getFacing());

    }

    @Test
    @DisplayName("East facing rover direction updates on rotate(L)")
    void rotateTestEastL() {
        Position position = new Position(Direction.E);
        Rover rover = new Rover(position);

        rover.rotate(Instruction.L);
        assertEquals(Direction.N, rover.getPosition().getFacing());

    }

    @Test
    @DisplayName("East facing rover direction updates on rotate(R)")
    void rotateTestEastR() {
        Position position = new Position(Direction.E);
        Rover rover = new Rover(position);

        rover.rotate(Instruction.R);
        assertEquals(Direction.S, rover.getPosition().getFacing());

    }

    @Test
    @DisplayName("South facing rover direction updates on rotate(L)")
    void rotateTestSouthL() {
        Position position = new Position(Direction.S);
        Rover rover = new Rover(position);

        rover.rotate(Instruction.L);
        assertEquals(Direction.E, rover.getPosition().getFacing());

    }

    @Test
    @DisplayName("South facing rover direction updates on rotate(R)")
    void rotateTestSouthR() {
        Position position = new Position(Direction.S);
        Rover rover = new Rover(position);

        rover.rotate(Instruction.R);
        assertEquals(Direction.W, rover.getPosition().getFacing());

    }

    @Test
    @DisplayName("West facing rover direction updates on rotate(L)")
    void rotateTestWestL() {
        Position position = new Position(Direction.W);
        Rover rover = new Rover(position);

        rover.rotate(Instruction.L);
        assertEquals(Direction.S, rover.getPosition().getFacing());

    }

    @Test
    @DisplayName("West facing rover direction updates on rotate(R)")
    void rotateTestWestR() {
        Position position = new Position(Direction.W);
        Rover rover = new Rover(position);

        rover.rotate(Instruction.R);
        assertEquals(Direction.N, rover.getPosition().getFacing());

    }

    @Test
    @DisplayName("app.logic.Rover will not move out of plateau bounds")
    void moveExceptionTest() {
        Position eastPosition = new Position(5, 5, Direction.E);
        Position northPosition = new Position(5, 5, Direction.N);
        Rover roverOutOfBoundsX = new Rover(eastPosition);
        Rover roverOutOfBoundsY = new Rover(northPosition);

        roverOutOfBoundsX.move();
        roverOutOfBoundsY.move();

        assertEquals(5, roverOutOfBoundsX.getPosition().getX());
        assertEquals(5, roverOutOfBoundsY.getPosition().getY());

    }

}