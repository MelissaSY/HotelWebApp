package by.tc.webapp.dao.mapper.impl;

import by.tc.webapp.dao.mapper.Columns;
import by.tc.webapp.dao.mapper.interfaces.Mapper;
import by.tc.webapp.entity.Booking;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class BookingMapperImpl implements Mapper<Booking> {
    @Override
    public Booking map(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt(Columns.column.get(Columns.Column.ID));
        int userId = resultSet.getInt(Columns.column.get(Columns.Column.USER_ID));
        int roomId = resultSet.getInt(Columns.column.get(Columns.Column.ROOM_ID));
        Timestamp startDate = resultSet.getTimestamp(Columns.column.get(Columns.Column.BOOKING_START_TIME));

        return new Booking(id, startDate, userId, roomId);
    }
}
