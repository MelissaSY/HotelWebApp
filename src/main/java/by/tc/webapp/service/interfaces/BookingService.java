package by.tc.webapp.service.interfaces;

import by.tc.webapp.entity.Booking;
import by.tc.webapp.service.exception.ServiceException;

import java.util.List;
import java.util.Optional;

public interface BookingService {

    Optional<Booking> retrieveBookingById(int userOrderId) throws ServiceException;
    List<Booking> retrieveBookingByUserId(int userId) throws ServiceException;
    List<Booking> retrieveBookingByStatus(String status) throws ServiceException;
    boolean updateStatusAtBookingById(int userOrderId, String status) throws ServiceException;
    boolean addNewBooking(String stringUserId,String stringRoomId)
            throws ServiceException;
}
