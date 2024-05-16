import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoverTest {

    @Test
    @DisplayName("Rover position updates on move()")
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
    void rotate() {
    }
}