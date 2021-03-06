package pro.zackpollard.trainbooking.cli.managers;

import pro.zackpollard.trainbooking.api.command.Command;
import pro.zackpollard.trainbooking.api.command.CommandLevel;
import pro.zackpollard.trainbooking.cli.TrainBookingCLI;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author Zack Pollard
 */
public class MenuManager {

    private final TrainBookingCLI instance;
    private CommandLevel commandLevel;
    private Stack<CommandLevel> previousCommandLevels;
    private List<Command> lastMenu;

    /**
     * Constructs a new MenuManager object.
     *
     * @param instance The TrainBookingCLI instance that this MenuManager should use.
     */
    public MenuManager(TrainBookingCLI instance) {

        this.instance = instance;
        this.commandLevel = CommandLevel.MAIN;
        this.previousCommandLevels = new Stack<>();
        this.lastMenu = new LinkedList<>();
    }

    /**
     * Gives the user the current CommandLevel.
     *
     * @return the current CommandLevel used for all Menus.
     */
    public CommandLevel getCommandLevel() {

        return commandLevel;
    }

    /**
     * Gives the user the previous CommandLevel, used primarily for the back function in menus.
     */
    public CommandLevel getPreviousCommandLevel(boolean remove) {

        if(previousCommandLevels.size() != 0) {

            if(remove) {
                return previousCommandLevels.pop();
            } else {
                return previousCommandLevels.peek();
            }
        } else {

            return null;
        }
    }

    /**
     * Used to change the CommandLevel, this will be mainly used by Commands.
     *
     * @param commandLevel
     */
    public void setCommandLevel(CommandLevel commandLevel) {

        if(!this.commandLevel.equals(commandLevel)) {

            if (commandLevel.equals(CommandLevel.MAIN)) {

                previousCommandLevels.clear();
            } else {

                this.previousCommandLevels.push(this.commandLevel);
            }

            this.commandLevel = commandLevel;
        }
    }

    /**
     * Provides the menu corresponding to the current CommandLevel in the form of a List<String>
     * where each new String is a new line.
     *
     * @return
     */
    public List<String> getMenu() {

        int count = 0;
        List<String> lines = new LinkedList<>();
        lastMenu.clear();

        for(Command command : instance.getCommandManager().getCommands(this.commandLevel)) {

            lines.add(++count + ".) " + command.getName() + " - " + command.getDescription());
            lastMenu.add(command);
        }

        return lines;
    }

    /**
     * Prints the menu from the getMenu() method to stdout.
     */
    public void printMenu() {

        for(String line : getMenu()) {

            System.out.println(line);
        }
    }

    /**
     * Used to get the command referenced by the last menu using the provided integer.
     *
     * @param menuID The integer that was used to reference a command.
     * @return The command referenced by that ID or null if it doesn't exist.
     */
    public Command getCommandFromMenu(int menuID) {

        if(lastMenu.size() >= menuID) {

            return lastMenu.get(menuID - 1);
        }

        return null;
    }
}