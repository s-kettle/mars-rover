import java.util.Scanner;

public class UserInterface {

    String RESET   = "\u001B[0m";
    String MAGENTA = "\u001B[35m";
    String GREEN   = "\u001B[32m";
    String RED     = "\u001B[31m";
    String CYAN    = "\u001B[36m";
    String YELLOW  = "\u001B[33m";

    Scanner scanner = new Scanner(System.in);
    InputParser inputParser = new InputParser();
    MissionControl missionControl;
    boolean finished;

    public void start() {
        printWelcome();
        missionControl = new MissionControl(getPlateauInput());
        printPlateauSuccessMessage();

        while (!finished) {
            getRoverInput();
            printRoverSuccessMessage();
            getInstructionInput();
            printImplementation();
            isUserFinished();
        }
    }

    public void printWelcome() {
        System.out.println(CYAN + "\n-*-*- WELCOME TO THE MARS ROVER PROGRAMME! -*-*-\n" + RESET);
    }

    public Plateau getPlateauInput() {

        System.out.println(MAGENTA + "---- CREATE A PLATEAU ----");
        System.out.print(YELLOW + "Please enter a plateau size (x, y): " + RESET);

        while (true) {
            try {
                String plateauInput = scanner.nextLine();
                return new Plateau(inputParser.parsePlateauCoordinates(plateauInput));
            } catch (IllegalArgumentException e) {
                System.out.println(RED + "Coordinates invalid. These must be greater than 0, and not exceed 5." + RESET);
                System.out.print(YELLOW + "Please enter new coordinates (x, y): " + RESET);
            }
        }
    }

    public void getRoverInput() {
        System.out.println(MAGENTA + "\n---- DROP A ROVER ----" + RESET);
        System.out.print(YELLOW + "What is this rover called? " + RESET);
        String roverNameInput = scanner.nextLine();
        System.out.print(YELLOW + "Please enter a starting location and heading (x, y, direction): " + RESET);
        String roverPositionInput = scanner.nextLine();

        Rover rover = new Rover(inputParser.parsePosition(roverPositionInput), roverNameInput);
        missionControl.addRover(rover);
    }

    public void getInstructionInput() {
        System.out.println(MAGENTA + "\n---- SEND INSTRUCTIONS ----");

        System.out.println(YELLOW + "Please enter in format MLR, e.g. MMLMRM" + RESET);
        System.out.println(CYAN + "M: Move forward");
        System.out.println("L: Rotate left");
        System.out.println("R: Move right\n" + RESET);

        System.out.print(YELLOW + "Enter instructions for \"" + missionControl.getRover().getName() + "\": " + RESET);

        while (true) {
            try {
                missionControl.setInstructions(inputParser.parseInstruction(scanner.nextLine()));
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(RED + "Invalid input");
                System.out.println("Instructions must in format MLR with no spaces." + RESET);
                System.out.print(YELLOW + "Please enter new instructions: " + RESET);
            }
        }
    }

    public void printPlateauSuccessMessage() {
        System.out.println(GREEN + "\nPlateau created successfully - dimensions: " +
                missionControl.getPlateau().getSize().getX() + ", " + missionControl.getPlateau().getSize().getY() + RESET);
    }

    public void printRoverSuccessMessage() {
        System.out.println(GREEN + "Rover \"" + missionControl.getRover().getName() + "\" successfully dropped at coordinates " +
                missionControl.getRover().getPosition().getX() + ", " + missionControl.getRover().getPosition().getY() + " facing " +
                missionControl.getRover().getPosition().getFacing() + "." + RESET);
    }

    public void printImplementation() {
        missionControl.implementInstructions();
        missionControl.printRoverLocation();
    }

    public void isUserFinished() {
        System.out.println(CYAN + "\nWould you like to place a new rover? (Y/N)" + RESET);
        if (scanner.nextLine().equalsIgnoreCase("N")) {
            System.out.println(MAGENTA + "\nThank you for using the Mars Rover Programme.");
            System.out.println("Goodbye!");
            finished = true;
        }

    }

}
