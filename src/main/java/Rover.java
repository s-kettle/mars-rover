import java.util.List;

public class Rover {

    private Position position;

    public Rover(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    public void move(){

        Direction currentFacing = position.getFacing();

        switch (currentFacing) {
            case N -> {
                this.position.setY(position.getY() + 1);
            }
            case E -> {
                this.position.setX(position.getX() + 1);
            }
            case S -> {
                this.position.setY(position.getY() - 1);
            }
            case W -> {
                this.position.setX(position.getX() - 1);
            }
        }
    }

//    public Position rotate() {
//
//    }

}
