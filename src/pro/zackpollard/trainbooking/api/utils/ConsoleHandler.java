package pro.zackpollard.trainbooking.api.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 * @author Zack Pollard
 */
public class ConsoleHandler {

    /**
     * Gets the next data that is input into stdin.
     *
     * @return A string of the input into stdin.
     */
    public static String getInput() {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        try {
            return bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

    /**
     * Calls getInput() but prints out the prompt to stdout before requesting input from stdin.
     *
     * @param prompt The message to be output to stdout.
     * @return A string of the input into stdin.
     */
    public static String getInput(String prompt) {

        System.out.print(prompt);
        return getInput();
    }

    /**
     * Gets the next data input into stdin and checks if it is an int.
     * If input was not an int it will request input again.
     *
     * @return An int that is > 0 that the user inputted into stdin.
     */
    public static int getInt() {

        while(true) {

            try {

                int myInt = Integer.parseInt(getInput());
                if(myInt > 0) return myInt;
            } catch (NumberFormatException e) {
            }

            System.out.print("Please re-enter a valid positive Integer: ");
        }
    }

    /**
     * Calls getInput() but prints out the prompt to stdout before requesting input from stdin.
     *
     * @param prompt The message to be output to stdout.
     * @return An int that is > 0 that the user inputted into stdin.
     */
    public static int getInt(String prompt) {

        System.out.print(prompt);
        return getInt();
    }

    /**
     * Gets a date from stdin in the format dd/MM/yyyy.
     * If the input provided is not in that format or is not a valid date then the method
     * will request input again until a valid date is provided. This method will not accept
     * input of dates that are in the past.
     *
     * @return A date object that has been converted from a string the user inputted into stdin.
     */
    public static Date getDate() {

        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        format.setLenient(false);

        while(true) {

            try {
                Date date = format.parse(getInput());

                Calendar originalCal = Calendar.getInstance();
                originalCal.setTime(date);

                Calendar yesterdayCal = Calendar.getInstance();
                yesterdayCal.add(Calendar.DAY_OF_YEAR, -1);

                if(originalCal.get(Calendar.YEAR) == yesterdayCal.get(Calendar.YEAR) &&
                        originalCal.get(Calendar.DAY_OF_YEAR) == yesterdayCal.get(Calendar.DAY_OF_YEAR)) {

                    System.out.println("You can not enter a date that is in the past.");
                } else {

                    return date;
                }
            } catch (ParseException e) {
            }

            System.out.print("Please re-enter a valid date (dd/mm/yyyy): ");
        }
    }

    /**
     * Calls getInput() but prints out the prompt to stdout before requesting input from stdin.
     *
     * @param prompt The message to be output to stdout.
     * @return A date object that has been converted from a string the user inputted into stdin.
     */
    public static Date getDate(String prompt) {

        System.out.print(prompt);
        return getDate();
    }

    /**
     * Prints out the message provided into stdout and then halts execution until the user presses the enter key.
     *
     * @param prompt The message to be output to stdout.
     */
    public static void waitForEnter(String prompt) {

        System.out.print(prompt);
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }
}
