package app;

import app.datatypes.Direction;
import app.datatypes.IllegalMovementException;
import app.datatypes.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PositionTest {

    Position p = new Position(0, 0, Direction.N);

    @Test
    @DisplayName("X app.datatypes.Position cannot be set beyond limit")
    void setX() {
        assertThrows(IllegalMovementException.class, () -> p.setX(6));
        assertThrows(IllegalMovementException.class, () -> p.setX(-1));
    }

    @Test
    @DisplayName("Y app.datatypes.Position cannot be set beyond limit")
    void setY() {
        assertThrows(IllegalMovementException.class, () -> p.setY(6));
        assertThrows(IllegalMovementException.class, () -> p.setY(-1));
    }
}