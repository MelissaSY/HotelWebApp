package by.tc.webapp.dao.impl;

import by.tc.webapp.dao.dbhelper.tables.Table;
import by.tc.webapp.dao.exception.DAOException;
import by.tc.webapp.dao.interfaces.RoomDAO;
import by.tc.webapp.dao.mapper.factory.MapperFactory;
import by.tc.webapp.entity.Room;

import java.util.List;

public class RoomDAOImpl extends HotelDAOImpl<Room> implements RoomDAO {
    private static final String roomString = Table.table.get(Table.Tables.ROOM);

    public RoomDAOImpl() {
        super(MapperFactory.getInstance().getRoomMapper(), roomString);
    }
    private static final String FIND_ROOM_BY_STATUS = "SELECT * FROM " + roomString + " WHERE status=? ";
    private static final String FIND_ROOM_BY_PRICE =
            "SELECT * FROM " + roomString + " WHERE price BETWEEN ? AND ? ";
    private static final String SAVE_ROOM_QUERY = "INSERT INTO " + roomString +
            " (status, room_number, price) VALUES (?, ?, ?)";
    private static final String UPDATE_ROOM_BY_ID =
            "UPDATE " + roomString + " SET status=? room_number=? price=? WHERE id=?";
    private static final String UPDATE_ROOM_STATUS_BY_ID =
            "UPDATE " + roomString + " SET status=?  WHERE id=?";

    @Override
    public int save(Room item) throws DAOException {
        return executeInsertQuery(SAVE_ROOM_QUERY, item.getStatus(), item.getNumber(), item.getPrice());
    }

    @Override
    public List<Room> findByStatus(String status) throws DAOException {
        return executeQuery(FIND_ROOM_BY_STATUS, status);
    }

    @Override
    public List<Room> findByPrice(double from, double to) throws DAOException {
        return executeQuery(FIND_ROOM_BY_PRICE, from, to);
    }

    @Override
    public void updateRoomStatusById(int id, String status) throws DAOException {
        executeUpdateQuery(UPDATE_ROOM_STATUS_BY_ID, status, id);
    }

    @Override
    public void updateRoomById(int id, Room room) throws DAOException {
        executeUpdateQuery(UPDATE_ROOM_BY_ID, room.getStatus(),
                room.getNumber(), room.getPrice(), room.getId());
    }
}
