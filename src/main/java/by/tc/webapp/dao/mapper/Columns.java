package by.tc.webapp.dao.mapper;

import by.tc.webapp.main.controller.commands.Commands;

import java.util.HashMap;

public final class Columns {
    public enum Column {
        ID, ROLE_ID, ROLE_NAME, USER_ID, USER_EMAIL, USER_PASSWORD, USER_NAME, USER_SURNAME,
        BOOKING_START_TIME, ROOM_ID, ROOM_IS_RESERVED, ROOM_NUMBER,
        ROOM_PRICE
    }

    public static final HashMap<Columns.Column, String> column = new HashMap<>()
    { {
        put(Column.ID, "id");
        put(Column.ROLE_ID, "role_id");
        put(Column.ROLE_NAME, "role_name");
        put(Column.USER_ID, "user_id");

        put(Column.USER_EMAIL, "email");
        put(Column.USER_PASSWORD, "password");
        put(Column.USER_NAME, "user_name");
        put(Column.USER_SURNAME, "user_surname");
        put(Column.BOOKING_START_TIME, "start_time");

        put(Column.ROOM_ID, "room_id");
        put(Column.ROOM_IS_RESERVED, "is_reserved");
        put(Column.ROOM_NUMBER, "room_number");
        put(Column.ROOM_PRICE, "room_price");
    } };
}
