package by.tc.webapp.dao.mapper.impl;

import by.tc.webapp.dao.mapper.Columns;
import by.tc.webapp.dao.mapper.interfaces.Mapper;
import by.tc.webapp.entity.Room;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class RoomMapperImpl implements Mapper<Room> {
    @Override
    public Room map(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt(Columns.column.get(Columns.Column.ROOM_ID));
        boolean isReserved = resultSet.getBoolean(Columns.column.get(Columns.Column.ROOM_IS_RESERVED));
        int price = resultSet.getInt(Columns.column.get(Columns.Column.ROOM_PRICE));
        int number = resultSet.getInt(Columns.column.get(Columns.Column.ROOM_NUMBER));
        return new Room(id, isReserved, price, number);
    }
}
