package app.datatypes;

public class Position {
    private int x;
    private int y;
    private Direction facing;

    public Position(Direction facing) {
        this.x = 0;
        this.y = 0;
        this.facing = facing;
    }

    public Position(int x, int y, Direction facing) {
        this.x = x;
        this.y = y;
        this.facing = facing;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Direction getFacing() {
        return facing;
    }

    public void setX(int x) throws IllegalMovementException {
        if (x <= 5 && x >= 0) {
            this.x = x;
        } else {
            throw new IllegalMovementException("Cannot move, out of plateau bounds.");
        }
    }

    public void setY(int y) throws IllegalMovementException {
        if (y <= 5 && y >= 0) {
            this.y = y;
        } else {
            throw new IllegalMovementException("Cannot move, out of plateau bounds.");
        }
    }

    public void setFacing(Direction facing) {
        this.facing = facing;
    }
}
