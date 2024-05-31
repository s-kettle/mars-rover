package app.logic;

import app.datatypes.Instruction;

public interface SpaceVehicle {

    public void move();
    public void rotate(Instruction instruction);
}
