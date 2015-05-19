package pro.zackpollard.trainbooking.cli.commands;

import pro.zackpollard.trainbooking.api.command.Command;
import pro.zackpollard.trainbooking.api.command.CommandLevel;
import pro.zackpollard.trainbooking.cli.TrainBookingCLI;

/**
 * @author Zack Pollard
 */
public class ExitCMD extends Command {

    private final TrainBookingCLI instance;

    public ExitCMD(TrainBookingCLI instance) {

        super("exit", CommandLevel.ADMIN);
        this.instance = instance;
    }

    @Override
    public void execute() {

        instance.getMenuManager().setCommandLevel(instance.getMenuManager().getPreviousCommandLevel(true));
    }

    @Override
    public String getDescription() {

        return "Exit the admin interface.";
    }
}