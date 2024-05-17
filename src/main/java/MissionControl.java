import java.util.List;

public class MissionControl {

    private Plateau plateau;
    private Rover rover;
    private String instructions;

    public MissionControl(Plateau plateau) {
        this.plateau = plateau;
    }

    public Plateau getPlateau() {
        return plateau;
    }

    public void addRover(Rover rover) {
        this.rover = rover;
    }

    public Rover getRover() {
        return rover;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public void implementInstructions(List<Instruction> instructions) {
        for (Instruction i : instructions) {

            switch (i) {
                case M -> rover.move();
                case L, R -> rover.rotate(i);
            }
        }
    }

    public void printRoverLocation() {
        System.out.println("\"" + rover.getName() + "\" location is: " +
                rover.getPosition().getX() + " " +
                rover.getPosition().getY() + " " +
                rover.getPosition().getFacing());
    }
}
