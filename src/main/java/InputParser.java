public class InputParser {

    public PlateauSize parsePlateauCoordinates(String input) {

        String[] stringCoordinates = input.split(" ");

        int positionX = Integer.parseInt(stringCoordinates[0]);
        int positionY = Integer.parseInt(stringCoordinates[1]);

        if (positionX < 0 || positionY < 0) {
            throw new IllegalArgumentException("Coordinates must be more than 0");
        }

        return new PlateauSize(positionX, positionY);

    }

    public Position parsePosition(String input) {

        String[] inputData = input.split(" ");

        int positionX = Integer.parseInt(inputData[0]);
        int positionY = Integer.parseInt(inputData[1]);

        return new Position(positionX, positionY, Direction.valueOf(inputData[2]));

    }

//    public Instruction parseInstruction(String input) {
//
//
//
//
//    }

}
