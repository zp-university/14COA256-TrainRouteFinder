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
public class SaveRouteCMD extends Command {

    private final TrainBookingCLI instance;

    public SaveRouteCMD(TrainBookingCLI instance) {

        super("Save Route", CommandLevel.ADMIN);
        this.instance = instance;
    }

    @Override
    public void execute() {

        while(true) {

            String defaultSave = ConsoleHandler.getInput("Would you like to save to the default file? (y/n): ");

            if (defaultSave.toLowerCase().equals("y")) {

                instance.getRouteManager().saveRoutes(new File(RouteManager.routesDefaultFilePath));
                return;
            } else if(defaultSave.toLowerCase().equals("n")) {

                File saveLocation = new File("./" + ConsoleHandler.getInput("Enter the file name you wish to save to: "));

                instance.getRouteManager().saveRoutes(saveLocation);
                ConsoleHandler.waitForEnter("Press the enter key to continue...");
                return;
            } else {

                System.out.println("Invalid response.");
            }
        }
    }

    @Override
    public String getDescription() {

        return "Save the routes to a file.";
    }
}