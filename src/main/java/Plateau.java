import java.util.ArrayList;
import java.util.List;

public class Plateau {

    private final PlateauSize size;
    private List<Rover> rovers;

    public Plateau(PlateauSize size) {
        this.size = size;
        this.rovers = new ArrayList<Rover>();
    }

    public PlateauSize getSize() {
        return size;
    }

    public void dropRover(Rover rover) {
        rovers.add(rover);
    }

    public boolean isEmpty(int x, int y) {
        for (Rover rover : rovers) {
            if (rover.getPosition().getX() == x && rover.getPosition().getY() == y) {
                return false;
            }
        }
        return true;
    }
}
