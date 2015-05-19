package pro.zackpollard.trainbooking.cli.commands;

import pro.zackpollard.trainbooking.api.command.Command;
import pro.zackpollard.trainbooking.api.command.CommandLevel;
import pro.zackpollard.trainbooking.api.io.Route;
import pro.zackpollard.trainbooking.api.utils.ConsoleHandler;
import pro.zackpollard.trainbooking.cli.TrainBookingCLI;

import java.util.*;

/**
 * @author Zack Pollard
 */
public class SortRoutesCMD extends Command {

    private final TrainBookingCLI instance;
    private static final String tableFormat = "%-20s%-24s%-10s%-10s%-10s";

    public SortRoutesCMD(TrainBookingCLI instance) {

        super("Sort Routes", CommandLevel.MAIN);
        this.instance = instance;
    }

    @Override
    public void execute() {

        List<Route> sortedRoutes = new LinkedList<>(instance.getRouteManager().getRoutes());

        System.out.println("1.) Sort routes by price ascending.");
        System.out.println("2.) Sort routes by price descending.");
        System.out.println("3.) Sort routes by duration ascending.");
        System.out.println("4.) Sort routes by duration descending.");
        System.out.println("5.) Sort routes by amount of stops ascending.");
        System.out.println("6.) Sort routes by amount of stops descending.");

        final int sortSelection = ConsoleHandler.getInt("Enter your selection: ");

        switch(sortSelection) {

            case 1:
            case 2:
                Collections.sort(sortedRoutes, new Comparator<Route>() {
                    @Override
                    public int compare(Route o1, Route o2) {
                        if(sortSelection == 1) {
                            return Double.compare(o1.getCost(), o2.getCost());
                        } else {
                            return Double.compare(o2.getCost(), o1.getCost());
                        }
                    }
                });
                break;
            case 3:
            case 4:
                Collections.sort(sortedRoutes, new Comparator<Route>() {
                    @Override
                    public int compare(Route o1, Route o2) {
                        if(sortSelection == 3) {
                            return Integer.compare(o1.getDuration(), o2.getDuration());
                        } else {
                            return Integer.compare(o2.getDuration(), o1.getDuration());
                        }
                    }
                });
                break;
            case 5:
            case 6:
                Collections.sort(sortedRoutes, new Comparator<Route>() {
                    @Override
                    public int compare(Route o1, Route o2) {
                        if(sortSelection == 5) {
                            return Integer.compare(o1.getStops().size(), o2.getStops().size());
                        } else {
                            return Integer.compare(o2.getStops().size(), o1.getStops().size());
                        }
                    }
                });
                break;
            default:
                System.out.println("Invalid selection, returning to main menu.");
                return;

        }

        System.out.format(tableFormat, "Origin Station", "Destination Station", "Cost", "Duration", "Stops");
        System.out.println();

        for(Route route : sortedRoutes) {

            System.out.format(
                    tableFormat,
                    route.getOrigin(),
                    route.getDestination(),
                    "\u00A3" + route.getCost(),
                    route.getDuration(),
                    route.getStops().size());
            System.out.println();
        }
    }

    @Override
    public String getDescription() {

        return "Sort routes by certain criteria and display them in ascending or descending order.";
    }
}