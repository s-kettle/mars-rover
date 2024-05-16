public class InputParser {

    public PlateauSize parsePlateauCoordinates(String string) {

        String[] stringCoordinates = string.split(" ");

        int positionX = Integer.parseInt(stringCoordinates[0]);
        int positionY = Integer.parseInt(stringCoordinates[1]);

        return new PlateauSize(positionX, positionY);

    }

    public Position parsePosition(String string) {

        String[] inputData = string.split(" ");

        int positionX = Integer.parseInt(inputData[0]);
        int positionY = Integer.parseInt(inputData[1]);

        return new Position(positionX, positionY, Direction.valueOf(inputData[2]));

    }

}
