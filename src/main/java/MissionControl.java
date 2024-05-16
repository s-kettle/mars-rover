import java.util.List;

public class MissionControl {

    private Plateau plateau;
    private Rover rover;

    public MissionControl(Plateau plateau) {
        this.plateau = plateau;
    }

    public void addRover(Rover rover) {
        this.rover = rover;
    }

    public Rover getRover() {
        return rover;
    }

    public void implementInstructions(List<Instruction> instructions) {

    }

    public void printRoverLocation() {
        System.out.println("\"" + rover.getName() + "\" location is: " +
                rover.getPosition().getX() + " " +
                rover.getPosition().getY() + " " +
                rover.getPosition().getFacing());
    }
}
