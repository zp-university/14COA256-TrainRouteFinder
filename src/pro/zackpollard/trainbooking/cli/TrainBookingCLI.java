package pro.zackpollard.trainbooking.cli;

import pro.zackpollard.trainbooking.api.TrainBookingAPI;
import pro.zackpollard.trainbooking.api.command.Command;
import pro.zackpollard.trainbooking.api.utils.ConsoleHandler;
import pro.zackpollard.trainbooking.cli.commands.PriceCMD;
import pro.zackpollard.trainbooking.cli.commands.TimeCMD;
import pro.zackpollard.trainbooking.cli.managers.MenuManager;

/**
 * @author Zack Pollard
 */
public class TrainBookingCLI extends TrainBookingAPI {

    private final MenuManager menuManager;

    /**
     * This method simply starts the program.
     *
     * @param args Any arguments from the command line, these are unused and are discarded in any future method calls.
     */
    public static void main(String[] args) {

        new TrainBookingCLI().run();
    }

    /**
     * Constructs a new TrainBookingCLI object.
     */
    public TrainBookingCLI() {

        this.menuManager = new MenuManager(this);
        this.registerCommands();
    }

    private void registerCommands() {

        this.getCommandManager().registerCommand(new TimeCMD(this));
        this.getCommandManager().registerCommand(new PriceCMD(this));
    }

    /**
     * The main program loop for the CLI.
     */
    public void run() {

        menuManager.printMenu();
        Command command = menuManager.getCommandFromMenu(ConsoleHandler.getInt("Please enter your selection: "));
        command.execute();
    }
}
