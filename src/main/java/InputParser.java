
import java.util.ArrayList;
import java.util.List;

public class InputParser {

    public PlateauSize parsePlateauCoordinates(String input) throws IllegalArgumentException,
            ArrayIndexOutOfBoundsException {

        String[] stringCoordinates = input.split(" ");

        if (stringCoordinates.length > 2) {
            throw new IllegalArgumentException();
        }

        try {
            int positionX = Integer.parseInt(stringCoordinates[0]);
            int positionY = Integer.parseInt(stringCoordinates[1]);

            if ((positionX >= 0 && positionY >= 0) && (positionX <= 5 && positionY <= 5)) {
                return new PlateauSize(positionX, positionY);
            } else {
                throw new IllegalArgumentException();
            }

        } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
            throw new ArrayIndexOutOfBoundsException();
        }

    }

    public Position parsePosition(String input) throws IllegalArgumentException, ArrayIndexOutOfBoundsException {

        String[] inputData = input.split(" ");

        if (inputData.length != 3) {
            throw new ArrayIndexOutOfBoundsException();
        }

        int positionX = Integer.parseInt(inputData[0]);
        int positionY = Integer.parseInt(inputData[1]);

        if (positionX < 0 || positionX > 5 || positionY < 0 || positionY > 5 ) {
            throw new IllegalArgumentException();
        }

        return new Position(positionX, positionY, Direction.valueOf(inputData[2]));

    }

    public List<Instruction> parseInstruction(String input) throws IllegalArgumentException {

        List<Instruction> instructionList = new ArrayList<>();

        try {
            String[] instructions = input.split("");
            for (String instruction : instructions) {
                instructionList.add(Instruction.valueOf(instruction));
            }
            return instructionList;

        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }

    }

}
