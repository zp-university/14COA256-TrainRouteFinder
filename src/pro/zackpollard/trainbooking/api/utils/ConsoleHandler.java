package pro.zackpollard.trainbooking.api.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Zack Pollard
 */
public class ConsoleHandler {

    public static String getInput() {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        try {
            return bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String getInput(String prompt) {

        System.out.print(prompt);
        return getInput();
    }

    public static int getInt() {

        int myInt = -1;

        while(myInt < 0) {

            try {

                myInt = Integer.parseInt(getInput());
            } catch (NumberFormatException e) {
            }
        }

        return myInt;
    }

    public static int getInt(String prompt) {

        System.out.print(prompt);
        return getInt();
    }
}
