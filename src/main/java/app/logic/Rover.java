package app.logic;

import app.datatypes.Direction;
import app.datatypes.IllegalMovementException;
import app.datatypes.Instruction;
import app.datatypes.Position;

public class Rover implements SpaceVehicle {

    private final String name;
    private final Position position;

    public Rover(Position position) {
        this.name = "Mars Rover";
        this.position = position;
    }

    public Rover(Position position, String name) {
        this.position = position;
        this.name = name;
    }

    public Position getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public void move(){

        try {
            switch (position.getFacing()) {
                case N -> this.position.setY(position.getY() + 1);
                case E -> this.position.setX(position.getX() + 1);
                case S -> this.position.setY(position.getY() - 1);
                case W -> this.position.setX(position.getX() - 1);
            }
        } catch (IllegalMovementException e) {
            System.out.println(e.getMessage());
        }
    }

    public void rotate(Instruction instruction) {

        switch(position.getFacing()) {
            case N -> {
                if (instruction.equals(Instruction.L)) {
                    this.position.setFacing(Direction.W);
                } else {
                    this.position.setFacing(Direction.E);
                }
            }
            case E -> {
                if (instruction.equals(Instruction.L)) {
                    this.position.setFacing(Direction.N);
                } else {
                    this.position.setFacing(Direction.S);
                }
            }
            case S -> {
                if (instruction.equals(Instruction.L)) {
                    this.position.setFacing(Direction.E);
                } else {
                    this.position.setFacing(Direction.W);
                }
            }
            case W -> {
                if (instruction.equals(Instruction.L)) {
                    this.position.setFacing(Direction.S);
                } else {
                    this.position.setFacing(Direction.N);
                }
            }
        }
    }

}
