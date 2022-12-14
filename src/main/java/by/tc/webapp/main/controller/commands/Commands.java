package by.tc.webapp.main.controller.commands;

import by.tc.webapp.main.controller.commands.factory.CommandFactory;

import java.util.HashMap;

public final class Commands {

    public enum Command {
        LOG_IN, LOG_OUT, RESERVE, REGISTER, DELETE_BOOKING, ADD_ROOM, GET_ALL_ROOMS, GET_RESERVED_ROOMS,
    };
    private static HashMap<String, Commands.Command> stringCommandTranslator  = new HashMap<>()
    { {
        put("LOG_IN", Command.LOG_IN);
        put("LOG_OUT", Command.LOG_OUT);
        put("RESERVE", Command.RESERVE);
        put("REGISTER", Command.REGISTER);
        put("DELETE_BOOKING", Command.DELETE_BOOKING);
        put("ADD_ROOM", Command.ADD_ROOM);
        put("GET_ALL_ROOMS", Command.GET_ALL_ROOMS);
        put("GET_RESERVED_ROOMS", Command.GET_RESERVED_ROOMS);
    } };

    private static HashMap<Commands.Command, String> commandStringTranslator = new HashMap<>()
    { {
        put(Command.LOG_IN, "LOG_IN");
        put(Command.LOG_OUT, "LOG_OUT");
        put(Command.RESERVE, "RESERVE");
        put(Command.REGISTER, "REGISTER");
        put(Command.DELETE_BOOKING, "DELETE_BOOKING");
        put(Command.ADD_ROOM, "ADD_ROOM");
        put(Command.GET_ALL_ROOMS, "GET_ALL_ROOMS");
        put(Command.GET_RESERVED_ROOMS, "GET_RESERVED_ROOMS");
    } };

    public static Commands.Command getCommand(String commandString) {
        return stringCommandTranslator.getOrDefault(commandString, null);
    }
}