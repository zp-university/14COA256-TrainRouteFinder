package pro.zackpollard.trainbooking.cli.managers;

import pro.zackpollard.trainbooking.api.TrainBooking;
import pro.zackpollard.trainbooking.cli.commands.Command;
import pro.zackpollard.trainbooking.api.utils.Logger;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Zack Pollard
 */
public class CommandManager {

    private final TrainBooking instance;
    private final Map<String, Command> commandMap;

    public CommandManager(TrainBooking instance) {

        this.instance = instance;
        this.commandMap = new HashMap<>();
    }

    /**
     * Register a commands' name and aliases in order for them to be called later.
     *
     * @param command The Command object to be registered.
     */
    public void registerCommand(Command command) {

        if (!commandMap.containsKey(command.getName().toLowerCase())) {

            commandMap.put(command.getName().toLowerCase(), command);

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
}