package pro.zackpollard.trainbooking.cli;

import pro.zackpollard.trainbooking.api.TrainBooking;

/**
 * @author Zack Pollard
 */
public class TrainBookingCLI {

    private final TrainBooking instance;

    /**
     * This method simply starts the program.
     *
     * @param args Any arguments from the command line, these are unused and are discarded in any future method calls.
     */
    public static void main(String[] args) {

        new TrainBookingCLI().run();
    }

    /**
     * Constructs a new TrainBookingCLI object.
     */
    public TrainBookingCLI() {

        this.instance = new TrainBooking();
    }

    /**
     * The main program loop for the CLI.
     */
    public void run() {

        //TODO: Run stuff for the CLI.
    }

    /**
     * Required to get the instance of the TrainBooking object being used by the CLI.
     *
     * @return the currently used TrainBooking object.
     */
    public TrainBooking getInstance() {
        return instance;
    }
}
