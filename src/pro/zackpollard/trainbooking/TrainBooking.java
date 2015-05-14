package pro.zackpollard.trainbooking;

import pro.zackpollard.trainbooking.managers.CommandManager;
import pro.zackpollard.trainbooking.utils.Logger;

/**
 * @author Zack Pollard
 */
public class TrainBooking {

    private final Logger logger;
    private final CommandManager commandManager;

    protected TrainBooking() {

        this.logger = new Logger();
        this.commandManager = new CommandManager(this);
    }

    public void run() {


    }

    public Logger getLogger() {

        return logger;
    }
}