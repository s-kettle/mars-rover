package app;

import app.datatypes.*;
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
    Rover rover = new Rover(p, "Test Rover");
    Rover rover2 = new Rover(p, "Test Rover2");

    @Test()
    @DisplayName("Mission control can add a rover")
    void addRover() {

        try {
            missionControl.addRover(rover, p.getX(), p.getY());
        } catch (CollisionException e) {
            System.out.println(e.getMessage());
        }
        assertEquals(missionControl.getRover(), rover);
    }

    @Test()
    @DisplayName("Mission control cannot add a rover on same landing site")
    void addRover2() {

        assertThrows(CollisionException.class, () -> {
            missionControl.addRover(rover, p.getX(), p.getY());
            missionControl.addRover(rover2, p.getX(), p.getY());
        });

    }


    @Test
    @DisplayName("MissionControl implements instructions for rover")
    void implementInstructions() {

        List<Instruction> instructionList = new ArrayList<>(List.of(
                Instruction.M, Instruction.M, Instruction.R, Instruction.M
        ));
        Position expectedPosition = new Position(1, 2, Direction.E);

        try {
            missionControl.addRover(rover, p.getX(), p.getY());
            missionControl.setInstructions(instructionList);
            missionControl.implementInstructions();
        } catch (CollisionException e) {
            System.out.println(e.getMessage());
        }

        assertEquals(expectedPosition.getX(), missionControl.getRover().getPosition().getX());
        assertEquals(expectedPosition.getY(), missionControl.getRover().getPosition().getY());
        assertEquals(expectedPosition.getFacing(), missionControl.getRover().getPosition().getFacing());
    }

    @Test
    @DisplayName("CollisionException thrown if instructions cause collision.")
    void implementInstructions2() {


    }

}