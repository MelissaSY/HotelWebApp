package by.tc.webapp.service.impl;

import by.tc.webapp.dao.exception.DAOException;
import by.tc.webapp.dao.factory.DAOFactory;
import by.tc.webapp.dao.interfaces.BookingDAO;
import by.tc.webapp.entity.Booking;
import by.tc.webapp.entity.Room;
import by.tc.webapp.service.exception.ServiceException;
import by.tc.webapp.service.interfaces.BookingService;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class BookingServiceImpl implements BookingService {
    @Override
    public Optional<Booking> retrieveBookingById(int userBookingId) throws ServiceException {
        try {
            BookingDAO userOrderDAO = DAOFactory.getInstance().getBookingDAO();
            Optional<Booking> result;
            result = userOrderDAO.findById(userBookingId);
            return result;
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Booking> retrieveBookingByUserId(int userId) throws ServiceException {
        try {
            BookingDAO userOrderDAO = DAOFactory.getInstance().getBookingDAO();
            List<Booking> result;
            result = userOrderDAO.findByUserId(userId);
            return result;
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }
    @Override
    public List<Booking> retrieveBookingByStatus(String status) throws ServiceException {
        try {
            BookingDAO userBookingDAO = DAOFactory.getInstance().getBookingDAO();
            return userBookingDAO.findByStatus(status);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public boolean updateStatusAtBookingById(int userOrderId, String status) throws ServiceException {
        try {
            BookingDAO userBookingDAO = DAOFactory.getInstance().getBookingDAO();
            Optional<Booking> userOrder = userBookingDAO.findById(userOrderId);
            if (!userOrder.isPresent()) {
                return false;
            }
            userBookingDAO.updateStatusById(userOrderId, status);
            return true;
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public boolean addNewBooking(String stringUserId, String stringRoomId) throws ServiceException {
        if (stringUserId==null || stringRoomId==null ) {
            return false;
        }
        int userId=Integer.parseInt(stringUserId);
        int apartmentId=Integer.parseInt(stringRoomId);

        try {
            Booking userBooking = buildBooking(userId,apartmentId);
            BookingDAO userBookingDAO = DAOFactory.getInstance().getBookingDAO();
            userBookingDAO.save(userBooking);
            return true;
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }
    private Booking buildBooking(int userId, int roomId) {
        Date date = new Date();
        Booking booking = new Booking(Timestamp.from(Instant.now()), userId, roomId);
        return booking;
    }
}
