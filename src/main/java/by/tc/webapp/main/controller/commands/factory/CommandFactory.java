package by.tc.webapp.main.controller.commands.factory;

import by.tc.webapp.main.controller.commands.Commands;
import by.tc.webapp.main.controller.commands.impl.*;
import by.tc.webapp.main.controller.commands.interfaces.Command;

import java.util.HashMap;
import java.util.Map;

public class CommandFactory {
    private static final CommandFactory instance = new CommandFactory();
    private Map<Commands.Command, Command> commands = new HashMap<>();
    private CommandFactory() {
        commands.put(Commands.Command.LOG_IN, new LogInCommand());
        commands.put(Commands.Command.REGISTER, new RegisterCommand());
        commands.put(Commands.Command.RESERVE, new ReserveRoom());
        commands.put(Commands.Command.ADD_ROOM, new AddRoomCommand());
        commands.put(Commands.Command.DELETE_BOOKING, new DeleteBookingCommand());
        commands.put(Commands.Command.GET_ALL_ROOMS, new GetAllRoomsCommand());
        commands.put(Commands.Command.GET_RESERVED_ROOMS, new GetReservedRoomsCommand());
        commands.put(Commands.Command.LOG_OUT, new LogOutCommand());
    }
    public Command getCommand(String commandName) {
        Command res = null;
        if(Commands.getCommand(commandName) != null) {
            res = commands.get(Commands.getCommand(commandName));
        }
        return res;
    }
    public static CommandFactory getInstance() {
        return instance;
    }
}
