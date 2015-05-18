package pro.zackpollard.trainbooking.api.utils;

/**
 * @author Zack Pollard
 */
public class Utils {

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