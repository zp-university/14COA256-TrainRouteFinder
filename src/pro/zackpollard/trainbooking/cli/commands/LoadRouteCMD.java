package pro.zackpollard.trainbooking.cli.commands;

import pro.zackpollard.trainbooking.api.command.Command;
import pro.zackpollard.trainbooking.api.command.CommandLevel;
import pro.zackpollard.trainbooking.api.managers.RouteManager;
import pro.zackpollard.trainbooking.api.utils.ConsoleHandler;
import pro.zackpollard.trainbooking.cli.TrainBookingCLI;

import java.io.File;

/**
 * @author Zack Pollard
 */
public class LoadRouteCMD extends Command {

    private final TrainBookingCLI instance;

    public LoadRouteCMD(TrainBookingCLI instance) {

        super("loadroute", CommandLevel.ADMIN);
        this.instance = instance;
    }

    @Override
    public void execute() {

        while(true) {

            String defaultSave = ConsoleHandler.getInput("Would you like to load routes from the default file? (y/n): ");

            if (defaultSave.toLowerCase().equals("y")) {

                instance.getRouteManager().loadRoutes(new File(RouteManager.routesDefaultFilePath));
                return;
            } else if(defaultSave.toLowerCase().equals("n")) {

                File loadLocation = new File("./" + ConsoleHandler.getInput("Enter the file name you wish to load from: "));

                String confirmation = ConsoleHandler.getInput("Are you sure you want to load this file, all unsaved data will be lost? (y/n): ");

                if(confirmation.toLowerCase().equals("y")) {

                    instance.getRouteManager().loadRoutes(loadLocation);
                } else {

                    return;
                }

                return;
            } else {

                System.out.println("Invalid response.");
            }
        }
    }

    @Override
    public String getDescription() {

        return "Load the routes from a file.";
    }
}