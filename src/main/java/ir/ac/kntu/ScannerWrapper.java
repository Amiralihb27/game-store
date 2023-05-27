package ir.ac.kntu;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Wrapper class for java.util.Scanner that provides a simpler interface for user input of
 * primitives from System.in
 *
 * @author Daniel Shevtsov (SID: 200351253)
 */
public class ScannerWrapper {
    static Scanner scanner;

    /**
     * Constructor. Creates a new ScannerWrapper object
     */
    public ScannerWrapper() {
        scanner = new Scanner(System.in, "UTF-8");
    }

    /**
     * Get an int of input from a Scanner object
     *
     * @return int input from Scanner
     */
    public static int getInt() {
        int userInput = 0;
        boolean correctInput = false;

        do {
            //System.out.print("INPUT: ");
            try {
                userInput = scanner.nextInt();
                correctInput = true;
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("ERROR: Invalid input");
                scanner.nextLine();
            }
        } while (!correctInput);

        return userInput;
    }

    /**
     * Get an int of input from a Scanner object
     *
     * @param lLimit int Lower limit (user input >= lower limit)
     * @param uLimit int Upper limit (user input <= upper limit)
     * @return int input from Scanner
     */
    public static int getInt(int lLimit, int uLimit) {
        int userInput = 0;
        boolean correctInput = false;

        do {
            System.out.print("INPUT: ");
            try {
                userInput = scanner.nextInt();
                if (userInput >= lLimit && userInput <= uLimit) {
                    correctInput = true;
                } else {
                    System.out.println("ERROR: Invalid input");
                }
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("ERROR: Invalid input");
                scanner.nextLine();
            }
        } while (!correctInput);

        return userInput;
    }

    /**
     * Get a double of input from a Scanner object
     *
     * @return double input from Scanner
     */
    public static double getDouble() {
        double userInput = 0;
        boolean correctInput = false;

        do {
            try {
                userInput = scanner.nextDouble();
                correctInput = true;
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("ERROR: Invalid input");
                scanner.nextLine();
            }
        } while (!correctInput);

        return userInput;
    }

    /**
     * Get a double of input from a Scanner object
     *
     * @param lLimit double Lower limit (user input >= lower limit)
     * @param uLimit double Upper limit (user input >= upper limit)
     * @return double input from Scanner
     */
    public static double getDouble(double lLimit, double uLimit) {
        double userInput = 0;
        boolean correctInput = false;

        do {
            System.out.print("INPUT: ");
            try {
                userInput = scanner.nextDouble();
                if (userInput >= lLimit && userInput <= uLimit) {
                    correctInput = true;
                } else {
                    System.out.println("ERROR: Invalid input");
                }

                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("ERROR: Invalid input");
                scanner.nextLine();
            }
        } while (!correctInput);

        return userInput;
    }

    /**
     * Get a char of input from a Scanner object
     *
     * @return first char from single line of user input from Scanner
     */
    public static char getChar() {
        char userInput = '\0';
        boolean correctInput = false;

        do {
            try {
                userInput = scanner.next().charAt(0);
                correctInput = true;
            } catch (InputMismatchException e) {
                System.out.println("ERROR: Invalid input");
                scanner.nextLine();
            }
        } while (!correctInput);

        return userInput;
    }

    /**
     * Get a String line of input from a Scanner object
     *
     * @return String from single line of user input from Scanner
     */
    public static String getString() {
        String userInput = "";
        boolean correctInput = false;

        do {
            try {
                userInput = scanner.nextLine();
                correctInput = true;
            } catch (InputMismatchException e) {
                System.out.println("ERROR: Invalid input");
                scanner.nextLine();
            }
        } while (!correctInput);

        return userInput;
    }
}