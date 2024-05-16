import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MissionControlTest {

    @Test
    @DisplayName("Mission control can add a rover")
    void addRover() {
        Plateau plateau = new Plateau(new PlateauSize(5, 5));
        MissionControl missionControl = new MissionControl(plateau);
        Position p = new Position(Direction.N);
        Rover rover = new Rover(p, "Test Rover");

        missionControl.addRover(rover);

        assertEquals(missionControl.getRover(), rover);

    }

    @Test
    void implementInstructions() {
    }
}