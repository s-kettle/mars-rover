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

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setFacing(Direction facing) {
        this.facing = facing;
    }
}
