package pro.zackpollard.trainbooking.cli.commands;

import pro.zackpollard.trainbooking.api.command.Command;
import pro.zackpollard.trainbooking.api.command.CommandLevel;
import pro.zackpollard.trainbooking.api.io.Route;
import pro.zackpollard.trainbooking.api.utils.ConsoleHandler;
import pro.zackpollard.trainbooking.cli.TrainBookingCLI;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Zack Pollard
 */
public class SplitTicketCMD extends Command {

    private final TrainBookingCLI instance;
    private static final String tableFormat = "%-16s%-16s%-24s%-8s%-10s%-8s";

    public SplitTicketCMD(TrainBookingCLI instance) {

        super("Split Ticket", CommandLevel.MAIN);
        this.instance = instance;
    }

    @Override
    public void execute() {

        String origin = ConsoleHandler.getInput("Enter journey origin: ").toLowerCase();
        String destination = ConsoleHandler.getInput("Enter journey destination: ").toLowerCase();

        List<List<Route>> possibleRoutes = new ArrayList<>();

        for (Route primaryRoute : instance.getRouteManager().getRoutes()) {

            if (primaryRoute.getOrigin().toLowerCase().equals(origin)) {

                for (Route secondaryRoute : instance.getRouteManager().getRoutes()) {

                    if (secondaryRoute.getOrigin().toLowerCase().equals(primaryRoute.getDestination().toLowerCase()) &&
                            secondaryRoute.getDestination().toLowerCase().equals(destination)) {

                        List<Route> thisRoute = new LinkedList<>();

                        thisRoute.add(primaryRoute);
                        thisRoute.add(secondaryRoute);

                        possibleRoutes.add(thisRoute);
                    }
                }
            }
        }

        System.out.println();
        System.out.format(tableFormat, "Origin Station", "Middle Station", "Destination Station", "Cost", "Duration", "Stops");
        System.out.println();

        for(List<Route> routes : possibleRoutes) {

            Route first = routes.get(0);
            Route second = routes.get(1);

            System.out.format(tableFormat,
                    first.getOrigin(),
                    first.getDestination(),
                    second.getDestination(),
                    "\u00A3" + (first.getCost() + second.getCost()),
                    first.getDuration() + second.getDuration(),
                    first.getStops().size() + second.getStops().size());
            System.out.println();
        }

        ConsoleHandler.waitForEnter("Press the enter key to continue...");
    }

    @Override
    public String getDescription() {

        return "Find alternative ways of travelling between two stations.";
    }
}