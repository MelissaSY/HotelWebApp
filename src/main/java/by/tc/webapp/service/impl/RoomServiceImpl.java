package by.tc.webapp.service.impl;

import by.tc.webapp.entity.Booking;
import by.tc.webapp.entity.Room;
import by.tc.webapp.service.exception.ServiceException;
import by.tc.webapp.service.interfaces.RoomService;

import java.util.List;
import java.util.Optional;

public class RoomServiceImpl implements RoomService {
    @Override
    public List<Room> retrieveALLRooms() throws ServiceException {
        return null;
    }

    @Override
    public Optional<Room> retrieveRoomById(int room) throws ServiceException {
        return Optional.empty();
    }

    @Override
    public List<Room> retrieveRoomByUserId(int userId) throws ServiceException {
        return null;
    }

    @Override
    public void removeRoomById(int apartmentId) throws ServiceException {

    }

    @Override
    public List<Room> retrieveRoomByStatus(String status) throws ServiceException {
        return null;
    }

    @Override
    public List<Room> retrieveRoomByUserBookings(List<Booking> userOrders) throws ServiceException {
        return null;
    }

    @Override
    public boolean addNewRoom(String status, String StringRoomNumber, String StringPrice) throws ServiceException {
        return false;
    }

    @Override
    public void updateRoomStatusById(int id, String status) throws ServiceException {

    }

    @Override
    public boolean updateRoomInformation(String StringId, String status, String StringRoomNumber, String StringPrice) throws ServiceException {
        return false;
    }
}
