package pro.zackpollard.trainbooking.cli.commands;

import pro.zackpollard.trainbooking.api.command.Command;
import pro.zackpollard.trainbooking.api.command.CommandLevel;
import pro.zackpollard.trainbooking.api.io.Route;
import pro.zackpollard.trainbooking.api.utils.ConsoleHandler;
import pro.zackpollard.trainbooking.cli.TrainBookingCLI;

/**
 * @author Zack Pollard
 */
public class InputRouteCMD extends Command {

    private final TrainBookingCLI instance;
    private static final String tableFormat = "%-20s%-20s%-24s%-10s%-10s";

    public InputRouteCMD(TrainBookingCLI instance) {

        super("Input Route", CommandLevel.ADMIN);
        this.instance = instance;
    }

    @Override
    public void execute() {

        String origin = ConsoleHandler.getInput("Enter journey origin: ").toLowerCase();
        String destination = ConsoleHandler.getInput("Enter journey destination: ").toLowerCase();

        Route selectedRoute = null;

        for (Route route : instance.getRouteManager().getRoutes()) {

            if (route.getOrigin().toLowerCase().equals(origin)) {

                if (route.getDestination().toLowerCase().equals(destination)) {

                    selectedRoute = route;
                    break;
                }
            }
        }

        if(selectedRoute != null) {

            int amountInputs = ConsoleHandler.getInt("Enter the amount of stops to add: ");

            for(int i = 1; i <= amountInputs; ++i) {

                selectedRoute.addStop(ConsoleHandler.getInput("Enter the name of the stop to add: "));
            }
        }

        ConsoleHandler.waitForEnter("Press the enter key to continue...");
    }

    @Override
    public String getDescription() {

        return "Add extra stations to a route.";
    }
}