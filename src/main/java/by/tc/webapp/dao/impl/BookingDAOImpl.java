package by.tc.webapp.dao.impl;

import by.tc.webapp.dao.dbhelper.tables.Table;
import by.tc.webapp.dao.exception.DAOException;
import by.tc.webapp.dao.interfaces.BookingDAO;
import by.tc.webapp.dao.mapper.factory.MapperFactory;
import by.tc.webapp.entity.Booking;

import java.util.List;

public class BookingDAOImpl extends HotelDAOImpl<Booking> implements BookingDAO {
    private static final String bookingString = Table.table.get(Table.Tables.BOOKING);
    private static final String FIND_USER_ORDERS_BY_STATUS_QUERY =
            "SELECT * FROM " + bookingString + " WHERE status=?";
    private static final String UPDATE_USER_ORDER_STATUS_BY_ID_QUERY =
            "UPDATE " + bookingString + " SET status=? WHERE id=?";
    private static final String SAVE_USER_ORDER_QUERY = "INSERT INTO " +
            bookingString + " (status, start_time, user_id, room_id) VALUES (?, ?, ?, ?,?)";
    private static final String FIND_USER_ORDERS_BY_USER_ID_QUERY="SELECT * FROM " +
            bookingString + " WHERE user_id=?";
    private static final String FIND_USER_ORDERS_BY_ROOM_ID="SELECT * FROM " +
            bookingString + " WHERE room_id=?";

    public BookingDAOImpl() {
        super(MapperFactory.getInstance().getUserBookingMapper(), bookingString);
    }

    @Override
    public List<Booking> findByStatus(String status) throws DAOException {
        return executeQuery(FIND_USER_ORDERS_BY_STATUS_QUERY, status);
    }

    @Override
    public List<Booking> findByRoomID(int apartmentId) throws DAOException {
        return executeQuery(FIND_USER_ORDERS_BY_ROOM_ID, apartmentId);
    }

    @Override
    public void updateStatusById(long id, String status) throws DAOException {
        executeUpdateQuery(UPDATE_USER_ORDER_STATUS_BY_ID_QUERY, status, id);
    }

    @Override
    public int save(Booking userOrder) throws DAOException {
        return executeInsertQuery(SAVE_USER_ORDER_QUERY,userOrder.getStartTime(),userOrder.getIdUser(),userOrder.getIdRoom());
    }

    @Override
    public List<Booking> findByUserId(int userId) throws DAOException {
        return executeQuery(FIND_USER_ORDERS_BY_USER_ID_QUERY,userId);
    }

}
