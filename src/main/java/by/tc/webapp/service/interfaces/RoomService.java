package by.tc.webapp.service.interfaces;

import by.tc.webapp.entity.Booking;
import by.tc.webapp.entity.Room;
import by.tc.webapp.service.exception.ServiceException;

import java.util.List;
import java.util.Optional;

public interface RoomService {
    List<Room> retrieveALLRooms() throws ServiceException;
    Optional<Room> retrieveRoomById(int room) throws ServiceException;
    List<Room> retrieveRoomByUserId(int userId) throws ServiceException;
    void removeRoomById(int apartmentId) throws ServiceException;
    List<Room> retrieveRoomByStatus(String status) throws ServiceException;
    List<Room> retrieveRoomByUserBookings(List<Booking> userOrders) throws ServiceException;
    boolean addNewRoom(String status,String StringRoomNumber,String StringPrice)
            throws ServiceException;
    void updateRoomStatusById(int id,String status) throws ServiceException;
    boolean updateRoomInformation(String StringId, String status, String StringRoomNumber,
                                  String StringPrice)
            throws ServiceException;
}
