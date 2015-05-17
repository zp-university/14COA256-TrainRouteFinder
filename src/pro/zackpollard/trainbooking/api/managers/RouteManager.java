package pro.zackpollard.trainbooking.api.managers;

import pro.zackpollard.trainbooking.api.io.Route;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Zack Pollard
 */
public class RouteManager {

    private List<Route> routes;
    public static final String routesFilePath = "./main.routes";

    /**
     * Constructs a new RouteManager. This will initiate the routes List as an ArrayList.
     */
    public RouteManager() {

        this.routes = new ArrayList<>();
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
     * @return True if the Route existed in the program and was removed, False otherwise.
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
     * @param file The file that the routes should be saved to.
     * @return True if the save operation succeeded, false otherwise.
     */
    public boolean saveRoutes(File file) {

        //TODO: Implement saving of routes file. Make routes serializable.
        return false;
    }

    /**
     * Load the routes from the file specified.
     *
     * @param file The file that the routes should be loaded from.
     * @return True if the load operation succeeded, false otherwise.
     */
    public boolean loadRoutes(File file) {

        //TODO: Implement loading of routes file. Make routes serializable.
        return false;
    }
}