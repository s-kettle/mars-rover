package app.logic;

import app.datatypes.CollisionException;
import app.datatypes.Instruction;

import java.util.List;

public class MissionControl {

    private Plateau plateau;
    private Rover currentRover;
    private List<Instruction> instructions;

    public MissionControl(Plateau plateau) {
        this.plateau = plateau;
    }

    public Plateau getPlateau() {
        return plateau;
    }

    public void addRover(Rover rover, int x, int y) throws CollisionException {
        this.currentRover = rover;
        if (plateau.locationIsEmpty(x, y)) {
            plateau.addRoverLocation(rover, x, y);
        } else {
            throw new CollisionException("Cannot place a rover here, landing site full.");
        }
    }

    public Rover getRover() {
        return currentRover;
    }

    public void setInstructions(List<Instruction> instructions) {
        this.instructions = instructions;
    }

    public void implementInstructions() throws CollisionException {

        for (Instruction i : instructions) {

            switch (i) {
                case M -> {
                    switch (currentRover.getPosition().getFacing()) {
                        case N -> {
                            if (plateau.locationIsEmpty(currentRover.getPosition().getX(), currentRover.getPosition().getY() + 1)) {
                                currentRover.move();
                            } else {
                                throw new CollisionException("Collision! Aborting.");
                            }
                        }
                        case E -> {
                            if (plateau.locationIsEmpty(currentRover.getPosition().getX() + 1, currentRover.getPosition().getY())) {
                                currentRover.move();
                            } else {
                                throw new CollisionException("Collision! Aborting.");
                            }
                        }
                        case S -> {
                            if (plateau.locationIsEmpty(currentRover.getPosition().getX(), currentRover.getPosition().getY() - 1)) {
                                currentRover.move();
                            } else {
                                throw new CollisionException("Collision! Aborting.");
                            }
                        }
                        case W -> {
                            if (plateau.locationIsEmpty(currentRover.getPosition().getX() - 1, currentRover.getPosition().getY())) {
                                currentRover.move();
                            } else {
                                throw new CollisionException("Collision! Aborting.");
                            }
                        }
                    }
                }

                case L, R -> currentRover.rotate(i);
            }
        }
    }

    public void printRoverLocation() {
        System.out.println("\"" + currentRover.getName() + "\" location is: " +
                currentRover.getPosition().getX() + " " +
                currentRover.getPosition().getY() + " " +
                currentRover.getPosition().getFacing());
    }

    public String instructRoverToTakeSample() {
        switch (plateau.getPlateauGrid()[currentRover.getPosition().getX() - 1][currentRover.getPosition().getY() - 1]) {
            case 1 -> { return "You found Titanium!"; }
            case 2 -> { return "You found Zinc!"; }
            case 3 -> { return "You found Copper!"; }
            case 4 -> { return "You found Aluminium!"; }
            case 5 -> { return "Wow! You struck Gold!!"; }
        }
        return null;
    }
}
