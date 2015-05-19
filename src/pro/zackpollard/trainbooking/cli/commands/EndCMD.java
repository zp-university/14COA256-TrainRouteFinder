package pro.zackpollard.trainbooking.cli.commands;

import pro.zackpollard.trainbooking.api.command.Command;
import pro.zackpollard.trainbooking.api.command.CommandLevel;
import pro.zackpollard.trainbooking.cli.TrainBookingCLI;

/**
 * @author Zack Pollard
 */
public class EndCMD extends Command {

    private final TrainBookingCLI instance;

    public EndCMD(TrainBookingCLI instance) {

        super("end", CommandLevel.MAIN);
        this.instance = instance;
    }

    @Override
    public void execute() {

        System.out.println("Goodbye!");
        System.exit(0);
    }

    @Override
    public String getDescription() {

        return "Exit the program.";
    }
}
