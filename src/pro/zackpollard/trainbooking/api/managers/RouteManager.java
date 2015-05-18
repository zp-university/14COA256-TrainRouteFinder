package pro.zackpollard.trainbooking.api.managers;

import pro.zackpollard.trainbooking.api.TrainBookingAPI;
import pro.zackpollard.trainbooking.api.io.Route;
import pro.zackpollard.trainbooking.api.utils.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Zack Pollard
 */
public class RouteManager {

    public static final String routesDefaultFilePath = "./main.routes";

    private List<Route> routes;
    private final TrainBookingAPI instance;

    /**
     * Construct a new RouteManager object.
     *
     * @param instance The instance of TrainBookingAPI that this class should use.
     */
    public RouteManager(TrainBookingAPI instance) {

        this.instance = instance;
        this.routes = new ArrayList<>();
        this.loadRoutes(new File(routesDefaultFilePath));
    }

    /**
     * Adds a new Route object to the list of routes the program has available.
     *
     * @param route The Route object to be added to the program.
     */
    public void addRoute(Route route) {

        this.routes.add(route);
    }

    /**
     * Removes a Route object from the list of routes the program has available.
     *
     * @param route The Route object to be remove from the program.
     * @return      True if the Route existed in the program and was removed, False otherwise.
     */
    public boolean removeRoute(Route route) {

        return this.routes.remove(route);
    }

    /**
     * Get a list of the routes in the program.
     *
     * @return The list of Route objects stored by the RouteManager.
     */
    public List<Route> getRoutes() {

        return routes;
    }

    /**
     * Save the routes to the file specified.
     *
     * @param file  The file that the routes should be saved to.
     * @return      True if the save operation succeeded, false otherwise.
     */
    public boolean saveRoutes(File file) {

        try {

            if(!file.exists()) file.createNewFile();

            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
            out.writeObject(routes);
            out.flush();
            out.close();

            instance.getLogger().log(Logger.LoggerLevel.DEBUG, "All currently loaded routes were saved to " + file.getAbsolutePath());
            return true;

        } catch (IOException e) {
            instance.getLogger().log(Logger.LoggerLevel.ERROR, "Routes failed to save.", e);
        }

        return false;
    }

    /**
     * Load the routes from the file specified.
     *
     * @param file  The file that the routes should be loaded from.
     * @return      True if the load operation succeeded, false otherwise.
     */
    public boolean loadRoutes(File file) {

        if(file == null) {

            file = new File(routesDefaultFilePath);
        }

        if(!file.exists()) {

            instance.getLogger().log(Logger.LoggerLevel.ERROR, "The routes file was not loaded as it did not exist.");
            return false;
        }

        try {

            ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
            routes = (List<Route>) in.readObject();
            in.close();

            instance.getLogger().log(Logger.LoggerLevel.DEBUG, "New routes were loaded from " + file.getAbsolutePath());

            return true;
        } catch (IOException | ClassNotFoundException e) {
            instance.getLogger().log(Logger.LoggerLevel.ERROR, "There was an issue whilst loading the routes file.", e);
        }

        return false;
    }
}