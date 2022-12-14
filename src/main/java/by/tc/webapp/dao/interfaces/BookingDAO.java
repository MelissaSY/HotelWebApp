package by.tc.webapp.dao.interfaces;

import by.tc.webapp.dao.exception.DAOException;
import by.tc.webapp.entity.Booking;

import java.util.List;

public interface BookingDAO extends HotelDAO<Booking> {
    List<Booking> findByStatus(String status) throws DAOException;
    List<Booking> findByUserId(int userId) throws DAOException;
    void updateStatusById(long id, String status) throws DAOException;
    List<Booking> findByRoomID(int apartmentId) throws DAOException;
}