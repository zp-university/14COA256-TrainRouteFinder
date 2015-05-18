package pro.zackpollard.trainbooking.api;

import pro.zackpollard.trainbooking.api.managers.CommandManager;
import pro.zackpollard.trainbooking.api.utils.Logger;

/**
 * @author Zack Pollard
 */
public class TrainBooking {

    private final Logger logger;
    private final CommandManager commandManager;

    /**
     * Constructs a new TrainBooking object which will generate all of the objects needed for the API.
     * This should be accessed rather than accessing and constructing all of the other objects individually.
     */
    public TrainBooking() {

        this.logger = new Logger();
        this.commandManager = new CommandManager(this);
    }

    /**
     * Get the current Logger used in this API session.
     *
     * @return The Logger object created on construction.
     */
    public Logger getLogger() {

        return logger;
    }

    /**
     * Get the CommandManager used in this API session.
     *
     * @return The CommandManager object created on construction.
     */
    public CommandManager getCommandManager() {

        return commandManager;
    }
}