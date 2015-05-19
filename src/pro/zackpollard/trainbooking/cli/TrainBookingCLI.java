package pro.zackpollard.trainbooking.cli;

import pro.zackpollard.trainbooking.api.TrainBookingAPI;
import pro.zackpollard.trainbooking.api.command.Command;
import pro.zackpollard.trainbooking.api.utils.ConsoleHandler;
import pro.zackpollard.trainbooking.cli.commands.*;
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
        this.getCommandManager().registerCommand(new RouteCMD(this));
        this.getCommandManager().registerCommand(new SplitTicketCMD(this));

        this.getCommandManager().registerCommand(new AdminCMD(this));
        this.getCommandManager().registerCommand(new InputRouteCMD(this));
        this.getCommandManager().registerCommand(new SaveRouteCMD(this));
        this.getCommandManager().registerCommand(new LoadRouteCMD(this));

        this.getCommandManager().registerCommand(new ExitCMD(this));
        this.getCommandManager().registerCommand(new EndCMD(this));
    }

    /**
     * The main program loop for the CLI.
     */
    public void run() {

        while(true) {

            menuManager.printMenu();
            Command command = menuManager.getCommandFromMenu(ConsoleHandler.getInt("Please enter your selection: "));
            command.execute();
        }
    }

    public MenuManager getMenuManager() {

        return menuManager;
    }
}
