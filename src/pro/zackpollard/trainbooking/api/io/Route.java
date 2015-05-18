package pro.zackpollard.trainbooking.api.io;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Zack Pollard
 */
public class Route implements Serializable {

    private static final long serialVersionUID = -1327286908415191626L;
    private String origin;
    private String destination;
    private double cost;
    private int duration;
    private List<String> stops;

    /**
     * Constructs a new Route object.
     *
     * @param origin        The name of the origin of the route.
     * @param destination   The name of the destination of the route.
     * @param cost          The cost of travelling the route.
     * @param duration          The duration to travel the entire route.
     * @param stops          The stops that occur on the route.
     */
    public Route(String origin, String destination, double cost, int duration, String... stops) {

        this.origin = origin;
        this.destination = destination;
        this.cost = cost;
        this.duration = duration;
        this.stops = new ArrayList<>();
        Collections.addAll(this.stops, stops);
    }

    /**
     * Getter method for origin.
     *
     * @return A string of the origin of the Route object.
     */
    public String getOrigin() {

        return origin;
    }

    /**
     * Getter method for destination.
     *
     * @return A string of the destination of the Route object.
     */
    public String getDestination() {

        return destination;
    }

    /**
     * Getter method for cost.
     *
     * @return A double of the cost of travelling the route.
     */
    public double getCost() {

        return cost;
    }

    /**
     * Getter method for duration.
     *
     * @return A double of the duration of travelling the route.
     */
    public long getDuration() {

        return duration;
    }

    /**
     * Getter method for stops.
     *
     * @return A List<String> for the objects on the route.
     */
    public List<String> getStops() {

        return stops;
    }

    /**
     * Setter for the origin.
     *
     * @param origin The new origin of the route.
     */
    public void setOrigin(String origin) {

        this.origin = origin;
    }

    /**
     * Setter for the destination.
     *
     * @param destination The new destination of the route.
     */
    public void setDestination(String destination) {

        this.destination = destination;
    }

    /**
     * Setter for the cost.
     *
     * @param cost The new cost of the route.
     */
    public void setCost(double cost) {

        this.cost = cost;
    }

    /**
     * Setter for the duration.
     *
     * @param duration The new duration of the route.
     */
    public void setDuration(int duration) {

        this.duration = duration;
    }

    /**
     * Setter for the stops.
     *
     * @param stops A new list of stops for the route.
     */
    public void setStops(String... stops) {

        this.stops = new ArrayList<>();
        Collections.addAll(this.stops, stops);
    }

    /**
     * Add a stop to the end of the route, before the final destination but after the other stops.
     *
     * @param stop The name of the new stop.
     */
    public void addStop(String stop) {

        this.stops.add(stop);
    }

    /**
     * Add a stop to a specific position in the route.
     *
     * @param stop      The name of the new stop.
     * @param position  The position that this stop is at in the route.
     */
    public void addStop(String stop, int position) {

        this.stops.add(position, stop);
    }
}