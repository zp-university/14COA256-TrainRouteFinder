package pro.zackpollard.trainbooking.cli.commands;

import pro.zackpollard.trainbooking.api.command.Command;
import pro.zackpollard.trainbooking.api.command.CommandLevel;
import pro.zackpollard.trainbooking.api.io.Route;
import pro.zackpollard.trainbooking.api.utils.ConsoleHandler;
import pro.zackpollard.trainbooking.cli.TrainBookingCLI;

import java.util.List;

/**
 * @author Zack Pollard
 */
public class RouteCMD extends Command {

    private final TrainBookingCLI instance;

    public RouteCMD(TrainBookingCLI instance) {

        super("Route", CommandLevel.MAIN);
        this.instance = instance;
    }

    @Override
    public void execute() {

        String origin = ConsoleHandler.getInput("Enter journey origin: ").toLowerCase();
        String destination = ConsoleHandler.getInput("Enter journey destination: ").toLowerCase();

        for(Route route : instance.getRouteManager().getRoutes()) {

            if(route.getOrigin().toLowerCase().equals(origin)) {

                if(route.getDestination().toLowerCase().equals(destination)) {

                    List<String> stops = route.getStops();

                    System.out.println("The trains route is as follows.");
                    System.out.println("Origin: " + route.getOrigin());

                    if(stops.size() != 0) {

                        int count = 0;

                        for(String stop : stops) {

                            System.out.println("Stop " + ++count + ": " + stop);
                        }
                    }

                    System.out.println("Destination: " + route.getDestination());
                }
            }
        }

        ConsoleHandler.waitForEnter("Press the enter key to continue...");
    }

    @Override
    public String getDescription() {

        return "Find the stops inbetween two stations.";
    }
}