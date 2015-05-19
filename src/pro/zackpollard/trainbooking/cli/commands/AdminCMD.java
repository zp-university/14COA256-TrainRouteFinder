package pro.zackpollard.trainbooking.cli.commands;

import pro.zackpollard.trainbooking.api.command.Command;
import pro.zackpollard.trainbooking.api.command.CommandLevel;
import pro.zackpollard.trainbooking.cli.TrainBookingCLI;

/**
 * @author Zack Pollard
 */
public class AdminCMD extends Command {

    private final TrainBookingCLI instance;

    public AdminCMD(TrainBookingCLI instance) {

        super("Admin", CommandLevel.MAIN);
        this.instance = instance;
    }

    @Override
    public void execute() {

        instance.getMenuManager().setCommandLevel(CommandLevel.ADMIN);
    }

    @Override
    public String getDescription() {

        return "Access the admin options in the program.";
    }
}
