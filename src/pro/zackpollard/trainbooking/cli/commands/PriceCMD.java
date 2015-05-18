package pro.zackpollard.trainbooking.cli.commands;

import pro.zackpollard.trainbooking.api.command.Command;
import pro.zackpollard.trainbooking.api.command.CommandLevel;
import pro.zackpollard.trainbooking.api.io.Route;
import pro.zackpollard.trainbooking.api.utils.ConsoleHandler;
import pro.zackpollard.trainbooking.cli.TrainBookingCLI;

import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Zack Pollard
 */
public class PriceCMD extends Command {

    private final TrainBookingCLI instance;
    private final DecimalFormat decimalFormat;

    public PriceCMD(TrainBookingCLI instance) {

        super("price", CommandLevel.MAIN);
        this.instance = instance;
        this.decimalFormat = new DecimalFormat("#.00");
    }

    @Override
    public void execute() {

        String origin = ConsoleHandler.getInput("Enter journey origin: ").toLowerCase();
        String destination = ConsoleHandler.getInput("Enter journey destination: ").toLowerCase();
        Date date = ConsoleHandler.getDate("Enter journey date: ");

        Calendar originalCal = Calendar.getInstance();
        originalCal.setTime(date);

        Calendar lastDayCal = Calendar.getInstance();
        lastDayCal.setTime(date);
        lastDayCal.set(Calendar.DAY_OF_MONTH, lastDayCal.getActualMaximum(Calendar.DAY_OF_MONTH));

        boolean lastDayOfMonth = (originalCal.get(Calendar.DAY_OF_MONTH) == lastDayCal.get(Calendar.DAY_OF_MONTH));

        for(Route route : instance.getRouteManager().getRoutes()) {

            if(route.getOrigin().toLowerCase().equals(origin)) {

                if(route.getDestination().toLowerCase().equals(destination)) {

                    double price = route.getCost();

                    if(lastDayOfMonth) {

                        price = price * 0.9;
                    }

                    System.out.println("Journey price would be £" + decimalFormat.format(price));
                }
            }
        }
    }

    @Override
    public String getDescription() {

        return "Find the cost of travelling between two stations.";
    }
}
