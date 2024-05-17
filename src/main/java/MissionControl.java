import java.util.List;

public class MissionControl {

    private Plateau plateau;
    private Rover rover;
    private List<Instruction> instructions;

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

    public void setInstructions(List<Instruction> instructions) {
        this.instructions = instructions;
    }

    public void implementInstructions() {

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
