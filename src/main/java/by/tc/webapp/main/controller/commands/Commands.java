package by.tc.webapp.main.controller.commands;

import by.tc.webapp.main.controller.commands.factory.CommandFactory;

import java.util.HashMap;

public final class Commands {

    public enum Command {
        LOG_IN, LOG_OUT, RESERVE, REGISTER, DELETE_BOOKING, ADD_ROOM, GET_ALL_ROOMS, GET_RESERVED_ROOMS,
    };
    private static HashMap<String, Commands.Command> stringCommandTranslator  = new HashMap<>()
    { {
        put("login", Command.LOG_IN);
        put("logout", Command.LOG_OUT);
        put("reserve", Command.RESERVE);
        put("register", Command.REGISTER);
        put("delete_booking", Command.DELETE_BOOKING);
        put("add_room", Command.ADD_ROOM);
        put("get_all", Command.GET_ALL_ROOMS);
        put("get_reserved", Command.GET_RESERVED_ROOMS);
    } };

    private static HashMap<Commands.Command, String> commandStringTranslator = new HashMap<>()
    { {
        put(Command.LOG_IN, "login");
        put(Command.LOG_OUT, "logout");
        put(Command.RESERVE, "reserve");
        put(Command.REGISTER, "register");
        put(Command.DELETE_BOOKING, "delete_booking");
        put(Command.ADD_ROOM, "add_room");
        put(Command.GET_ALL_ROOMS, "get_all");
        put(Command.GET_RESERVED_ROOMS, "get_reserved");
    } };

    public static Commands.Command getCommand(String commandString) {
        if(stringCommandTranslator.containsKey(commandString.toLowerCase()))
            return stringCommandTranslator.get(commandString);
        else
            return null;
    }
}