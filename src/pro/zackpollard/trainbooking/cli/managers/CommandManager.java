package pro.zackpollard.trainbooking.cli.managers;

import pro.zackpollard.trainbooking.api.TrainBooking;
import pro.zackpollard.trainbooking.cli.commands.Command;
import pro.zackpollard.trainbooking.api.utils.Logger;
import pro.zackpollard.trainbooking.cli.commands.MenuLevel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Zack Pollard
 */
public class CommandManager {

    private final TrainBooking instance;
    private final Map<String, Command> commandMap;
    private final Map<MenuLevel, List<Command>> levelCommandMap;
    private MenuLevel menuLevel;

    /**
     * Construct a new CommandManager object.
     *
     * @param instance The instance of TrainBooking that this class should use.
     */
    public CommandManager(TrainBooking instance) {

        this.instance = instance;
        this.commandMap = new HashMap<>();
        this.levelCommandMap = new HashMap<>();
        this.menuLevel = MenuLevel.MAIN;
    }

    /**
     * Register a commands' name and aliases in order for them to be called later.
     *
     * @param command The Command object to be registered.
     */
    public void registerCommand(Command command) {

        if (!commandMap.containsKey(command.getName().toLowerCase())) {

            commandMap.put(command.getName().toLowerCase(), command);

            if(levelCommandMap.containsKey(command.getMenuLevel())) {

                levelCommandMap.get(command.getMenuLevel()).add(command);
            } else {

                List<Command> commands = new ArrayList<>();
                commands.add(command);
                levelCommandMap.put(command.getMenuLevel(), commands);
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

    public List<Command> getCommands(MenuLevel level) {

        return levelCommandMap.get(level);
    }
}
