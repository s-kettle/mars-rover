public class InputParser {

    public PlateauSize parsePlateauCoordinates(String string) {

        String[] stringCoordinates = string.split(" ");
        int[] intCoordinates = new int[stringCoordinates.length];

        for (int i = 0; i < stringCoordinates.length; i++) {
            intCoordinates[i] = Integer.parseInt(stringCoordinates[i]);
        }

        return new PlateauSize(intCoordinates[0], intCoordinates[1]);

    }
}
