package pro.zackpollard.trainbooking.cli.commands;

import pro.zackpollard.trainbooking.api.command.Command;
import pro.zackpollard.trainbooking.api.command.CommandLevel;
import pro.zackpollard.trainbooking.api.io.Route;
import pro.zackpollard.trainbooking.api.utils.ConsoleHandler;
import pro.zackpollard.trainbooking.api.utils.Utils;
import pro.zackpollard.trainbooking.cli.TrainBookingCLI;

/**
 * @author Zack Pollard
 */
public class TimeCMD extends Command {

    private final TrainBookingCLI instance;

    public TimeCMD(TrainBookingCLI instance) {

        super("Time", CommandLevel.MAIN);
        this.instance = instance;
    }

    @Override
    public void execute() {

        String origin = ConsoleHandler.getInput("Enter journey origin: ").toLowerCase();
        String destination = ConsoleHandler.getInput("Enter journey destination: ").toLowerCase();

        for(Route route : instance.getRouteManager().getRoutes()) {

            if(route.getOrigin().toLowerCase().equals(origin)) {

                if(route.getDestination().toLowerCase().equals(destination)) {

                    System.out.println("Journey time would be " + Utils.parseStringTimeInfo("%hh% hours and %mm% minutes.", route.getDuration()));
                }
            }
        }

        ConsoleHandler.waitForEnter("Press the enter key to continue...");
    }

    @Override
    public String getDescription() {

        return "Find travel time between two stations.";
    }
}