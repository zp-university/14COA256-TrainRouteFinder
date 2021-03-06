package pro.zackpollard.trainbooking.api;

import pro.zackpollard.trainbooking.api.managers.CommandManager;
import pro.zackpollard.trainbooking.api.managers.RouteManager;
import pro.zackpollard.trainbooking.api.utils.Logger;

/**
 * @author Zack Pollard
 */
public class TrainBookingAPI {

    private final Logger logger;
    private final RouteManager routeManager;
    private final CommandManager commandManager;

    /**
     * Constructs a new TrainBookingAPI object which will generate all of the objects needed for the API.
     * This should be accessed rather than accessing and constructing all of the other objects individually.
     */
    public TrainBookingAPI() {

        this.logger = new Logger();
        this.routeManager = new RouteManager(this);
        this.commandManager = new CommandManager(this);
    }

    /**
     * Get the current Logger used in this API session.
     *
     * @return The Logger object created for this session.
     */
    public Logger getLogger() {

        return logger;
    }

    /**
     * Get the CommandManager used in this API session.
     *
     * @return The CommandManager object created for this session.
     */
    public CommandManager getCommandManager() {

        return commandManager;
    }

    /**
     * Get the RouteManager used in this API session.
     *
     * @return The RouteManager object created for this session.
     */
    public RouteManager getRouteManager() {

        return routeManager;
    }
}