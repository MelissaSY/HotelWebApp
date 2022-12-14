package by.tc.webapp.dao.dbhelper.tables;

import java.util.HashMap;

public final class Table {
    public enum Tables {
        ROLE, USER, BOOKING, ROOM
    }
    public static final HashMap<Tables, String> table = new HashMap<>()
    { {
        put(Tables.ROLE, "role");
        put(Tables.USER, "user");
        put(Tables.BOOKING, "booking");
        put(Tables.ROOM, "room");
    } };
}
