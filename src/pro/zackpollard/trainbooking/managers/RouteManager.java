package pro.zackpollard.trainbooking.managers;

import pro.zackpollard.trainbooking.io.Route;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Zack Pollard
 */
public class RouteManager {

    private List<Route> routes;
    private String routesFilePath;

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
     *
     *
     * @param route
     * @return
     */
    public boolean removeRoute(Route route) {

        return this.removeRoute(route);
    }

    public List<Route> getRoutes() {

        return routes;
    }

    public boolean saveRoutes(String path) {

        //TODO: Implement saving of routes file. Make routes serializable.
        return false;
    }

    public boolean loadRoutes() {

        //TODO: Implement loading of routes file. Make routes serializable.
        return false;
    }

    public String getRoutesFilePath() {

        return routesFilePath;
    }

    public boolean setRoutesFilePath(String path) {

        File file = new File(path);
        if(file.exists()) {

            String tempPath = routesFilePath;
            routesFilePath = path;

            if(!loadRoutes()) {

                routesFilePath = path;
                loadRoutes();
                return false;
            }

            return true;
        }

        return false;
    }
}