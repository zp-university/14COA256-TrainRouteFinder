package pro.zackpollard.trainbooking.api.managers;

import pro.zackpollard.trainbooking.api.TrainBookingAPI;
import pro.zackpollard.trainbooking.api.commands.Command;
import pro.zackpollard.trainbooking.api.utils.Logger;
import pro.zackpollard.trainbooking.api.commands.CommandLevel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Zack Pollard
 */
public class CommandManager {

    private final TrainBookingAPI instance;
    private final Map<String, Command> commandMap;
    private final Map<CommandLevel, List<Command>> levelCommandMap;

    /**
     * Construct a new CommandManager object.
     *
     * @param instance The instance of TrainBookingAPI that this class should use.
     */
    public CommandManager(TrainBookingAPI instance) {

        this.instance = instance;
        this.commandMap = new HashMap<>();
        this.levelCommandMap = new HashMap<>();
    }

    /**
     * Register a commands' name and aliases in order for them to be called later.
     *
     * @param command The Command object to be registered.
     */
    public void registerCommand(Command command) {

        if (!commandMap.containsKey(command.getName().toLowerCase())) {

            commandMap.put(command.getName().toLowerCase(), command);

            if(levelCommandMap.containsKey(command.getCommandLevel())) {

                levelCommandMap.get(command.getCommandLevel()).add(command);
            } else {

                List<Command> commands = new ArrayList<>();
                commands.add(command);
                levelCommandMap.put(command.getCommandLevel(), commands);
            }

            if (command.getAliases() != null) {

                for (String alias : command.getAliases()) {

                    if (!commandMap.containsKey(alias.toLowerCase())) {

                        commandMap.put(alias.toLowerCase(), command);
                    } else {

                        instance.getLogger().log(Logger.LoggerLevel.WARNING,
                                String.format(
                                        "A class with name %s tried to register an alias that has already been registered!",
                                        command.getActualName()
                                )
                        );
                    }
                }
            }
        } else {

            instance.getLogger().log(Logger.LoggerLevel.WARNING,
                    String.format(
                            "A class with name %s tried to register a command name that has already been registered!",
                            command.getActualName()
                    )
            );
        }
    }

    /**
     * Get the command object by it's name or an alias.
     *
     * @param commandName   The name or alias for a command.
     * @return              The command object with the name or alias specified or null if none found.
     */
    public Command getCommand(String commandName) {

        return commandMap.get(commandName.toLowerCase());
    }

    /**
     * Get the Command objects that are associated with a specific CommandLevel.
     *
     * @param level The CommandLevel of the Command objects to be returned.
     * @return The Command objects that match the specified CommandLevel, null if none were found.
     */
    public List<Command> getCommands(CommandLevel level) {

        return levelCommandMap.get(level);
    }
}