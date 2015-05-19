package pro.zackpollard.trainbooking.api.utils;

/**
 * @author Zack Pollard
 */
public class Utils {

    /**
     * Fills in the provided message String with converted time units.
     * If %hh% and %mm% were provided, it would display the max amount of hours
     * in those minutes rounded down and then the rest would be displayed as minutes.
     * The message "The time is %hh%:%mm%" with amountTimeMinutes as 100 would be converted
     * into "The time is 1:40".
     *
     * @param message   A message with formatting strings to be replaced by the converted time units.
     *                  %ww% - weeks
     *                  %dd% - days
     *                  %hh% - hours
     *                  %mm% - minutes
     * @param amountTimeMinutes Time in minutes to be converted into other units of time.
     * @return The original string but with the formatting strings replaced.
     */
    public static String parseStringTimeInfo(String message, long amountTimeMinutes) {

        long weeks = -1;
        long days = -1;
        long hours = -1;
        long minutes = -1;

        if (message.contains("%ww%")) {

            weeks = amountTimeMinutes / 10080;
            amountTimeMinutes = amountTimeMinutes % 10080;
        }
        if (message.contains("%dd%")) {

            days = amountTimeMinutes / 1440;
            amountTimeMinutes = amountTimeMinutes % 1440;
        }
        if (message.contains("%hh%")) {

            hours = amountTimeMinutes / 60;
            amountTimeMinutes = amountTimeMinutes % 60;
        }
        if (message.contains("%mm%")) {

            minutes = amountTimeMinutes;
        }

        message = message.replace("%ww%", String.valueOf(weeks))
                .replace("%dd%", String.valueOf(days))
                .replace("%hh%", String.valueOf(hours))
                .replace("%mm%", String.valueOf(minutes));

        return message;
    }
}