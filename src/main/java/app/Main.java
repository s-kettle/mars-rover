package app;

import app.parsers.InputParser;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        InputParser inputParser = new InputParser();
        UserInterface ui = new UserInterface();

        ui.start();

    }
}
