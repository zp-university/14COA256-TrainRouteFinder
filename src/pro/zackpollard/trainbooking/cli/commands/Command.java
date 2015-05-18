package pro.zackpollard.trainbooking.cli.commands;

import java.util.Collections;

/**
 * @author Zack Pollard
 */
public abstract class Command {

    private final String name;
    private final String[] aliases;
    private final MenuLevel menuLevel;

    /**
     * Construct a new command with no aliases.
     *
     * @param name the name of this command
     */
    public Command(String name, MenuLevel menuLevel) {
        this(name, menuLevel, null);
    }

    /**
     * Construct a new command.
     *
     * @param name    primary name of this command
     * @param aliases aliases which map back to this command
     */
    public Command(String name, MenuLevel menuLevel, String... aliases) {
        this.name = name;
        this.menuLevel = menuLevel;
        this.aliases = aliases;
    }

    /**
     * Used to get the command name set for this Command.
     *
     * @return The command name that was set for this Command.
     */
    public String getName() {
        return name;
    }

    /**
     * Used to get the aliases of this Command.
     *
     * @return an Array of type String of the aliases this Command has.
     */
    public String[] getAliases() {
        return aliases;
    }

    /**
     * Used to get the actual name of the class. Used mostly for internal logging.
     *
     * @return The full name of the class.
     */
    public String getActualName() {
        return this.getClass().getName();
    }

    /**
     * Code that should be executed when the command is run should be entered here.
     */
    public abstract void execute();

    /**
     * Should provide a description of what the command does for use in menus.
     *
     * @return A String description of what the command does.
     */
    public abstract String getDescription();
}