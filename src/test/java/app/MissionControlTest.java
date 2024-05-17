package app;

import app.datatypes.Direction;
import app.datatypes.Instruction;
import app.datatypes.PlateauSize;
import app.datatypes.Position;
import app.logic.MissionControl;
import app.logic.Plateau;
import app.logic.Rover;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MissionControlTest {

    Plateau plateau = new Plateau(new PlateauSize(5, 5));
    MissionControl missionControl = new MissionControl(plateau);
    Position p = new Position(Direction.N);
    Rover rover = new Rover(p, "Test app.logic.Rover");

    @Test
    @DisplayName("Mission control can add a rover")
    void addRover() {

        missionControl.addRover(rover);
        assertEquals(missionControl.getRover(), rover);

    }

    @Test
    @DisplayName("app.logic.MissionControl implements instructions for rover")
    void implementInstructions() {

        List<Instruction> instructionList = new ArrayList<>(List.of(
                Instruction.M, Instruction.M, Instruction.R, Instruction.M
        ));
        Position expectedPosition = new Position(1, 2, Direction.E);

        missionControl.addRover(rover);
        missionControl.setInstructions(instructionList);
        missionControl.implementInstructions();

        assertEquals(expectedPosition.getX(), missionControl.getRover().getPosition().getX());
        assertEquals(expectedPosition.getY(), missionControl.getRover().getPosition().getY());
        assertEquals(expectedPosition.getFacing(), missionControl.getRover().getPosition().getFacing());
    }
}